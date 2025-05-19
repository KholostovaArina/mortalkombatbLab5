package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame {

    public FirstFrame() {
        setTitle("Mortal Kombat");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Design.black_blue);

        // Основная панель с вертикальным расположением
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Заголовок
        JLabel titleLabel = new JLabel("Mortal Kombat");
        titleLabel.setFont(Design.font.deriveFont(46f));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Подзаголовок
        JLabel subtitleLabel = new JLabel("Legacy Edition");
        subtitleLabel.setFont(Design.font.deriveFont(22f));
        subtitleLabel.setForeground(Design.yellow);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Логотип
        JLabel logoLabel = new JLabel(new ImageIcon(Design.logo));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Панель с кнопками
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Кнопка "Начать игру"
        JButton startButton = new JButton("Начать игру");
        customizeButton(startButton, Design.green, Design.green.darker());

        // Кнопка "Таблица рекордов"
        JButton tableButton = new JButton("Таблица рекордов");
        customizeButton(tableButton, Design.blue, Design.blue.darker());

        // Обработчики событий
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new LocationFrame().setVisible(true);
            }
        });

        tableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartTableFrame().setVisible(true);
            }
        });

        // Добавляем элементы на панель
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(subtitleLabel);
        centerPanel.add(Box.createVerticalStrut(40));
        centerPanel.add(logoLabel);
        centerPanel.add(Box.createVerticalStrut(40));

        buttonPanel.add(startButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(tableButton);
        centerPanel.add(buttonPanel);

        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel);
        setVisible(true);
    }

    // Метод для стилизации кнопок
    private void customizeButton(JButton button, Color baseColor, Color hoverColor) {
        button.setFont(Design.font);
        button.setBackground(baseColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        // Эффект при наведении
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(baseColor);
            }
        });
    }
}
