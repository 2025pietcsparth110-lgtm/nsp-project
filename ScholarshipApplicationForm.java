
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ScholarshipApplicationForm extends JFrame {

    private JTextField studentNameField;
    private JTextField registrationIdField;
    private JComboBox<String> courseCombo;
    private JComboBox<String> yearCombo;
    private JTextField marksField;
    private JTextField incomeField;

    private JRadioButton scButton;
    private JRadioButton stButton;
    private JRadioButton obcButton;
    private JRadioButton generalButton;

    private JTextField accountHolderField;
    private JTextField accountNumberField;
    private JTextField ifscField;

    private JComboBox<String> scholarshipCombo;
    private JLabel uploadStatus;
    private File[] selectedFiles;

    private final Color BLUE = new Color(25, 83, 190);
    private final Color DARK_BLUE = new Color(20, 45, 100);
    private final Color LIGHT_BLUE = new Color(230, 239, 255);
    private final Color BORDER = new Color(205, 216, 235);

    public ScholarshipApplicationForm() {

        setTitle("Scholarship Management System - Application Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(850, 850);
        setMinimumSize(new Dimension(650, 650));
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // HEADER
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(BLUE);
        header.setBorder(new EmptyBorder(15, 10, 14, 10));

        JLabel title = new JLabel(
                "\uD83C\uDF93 Scholarship Management System"
        );
        title.setFont(new Font("Arial", Font.BOLD, 21));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Scholarship Application Form");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(Color.WHITE);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(8));
        header.add(subtitle);

        mainPanel.add(header, BorderLayout.NORTH);

        // SCROLLABLE FORM
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(new EmptyBorder(12, 12, 12, 12));

        // INTRODUCTION BOX
        JPanel intro = new JPanel();
        intro.setLayout(new BoxLayout(intro, BoxLayout.Y_AXIS));
        intro.setBackground(LIGHT_BLUE);
        intro.setBorder(new EmptyBorder(15, 12, 15, 12));
        intro.setAlignmentX(Component.LEFT_ALIGNMENT);
        intro.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        JLabel introTitle = new JLabel("Submit Your Application");
        introTitle.setFont(new Font("Arial", Font.BOLD, 15));
        introTitle.setForeground(BLUE);

        JLabel introText = new JLabel(
                "Fill in your academic and financial details to apply for a scholarship."
        );
        introText.setFont(new Font("Arial", Font.PLAIN, 13));
        introText.setForeground(DARK_BLUE);

        intro.add(introTitle);
        intro.add(Box.createVerticalStrut(8));
        intro.add(introText);

        formPanel.add(intro);
        formPanel.add(Box.createVerticalStrut(16));

        // 1. STUDENT DETAILS
        addSectionTitle(formPanel, "1. Student Details *");

        JPanel studentGrid = new JPanel(new GridLayout(1, 2, 10, 0));
        studentGrid.setBackground(Color.WHITE);
        studentGrid.setAlignmentX(Component.LEFT_ALIGNMENT);
        studentGrid.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 76)
        );

        studentNameField = new JTextField();
        registrationIdField = new JTextField();

        studentGrid.add(createField(
                "Student Name", studentNameField, "Enter full name"
        ));
        studentGrid.add(createField(
                "Registration ID", registrationIdField, "Enter ID"
        ));

        formPanel.add(studentGrid);
        addSeparator(formPanel);

        // 2. ACADEMIC DETAILS
        addSectionTitle(formPanel, "2. Academic Details *");

        courseCombo = new JComboBox<>(new String[]{
                "Select course",
                "B.Tech - CSE",
                "B.Tech - IT",
                "B.Tech - ECE",
                "B.Tech - Mechanical",
                "B.Tech - Civil",
                "BCA",
                "BBA",
                "B.Sc",
                "B.Com",
                "Other"
        });

        styleCombo(courseCombo);

        formPanel.add(createField(
                "Course / Branch", courseCombo, null
        ));
        formPanel.add(Box.createVerticalStrut(12));

        JPanel academicGrid = new JPanel(new GridLayout(1, 2, 10, 0));
        academicGrid.setBackground(Color.WHITE);
        academicGrid.setAlignmentX(Component.LEFT_ALIGNMENT);
        academicGrid.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 76)
        );

        yearCombo = new JComboBox<>(new String[]{
                "Select year",
                "1st Year",
                "2nd Year",
                "3rd Year",
                "4th Year",
                "Final Year"
        });

        styleCombo(yearCombo);
        marksField = new JTextField();

        academicGrid.add(createField(
                "Current Year", yearCombo, null
        ));
        academicGrid.add(createField(
                "Previous Marks (%)", marksField, "Enter percentage"
        ));

        formPanel.add(academicGrid);
        addSeparator(formPanel);

        // 3. FAMILY INCOME
        addSectionTitle(formPanel, "3. Family Income *");

        incomeField = new JTextField();
        formPanel.add(createField(
                "Annual Family Income (₹)", incomeField,
                "Annual family income (₹)"
        ));

        addSeparator(formPanel);

        // 4. CATEGORY
        addSectionTitle(formPanel, "4. Category *");

        JPanel categoryPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 12, 2)
        );
        categoryPanel.setBackground(Color.WHITE);
        categoryPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        categoryPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 35)
        );

        scButton = new JRadioButton("SC");
        stButton = new JRadioButton("ST");
        obcButton = new JRadioButton("OBC");
        generalButton = new JRadioButton("General");

        ButtonGroup categoryGroup = new ButtonGroup();
        categoryGroup.add(scButton);
        categoryGroup.add(stButton);
        categoryGroup.add(obcButton);
        categoryGroup.add(generalButton);

        styleRadio(scButton);
        styleRadio(stButton);
        styleRadio(obcButton);
        styleRadio(generalButton);

        categoryPanel.add(scButton);
        categoryPanel.add(stButton);
        categoryPanel.add(obcButton);
        categoryPanel.add(generalButton);

        formPanel.add(categoryPanel);
        addSeparator(formPanel);

        // 5. BANK ACCOUNT DETAILS
        addSectionTitle(formPanel, "5. Bank Account Details *");

        accountHolderField = new JTextField();
        accountNumberField = new JTextField();
        ifscField = new JTextField();

        formPanel.add(createField(
                "Account Holder Name", accountHolderField,
                "Enter account holder name"
        ));
        formPanel.add(Box.createVerticalStrut(10));

        formPanel.add(createField(
                "Bank Account Number", accountNumberField,
                "Enter account number"
        ));
        formPanel.add(Box.createVerticalStrut(10));

        formPanel.add(createField(
                "IFSC Code", ifscField, "Enter IFSC code"
        ));

        addSeparator(formPanel);

        // 6. SCHOLARSHIP TYPE
        addSectionTitle(formPanel, "6. Scholarship Type *");

        scholarshipCombo = new JComboBox<>(new String[]{
                "Select scholarship type",
                "Merit-Based Scholarship",
                "Need-Based Scholarship",
                "Government Scholarship",
                "SC/ST Scholarship",
                "OBC Scholarship",
                "Minority Scholarship",
                "Other"
        });

        styleCombo(scholarshipCombo);
        formPanel.add(createField(
                "Scholarship Type", scholarshipCombo, null
        ));

        addSeparator(formPanel);

        // 7. DOCUMENT UPLOAD
        addSectionTitle(formPanel, "7. Required Documents Upload *");

        JPanel uploadPanel = new JPanel();
        uploadPanel.setLayout(new BoxLayout(
                uploadPanel, BoxLayout.Y_AXIS
        ));
        uploadPanel.setBackground(Color.WHITE);
        uploadPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(165, 195, 255), 1, true),
                new EmptyBorder(15, 10, 15, 10)
        ));
        uploadPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        uploadPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 135)
        );

        JButton uploadButton = new JButton(
                "\u2601  Upload Documents"
        );
        uploadButton.setFont(new Font("Arial", Font.BOLD, 15));
        uploadButton.setForeground(BLUE);
        uploadButton.setBackground(Color.WHITE);
        uploadButton.setBorderPainted(false);
        uploadButton.setFocusPainted(false);
        uploadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        uploadButton.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        JLabel uploadHint = new JLabel(
                "Marksheets, income certificate, category certificate, bank proof"
        );
        uploadHint.setFont(new Font("Arial", Font.PLAIN, 11));
        uploadHint.setForeground(new Color(100, 120, 160));
        uploadHint.setAlignmentX(Component.CENTER_ALIGNMENT);

        uploadStatus = new JLabel("No documents selected");
        uploadStatus.setFont(new Font("Arial", Font.PLAIN, 11));
        uploadStatus.setForeground(DARK_BLUE);
        uploadStatus.setAlignmentX(Component.CENTER_ALIGNMENT);

        uploadButton.addActionListener(e -> chooseDocuments());

        uploadPanel.add(uploadButton);
        uploadPanel.add(Box.createVerticalStrut(8));
        uploadPanel.add(uploadHint);
        uploadPanel.add(Box.createVerticalStrut(8));
        uploadPanel.add(uploadStatus);

        formPanel.add(uploadPanel);
        formPanel.add(Box.createVerticalStrut(12));

        // SUBMIT BUTTON
        JButton submitButton = new JButton("Submit Application");
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(20, 99, 225));
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.setFocusPainted(false);
        submitButton.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );
        submitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitButton.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 48)
        );
        submitButton.setPreferredSize(new Dimension(700, 48));

        submitButton.addActionListener(e -> submitApplication());

        formPanel.add(submitButton);
        formPanel.add(Box.createVerticalStrut(12));

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getViewport().setBackground(Color.WHITE);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        setContentPane(mainPanel);
        setVisible(true);
    }

    // SECTION HEADING
    private void addSectionTitle(JPanel panel, String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(DARK_BLUE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(new EmptyBorder(0, 0, 12, 0));

        panel.add(label);
    }

    // TEXT FIELD WITH LABEL
    private JPanel createField(
            String labelText, JComponent input, String placeholder
    ) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        label.setForeground(DARK_BLUE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        input.setFont(new Font("Arial", Font.PLAIN, 13));
        input.setPreferredSize(new Dimension(200, 35));
        input.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 35)
        );
        input.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (input instanceof JTextField) {
            input.setBorder(new CompoundBorder(
                    new LineBorder(BORDER, 1, true),
                    new EmptyBorder(5, 8, 5, 8)
            ));

            if (placeholder != null) {
                ((JTextField) input).putClientProperty(
                        "JTextField.placeholderText", placeholder
                );
            }
        }

        panel.add(label);
        panel.add(Box.createVerticalStrut(7));
        panel.add(input);

        return panel;
    }

    // COMBO BOX DESIGN
    private void styleCombo(JComboBox<String> combo) {
        combo.setFont(new Font("Arial", Font.PLAIN, 13));
        combo.setBackground(Color.WHITE);
        combo.setForeground(DARK_BLUE);
        combo.setBorder(new LineBorder(BORDER, 1, true));
    }

    // RADIO BUTTON DESIGN
    private void styleRadio(JRadioButton radio) {
        radio.setFont(new Font("Arial", Font.PLAIN, 13));
        radio.setForeground(DARK_BLUE);
        radio.setBackground(Color.WHITE);
        radio.setFocusPainted(false);
    }

    // SECTION SEPARATOR
    private void addSeparator(JPanel panel) {
        panel.add(Box.createVerticalStrut(18));

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(220, 226, 237));
        separator.setAlignmentX(Component.LEFT_ALIGNMENT);
        separator.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 1)
        );

        panel.add(separator);
        panel.add(Box.createVerticalStrut(18));
    }

    // SELECT DOCUMENTS
    private void chooseDocuments() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Required Documents");
        chooser.setMultiSelectionEnabled(true);

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFiles = chooser.getSelectedFiles();

            if (selectedFiles.length > 0) {
                uploadStatus.setText(
                        selectedFiles.length + " document(s) selected"
                );
            }
        }
    }

    // SUBMIT APPLICATION
    private void submitApplication() {

        if (studentNameField.getText().trim().isEmpty()
                || registrationIdField.getText().trim().isEmpty()
                || courseCombo.getSelectedIndex() == 0
                || yearCombo.getSelectedIndex() == 0
                || marksField.getText().trim().isEmpty()
                || incomeField.getText().trim().isEmpty()
                || accountHolderField.getText().trim().isEmpty()
                || accountNumberField.getText().trim().isEmpty()
                || ifscField.getText().trim().isEmpty()
                || scholarshipCombo.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all required fields.",
                    "Incomplete Form",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (!scButton.isSelected()
                && !stButton.isSelected()
                && !obcButton.isSelected()
                && !generalButton.isSelected()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select your category.",
                    "Category Required",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            double marks = Double.parseDouble(
                    marksField.getText().trim()
            );
            double income = Double.parseDouble(
                    incomeField.getText().trim()
            );

            if (marks < 0 || marks > 100 || income < 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Enter valid marks (0-100) and annual income.",
                    "Invalid Details",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (selectedFiles == null || selectedFiles.length == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please upload your required documents.",
                    "Documents Required",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String category = scButton.isSelected() ? "SC"
                : stButton.isSelected() ? "ST"
                : obcButton.isSelected() ? "OBC" : "General";

        String appId = "APP-" + (int)(Math.random() * 9000 + 1000);
        String sName = studentNameField.getText().trim();
        String regId = registrationIdField.getText().trim();
        String schName = scholarshipCombo.getSelectedItem().toString();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMM-yyyy");
        String today = sdf.format(new java.util.Date());

        boolean saved = InsertData.insertApplication(appId, regId, sName, schName, today, "Pending");

        if (saved) {
            JOptionPane.showMessageDialog(
                    this,
                    "Application submitted successfully!\n\n"
                            + "Application ID: " + appId
                            + "\nStudent: " + sName
                            + "\nRegistration ID: " + regId
                            + "\nScholarship: " + schName
                            + "\nStatus: Pending Approval",
                    "Application Submitted",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Application validated, but could not connect to database to save.",
                    "Database Alert",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new ScholarshipApplicationForm()
        );
    }
}
