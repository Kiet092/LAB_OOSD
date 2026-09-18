package form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmMuonTra extends JFrame {

    private JTextField txtMaPhieu, txtMaDocGia, txtMaSach, txtNgayMuon, txtNgayHenTra;
    private JButton btnMuonSach, btnTraSach, btnLamMoi;
    private JTable tblMuonTra;
    private DefaultTableModel modelTable;

    public FrmMuonTra() {
        setTitle("Quản Lý Mượn / Trả Sách");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Form nhập thông tin
        JPanel pnlInput = new JPanel(new GridLayout(5, 2, 5, 5));
        pnlInput.setBorder(BorderFactory.createTitledBorder("Thông tin phiếu mượn"));

        pnlInput.add(new JLabel(" Mã phiếu mượn:"));
        txtMaPhieu = new JTextField();
        pnlInput.add(txtMaPhieu);

        pnlInput.add(new JLabel(" Mã độc giả:"));
        txtMaDocGia = new JTextField();
        pnlInput.add(txtMaDocGia);

        pnlInput.add(new JLabel(" Mã sách:"));
        txtMaSach = new JTextField();
        pnlInput.add(txtMaSach);

        pnlInput.add(new JLabel(" Ngày mượn:"));
        txtNgayMuon = new JTextField();
        pnlInput.add(txtNgayMuon);

        pnlInput.add(new JLabel(" Ngày hẹn trả:"));
        txtNgayHenTra = new JTextField();
        pnlInput.add(txtNgayHenTra);

        add(pnlInput, BorderLayout.NORTH);

        // Bảng phiếu mượn
        String[] columnNames = {"Mã Phiếu", "Mã Độc Giả", "Mã Sách", "Ngày Mượn", "Ngày Hẹn Trả", "Trạng Thái"};
        modelTable = new DefaultTableModel(columnNames, 0);
        tblMuonTra = new JTable(modelTable);
        JScrollPane scrollPane = new JScrollPane(tblMuonTra);
        add(scrollPane, BorderLayout.CENTER);

        // Nút thao tác
        JPanel pnlButtons = new JPanel();
        btnMuonSach = new JButton("Mượn Sách");
        btnTraSach = new JButton("Trả Sách");
        btnLamMoi = new JButton("Làm Mới");

        pnlButtons.add(btnMuonSach);
        pnlButtons.add(btnTraSach);
        pnlButtons.add(btnLamMoi);
        add(pnlButtons, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmMuonTra().setVisible(true));
    }
}