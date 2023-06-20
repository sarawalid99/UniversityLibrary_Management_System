import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sdelete extends JFrame implements ActionListener {
    //AYA ALI WAS HERE
    private JButton deleteButton;
    private JTextField id;
    private JButton returnButton;

    Sdelete() {
        setTitle("Delete Student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        getContentPane().setBackground(new Color(238, 210, 186, 255));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(getContentPane().getBackground());

        JLabel idLabel = new JLabel("Student ID:");
        id = new JTextField();
        deleteButton = new JButton("Delete");
        returnButton = new JButton("Return to Options Menu");

        idLabel.setBounds(50, 30, 100, 25);
        id.setBounds(160, 30, 200, 25);
        deleteButton.setBounds(50, 70, 100, 25);
        returnButton.setBounds(50, 110, 200, 25);


        Color btncolor = new Color(173, 147, 124);
        deleteButton.setBackground(btncolor);
        returnButton.setBackground(btncolor);

        deleteButton.setBorderPainted(false);
        deleteButton.setFocusPainted(false);
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);

        panel.add(idLabel);
        panel.add(id);
        panel.add(deleteButton);
        panel.add(returnButton);

        deleteButton.addActionListener(this);
        returnButton.addActionListener(this);

        // Set icon for the JFrame
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());

        // Set panel to be centered
        panel.setSize(400, 200);
        panel.setLocation((getWidth() - panel.getWidth()) / 2, (getHeight() - panel.getHeight()) / 2);

        getContentPane().add(panel);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            String deleteId = id.getText();
            Student student = new Student();
            if (student.deleteStudent(Integer.parseInt(String.valueOf(deleteId)))) {
                JOptionPane.showMessageDialog(this, "Student deleted successfully!");
                Aoption OptionPage = new Aoption();
                OptionPage.setVisible(true);
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (e.getSource() == returnButton) {
            Aoption OptionPage = new Aoption();
            OptionPage.setVisible(true);
            dispose();
        }
    }

}
