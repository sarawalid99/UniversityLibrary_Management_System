import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AEditAcc extends JFrame implements ActionListener {
    private JTextField firstName;
    private JTextField lastName;
    private JTextField City;
    private JTextField Street;

    private JTextField phoneNum;
    private JTextField Role;
    private JTextField id ;
    private JPasswordField Password;

    private JButton saveButton;
    private JButton cancelButton;
    private JButton returnButton ;

    AEditAcc() {
        setTitle("Edit Admin Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        getContentPane().setBackground(new Color(238,210,186,255));

        JLabel idLabel = new JLabel("ID:");
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("LastName:");
        JLabel cityLabel = new JLabel("City:");
        JLabel streetLabel = new JLabel("Street:");
        JLabel phoneNumLabel = new JLabel("phone Number:");
        JLabel RoleLabel = new JLabel("Role:");
        JLabel PasswordLabel = new JLabel("Password:");

        id = new JTextField(loginSystem.admin.getID());
        id.setText(String.valueOf(loginSystem.admin.getID()));
        id.setEnabled(false);
        firstName = new JTextField(loginSystem.admin.getFirstName());
        lastName = new JTextField(loginSystem.admin.getLastName());
        City = new JTextField(loginSystem.admin.getCity());
        Street = new JTextField(loginSystem.admin.getStreet());
        phoneNum = new JTextField(loginSystem.admin.getPhoneNum());
        Role = new JTextField(loginSystem.admin.getRole());
        Password = new JPasswordField(loginSystem.admin.getPassword());


        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        returnButton = new JButton("Return to Options Menu");


        idLabel.setBounds(50, 30, 100, 25);
        id.setBounds(160, 30, 200, 25);
        firstNameLabel.setBounds(50, 70, 100, 25);
        firstName.setBounds(160, 70, 200, 25);
        lastNameLabel.setBounds(50, 110, 100, 25);
        lastName.setBounds(160, 110, 200, 25);
        cityLabel.setBounds(50, 150, 100, 25);
        City.setBounds(160, 150, 200, 25);
        streetLabel.setBounds(50, 190, 100, 25);
        Street.setBounds(160, 190, 200, 25);
        phoneNumLabel.setBounds(50, 230, 100, 25);
        phoneNum.setBounds(160, 230, 200, 25);
        RoleLabel.setBounds(50, 270, 100, 25);
        Role.setBounds(160, 270, 200, 25);
        PasswordLabel.setBounds(50, 310, 100, 25);
        Password.setBounds(160, 310, 200, 25);
        saveButton.setBounds(100, 360, 100, 30);
        cancelButton.setBounds(220, 360, 100, 30);
        returnButton.setBounds(50, 400, 200, 25);

        Color btncolor = new Color(173, 147, 124);
        saveButton.setBackground(btncolor);
        cancelButton.setBackground(btncolor);
        returnButton.setBackground(btncolor);

        saveButton.setBorderPainted(false);
        saveButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);


        // Add labels, fields, and buttons to the frame
        add(idLabel);
        add(id);
        add(firstNameLabel);
        add(firstName);
        add(lastNameLabel);
        add(lastName);
        add(cityLabel);
        add(City);
        add(streetLabel);
        add(Street);
        add(phoneNumLabel);
        add(phoneNum);
        add(RoleLabel);
        add(Role);
        add(PasswordLabel);
        add(Password);

        add(saveButton);
        add(cancelButton);
        add(returnButton);

        // Add action listeners to the buttons
        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
        returnButton.addActionListener(this);

        // Set icon for the JFrame
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());


        // Set layout and visibility
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent e){
        if (e.getSource() == saveButton) {
            String newFirstName = firstName.getText();
            String newLastName = lastName.getText();
            String newCity = City.getText();
            String newStreet = Street.getText();
            String newPhone = phoneNum.getText();
            String newRole = Role.getText();
            String newPassword = Password.getText();

            loginSystem.admin.editfName(loginSystem.admin.getID(), newFirstName);
            loginSystem.admin.editlName(loginSystem.admin.getID(), newLastName);
            loginSystem.admin.editCity(loginSystem.admin.getID(), newCity);
            loginSystem.admin.editStreet(loginSystem.admin.getID(), newStreet);
            if (!RegistrationSystem.isValidPhoneNumber(newPhone)) {
                JOptionPane.showMessageDialog(this, "Invalid phone number. Phone number must be 11 digits long and start with 012, 011, or 015."
                        , "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            loginSystem.admin.editPhone(loginSystem.admin.getID(), newPhone);
            loginSystem.admin.editRole(loginSystem.admin.getID(), newRole);
            if (!RegistrationSystem.isValidPassword(newPassword)) {
                JOptionPane.showMessageDialog(this, "Invalid password. Password must be at least 8 characters long and " +
                        "contain at least one digit and one special character.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            loginSystem.admin.editPass(loginSystem.admin.getID(), newPassword);

            // Display a message dialog to inform the user about the successful update
            JOptionPane.showMessageDialog(this, "Account information updated successfully!");

        }
        else if (e.getSource() == cancelButton) {
            Aoption aoption = new Aoption();
            aoption.setVisible(true);
            // Close the AdminEditAcc form without saving changes
            dispose();
        } else if (e.getSource() == returnButton) {
            Aoption OptionPage = new Aoption();
            OptionPage.setVisible(true);
            dispose();
        }
    }
}



