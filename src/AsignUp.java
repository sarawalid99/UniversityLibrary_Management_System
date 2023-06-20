import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AsignUp extends JFrame {
    private JLabel fnameText = new JLabel("First Name");
    private JFormattedTextField fnameTextField = new JFormattedTextField();
    private JLabel lnameText = new JLabel("Last Name");
    private JFormattedTextField lnameTextField = new JFormattedTextField();

    private JLabel IDText = new JLabel( "ID");
    private JFormattedTextField IDTextField = new JFormattedTextField();

    private JLabel CityText = new JLabel( "City");
    private JFormattedTextField CityTextField = new JFormattedTextField();

    private JLabel StreetText = new JLabel( "Street");
    private JFormattedTextField StreetTextField = new JFormattedTextField();

    private JLabel PHText = new JLabel( "Phone");
    private JFormattedTextField PHTextField = new JFormattedTextField();
    private JLabel genderText = new JLabel( "Gender");
    private JFormattedTextField genderTextField = new JFormattedTextField();
    private JLabel RoleText = new JLabel( "Role");
    private JFormattedTextField RoleTextField = new JFormattedTextField();
    private JLabel passText = new JLabel( "Password");
    private JPasswordField passTextField = new JPasswordField();
    private JButton submit = new JButton("Sign Up");



    public AsignUp() {
        setTitle("Sign Up");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10); // Set the spacing between components

        panel.setBackground(new Color (238,210,186,255));

        // Set the preferred sizes and fonts for the labels and text fields
        Dimension labelSize = new Dimension(150, 50);
        Dimension textFieldSize = new Dimension(400, 30);
        Font labelFont = new Font("Arial", Font.BOLD, 20);

        getContentPane().setBackground(new Color(238, 210, 186, 255));

        fnameText.setPreferredSize(labelSize);
        fnameText.setFont(labelFont);
        fnameTextField.setPreferredSize(textFieldSize);

        lnameText.setPreferredSize(labelSize);
        lnameText.setFont(labelFont);
        lnameTextField.setPreferredSize(textFieldSize);

        IDText.setPreferredSize(labelSize);
        IDText.setFont(labelFont);
        IDTextField.setPreferredSize(textFieldSize);

        CityText.setPreferredSize(labelSize);
        CityText.setFont(labelFont);
        CityTextField.setPreferredSize(textFieldSize);

        StreetText.setPreferredSize(labelSize);
        StreetText.setFont(labelFont);
        StreetTextField.setPreferredSize(textFieldSize);

        PHText.setPreferredSize(labelSize);
        PHText.setFont(labelFont);
        PHTextField.setPreferredSize(textFieldSize);

        genderText.setPreferredSize(labelSize);
        genderText.setFont(labelFont);
        genderTextField.setPreferredSize(textFieldSize);

        RoleText.setPreferredSize(labelSize);
        RoleText.setFont(labelFont);
        RoleTextField.setPreferredSize(textFieldSize);

        passText.setPreferredSize(labelSize);
        passText.setFont(labelFont);
        passTextField.setPreferredSize(textFieldSize);

        submit.setPreferredSize(new Dimension(100, 30));


        fnameText.setPreferredSize(new Dimension(150, 30));
        fnameTextField.setPreferredSize(new Dimension(400, 30));

        lnameText.setPreferredSize(new Dimension(150, 30));
        lnameTextField.setPreferredSize(new Dimension(400, 30));

        IDText.setPreferredSize(new Dimension(150, 30));
        IDTextField.setPreferredSize(new Dimension(400, 30));

        CityText.setPreferredSize(new Dimension(150, 30));
        CityTextField.setPreferredSize(new Dimension(400, 30));

        StreetText.setPreferredSize(new Dimension(150, 30));
        StreetTextField.setPreferredSize(new Dimension(400, 30));

        PHText.setPreferredSize(new Dimension(150, 30));
        PHTextField.setPreferredSize(new Dimension(400, 30));

        genderText.setPreferredSize(new Dimension(150, 30));
        genderTextField.setPreferredSize(new Dimension(400, 30));

        RoleText.setPreferredSize(new Dimension(150, 30));
        RoleTextField.setPreferredSize(new Dimension(400, 30));

        passText.setPreferredSize(new Dimension(150, 30));
        passTextField.setPreferredSize(new Dimension(400, 30));

        submit.setPreferredSize(new Dimension(100, 30));


        // Add components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(fnameText, gbc);

        gbc.gridx = 1;
        panel.add(fnameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lnameText, gbc);

        gbc.gridx = 1;
        panel.add(lnameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(IDText, gbc);

        gbc.gridx = 1;
        panel.add(IDTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(CityText, gbc);

        gbc.gridx = 1;
        panel.add(CityTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(StreetText, gbc);

        gbc.gridx = 1;
        panel.add(StreetTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(PHText, gbc);

        gbc.gridx = 1;
        panel.add(PHTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(genderText, gbc);

        gbc.gridx = 1;
        panel.add(genderTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(RoleText, gbc);

        gbc.gridx = 1;
        panel.add(RoleTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(passText, gbc);

        gbc.gridx = 1;
        panel.add(passTextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0); // Adjust spacing for the button
        gbc.gridwidth = 2;
        panel.add(submit, gbc);

        Color btncolor = new Color(173, 147, 124);
        submit.setBackground(btncolor);
        submit.setBorderPainted(false);
        submit.setFocusPainted(false);

        // Use a BorderLayout for the main content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);

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
        });}
        private void registerButtonClicked() throws SQLException {
            int id = Integer.parseInt(IDTextField.getText());
            String firstName = fnameTextField.getText();
            String lastName = lnameTextField.getText();
            String street = StreetTextField.getText();
            String city = CityTextField.getText();
            String phoneNum = PHTextField.getText();
            String gender = genderTextField.getText();
            String role = RoleTextField.getText();
            String password = passTextField.getText();
            RegistrationSystem obj = new RegistrationSystem();
            if (!obj.isValidPassword(password)) {
                JOptionPane.showMessageDialog(this, "Invalid password. Password must be at least 8 characters long and " +
                        "contain at least one digit and one special character.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

             if (!obj.isValidPhoneNumber(phoneNum)) {
                JOptionPane.showMessageDialog(this, "Invalid phone number. Phone number must be 11 digits long and start with 012, 011, or 015.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            obj.adminSignUp(id, firstName, lastName, city, street, phoneNum, gender, role, password);
            Alogin OptionPage = new Alogin();
            OptionPage.setVisible(true);
            dispose();
        }




}

