package form;

import javax.swing.*;
import java.awt.*;

public class FrmMain extends JFrame {

    private JButton btnQuanLySach;
    private JButton btnQuanLyDocGia;
    private JButton btnQuanLyMuonTra;
    private JButton btnDangXuat;

    public FrmMain() {
        setTitle("HỆ THỐNG QUẢN LÝ THƯ VIỆN");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tiêu đề
        JLabel lblTitle = new JLabel("HỆ THỐNG QUẢN LÝ THƯ VIỆN", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Bảng chứa các nút điều hướng
        JPanel pnlMenu = new JPanel(new GridLayout(4, 1, 10, 15));
        pnlMenu.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));

        btnQuanLySach = new JButton("Quản Lý Sách");
        btnQuanLyDocGia = new JButton("Quản Lý Độc Giả");
        btnQuanLyMuonTra = new JButton("Quản Lý Mượn/Trả Sách");
        btnDangXuat = new JButton("Thoát");

        pnlMenu.add(btnQuanLySach);
        pnlMenu.add(btnQuanLyDocGia);
        pnlMenu.add(btnQuanLyMuonTra);
        pnlMenu.add(btnDangXuat);

        add(pnlMenu, BorderLayout.CENTER);

        // --- ĐOẠN XỬ LÝ SỰ KIỆN NẰM Ở ĐÂY ---
        btnQuanLySach.addActionListener(e -> {
            new FrmSach().setVisible(true);
        });

        // Nút mở Form Độc Giả vừa cập nhật:
        btnQuanLyDocGia.addActionListener(e -> {
            new FrmDocGia().setVisible(true);
        });

        btnQuanLyMuonTra.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Chức năng Mượn/Trả đang phát triển!");
        });

        btnDangXuat.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmMain().setVisible(true);
        });
    }
}