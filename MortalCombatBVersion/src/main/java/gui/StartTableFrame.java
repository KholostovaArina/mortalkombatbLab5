package gui;

import excel.ExcelManager;
import excel.PlayerScore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class StartTableFrame extends JFrame {

    private ExcelManager excelManager = new ExcelManager();
    private JTable table;
    private DefaultTableModel tableModel;

    public StartTableFrame() {
        setTitle("Таблица рекордов");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(Design.black_blue);

        List<PlayerScore> scores = excelManager.readScores();

        initTable(scores);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Таблица рекордов", SwingConstants.CENTER);
        titleLabel.setFont(Design.font);
        titleLabel.setForeground(Color.WHITE);

        JButton backButton = new JButton("Назад");
        backButton.setFont(Design.font);
        backButton.setBackground(Design.red);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Эффект при наведении
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(Design.red.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(Design.red);
            }
        });

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(backButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(scrollPane);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    private void initTable(List<PlayerScore> scores) {
        tableModel = new DefaultTableModel(new Object[]{"Имя", "Очки"}, 0);
        table = new JTable(tableModel);

        table.setFont(Design.font.deriveFont(22f));
        table.setRowHeight(30);
        table.setGridColor(Color.WHITE);
        table.setIntercellSpacing(new Dimension(10, 5));

        JTableHeader header = table.getTableHeader();
        header.setFont(Design.font);
        header.setBackground(Design.blue);

        for (int i = 0; i < Math.min(scores.size(), 10); i++) {
            PlayerScore score = scores.get(i);
            tableModel.addRow(new Object[]{score.getName(), score.getPoints()});
        }
    }
}