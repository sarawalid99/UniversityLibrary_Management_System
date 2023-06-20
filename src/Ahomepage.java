import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Ahomepage extends JFrame {
    private JButton signupButton;
    private JButton logInButton;

    public Ahomepage() {
        setTitle("Admin Homepage");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(238,210,186,255));

        signupButton = new JButton("Sign In");
        logInButton = new JButton("Log In");

        signupButton.setFont(new Font("Arial", Font.PLAIN, 20));
        logInButton.setFont(new Font("Arial", Font.PLAIN, 20));

        signupButton.setPreferredSize(new Dimension(200, 60));
        logInButton.setPreferredSize(new Dimension(200, 60));

        Color btncolor = new Color(173, 147, 124);
        signupButton.setBackground(btncolor);
        logInButton.setBackground(btncolor);
        signupButton.setBorderPainted(false);
        signupButton.setFocusPainted(false);
        logInButton.setBorderPainted(false);
        logInButton.setFocusPainted(false);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your sign in logic here
                AsignUp asignUp = new AsignUp();
                asignUp.setVisible(true);
                dispose();
            }
        });

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your log in logic here
                Alogin alogin = null;
                try {
                    alogin = new Alogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                alogin.setVisible(true);
                dispose(); // Close the login form
            }
        });

        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Add some vertical spacing

        JPanel signupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        signupPanel.add(signupButton);
        getContentPane().add(signupPanel, gbc);
        signupPanel.setBackground(new Color (238,210,186,255));

        gbc.gridy = 1;

        JPanel logInPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logInPanel.add(logInButton);
        getContentPane().add(logInPanel, gbc);
        logInPanel.setBackground(new Color (238,210,186,255));

        // Set icon for the JFrame
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());

        setVisible(true);
    }
    
}
