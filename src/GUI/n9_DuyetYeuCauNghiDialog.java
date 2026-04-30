package GUI;

import BUS.YeuCauNhanSuBUS;
import DTO.YeuCauNhanSuDTO;
import Util.dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class n9_DuyetYeuCauNghiDialog extends JDialog {

    private final String maQuanLy;
    private final YeuCauNhanSuBUS bus = new YeuCauNhanSuBUS();

    private final JTable table = new JTable();
    private final JButton btnDuyet = new JButton("Duyệt");
    private final JButton btnTuChoi = new JButton("Từ chối");
    private final JButton btnLamMoi = new JButton("Làm mới");
    private final JButton btnDong = new JButton("Đóng");

    public n9_DuyetYeuCauNghiDialog(java.awt.Frame owner, String maQuanLy) {
        super(owner, "Duyệt yêu cầu nghỉ", true);
        this.maQuanLy = maQuanLy;
        initUI();
        loadData();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "Mã YC", "Mã NV", "Loại", "Từ ngày", "Đến ngày", "Lý do", "Trạng thái", "Ngày tạo" }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        JPanel actions = new JPanel();
        actions.add(btnDuyet);
        actions.add(btnTuChoi);
        actions.add(btnLamMoi);
        actions.add(btnDong);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(actions, BorderLayout.SOUTH);

        btnDuyet.addActionListener(e -> duyet(true));
        btnTuChoi.addActionListener(e -> duyet(false));
        btnLamMoi.addActionListener(e -> loadData());
        btnDong.addActionListener(e -> dispose());

        setSize(900, 420);
        setLocationRelativeTo(getOwner());
    }

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<YeuCauNhanSuDTO> list = bus.layDanhSachChoDuyet();
        for (YeuCauNhanSuDTO yc : list) {
            String loaiLabel = YeuCauNhanSuBUS.LOAI_NGHI_VIEC.equals(yc.getLoaiYeuCau()) ? "Nghỉ việc"
                    : "Nghỉ phép";
            model.addRow(new Object[] { yc.getMaYeuCau(), yc.getMaNhanVien(), loaiLabel, yc.getTuNgay(),
                    yc.getDenNgay(), yc.getLyDo(), yc.getTrangThai(), yc.getNgayTao() });
        }
    }

    private void duyet(boolean chapNhan) {
        int row = table.getSelectedRow();
        if (row < 0) {
            new dialog("Vui lòng chọn một yêu cầu.", dialog.WARNING_DIALOG);
            return;
        }
        String maYeuCau = String.valueOf(table.getValueAt(row, 0));
        if (bus.duyetYeuCau(maYeuCau, maQuanLy, chapNhan)) {
            loadData();
        }
    }
}
