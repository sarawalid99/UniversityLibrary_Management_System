import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AAddBook extends JFrame {
    private JLabel ISBNLabel = new JLabel("Book ISBN:");
    private JTextField ISBNTextField = new JTextField();
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
    private JButton addBookButton = new JButton("Add Book");
    private JButton returnButton = new JButton("Return to Options Menu");
    private JLabel authorNameLabel = new JLabel("Author Name:");
    private JTextField authorNameTextField = new JTextField();
    private JLabel authorNationLabel = new JLabel("Author Nationality:");
    private JTextField authorNationTextField = new JTextField();

    private JPanel bookTitle;

    public AAddBook() {
        setTitle("Add Book");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 20, 10, 20);

        contentPanel.setBackground(new Color(238,210,186,255));
        // Add searchLabel
        contentPanel.add(ISBNLabel, gbc);

        // Add ISBNTextField
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ISBNTextField.setPreferredSize(new Dimension(200, 24));

        contentPanel.add(ISBNTextField, gbc);



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
        categoryTextField.setPreferredSize(new Dimension(200, 24));
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

        gbc.gridx = 0;
        gbc.gridy = 6;
        contentPanel.add(authorNameLabel, gbc);

        // Add publishingYearTextField
        gbc.gridx = 1;
        gbc.gridy = 6;
        contentPanel.add(authorNameTextField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 7;
        contentPanel.add(authorNationLabel, gbc);

        // Add publishingYearTextField
        gbc.gridx = 1;
        gbc.gridy = 7;
        contentPanel.add(authorNationTextField, gbc);

        // Add addBookButton
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(addBookButton, gbc);
        // Add returnButton
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(returnButton, gbc);

        Color btncolor = new Color(173, 147, 124);
        addBookButton.setBackground(btncolor);
        returnButton.setBackground(btncolor);
        addBookButton.setBorderPainted(false);
        addBookButton.setFocusPainted(false);
        returnButton.setBorderPainted(false);
        returnButton.setFocusPainted(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);


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

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action when returnButton is clicked
                Aoption OptionPage = new Aoption();
                OptionPage.setVisible(true);
                dispose();
            }
        });
    }



    public void Book() {
        int ISBN = Integer.parseInt(ISBNTextField.getText());
        String bookTitle = bookTitleTextField.getText();
        String category = categoryTextField.getText();
        String language = languageTextField.getText();
        String edition = editionTextField.getText();
        String publishingYear = publishingYearTextField.getText();
        String authorName = authorNameTextField.getText();
        String authorNation = authorNationTextField.getText();
        Book book = new Book();
        Author Au = new Author(authorName,authorNation,ISBN);
        book.addNewBook(ISBN, bookTitle, category, language, edition, publishingYear);
        Au.addAuthor();
        JOptionPane.showMessageDialog(this, "Book added successfully!");
        Aoption OptionPage = new Aoption();
        OptionPage.setVisible(true);
        dispose();
    }
}

