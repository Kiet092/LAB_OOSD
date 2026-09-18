package form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmSach extends JFrame {

    // Ô nhập dữ liệu
    private JTextField txtMaSach;
    private JTextField txtTenSach;
    private JTextField txtTacGia;
    private JTextField txtTheLoai;
    private JTextField txtNamXuatBan;
    private JTextField txtSoLuong;

    // Nút
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;

    public FrmSach() {
        setTitle("Quản Lý Sách");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo giao diện cơ bản
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        
        panel.add(new JLabel(" Mã sách:"));
        txtMaSach = new JTextField();
        panel.add(txtMaSach);

        panel.add(new JLabel(" Tên sách:"));
        txtTenSach = new JTextField();
        panel.add(txtTenSach);

        panel.add(new JLabel(" Tác giả:"));
        txtTacGia = new JTextField();
        panel.add(txtTacGia);

        panel.add(new JLabel(" Thể loại:"));
        txtTheLoai = new JTextField();
        panel.add(txtTheLoai);

        panel.add(new JLabel(" Năm xuất bản:"));
        txtNamXuatBan = new JTextField();
        panel.add(txtNamXuatBan);

        panel.add(new JLabel(" Số lượng:"));
        txtSoLuong = new JTextField();
        panel.add(txtSoLuong);

        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");

        JPanel pnlButtons = new JPanel();
        pnlButtons.add(btnThem);
        pnlButtons.add(btnSua);
        pnlButtons.add(btnXoa);

        add(panel, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmSach().setVisible(true);
        });
    }
}