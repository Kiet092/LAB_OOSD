package form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmDocGia extends JFrame {

    private JTextField txtMaDocGia, txtHoTen, txtSoDienThoai, txtEmail;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi;
    private JTable tblDocGia;
    private DefaultTableModel modelTable;

    public FrmDocGia() {
        setTitle("Quản Lý Độc Giả");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Form nhập thông tin
        JPanel pnlInput = new JPanel(new GridLayout(4, 2, 5, 5));
        pnlInput.setBorder(BorderFactory.createTitledBorder("Thông tin độc giả"));

        pnlInput.add(new JLabel(" Mã độc giả:"));
        txtMaDocGia = new JTextField();
        pnlInput.add(txtMaDocGia);

        pnlInput.add(new JLabel(" Họ và tên:"));
        txtHoTen = new JTextField();
        pnlInput.add(txtHoTen);

        pnlInput.add(new JLabel(" Số điện thoại:"));
        txtSoDienThoai = new JTextField();
        pnlInput.add(txtSoDienThoai);

        pnlInput.add(new JLabel(" Email:"));
        txtEmail = new JTextField();
        pnlInput.add(txtEmail);

        add(pnlInput, BorderLayout.NORTH);

        // Bảng danh sách độc giả
        String[] columnNames = {"Mã ĐG", "Họ và Tên", "Số Điện Thoại", "Email"};
        modelTable = new DefaultTableModel(columnNames, 0);
        tblDocGia = new JTable(modelTable);
        JScrollPane scrollPane = new JScrollPane(tblDocGia);
        add(scrollPane, BorderLayout.CENTER);

        // Nút bấm thao tác
        JPanel pnlButtons = new JPanel();
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");

        pnlButtons.add(btnThem);
        pnlButtons.add(btnSua);
        pnlButtons.add(btnXoa);
        pnlButtons.add(btnLamMoi);
        add(pnlButtons, BorderLayout.SOUTH);

        // --- BỔ SUNG XỬ LÝ SỰ KIỆN ---

        // 1. Sự kiện nút Thêm
        btnThem.addActionListener(e -> themDocGia());

        // 2. Sự kiện nút Làm mới
        btnLamMoi.addActionListener(e -> lamMoiForm());
    }

    // Hàm xử lý thêm dữ liệu vào bảng JTable
    private void themDocGia() {
        String ma = txtMaDocGia.getText().trim();
        String ten = txtHoTen.getText().trim();
        String sdt = txtSoDienThoai.getText().trim();
        String email = txtEmail.getText().trim();

        if (ma.isEmpty() || ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ Mã và Tên độc giả!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Thêm hàng mới vào bảng
        modelTable.addRow(new Object[]{ma, ten, sdt, email});
        JOptionPane.showMessageDialog(this, "Thêm độc giả thành công!");
        lamMoiForm();
    }

    // Hàm xóa trắng ô nhập liệu
    private void lamMoiForm() {
        txtMaDocGia.setText("");
        txtHoTen.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        txtMaDocGia.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmDocGia().setVisible(true));
    }
}