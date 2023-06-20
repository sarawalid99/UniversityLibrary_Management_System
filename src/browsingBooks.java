import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class browsingBooks extends JFrame {
    private JTable table;
    private JComboBox<String> searchCriteriaComboBox;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton returnButton ;


    public browsingBooks() {
        setTitle("Search for a book");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create a panel for search components
        JPanel searchPanel = new JPanel();
        searchCriteriaComboBox = new JComboBox<>(new String[]{"ISBN", "Title", "Category", "Author", "Publishing Year"});
        searchCriteriaComboBox.setBackground(Color.white);
        searchCriteriaComboBox.setForeground(new Color(238,210,186,255));

        searchTextField = new JTextField(20);
        searchButton = new JButton("Search");
        returnButton = new JButton("Return to Options Menu");
        searchPanel.setBackground(new Color(238,210,186,255));

        // Add components to the search panel
        searchPanel.add(searchCriteriaComboBox);
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);
        searchPanel.add(returnButton);


        // Create a DefaultTableModel to store the table data
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add column names to the table model
        tableModel.addColumn("ISBN");
        tableModel.addColumn("Title");
        tableModel.addColumn("Category");
        tableModel.addColumn("Language");
        tableModel.addColumn("Edition");
        tableModel.addColumn("Publishing Year");
        tableModel.addColumn("Author");

        // Create the JTable with the populated table model
        table = new JTable(tableModel);
        table.setBackground(new Color(238,210,186,255));
        // Set the layout manager for the content pane
        getContentPane().setLayout(new BorderLayout());
        table.setEnabled(false);

        // Add the search panel to the content pane
        getContentPane().add(searchPanel, BorderLayout.NORTH);

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(238,210,186,255));

        // Add the scroll pane to the content pane
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        Color btncolor = new Color(173, 147, 124);
        searchButton.setBackground(btncolor);
        returnButton.setBackground(btncolor);

        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);

        // Add ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
            Display display = new Display();
            ArrayList<Book> searchResult = new ArrayList<>();
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchCriteria = (String) searchCriteriaComboBox.getSelectedItem();
                String searchTerm = searchTextField.getText();

                // Call the Display class method to search by the chosen criteria and get the result

                try {
                    if (searchCriteria.equals("ISBN")) {
                        searchResult = display.searchByISBN(searchTerm);
                    } else if (searchCriteria.equals("Title")) {
                        searchResult = display.searchByTitle(searchTerm);
                    } else if (searchCriteria.equals("Category")) {
                        searchResult = display.searchByCategory(searchTerm);
                    } else if (searchCriteria.equals("Author")) {
                        searchResult = display.searchByAuthor(searchTerm);
                    } else if (searchCriteria.equals("Publishing Year")) {
                        searchResult = display.searchByYear(searchTerm);
                    }

                    // Clear the table
                    tableModel.setRowCount(0);

                    // Add row data to the table model
                    for (Book book : searchResult) {
                        Object[] rowData = {book.getISBN(), book.getTitle(), book.getCategory(), book.getLanguage(),
                                book.getEdition(), book.getPublishingYear(), book.getAuthor()};
                        tableModel.addRow(rowData);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                // Clear the table model
                tableModel.setRowCount(0);

                // Add row data to the table model
                for (Book book : searchResult) {
                    Object[] rowData = {book.getISBN(), book.getTitle(), book.getCategory(),
                            book.getLanguage(), book.getEdition(), book.getPublishingYear(), book.getAuthor()};
                    tableModel.addRow(rowData);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginSystem.student == null){
                    Aoption OptionPage = new Aoption();
                    OptionPage.setVisible(true);
                    dispose();
                } else if(loginSystem.admin == null){
                    Soption OptionPage = new Soption();
                    OptionPage.setVisible(true);
                    dispose();
                }
            }
        });


        Display display = new Display();
        ArrayList<Book> searchResult = new ArrayList<>();
        try {
            searchResult = display.viewAllBooks();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        for (Book book : searchResult) {
            Object[] rowData = {book.getISBN(), book.getTitle(), book.getCategory(),
                    book.getLanguage(), book.getEdition(), book.getPublishingYear(), book.getAuthor()};
            tableModel.addRow(rowData);
        }

        // Set icon for the JFrame
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());

        setVisible(true);
    }
}
