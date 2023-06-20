import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AEditBook extends JFrame {
    private JLabel searchLabel = new JLabel("Book ISBN:");
    private JButton searchButton = new JButton("Search");
    private JTextField searchISBNTextField = new JTextField();
    private JLabel bookTitleLabel = new JLabel("Book Title:");
    private JTextField bookTitleTextField = new JTextField();

    private JLabel categoryLabel = new JLabel("Category:");
    private JTextField categoryTextField = new JTextField();
    private JLabel languageLabel = new JLabel("Language:");
    private JTextField languageTextField = new JTextField();
    private JLabel editionLabel = new JLabel("Edition:");
    private JTextField editionTextField = new JTextField();
    private JLabel publishingYearLabel = new JLabel("<html>Publishing<br>Year:</html>");
    private JTextField publishingYearTextField = new JTextField();
    private JButton addBookButton = new JButton("Edit Book");
    private JButton returnButton = new JButton("Return to Options Menu");
    private JButton Delete = new JButton("Delete");


    public AEditBook() {
        setTitle("Edit Book");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 5, 10, 5);
        contentPanel.setBackground(new Color(238,210,186,255));
        // Add searchLabel
        contentPanel.add(searchLabel, gbc);

        // Add searchISBNTextField
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        searchISBNTextField.setPreferredSize(new Dimension(200, 24));
        contentPanel.add(searchISBNTextField, gbc);

        // Add searchButton
        gbc.gridx = 2;
        contentPanel.add(searchButton, gbc);


        // Add bookTitleLabel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(bookTitleLabel, gbc);
        // Add bookTitleTextField
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(bookTitleTextField, gbc);

        // Add categoryLabel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(categoryLabel, gbc);

        // Add categoryTextField
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        contentPanel.add(categoryTextField, gbc);

        // Add languageLabel
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPanel.add(languageLabel, gbc);

        // Add languageTextField
        gbc.gridx = 1;
        gbc.gridy = 3;
        contentPanel.add(languageTextField, gbc);

        // Add editionLabel
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPanel.add(editionLabel, gbc);

        // Add editionTextField
        gbc.gridx = 1;
        gbc.gridy = 4;
        contentPanel.add(editionTextField, gbc);

        // Add publishingYearLabel
        gbc.gridx = 0;
        gbc.gridy = 5;
        contentPanel.add(publishingYearLabel, gbc);

        // Add publishingYearTextField
        gbc.gridx = 1;
        gbc.gridy = 5;
        contentPanel.add(publishingYearTextField, gbc);

        // Add addBookButton
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(addBookButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(Delete, gbc);
        Color btn2color = new Color(173, 147, 124);
        Delete.setBackground(btn2color);
        Delete.setBorderPainted(false);
        Delete.setFocusPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        Color btncolor = new Color(173, 147, 124);
        returnButton.setBackground(btncolor);
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);
        contentPanel.add(returnButton, gbc);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);


        addBookButton.setBackground(btncolor);
        searchButton.setBackground(btncolor);

        addBookButton.setBorderPainted(false);
        addBookButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);

        getContentPane().setBackground(new Color(238,210,186,255));

        // Set icon for the JFrame
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());

        setVisible(true);

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Book();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    searchBook();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action when returnButton is clicked
                Aoption OptionPage = new Aoption();
                OptionPage.setVisible(true);
                dispose();
            }
        });
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action when returnButton is clicked
                DeleteBook();
            }
        });
    }
    public void Book() {
        Book book = new Book();
        String ISBN = searchISBNTextField.getText();
        String title =  bookTitleTextField.getText();
        String category =  categoryTextField.getText();
        String language = languageTextField.getText();
        String edition =editionTextField.getText();
        String publishingYear = publishingYearTextField.getText();
        book.updateBookTitle(Integer.parseInt(ISBN),title);
        book.updateBookCategory(Integer.parseInt(ISBN),category);
        book.updateBookEdition(Integer.parseInt(ISBN),language);
        book.updateBookLanguage(Integer.parseInt(ISBN),edition);
        book.updateBookPublisingYear(Integer.parseInt(ISBN),publishingYear);
        JOptionPane.showMessageDialog(this, "Book updated successfully!");
        Aoption OptionPage = new Aoption();
        OptionPage.setVisible(true);
        dispose();
    }
    public void searchBook() throws SQLException {
        String ISBN = searchISBNTextField.getText();
        ArrayList<Book> bookList;
        bookList = Display.searchByISBN(ISBN);
        if (!bookList.isEmpty()) {
            Book book = bookList.get(0);
            String bookTitle = book.getTitle();
            String category = book.getCategory();
            String language = book.getLanguage();
            String edition = book.getEdition();
            String publishingYear = book.getPublishingYear();
            bookTitleTextField.setText(bookTitle);
            categoryTextField.setText(category);
            languageTextField.setText(language);
            editionTextField.setText(edition);
            publishingYearTextField.setText(publishingYear);
        }else{
            JOptionPane.showMessageDialog(this, "Invalid ISBN!"
                    , "Error", JOptionPane.ERROR_MESSAGE);

        }

    }
    public void DeleteBook(){
        Book book = new Book();
        String ISBN = searchISBNTextField.getText();
        book.deleteBook(Integer.parseInt(ISBN));
        JOptionPane.showMessageDialog(this, "Book deleted successfully!"
                , "Message", JOptionPane.ERROR_MESSAGE);
        Aoption OptionPage = new Aoption();
        OptionPage.setVisible(true);
        dispose();
    }

}
