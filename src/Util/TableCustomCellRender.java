package Util;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCustomCellRender extends DefaultTableCellRenderer {

    private final HoverIndex hoverRow;

    public TableCustomCellRender(HoverIndex hoverRow) {
        this.hoverRow = hoverRow;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        if (isSelected) {
            com.setBackground(table.getSelectionBackground());
        } else {
            if (row == hoverRow.getIndex()) {
                com.setBackground(UIHelper.SURFACE_ALT);
            } else {
                if (row % 2 == 0) {
                    com.setBackground(UIHelper.WHITE);
                } else {
                    com.setBackground(UIHelper.SURFACE);
                }
            }
        }
        com.setFont(table.getFont());
        return com;
    }
}