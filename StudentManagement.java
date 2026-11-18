import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentManagement extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField mobileField;
    private JTextField courseField;
    private JTextField yearField;
    private JTextField categoryField;
    private JTextField searchField;

    private JTable studentTable;
    private DefaultTableModel tableModel;


    // ================= COLORS =================

    private final Color PRIMARY = new Color(37, 99, 235);
    private final Color BACKGROUND = new Color(245, 247, 250);
    private final Color WHITE = Color.WHITE;
    private final Color TEXT = new Color(31, 41, 55);
    private final Color GREEN = new Color(16, 185, 129);
    private final Color RED = new Color(239, 68, 68);
    private final Color ORANGE = new Color(245, 158, 11);


    // ================= CONSTRUCTOR =================

    public StudentManagement() {

        setTitle("Student Management - Scholarship Management System");

        setSize(1100, 700);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        getContentPane().setBackground(BACKGROUND);

        setLayout(new BorderLayout());


        // ================= HEADER =================

        JPanel headerPanel = new JPanel(
                new BorderLayout()
        );

        headerPanel.setBackground(WHITE);

        headerPanel.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        1,
                        0,
                        new Color(220, 225, 230)
                )
        );


        JLabel titleLabel = new JLabel(
                "Student Management"
        );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        titleLabel.setForeground(PRIMARY);

        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        18,
                        25,
                        18,
                        10
                )
        );


        JLabel systemLabel = new JLabel(
                "Scholarship Management System"
        );

        systemLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        systemLabel.setForeground(TEXT);

        systemLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        18,
                        10,
                        18,
                        25
                )
        );


        headerPanel.add(
                titleLabel,
                BorderLayout.WEST
        );

        headerPanel.add(
                systemLabel,
                BorderLayout.EAST
        );


        add(
                headerPanel,
                BorderLayout.NORTH
        );


        // ================= MAIN PANEL =================

        JPanel mainPanel = new JPanel(
                new BorderLayout(20, 20)
        );

        mainPanel.setBackground(BACKGROUND);

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        25,
                        20,
                        25
                )
        );


        // ================= FORM PANEL =================

        JPanel formPanel = new JPanel();

        formPanel.setBackground(WHITE);

        formPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 230, 235)
                        ),
                        BorderFactory.createEmptyBorder(
                                20,
                                20,
                                20,
                                20
                        )
                )
        );


        formPanel.setLayout(
                new GridBagLayout()
        );


        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(7, 7, 7, 7);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;


        // ================= FORM TITLE =================

        JLabel formTitle =
                new JLabel("Student Details");

        formTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        formTitle.setForeground(TEXT);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        formPanel.add(
                formTitle,
                gbc
        );


        gbc.gridwidth = 1;


        // ================= STUDENT ID =================

        gbc.gridx = 0;
        gbc.gridy = 1;

        formPanel.add(
                createLabel("Student ID"),
                gbc
        );


        idField = createField();

        gbc.gridx = 1;
        gbc.gridy = 1;

        formPanel.add(
                idField,
                gbc
        );


        // ================= NAME =================

        gbc.gridx = 0;
        gbc.gridy = 2;

        formPanel.add(
                createLabel("Student Name"),
                gbc
        );


        nameField = createField();

        gbc.gridx = 1;
        gbc.gridy = 2;

        formPanel.add(
                nameField,
                gbc
        );


        // ================= EMAIL =================

        gbc.gridx = 0;
        gbc.gridy = 3;

        formPanel.add(
                createLabel("Email"),
                gbc
        );


        emailField = createField();

        gbc.gridx = 1;
        gbc.gridy = 3;

        formPanel.add(
                emailField,
                gbc
        );


        // ================= MOBILE =================

        gbc.gridx = 0;
        gbc.gridy = 4;

        formPanel.add(
                createLabel("Mobile"),
                gbc
        );


        mobileField = createField();

        gbc.gridx = 1;
        gbc.gridy = 4;

        formPanel.add(
                mobileField,
                gbc
        );


        // ================= COURSE =================

        gbc.gridx = 0;
        gbc.gridy = 5;

        formPanel.add(
                createLabel("Course"),
                gbc
        );


        courseField = createField();

        gbc.gridx = 1;
        gbc.gridy = 5;

        formPanel.add(
                courseField,
                gbc
        );


        // ================= YEAR =================

        gbc.gridx = 0;
        gbc.gridy = 6;

        formPanel.add(
                createLabel("Year"),
                gbc
        );


        yearField = createField();

        gbc.gridx = 1;
        gbc.gridy = 6;

        formPanel.add(
                yearField,
                gbc
        );


        // ================= CATEGORY =================

        gbc.gridx = 0;
        gbc.gridy = 7;

        formPanel.add(
                createLabel("Category"),
                gbc
        );


        categoryField = createField();

        gbc.gridx = 1;
        gbc.gridy = 7;

        formPanel.add(
                categoryField,
                gbc
        );


        // ================= BUTTON PANEL =================

        JPanel buttonPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                3,
                                8,
                                8
                        )
                );

        buttonPanel.setBackground(WHITE);


        JButton addButton =
                createButton(
                        "Add Student",
                        GREEN
                );


        JButton editButton =
                createButton(
                        "Edit Student",
                        PRIMARY
                );


        JButton deleteButton =
                createButton(
                        "Delete",
                        RED
                );


        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);


        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;

        gbc.insets =
                new Insets(
                        20,
                        7,
                        7,
                        7
                );


        formPanel.add(
                buttonPanel,
                gbc
        );


        // ================= CLEAR BUTTON =================

        JButton clearButton =
                createButton(
                        "Clear",
                        ORANGE
                );


        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;

        formPanel.add(
                clearButton,
                gbc
        );


        mainPanel.add(
                formPanel,
                BorderLayout.WEST
        );


        // ================= TABLE PANEL =================

        JPanel tablePanel =
                new JPanel(
                        new BorderLayout(
                                10,
                                10
                        )
                );

        tablePanel.setBackground(WHITE);

        tablePanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 230, 235)
                        ),
                        BorderFactory.createEmptyBorder(
                                15,
                                15,
                                15,
                                15
                        )
                )
        );


        // ================= SEARCH =================

        JPanel searchPanel =
                new JPanel(
                        new BorderLayout(10, 0)
                );

        searchPanel.setBackground(WHITE);


        JLabel searchLabel =
                new JLabel("Search Student:");

        searchLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );


        searchField =
                new JTextField();


        JButton searchButton =
                createButton(
                        "Search",
                        PRIMARY
                );

        searchButton.setPreferredSize(
                new Dimension(
                        100,
                        35
                )
        );


        searchPanel.add(
                searchLabel,
                BorderLayout.WEST
        );

        searchPanel.add(
                searchField,
                BorderLayout.CENTER
        );

        searchPanel.add(
                searchButton,
                BorderLayout.EAST
        );


        tablePanel.add(
                searchPanel,
                BorderLayout.NORTH
        );


        // ================= TABLE =================

        String[] columns = {
                "Student ID",
                "Name",
                "Email",
                "Mobile",
                "Course",
                "Year",
                "Category"
        };


        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                );
        SelectData.loadStudents(tableModel);


        studentTable =
                new JTable(tableModel);


        studentTable.setRowHeight(30);

        studentTable.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );


        studentTable.getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                13
                        )
                );


        studentTable.getTableHeader()
                .setBackground(PRIMARY);

        studentTable.getTableHeader()
                .setForeground(Color.WHITE);


        studentTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );


        JScrollPane scrollPane =
                new JScrollPane(
                        studentTable
                );


        tablePanel.add(
                scrollPane,
                BorderLayout.CENTER
        );


        mainPanel.add(
                tablePanel,
                BorderLayout.CENTER
        );


        add(
                mainPanel,
                BorderLayout.CENTER
        );


        // ================= ADD ACTION =================

        addButton.addActionListener(e -> {

            String id =
                    idField.getText().trim();

            String name =
                    nameField.getText().trim();

            String email =
                    emailField.getText().trim();

            String mobile =
                    mobileField.getText().trim();

            String course =
                    courseField.getText().trim();

            String year =
                    yearField.getText().trim();

            String category =
                    categoryField.getText().trim();


            if (id.isEmpty()
                    || name.isEmpty()
                    || email.isEmpty()
                    || mobile.isEmpty()
                    || course.isEmpty()
                    || year.isEmpty()
                    || category.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all student details.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            tableModel.addRow(
                    new Object[]{
                            id,
                            name,
                            email,
                            mobile,
                            course,
                            year,
                            category
                    }
            );

            InsertData.insertStudent(id, name, email, mobile, course, year, category);

            JOptionPane.showMessageDialog(
                    this,
                    "Student added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );


            clearFields();
        });


        // ================= EDIT ACTION =================

        editButton.addActionListener(e -> {

            int row =
                    studentTable.getSelectedRow();


            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a student from the table.",
                        "Edit Student",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            tableModel.setValueAt(
                    idField.getText().trim(),
                    row,
                    0
            );

            tableModel.setValueAt(
                    nameField.getText().trim(),
                    row,
                    1
            );

            tableModel.setValueAt(
                    emailField.getText().trim(),
                    row,
                    2
            );

            tableModel.setValueAt(
                    mobileField.getText().trim(),
                    row,
                    3
            );

            tableModel.setValueAt(
                    courseField.getText().trim(),
                    row,
                    4
            );

            tableModel.setValueAt(
                    yearField.getText().trim(),
                    row,
                    5
            );

            tableModel.setValueAt(
                    categoryField.getText().trim(),
                    row,
                    6
            );

            UpdateData.updateStudent(
                    idField.getText().trim(),
                    nameField.getText().trim(),
                    emailField.getText().trim(),
                    mobileField.getText().trim(),
                    courseField.getText().trim(),
                    yearField.getText().trim(),
                    categoryField.getText().trim()
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Student updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );


            clearFields();
        });


        // ================= DELETE ACTION =================

        deleteButton.addActionListener(e -> {

            int row =
                    studentTable.getSelectedRow();


            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a student.",
                        "Delete Student",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Do you want to delete this student?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                    );


            if (choice ==
                    JOptionPane.YES_OPTION) {

                String studentId = tableModel.getValueAt(row, 0).toString();
                DeleteData.deleteStudent(studentId);

                tableModel.removeRow(row);

                clearFields();

                JOptionPane.showMessageDialog(
                        this,
                        "Student deleted successfully!",
                        "Deleted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });


        // ================= CLEAR ACTION =================

        clearButton.addActionListener(e -> {

            clearFields();

        });


        // ================= TABLE CLICK =================

        studentTable.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            MouseEvent e
                    ) {

                        int row =
                                studentTable.getSelectedRow();


                        if (row >= 0) {

                            idField.setText(
                                    tableModel
                                            .getValueAt(row, 0)
                                            .toString()
                            );

                            nameField.setText(
                                    tableModel
                                            .getValueAt(row, 1)
                                            .toString()
                            );

                            emailField.setText(
                                    tableModel
                                            .getValueAt(row, 2)
                                            .toString()
                            );

                            mobileField.setText(
                                    tableModel
                                            .getValueAt(row, 3)
                                            .toString()
                            );

                            courseField.setText(
                                    tableModel
                                            .getValueAt(row, 4)
                                            .toString()
                            );

                            yearField.setText(
                                    tableModel
                                            .getValueAt(row, 5)
                                            .toString()
                            );

                            categoryField.setText(
                                    tableModel
                                            .getValueAt(row, 6)
                                            .toString()
                            );
                        }
                    }
                }
        );


        // ================= SEARCH ACTION =================

        searchButton.addActionListener(e -> {

            String search =
                    searchField
                            .getText()
                            .trim()
                            .toLowerCase();


            if (search.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter something to search.",
                        "Search",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            boolean found = false;


            for (int i = 0;
                 i < tableModel.getRowCount();
                 i++) {


                String id =
                        tableModel
                                .getValueAt(i, 0)
                                .toString()
                                .toLowerCase();


                String name =
                        tableModel
                                .getValueAt(i, 1)
                                .toString()
                                .toLowerCase();


                if (id.contains(search)
                        || name.contains(search)) {

                    studentTable
                            .setRowSelectionInterval(
                                    i,
                                    i
                            );

                    studentTable
                            .scrollRectToVisible(
                                    studentTable
                                            .getCellRect(
                                                    i,
                                                    0,
                                                    true
                                            )
                            );

                    found = true;

                    break;
                }
            }


            if (!found) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student not found.",
                        "Search",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }


    // =================================================
    // CREATE LABEL
    // =================================================

    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(TEXT);

        return label;
    }


    // =================================================
    // CREATE TEXT FIELD
    // =================================================

    private JTextField createField() {

        JTextField field =
                new JTextField();

        field.setPreferredSize(
                new Dimension(
                        220,
                        35
                )
        );

        field.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        return field;
    }


    // =================================================
    // CREATE BUTTON
    // =================================================

    private JButton createButton(
            String text,
            Color color
    ) {

        JButton button =
                new JButton(text);

        button.setBackground(color);

        button.setForeground(Color.WHITE);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }


    // =================================================
    // CLEAR FIELDS
    // =================================================

    private void clearFields() {

        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        mobileField.setText("");
        courseField.setText("");
        yearField.setText("");
        categoryField.setText("");

        studentTable.clearSelection();
    }


    // =================================================
    // MAIN METHOD
    // =================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    new StudentManagement()
                            .setVisible(true);

                }
        );
    }
}