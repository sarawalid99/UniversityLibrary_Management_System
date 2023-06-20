import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Slogin extends JFrame {
    private JLabel IDText = new JLabel("ID");
    private JFormattedTextField IDTextField = new JFormattedTextField();
    private JLabel PassText = new JLabel("Password");
    private JPasswordField PassTextField = new JPasswordField();

    private JButton submit = new JButton("Log in");

    public Slogin() {
        setTitle("Log in");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(238,210,186,255));

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Set the spacing between components

        // Set the preferred sizes and fonts for the labels and text fields
        Dimension labelSize = new Dimension(150, 50);
        Dimension textFieldSize = new Dimension(400, 30);
        Font labelFont = new Font("Arial", Font.BOLD, 20);

        IDText.setPreferredSize(labelSize);
        IDText.setFont(labelFont);
        IDTextField.setPreferredSize(textFieldSize);

        PassText.setPreferredSize(labelSize);
        PassText.setFont(labelFont);
        PassTextField.setPreferredSize(textFieldSize);

        submit.setPreferredSize(new Dimension(100, 30));


        Color btncolor = new Color(173, 147, 124);
        submit.setBackground(btncolor);

        submit.setBorderPainted(false);
        submit.setFocusPainted(false);

        // Add components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(IDText, gbc);

        gbc.gridx = 1;
        panel.add(IDTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(PassText, gbc);

        gbc.gridx = 1;
        panel.add(PassTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(submit, gbc);

        panel.setBackground(new Color(238,210,186,255));

        // Use a BorderLayout for the main content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        // Set icon for the JFrame
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());

        setVisible(true);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registerButtonClicked();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    private void registerButtonClicked() throws SQLException {
        String ID= IDTextField.getText();
        String password = PassTextField.getText();
        loginSystem s = new loginSystem();

        if (s.SisAuthenticated(ID,password)) {
            Soption OptionPage = new Soption();
            OptionPage.setVisible(true);
            dispose();
            return;
        }
        JOptionPane.showMessageDialog(this, "Invalid email or password! Please try again", "Error", JOptionPane.ERROR_MESSAGE);


    }
}
