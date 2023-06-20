import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Map;

public class Astatistics extends JFrame {

    private JTable statisticsTable;
    private JTable studentTable;
    private JTable publishingTable;
    private JButton returnButton = new JButton("Return to Options Menu");

    public Astatistics() {
        setTitle("Statistics");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        statisticsTable = new JTable();
        statisticsTable.setBackground(new Color(238,210,186,255));

        studentTable = new JTable();
        studentTable.setBackground(new Color(238,210,186,255));

        publishingTable = new JTable();
        publishingTable.setBackground(new Color(238,210,186,255));

        JScrollPane statisticsScrollPane = new JScrollPane(statisticsTable);
        JScrollPane studentScrollPane = new JScrollPane(studentTable);
        JScrollPane publishingScrollPane = new JScrollPane(publishingTable);

        panel.add(Box.createVerticalGlue());
        panel.add(statisticsScrollPane);
        panel.add(Box.createVerticalGlue());
        panel.add(studentScrollPane);
        panel.add(Box.createVerticalGlue());
        panel.add(publishingScrollPane);
        panel.add(Box.createVerticalGlue());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(returnButton, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
        Color btncolor = new Color(173, 147, 124);
        returnButton.setBackground(btncolor);
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);

        // Get the statistics data
        int numBooks = Statistics.noOfBooks();
        int numStudents = Statistics.noOfStudents();
        int numAdmins = Statistics.noOfAdmins();
        Map<String, Integer> studentCountMap = Statistics.countStudentsByDepartment();
        Map<String, Integer> bookCountMap = Statistics.countBooksByPublishingYear();

        // Set icon for the JFrame
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());

        // Create the statistics table model
        DefaultTableModel statisticsTableModel = new DefaultTableModel(
                new Object[][]{
                        {"Number of Books", numBooks},
                        {"Number of Students", numStudents},
                        {"Number of Admins", numAdmins}
                },
                new Object[]{"Statistic", "Value"}
        );
        statisticsTable.setModel(statisticsTableModel);

        statisticsTable.setEnabled(false); // Disable statisticsTable
        JTableHeader header = statisticsTable.getTableHeader();
        header.setBackground(new Color(154,118,82,255)); // Set the desired background color

        // Create the student table model
        DefaultTableModel studentTableModel = new DefaultTableModel(
                new Object[]{"Department", "Number of Students"},
                0
        );
        for (Map.Entry<String, Integer> entry : studentCountMap.entrySet()) {
            String department = entry.getKey();
            int count = entry.getValue();
            studentTableModel.addRow(new Object[]{department, count});
        }
        studentTable.setModel(studentTableModel);

        studentTable.setEnabled(false); // Disable studentTable
        JTableHeader header2 = studentTable.getTableHeader();
        header2.setBackground(new Color(154,118,82,255)); // Set the desired background color

        // Create the publishing table model
        DefaultTableModel publishingTableModel = new DefaultTableModel(
                new Object[]{"Publishing Year", "Book Count"},
                0
        );
        for (Map.Entry<String, Integer> entry : bookCountMap.entrySet()) {
            String publishingYear = entry.getKey();
            int bookCount = entry.getValue();
            publishingTableModel.addRow(new Object[]{publishingYear, bookCount});
        }
        publishingTable.setModel(publishingTableModel);

        publishingTable.setEnabled(false); // Disable publishingTable
        JTableHeader header3 = publishingTable.getTableHeader();
        header3.setBackground(new Color(154,118,82,255)); // Set the desired background color

        returnButton.addActionListener(e -> {
            // Handle the action when returnButton is clicked
            Aoption OptionPage = new Aoption();
            OptionPage.setVisible(true);
            dispose();
        });
    }

}
