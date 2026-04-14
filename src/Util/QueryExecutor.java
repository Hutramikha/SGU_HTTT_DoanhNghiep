package Util;

import java.sql.*;

/**
 * Performance Optimization Utility
 * - Automatic resource management
 * - Connection pooling (future)
 */
public class QueryExecutor {

    /**
     * Execute query và auto-close resources
     * Usage: QueryExecutor.executeQuery(sql, rs -> {
     * while(rs.next()) { ... }
     * });
     */
    @FunctionalInterface
    public interface ResultSetHandler {
        void handle(ResultSet rs) throws SQLException;
    }

    public static void executeQuery(String sql, ResultSetHandler handler) {
        try (Connection c = JDBCUtil.getConnection();
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            handler.handle(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execute prepared statement safely
     * Usage: QueryExecutor.executePrepared(sql, ps -> {
     * ps.setString(1, value);
     * ResultSet rs = ps.executeQuery();
     * while(rs.next()) { ... }
     * });
     */
    @FunctionalInterface
    public interface PreparedStatementHandler {
        void handle(PreparedStatement ps) throws SQLException;
    }

    public static void executePrepared(String sql, PreparedStatementHandler handler) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            handler.handle(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execute update (INSERT, UPDATE, DELETE) safely
     */
    public static int executeUpdate(String sql, PreparedStatementHandler handler) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            handler.handle(ps);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
