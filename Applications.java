import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Applications extends JFrame {

    private JTextField applicationIdField;
    private JTextField studentIdField;
    private JTextField studentNameField;
    private JTextField scholarshipField;
    private JTextField applicationDateField;

    private JComboBox<String> statusComboBox;

    private JTable applicationTable;
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

    public Applications() {

        setTitle("Applications - Scholarship Management System");

        setSize(1150, 700);

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
                        0, 0, 1, 0,
                        new Color(220, 225, 230)
                )
        );


        JLabel titleLabel = new JLabel(
                "Application Management"
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        titleLabel.setForeground(PRIMARY);

        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        18, 25, 18, 10
                )
        );


        JLabel systemLabel = new JLabel(
                "Scholarship Management System"
        );

        systemLabel.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        systemLabel.setForeground(TEXT);

        systemLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        18, 10, 18, 25
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
                        20, 25, 20, 25
                )
        );


        // ================= FORM PANEL =================

        JPanel formPanel = new JPanel(
                new GridBagLayout()
        );

        formPanel.setBackground(WHITE);

        formPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 230, 235)
                        ),
                        BorderFactory.createEmptyBorder(
                                20, 20, 20, 20
                        )
                )
        );


        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(7, 7, 7, 7);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;


        // ================= FORM TITLE =================

        JLabel formTitle = new JLabel(
                "Application Details"
        );

        formTitle.setFont(
                new Font("Arial", Font.BOLD, 20)
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


        // ================= APPLICATION ID =================

        gbc.gridx = 0;
        gbc.gridy = 1;

        formPanel.add(
                createLabel("Application ID"),
                gbc
        );


        applicationIdField = createField();

        gbc.gridx = 1;
        gbc.gridy = 1;

        formPanel.add(
                applicationIdField,
                gbc
        );


        // ================= STUDENT ID =================

        gbc.gridx = 0;
        gbc.gridy = 2;

        formPanel.add(
                createLabel("Student ID"),
                gbc
        );


        studentIdField = createField();

        gbc.gridx = 1;
        gbc.gridy = 2;

        formPanel.add(
                studentIdField,
                gbc
        );


        // ================= STUDENT NAME =================

        gbc.gridx = 0;
        gbc.gridy = 3;

        formPanel.add(
                createLabel("Student Name"),
                gbc
        );


        studentNameField = createField();

        gbc.gridx = 1;
        gbc.gridy = 3;

        formPanel.add(
                studentNameField,
                gbc
        );


        // ================= SCHOLARSHIP =================

        gbc.gridx = 0;
        gbc.gridy = 4;

        formPanel.add(
                createLabel("Scholarship"),
                gbc
        );


        scholarshipField = createField();

        gbc.gridx = 1;
        gbc.gridy = 4;

        formPanel.add(
                scholarshipField,
                gbc
        );


        // ================= APPLICATION DATE =================

        gbc.gridx = 0;
        gbc.gridy = 5;

        formPanel.add(
                createLabel("Application Date"),
                gbc
        );


        applicationDateField = createField();

        gbc.gridx = 1;
        gbc.gridy = 5;

        formPanel.add(
                applicationDateField,
                gbc
        );


        // ================= STATUS =================

        gbc.gridx = 0;
        gbc.gridy = 6;

        formPanel.add(
                createLabel("Status"),
                gbc
        );


        String[] statuses = {
                "Pending",
                "Approved",
                "Rejected"
        };


        statusComboBox =
                new JComboBox<>(statuses);

        statusComboBox.setPreferredSize(
                new Dimension(220, 35)
        );

        statusComboBox.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );


        gbc.gridx = 1;
        gbc.gridy = 6;

        formPanel.add(
                statusComboBox,
                gbc
        );


        // ================= BUTTON PANEL =================

        JPanel buttonPanel = new JPanel(
                new GridLayout(
                        1, 3, 8, 8
                )
        );

        buttonPanel.setBackground(WHITE);


        JButton addButton = createButton(
                "Add Application",
                GREEN
        );


        JButton editButton = createButton(
                "Edit",
                PRIMARY
        );


        JButton deleteButton = createButton(
                "Delete",
                RED
        );


        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);


        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        gbc.insets =
                new Insets(
                        20, 7, 7, 7
                );


        formPanel.add(
                buttonPanel,
                gbc
        );


        // ================= CLEAR BUTTON =================

        JButton clearButton = createButton(
                "Clear",
                ORANGE
        );


        gbc.gridx = 0;
        gbc.gridy = 8;
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

        JPanel tablePanel = new JPanel(
                new BorderLayout(10, 10)
        );

        tablePanel.setBackground(WHITE);

        tablePanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 230, 235)
                        ),
                        BorderFactory.createEmptyBorder(
                                15, 15, 15, 15
                        )
                )
        );


        // ================= SEARCH PANEL =================

        JPanel searchPanel = new JPanel(
                new BorderLayout(10, 0)
        );

        searchPanel.setBackground(WHITE);


        JLabel searchLabel =
                new JLabel("Search:");

        searchLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );


        JTextField searchField =
                new JTextField();


        JButton searchButton =
                createButton(
                        "Search",
                        PRIMARY
                );

        searchButton.setPreferredSize(
                new Dimension(100, 35)
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
                "Application ID",
                "Student ID",
                "Student Name",
                "Scholarship",
                "Application Date",
                "Status"
        };


        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                );
        SelectData.loadApplications(tableModel);


        applicationTable =
                new JTable(tableModel);


        applicationTable.setRowHeight(30);

        applicationTable.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );


        applicationTable
                .getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                13
                        )
                );


        applicationTable
                .getTableHeader()
                .setBackground(
                        PRIMARY
                );


        applicationTable
                .getTableHeader()
                .setForeground(
                        Color.WHITE
                );


        applicationTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );


        JScrollPane scrollPane =
                new JScrollPane(
                        applicationTable
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

            String applicationId =
                    applicationIdField
                            .getText()
                            .trim();

            String studentId =
                    studentIdField
                            .getText()
                            .trim();

            String studentName =
                    studentNameField
                            .getText()
                            .trim();

            String scholarship =
                    scholarshipField
                            .getText()
                            .trim();

            String applicationDate =
                    applicationDateField
                            .getText()
                            .trim();

            String status =
                    statusComboBox
                            .getSelectedItem()
                            .toString();


            if (
                    applicationId.isEmpty()
                            || studentId.isEmpty()
                            || studentName.isEmpty()
                            || scholarship.isEmpty()
                            || applicationDate.isEmpty()
            ) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all application details.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            tableModel.addRow(
                    new Object[]{
                            applicationId,
                            studentId,
                            studentName,
                            scholarship,
                            applicationDate,
                            status
                    }
            );

            InsertData.insertApplication(applicationId, studentId, studentName, scholarship, applicationDate, status);

            JOptionPane.showMessageDialog(
                    this,
                    "Application added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );


            clearFields();
        });


        // ================= EDIT ACTION =================

        editButton.addActionListener(e -> {

            int row =
                    applicationTable
                            .getSelectedRow();


            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select an application.",
                        "Edit Application",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            tableModel.setValueAt(
                    applicationIdField
                            .getText()
                            .trim(),
                    row,
                    0
            );


            tableModel.setValueAt(
                    studentIdField
                            .getText()
                            .trim(),
                    row,
                    1
            );


            tableModel.setValueAt(
                    studentNameField
                            .getText()
                            .trim(),
                    row,
                    2
            );


            tableModel.setValueAt(
                    scholarshipField
                            .getText()
                            .trim(),
                    row,
                    3
            );


            tableModel.setValueAt(
                    applicationDateField
                            .getText()
                            .trim(),
                    row,
                    4
            );


            tableModel.setValueAt(
                    statusComboBox
                            .getSelectedItem()
                            .toString(),
                    row,
                    5
            );

            UpdateData.updateApplicationStatus(
                    applicationIdField.getText().trim(),
                    statusComboBox.getSelectedItem().toString()
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Application updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );


            clearFields();
        });


        // ================= DELETE ACTION =================

        deleteButton.addActionListener(e -> {

            int row =
                    applicationTable
                            .getSelectedRow();


            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select an application.",
                        "Delete Application",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Do you want to delete this application?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                    );


            if (
                    choice ==
                            JOptionPane.YES_OPTION
            ) {

                String appId = tableModel.getValueAt(row, 0).toString();
                DeleteData.deleteApplication(appId);

                tableModel.removeRow(row);

                clearFields();

                JOptionPane.showMessageDialog(
                        this,
                        "Application deleted successfully!",
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

        applicationTable.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            MouseEvent e
                    ) {

                        int row =
                                applicationTable
                                        .getSelectedRow();


                        if (row >= 0) {

                            applicationIdField
                                    .setText(
                                            tableModel
                                                    .getValueAt(
                                                            row,
                                                            0
                                                    )
                                                    .toString()
                                    );


                            studentIdField
                                    .setText(
                                            tableModel
                                                    .getValueAt(
                                                            row,
                                                            1
                                                    )
                                                    .toString()
                                    );


                            studentNameField
                                    .setText(
                                            tableModel
                                                    .getValueAt(
                                                            row,
                                                            2
                                                    )
                                                    .toString()
                                    );


                            scholarshipField
                                    .setText(
                                            tableModel
                                                    .getValueAt(
                                                            row,
                                                            3
                                                    )
                                                    .toString()
                                    );


                            applicationDateField
                                    .setText(
                                            tableModel
                                                    .getValueAt(
                                                            row,
                                                            4
                                                    )
                                                    .toString()
                                    );


                            statusComboBox
                                    .setSelectedItem(
                                            tableModel
                                                    .getValueAt(
                                                            row,
                                                            5
                                                    )
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
                        "Enter Application ID or Student Name.",
                        "Search",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            boolean found = false;


            for (
                    int i = 0;
                    i < tableModel.getRowCount();
                    i++
            ) {

                String applicationId =
                        tableModel
                                .getValueAt(i, 0)
                                .toString()
                                .toLowerCase();


                String studentName =
                        tableModel
                                .getValueAt(i, 2)
                                .toString()
                                .toLowerCase();


                if (
                        applicationId.contains(search)
                                || studentName.contains(search)
                ) {

                    applicationTable
                            .setRowSelectionInterval(
                                    i,
                                    i
                            );


                    applicationTable
                            .scrollRectToVisible(
                                    applicationTable
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
                        "Application not found.",
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

        applicationIdField.setText("");
        studentIdField.setText("");
        studentNameField.setText("");
        scholarshipField.setText("");
        applicationDateField.setText("");

        statusComboBox.setSelectedIndex(0);

        applicationTable.clearSelection();
    }


    // =================================================
    // MAIN METHOD
    // =================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    new Applications()
                            .setVisible(true);

                }
        );
    }
}