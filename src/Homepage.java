import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame {
    private JButton adminButton;
    private JButton studentButton;

    public Homepage() {
        setTitle("University Library System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Background Image
        ImageIcon backgroundImage = new ImageIcon("photo.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 800, 600);
        getContentPane().add(backgroundLabel);

        JLabel welcomeLabel = new JLabel("Welcome! \n Are you Admin or Student?");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(94,70,58,255));

        adminButton = new JButton("Admin");
        studentButton = new JButton("Student");
        adminButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        studentButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        adminButton.setPreferredSize(new Dimension(150, 50));
        studentButton.setPreferredSize(new Dimension(150, 50));

        Color btncolor = new Color(173, 147, 124);
        adminButton.setBackground(btncolor);
        studentButton.setBackground(btncolor);
        adminButton.setBorderPainted(false);
        adminButton.setFocusPainted(false);
        studentButton.setBorderPainted(false);
        studentButton.setFocusPainted(false);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ahomepage adminHomePage = new Ahomepage();
                adminHomePage.setVisible(true);
                dispose();
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shomepage studentHomePage = new Shomepage();
                studentHomePage.setVisible(true);
                dispose();
            }
        });

        getContentPane().setLayout(null); // Use null layout for absolute positioning

        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.setOpaque(false); // Make the panel transparent
        welcomePanel.setBounds(0, 200, 800, 100); // Set the position and size of the panel
        welcomePanel.add(welcomeLabel);
        backgroundLabel.add(welcomePanel);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); // Make the panel transparent
        buttonPanel.setBounds(0, 300, 800, 100); // Set the position and size of the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Add some vertical spacing
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(adminButton, gbc);

        gbc.gridy = 1;
        buttonPanel.add(studentButton, gbc);
        backgroundLabel.add(buttonPanel);

        // Set icon for the JFrame
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());
        
        setVisible(true);
    }

}
