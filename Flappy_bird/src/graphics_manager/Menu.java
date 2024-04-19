package graphics_manager;

import javax.imageio.ImageIO;
import javax.swing.*;

import flappybird.FlappyBird;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu extends JFrame {
    private JPanel contentPane;
    private BufferedImage backgroundImage;

    public Menu() {
        setTitle("Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        loadBackgroundImage();

        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);
        contentPane.add(titlePanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Flappy Bird");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        titleLabel.setForeground(Color.WHITE);

        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.insets = new Insets(50, 0, 0, 0);
        titlePanel.add(titleLabel, titleConstraints);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 0, 5, 0); // Khoảng cách 5px giữa các nút

        JButton playButton = new JButton("New Game");
        playButton.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(new Color(0, 128, 0));
        playButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khởi chạy trò chơi khi nhấn nút "New Game"
                startGame();
            }
        });
        buttonPanel.add(playButton, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(5, 0, 5, 0); // Khoảng cách 5px giữa các nút
        JButton helpButton = new JButton("Help");
        helpButton.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        helpButton.setForeground(Color.WHITE);
        helpButton.setBackground(new Color(0, 128, 0));
        helpButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHelpDialog();
            }
        });
        buttonPanel.add(helpButton, gbc);

        gbc.gridy++;
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(0, 128, 0));
        exitButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Thoát trò chơi
            }
        });
        buttonPanel.add(exitButton, gbc);

        setVisible(true);
    }

    private void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(Menu.class.getResource("/Assets/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showHelpDialog() {
        JOptionPane.showMessageDialog(this,
                "Hướng dẫn:\n" +
                        "Hãy ấn chuột trái hoặc nút Space để giúp chú chim Kim Anh vỗ cánh, từ đó tránh các trướng ngại vật và dành điểm cao bạn nhé!.\n",
                "Hướng dẫn",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void startGame() {
        FlappyBird flappyBird = new FlappyBird();
        flappyBird.setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}
