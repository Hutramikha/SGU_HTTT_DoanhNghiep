package Util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

public class JDBCUtil {

    private static String hostname; // mặc định là localhost
    private static String dbname; // tên database
    private static String username; // tên tài khoản
    private static String password; // mật khẩu

    // ✅ Connection Pool - reuse connections instead of creating new ones
    private static final int POOL_SIZE = 10;
    private static Queue<Connection> connectionPool;
    private static boolean initialized = false;

    static {
        // Initialize connection settings on class load
        readFileText();
        // ✅ FIXED: Don't initialize pool immediately - do it lazily
        // This prevents UI freeze on app startup
    }

    /**
     * ✅ Initialize connection pool lazily (first time needed)
     */
    private static synchronized void ensurePoolInitialized() {
        if (initialized) {
            return;
        }
        initialized = true;

        System.out.println("🚀 [JDBCUtil] Initializing connection pool...");
        connectionPool = new LinkedList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Pre-create 3 connections (reduced from 10 to startup faster)
            for (int i = 0; i < 3; i++) {
                Connection conn = createNewConnection();
                if (conn != null) {
                    connectionPool.offer(conn);
                }
            }
            System.out
                    .println("✓ [JDBCUtil] Connection pool initialized with " + connectionPool.size() + " connections");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ✅ Create a new database connection
     */
    private static Connection createNewConnection() {
        if (checkNullValues()) {
            return null;
        }
        try {
            String dbUrl = "jdbc:sqlserver://" + hostname + ":1433;DatabaseName=" + dbname
                    + ";encrypt=true;trustServerCertificate=true;loginTimeout=10";
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to create connection: " + ex);
            return null;
        }
    }

    /**
     * ✅ Get connection from pool (reuse existing) or create new if no available
     */
    public static Connection getConnection() {
        // Ensure pool is initialized (lazy loading)
        ensurePoolInitialized();

        Connection conn = null;

        // Try to get connection from pool
        if (connectionPool != null && !connectionPool.isEmpty()) {
            conn = connectionPool.poll();
            try {
                // Check if connection is still valid
                if (conn != null && !conn.isClosed()) {
                    return conn;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // If no valid connection in pool, create new one
        conn = createNewConnection();
        if (conn != null) {
            System.out.println("✓ Created new connection (pool size: " +
                    (connectionPool != null ? connectionPool.size() : 0) + ")");
        }
        return conn;
    }

    /**
     * ✅ Return connection to pool for reuse
     */
    public static void returnConnection(Connection conn) {
        if (conn != null && connectionPool != null) {
            try {
                if (!conn.isClosed()) {
                    connectionPool.offer(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Close connection properly
     */
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                if (!c.isClosed()) {
                    // Return to pool if available space
                    if (connectionPool.size() < POOL_SIZE) {
                        returnConnection(c);
                    } else {
                        c.close();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close all connections in pool (call on application shutdown)
     */
    public static void closeAllConnections() {
        if (connectionPool != null) {
            while (!connectionPool.isEmpty()) {
                Connection conn = connectionPool.poll();
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("✓ All connections closed");
        }
    }

    private static void readFileText() {
        try {
            String projectRoot = System.getProperty("user.dir");
            String filePath = projectRoot + java.io.File.separator + "connect.txt";
            try (FileInputStream fileInputStream = new FileInputStream(filePath);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                hostname = bufferedReader.readLine();
                dbname = bufferedReader.readLine();
                username = bufferedReader.readLine();
                password = bufferedReader.readLine();
                if (password == null) {
                    password = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkNullValues() {
        return hostname == null || dbname == null || username == null;
    }

    public static void main(String[] args) {
        Connection c = JDBCUtil.getConnection();
        System.out.println("Test connection: " + c);
        JDBCUtil.closeConnection(c);
        JDBCUtil.closeAllConnections();
    }
}
