package Main;

import GUI.n0_LoginGUI;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.EventQueue;
import Util.UIHelper;

public class Main {

    public static void main(String[] args) {
        UIHelper.installProjectTheme();

        // Add shutdown hook to clean up resources when app closes
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Closing application, cleaning up resources...");
            try {
                Thread.sleep(100); // Give time for connections to close
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        EventQueue.invokeLater(() -> {
            n0_LoginGUI login = new n0_LoginGUI();

            // Add window listener to handle clean close
            login.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("Window closing, exiting application...");
                    System.exit(0);
                }
            });
        });
    }
}
