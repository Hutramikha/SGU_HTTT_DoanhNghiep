package GUI;

import javax.swing.*;

/**
 * SwingWorker to load statistics on background thread
 * Prevents UI freeze when opening Statistics panel
 */
public class StatisticsLoadWorker2_fixed extends SwingWorker<Void, Void> {

    private n10_ThongkePanel panel;

    public StatisticsLoadWorker2_fixed(n10_ThongkePanel panel) {
        this.panel = panel;
    }

    @Override
    protected Void doInBackground() throws Exception {
        System.out.println("🔄 Loading statistics data...");
        panel.initUI();
        panel.addControl();
        return null;
    }

    @Override
    protected void done() {
        try {
            get();
            panel.revalidate();
            panel.repaint();
            System.out.println("✅ Statistics panel loaded!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
        }
    }
}
