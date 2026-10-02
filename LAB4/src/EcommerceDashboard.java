import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class EcommerceDashboard extends JFrame {
    private final DecimalFormat currencyFormat = new DecimalFormat("#,##0\u00a0VND");

    public EcommerceDashboard() {
        setTitle("E-SHOPPING Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1200, 700));

        JPanel root = new JPanel(new BorderLayout(16, 16));
        root.setBorder(new EmptyBorder(16, 16, 16, 16));
        root.setBackground(new Color(244, 246, 250));

        root.add(createSidebar(), BorderLayout.WEST);
        root.add(createMainContent(), BorderLayout.CENTER);

        setContentPane(root);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(250, 0));
        sidebar.setBackground(new Color(22, 34, 58));
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(33, 52, 73)));
        sidebar.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setOpaque(false);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setBorder(new EmptyBorder(20, 20, 10, 20));

        JLabel logo = new JLabel("E-SHOPPING");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle = new JLabel("Admin Dashboard");
        subtitle.setForeground(new Color(173, 196, 241));
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        top.add(Box.createVerticalStrut(8));
        top.add(logo);
        top.add(Box.createVerticalStrut(4));
        top.add(subtitle);

        JPanel nav = new JPanel();
        nav.setOpaque(false);
        nav.setLayout(new BoxLayout(nav, BoxLayout.Y_AXIS));
        nav.setBorder(new EmptyBorder(20, 12, 12, 12));

        addNavButton(nav, "Tổng quan", true, "▣");
        addNavButton(nav, "Sản phẩm", false, "◫");
        addNavButton(nav, "Đơn hàng", false, "▤");
        addNavButton(nav, "Khách hàng", false, "◌");
        addNavButton(nav, "Báo cáo", false, "◍");
        addNavButton(nav, "Cài đặt", false, "⚙");

        sidebar.add(top, BorderLayout.NORTH);
        sidebar.add(nav, BorderLayout.CENTER);

        JPanel footer = new JPanel();
        footer.setOpaque(false);
        footer.setBorder(new EmptyBorder(10, 20, 20, 20));
        JLabel user = new JLabel("Admin • Online");
        user.setForeground(new Color(220, 232, 255));
        user.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        footer.add(user);
        sidebar.add(footer, BorderLayout.SOUTH);

        return sidebar;
    }

    private void addNavButton(Container container, String text, boolean active, String icon) {
        JButton button = new JButton(icon + "  " + text);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setForeground(active ? Color.WHITE : new Color(195, 210, 233));
        button.setBackground(active ? new Color(52, 96, 214) : new Color(22, 34, 58));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setPreferredSize(new Dimension(200, 42));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!active) {
                    button.setBackground(new Color(36, 56, 92));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!active) {
                    button.setBackground(new Color(22, 34, 58));
                }
            }
        });

        container.add(Box.createVerticalStrut(6));
        container.add(button);
    }

    private JPanel createMainContent() {
        JPanel content = new JPanel(new BorderLayout(20, 20));
        content.setOpaque(false);
        content.setBorder(new EmptyBorder(10, 0, 0, 0));

        JPanel headerBar = new JPanel(new BorderLayout());
        headerBar.setOpaque(false);
        headerBar.setBorder(new EmptyBorder(8, 0, 10, 0));

        JLabel title = new JLabel("Tổng quan hệ thống");
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title.setForeground(new Color(17, 24, 39));

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        actionPanel.setOpaque(false);
        JButton exportBtn = new JButton("Xuất báo cáo");
        JButton addBtn = new JButton("+ Thêm sản phẩm");
        stylePrimaryButton(addBtn);
        styleSecondaryButton(exportBtn);
        actionPanel.add(exportBtn);
        actionPanel.add(addBtn);

        headerBar.add(title, BorderLayout.WEST);
        headerBar.add(actionPanel, BorderLayout.EAST);

        JPanel cards = new JPanel(new GridLayout(1, 4, 18, 0));
        cards.setOpaque(false);
        cards.add(new StatCard("ĐƠN HÀNG", "1,284", "+12.5%", new Color(59, 130, 246), "Trong tháng"));
        cards.add(new StatCard("DOANH THU", "24.8M", "+8.3%", new Color(16, 185, 129), "Tổng tiền"));
        cards.add(new StatCard("KHÁCH HÀNG", "3,962", "+5.1%", new Color(245, 158, 11), "Mới"));
        cards.add(new StatCard("SẢN PHẨM", "1,230", "-2.0%", new Color(168, 85, 247), "Tồn kho"));

        JPanel summaryRow = new JPanel(new GridLayout(1, 2, 18, 0));
        summaryRow.setOpaque(false);
        summaryRow.add(createRevenuePanel());
        summaryRow.add(createTopCategoryPanel());

        JPanel lowerRow = new JPanel(new GridLayout(1, 2, 18, 0));
        lowerRow.setOpaque(false);
        lowerRow.add(createRecentOrdersPanel());
        lowerRow.add(createProductPanel());

        content.add(headerBar, BorderLayout.NORTH);
        content.add(cards, BorderLayout.CENTER);
        content.add(summaryRow, BorderLayout.SOUTH);

        JPanel body = new JPanel(new BorderLayout(18, 18));
        body.setOpaque(false);
        body.add(summaryRow, BorderLayout.NORTH);
        body.add(lowerRow, BorderLayout.CENTER);

        JPanel wrapper = new JPanel(new BorderLayout(0, 16));
        wrapper.setOpaque(false);
        wrapper.add(cards, BorderLayout.NORTH);
        wrapper.add(body, BorderLayout.CENTER);

        content.add(wrapper, BorderLayout.CENTER);
        return content;
    }

    private JPanel createRevenuePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 12));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(229, 231, 235)),
                new EmptyBorder(16, 16, 16, 16)
        ));

        JPanel titleRow = new JPanel(new BorderLayout());
        titleRow.setOpaque(false);

        JLabel title = new JLabel("Doanh thu theo tháng");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        JLabel badge = new JLabel("+18.2% so với tháng trước");
        badge.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        badge.setForeground(new Color(16, 185, 129));
        badge.setOpaque(true);
        badge.setBackground(new Color(236, 253, 245));
        badge.setBorder(new EmptyBorder(6, 10, 6, 10));

        titleRow.add(title, BorderLayout.WEST);
        titleRow.add(badge, BorderLayout.EAST);

        panel.add(titleRow, BorderLayout.NORTH);
        panel.add(new BarChartPanel(), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createTopCategoryPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 12));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(229, 231, 235)),
                new EmptyBorder(16, 16, 16, 16)
        ));

        JLabel title = new JLabel("Danh mục bán chạy");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setOpaque(false);

        list.add(createCategoryRow("Điện tử", 38, new Color(59, 130, 246), "4.8k đơn"));
        list.add(createCategoryRow("Thời trang", 26, new Color(168, 85, 247), "3.2k đơn"));
        list.add(createCategoryRow("Gia dụng", 18, new Color(16, 185, 129), "2.7k đơn"));
        list.add(createCategoryRow("Sắc đẹp", 14, new Color(245, 158, 11), "1.9k đơn"));

        panel.add(list, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createCategoryRow(String name, int percent, Color color, String text) {
        JPanel row = new JPanel(new BorderLayout(10, 0));
        row.setOpaque(false);
        row.setBorder(new EmptyBorder(8, 0, 8, 0));

        JLabel category = new JLabel(name);
        category.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JPanel barWrap = new JPanel(new BorderLayout());
        barWrap.setOpaque(false);
        JProgressBar progress = new JProgressBar(0, 100);
        progress.setValue(percent);
        progress.setStringPainted(false);
        progress.setBackground(new Color(237, 242, 247));
        progress.setForeground(color);
        progress.setBorderPainted(false);
        progress.setPreferredSize(new Dimension(0, 10));
        barWrap.add(progress, BorderLayout.CENTER);

        JLabel count = new JLabel(text);
        count.setFont(new Font("Segoe UI", Font.BOLD, 12));
        count.setForeground(new Color(75, 85, 99));

        row.add(category, BorderLayout.WEST);
        row.add(barWrap, BorderLayout.CENTER);
        row.add(count, BorderLayout.EAST);
        return row;
    }

    private JPanel createRecentOrdersPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 12));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(229, 231, 235)),
                new EmptyBorder(16, 16, 16, 16)
        ));

        JPanel titleRow = new JPanel(new BorderLayout());
        titleRow.setOpaque(false);
        JLabel title = new JLabel("Đơn hàng gần đây");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        JButton viewAll = new JButton("Xem tất cả");
        viewAll.setBorderPainted(false);
        viewAll.setContentAreaFilled(false);
        viewAll.setForeground(new Color(37, 99, 235));
        viewAll.setFocusPainted(false);
        titleRow.add(title, BorderLayout.WEST);
        titleRow.add(viewAll, BorderLayout.EAST);

        panel.add(titleRow, BorderLayout.NORTH);

        String[] columns = {"Mã đơn", "Khách hàng", "Ngày", "Tổng", "Trạng thái"};
        Object[][] data = {
                {"DH-1024", "Nguyễn Văn A", "17/10/2026", "4.500.000", "Đã giao"},
                {"DH-1023", "Trần Thị B", "16/10/2026", "2.120.000", "Đang xử lý"},
                {"DH-1022", "Lê Minh C", "15/10/2026", "8.750.000", "Chờ thanh toán"},
                {"DH-1021", "Phạm Anh D", "14/10/2026", "1.980.000", "Đã hủy"},
                {"DH-1020", "Hoàng Lan E", "13/10/2026", "3.450.000", "Đã giao"}
        };

        JTable table = new JTable(new RecentOrderTableModel(columns, data));
        table.setRowHeight(42);
        table.setFillsViewportHeight(true);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 10));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(248, 250, 252));
        table.getTableHeader().setForeground(new Color(71, 85, 105));
        table.setSelectionBackground(new Color(239, 246, 255));
        table.setSelectionForeground(new Color(17, 24, 39));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createProductPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 12));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(229, 231, 235)),
                new EmptyBorder(16, 16, 16, 16)
        ));

        JLabel title = new JLabel("Sản phẩm nổi bật");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setOpaque(false);

        list.add(createProductItem("Laptop Dell XPS 13", "3.499.000", "Còn hàng", new Color(59, 130, 246)));
        list.add(createProductItem("IPhone 15 Pro Max", "28.990.000", "Hết hàng", new Color(239, 68, 68)));
        list.add(createProductItem("Tai nghe Sony WH-1000XM5", "6.990.000", "Còn hàng", new Color(16, 185, 129)));
        list.add(createProductItem("Máy giặt Samsung 9kg", "8.790.000", "Còn hàng", new Color(245, 158, 11)));

        panel.add(list, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createProductItem(String name, String price, String status, Color statusColor) {
        JPanel item = new JPanel(new BorderLayout(12, 0));
        item.setOpaque(false);
        item.setBorder(new EmptyBorder(8, 0, 8, 0));

        JLabel icon = new JLabel("◉");
        icon.setForeground(statusColor);
        icon.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);
        JLabel productName = new JLabel(name);
        productName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JLabel productPrice = new JLabel(price);
        productPrice.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        productPrice.setForeground(new Color(75, 85, 99));
        info.add(productName);
        info.add(productPrice);

        JLabel statusLabel = new JLabel(status);
        statusLabel.setForeground(statusColor);
        statusLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(new Color(239, 246, 255));
        statusLabel.setBorder(new EmptyBorder(5, 8, 5, 8));

        item.add(icon, BorderLayout.WEST);
        item.add(info, BorderLayout.CENTER);
        item.add(statusLabel, BorderLayout.EAST);
        return item;
    }

    private void stylePrimaryButton(JButton button) {
        button.setBackground(new Color(37, 99, 235));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
    }

    private void styleSecondaryButton(JButton button) {
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(31, 41, 55));
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225)),
                new EmptyBorder(9, 15, 9, 15)
        ));
    }

    private static class StatCard extends JPanel {
        StatCard(String label, String value, String trend, Color accent, String caption) {
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(229, 231, 235)),
                    new EmptyBorder(16, 16, 16, 16)
            ));
            setLayout(new BorderLayout(10, 8));

            JLabel title = new JLabel(label);
            title.setFont(new Font("Segoe UI", Font.BOLD, 12));
            title.setForeground(new Color(100, 116, 139));

            JLabel amount = new JLabel(value);
            amount.setFont(new Font("Segoe UI", Font.BOLD, 28));
            amount.setForeground(new Color(15, 23, 42));

            JLabel delta = new JLabel(trend);
            delta.setForeground(new Color(16, 185, 129));
            delta.setFont(new Font("Segoe UI", Font.BOLD, 11));
            delta.setOpaque(true);
            delta.setBackground(new Color(236, 253, 245));
            delta.setBorder(new EmptyBorder(5, 8, 5, 8));

            JPanel top = new JPanel(new BorderLayout());
            top.setOpaque(false);
            top.add(title, BorderLayout.WEST);
            top.add(delta, BorderLayout.EAST);

            JLabel captionLabel = new JLabel(caption);
            captionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            captionLabel.setForeground(new Color(100, 116, 139));

            JPanel badge = new JPanel(new BorderLayout());
            badge.setOpaque(false);
            badge.setBorder(new EmptyBorder(6, 0, 0, 0));
            badge.add(amount, BorderLayout.CENTER);
            badge.add(captionLabel, BorderLayout.SOUTH);

            add(top, BorderLayout.NORTH);
            add(badge, BorderLayout.CENTER);

            JPanel iconWrap = new JPanel();
            iconWrap.setBackground(accent);
            iconWrap.setPreferredSize(new Dimension(12, 12));
            iconWrap.setBorder(new EmptyBorder(0, 0, 0, 0));
            add(iconWrap, BorderLayout.EAST);
        }
    }

    private static class RecentOrderTableModel extends AbstractTableModel {
        private final String[] columns;
        private final Object[][] data;

        RecentOrderTableModel(String[] columns, Object[][] data) {
            this.columns = columns;
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }
    }

    private static class BarChartPanel extends JPanel {
        private final List<Integer> values = Arrays.asList(34, 58, 42, 72, 61, 84, 70);
        private final List<String> labels = Arrays.asList("T1", "T2", "T3", "T4", "T5", "T6", "T7");

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int paddingLeft = 30;
            int paddingRight = 20;
            int paddingTop = 20;
            int paddingBottom = 35;
            int width = getWidth() - paddingLeft - paddingRight;
            int height = getHeight() - paddingTop - paddingBottom;

            g2.setColor(new Color(224, 232, 240));
            g2.drawLine(paddingLeft, paddingTop, paddingLeft, paddingTop + height);
            g2.drawLine(paddingLeft, paddingTop + height, paddingLeft + width, paddingTop + height);

            int barWidth = (width - 20) / values.size();
            int max = 100;
            for (int i = 0; i < values.size(); i++) {
                int barHeight = (values.get(i) * height) / max;
                int x = paddingLeft + 10 + i * (barWidth + 6);
                int y = paddingTop + height - barHeight;

                GradientPaint gradient = new GradientPaint(x, y, new Color(96, 165, 250), x, y + barHeight, new Color(37, 99, 235));
                g2.setPaint(gradient);
                g2.fillRoundRect(x, y, barWidth - 8, barHeight, 12, 12);

                g2.setColor(new Color(71, 85, 105));
                g2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                g2.drawString(labels.get(i), x, paddingTop + height + 20);
            }

            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            new EcommerceDashboard().setVisible(true);
        });
    }
}
