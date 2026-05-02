package GUI;

import BUS.LichLamBUS;
import DAO.n6_CaLamDAO;
import DAO.n6_LichLamDAO;
import DTO.CaLamDTO;
import DTO.LichLamDTO;
import Util.dialog;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class n11_DiemDanhDialog extends JDialog {

    private final String maNhanVien;
    private final LichLamBUS lichLamBUS = LichLamBUS.getInstance();
    
    private JLabel lblTime = new JLabel();
    private JLabel lblShift = new JLabel("Đang tìm ca làm...");
    private JButton btnCheckIn = new JButton("Điểm danh (Check-in)");
    private JLabel lblStatus = new JLabel("Trạng thái: Chưa điểm danh");

    public n11_DiemDanhDialog(java.awt.Frame owner, String maNhanVien) {
        super(owner, "Chấm công nhân viên", true);
        this.maNhanVien = maNhanVien;
        initUI();
        updateCurrentInfo();
    }

    private void initUI() {
        setSize(400, 300);
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblTime.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTime.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblShift.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblStatus.setFont(new Font("Segoe UI", Font.ITALIC, 14));

        btnCheckIn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCheckIn.setBackground(new Color(40, 167, 69));
        btnCheckIn.setForeground(Color.WHITE);
        btnCheckIn.setFocusPainted(false);
        btnCheckIn.setEnabled(false);

        gbc.gridy = 0;
        mainPanel.add(lblTime, gbc);
        
        gbc.gridy = 1;
        mainPanel.add(new JSeparator(), gbc);
        
        gbc.gridy = 2;
        mainPanel.add(lblShift, gbc);
        
        gbc.gridy = 3;
        mainPanel.add(lblStatus, gbc);
        
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 10, 10, 10);
        mainPanel.add(btnCheckIn, gbc);

        add(mainPanel, BorderLayout.CENTER);

        btnCheckIn.addActionListener(e -> performCheckIn());
        
        // Timer to update time
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
        updateTime();

        setLocationRelativeTo(getOwner());
    }

    private void updateTime() {
        lblTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
    }

    private LichLamDTO currentLich;

    private void updateCurrentInfo() {
        currentLich = n6_LichLamDAO.getInstance().timLichLamHienTai(maNhanVien);
        if (currentLich == null) {
            lblShift.setText("<html><font color='red'>Không tìm thấy ca làm việc của bạn vào lúc này.</font></html>");
            lblStatus.setText("Trạng thái: Ngoài giờ làm việc");
            btnCheckIn.setEnabled(false);
        } else {
            CaLamDTO cl = n6_CaLamDAO.getInstance().getById(currentLich.getMaCaLam());
            String tenCa = (cl != null) ? cl.getTenCaLam() : currentLich.getMaCaLam();
            lblShift.setText("Ca hiện tại: " + tenCa + " (" + cl.getThoiGianVaoCaLam().substring(0, 5) + " - " + cl.getThoiGianRaCaLam().substring(0, 5) + ")");
            
            int status = currentLich.getTrangThaiDiemDanh();
            if (status == 1) {
                lblStatus.setText("Trạng thái: Đã điểm danh");
                btnCheckIn.setEnabled(false);
                btnCheckIn.setText("Đã hoàn thành điểm danh");
            } else if (status == 2) {
                lblStatus.setText("Trạng thái: Nghỉ phép (Có lương)");
                btnCheckIn.setEnabled(false);
            } else if (status == 3) {
                lblStatus.setText("Trạng thái: Nghỉ (Không lương)");
                btnCheckIn.setEnabled(false);
            } else {
                lblStatus.setText("Trạng thái: Chưa điểm danh");
                btnCheckIn.setEnabled(true);
            }
        }
    }

    private void performCheckIn() {
        if (currentLich != null) {
            boolean success = lichLamBUS.capNhatDiemDanh(maNhanVien, currentLich.getMaCaLam(), currentLich.getNgayLam(), 1);
            if (success) {
                new dialog("Điểm danh thành công!", dialog.SUCCESS_DIALOG);
                updateCurrentInfo();
            } else {
                new dialog("Điểm danh thất bại. Vui lòng thử lại.", dialog.ERROR_DIALOG);
            }
        }
    }
}
