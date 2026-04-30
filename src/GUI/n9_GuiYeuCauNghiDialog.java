package GUI;

import BUS.YeuCauNhanSuBUS;
import Util.dialog;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;

public class n9_GuiYeuCauNghiDialog extends JDialog {

    private final String maNhanVien;
    private final YeuCauNhanSuBUS bus = new YeuCauNhanSuBUS();

    private final JComboBox<String> cbLoai = new JComboBox<>(new String[] { "Nghỉ phép", "Nghỉ việc" });
    private final JDateChooser dcTuNgay = new JDateChooser();
    private final JDateChooser dcDenNgay = new JDateChooser();
    private final JTextArea txtLyDo = new JTextArea(4, 24);
    private final JButton btnGui = new JButton("Gửi yêu cầu");
    private final JButton btnDong = new JButton("Đóng");

    public n9_GuiYeuCauNghiDialog(java.awt.Frame owner, String maNhanVien) {
        super(owner, "Gửi yêu cầu nghỉ", true);
        this.maNhanVien = maNhanVien;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;

        dcTuNgay.setDateFormatString("dd-MM-yyyy");
        dcDenNgay.setDateFormatString("dd-MM-yyyy");

        gbc.gridx = 0;
        gbc.gridy = 0;
        form.add(new JLabel("Loại yêu cầu"), gbc);
        gbc.gridx = 1;
        form.add(cbLoai, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        form.add(new JLabel("Từ ngày"), gbc);
        gbc.gridx = 1;
        form.add(dcTuNgay, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        form.add(new JLabel("Đến ngày"), gbc);
        gbc.gridx = 1;
        form.add(dcDenNgay, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        form.add(new JLabel("Lý do"), gbc);
        gbc.gridx = 1;
        form.add(new JScrollPane(txtLyDo), gbc);

        JPanel actions = new JPanel();
        actions.add(btnGui);
        actions.add(btnDong);

        add(form, BorderLayout.CENTER);
        add(actions, BorderLayout.SOUTH);

        cbLoai.addActionListener(e -> toggleDenNgay());
        btnGui.addActionListener(e -> guiYeuCau());
        btnDong.addActionListener(e -> dispose());

        toggleDenNgay();
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void toggleDenNgay() {
        boolean isNghiViec = "Nghỉ việc".equals(cbLoai.getSelectedItem());
        dcDenNgay.setEnabled(!isNghiViec);
    }

    private void guiYeuCau() {
        if (maNhanVien == null || maNhanVien.trim().isEmpty()) {
            new dialog("Không xác định nhân viên hiện tại.", dialog.ERROR_DIALOG);
            return;
        }

        String loai = "Nghỉ việc".equals(cbLoai.getSelectedItem())
                ? YeuCauNhanSuBUS.LOAI_NGHI_VIEC
                : YeuCauNhanSuBUS.LOAI_NGHI_PHEP;

        java.util.Date tuUtil = dcTuNgay.getDate();
        java.util.Date denUtil = dcDenNgay.getDate();

        Date tuNgay = tuUtil != null ? new Date(tuUtil.getTime()) : null;
        Date denNgay = denUtil != null ? new Date(denUtil.getTime()) : null;

        if (YeuCauNhanSuBUS.LOAI_NGHI_VIEC.equals(loai)) {
            denNgay = tuNgay;
        }

        String lyDo = txtLyDo.getText().trim();
        if (bus.guiYeuCau(maNhanVien, loai, tuNgay, denNgay, lyDo)) {
            dispose();
        }
    }
}
