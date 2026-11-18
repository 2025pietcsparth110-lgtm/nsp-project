
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ScholarshipManagementForm extends JFrame {

    private final Color blue = new Color(23, 75, 185);
    private final Color background = new Color(244, 248, 255);

    private JTextField nameField;
    private JTextArea descriptionArea;
    private JTextField eligibilityField;
    private JTextField dateField;
    private JTextField amountField;

    private DefaultListModel<String> listModel;
    private JList<String> scholarshipList;

    private final ArrayList<String[]> scholarships = new ArrayList<>();
    private int selectedIndex = -1;

    public ScholarshipManagementForm() {

        setTitle("Scholarship Management System - Admin");
        setSize(900, 720);
        setMinimumSize(new Dimension(700, 600));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(background);

        // HEADER
        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBackground(blue);
        header.setPreferredSize(new Dimension(900, 85));

        JLabel title = new JLabel(
                "Scholarship Management System",
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel(
                "8. Scholarship Management Form (Admin)",
                SwingConstants.CENTER
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(Color.WHITE);

        header.add(title);
        header.add(subtitle);
        mainPanel.add(header, BorderLayout.NORTH);

        // MAIN CONTENT
        JPanel content = new JPanel(new GridBagLayout());
        content.setBackground(background);
        content.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;

        // LEFT FORM
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(215, 225, 240)),
                new EmptyBorder(20, 20, 20, 20)
        ));

        JLabel formHeading = new JLabel("Manage Scholarships");
        formHeading.setFont(new Font("Arial", Font.BOLD, 20));
        formHeading.setForeground(blue);
        formHeading.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(formHeading);

        JLabel description = new JLabel(
                "<html>Add, edit or delete scholarship schemes.</html>"
        );
        description.setFont(new Font("Arial", Font.PLAIN, 12));
        description.setForeground(Color.GRAY);
        description.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(description);
        formPanel.add(Box.createVerticalStrut(20));

        nameField = addField(
                formPanel, "Scholarship Name *", "Enter scholarship name"
        );

        JLabel descLabel = new JLabel("Description *");
        styleLabel(descLabel);
        formPanel.add(descLabel);
        formPanel.add(Box.createVerticalStrut(5));

        descriptionArea = new JTextArea(4, 20);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 13));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBorder(new EmptyBorder(7, 7, 7, 7));

        JScrollPane descScroll = new JScrollPane(descriptionArea);
        descScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        descScroll.setMaximumSize(new Dimension(500, 90));
        descScroll.setPreferredSize(new Dimension(500, 90));
        formPanel.add(descScroll);
        formPanel.add(Box.createVerticalStrut(12));

        eligibilityField = addField(
                formPanel, "Eligibility *", "Enter eligibility criteria"
        );

        dateField = addField(
                formPanel, "Last Date (DD/MM/YYYY) *", "DD/MM/YYYY"
        );

        amountField = addField(
                formPanel, "Scholarship Amount (₹) *", "Enter amount"
        );

        // ACTION BUTTONS
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 8, 0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(new Dimension(500, 42));

        JButton addButton = createButton("Add", new Color(22, 110, 70));
        JButton editButton = createButton("Edit", new Color(220, 155, 30));
        JButton deleteButton = createButton("Delete", new Color(200, 55, 55));

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(buttonPanel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.3;
        content.add(formPanel, gbc);

        // RIGHT SCHOLARSHIP LIST
        JPanel listPanel = new JPanel(new BorderLayout(5, 12));
        listPanel.setBackground(Color.WHITE);
        listPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(215, 225, 240)),
                new EmptyBorder(18, 15, 18, 15)
        ));

        JLabel listHeading = new JLabel("Scholarship List");
        listHeading.setFont(new Font("Arial", Font.BOLD, 18));
        listHeading.setForeground(blue);
        listPanel.add(listHeading, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        scholarshipList = new JList<>(listModel);
        scholarshipList.setFont(new Font("Arial", Font.PLAIN, 13));
        scholarshipList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );
        scholarshipList.setFixedCellHeight(42);
        scholarshipList.setBorder(new EmptyBorder(5, 5, 5, 5));

        JScrollPane listScroll = new JScrollPane(scholarshipList);
        listPanel.add(listScroll, BorderLayout.CENTER);

        JLabel hint = new JLabel(
                "<html>Select a scholarship to edit or delete.</html>"
        );
        hint.setFont(new Font("Arial", Font.PLAIN, 11));
        hint.setForeground(Color.GRAY);
        listPanel.add(hint, BorderLayout.SOUTH);

        gbc.gridx = 1;
        gbc.weightx = 1;
        content.add(listPanel, gbc);

        mainPanel.add(content, BorderLayout.CENTER);
        setContentPane(mainPanel);

        // ADD
        addButton.addActionListener(e -> {
            if (!validateForm()) {
                return;
            }

            scholarships.add(getFormData());
            refreshList();
            clearForm();

            JOptionPane.showMessageDialog(
                    this, "Scholarship added successfully!"
            );
        });

        // SELECT A SCHOLARSHIP
        scholarshipList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = scholarshipList.getSelectedIndex();

                if (index >= 0) {
                    selectedIndex = index;
                    String[] data = scholarships.get(index);

                    nameField.setText(data[0]);
                    descriptionArea.setText(data[1]);
                    eligibilityField.setText(data[2]);
                    dateField.setText(data[3]);
                    amountField.setText(data[4]);
                }
            }
        });

        // EDIT
        editButton.addActionListener(e -> {
            if (selectedIndex < 0) {
                JOptionPane.showMessageDialog(
                        this, "Please select a scholarship to edit."
                );
                return;
            }

            if (!validateForm()) {
                return;
            }

            scholarships.set(selectedIndex, getFormData());
            refreshList();

            int updatedIndex = selectedIndex;
            clearForm();

            JOptionPane.showMessageDialog(
                    this, "Scholarship updated successfully!"
            );
        });

        // DELETE
        deleteButton.addActionListener(e -> {
            int index = scholarshipList.getSelectedIndex();

            if (index < 0) {
                JOptionPane.showMessageDialog(
                        this, "Please select a scholarship to delete."
                );
                return;
            }

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to delete this scholarship?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                scholarships.remove(index);
                refreshList();
                clearForm();

                JOptionPane.showMessageDialog(
                        this, "Scholarship deleted successfully!"
                );
            }
        });
    }

    private JTextField addField(
            JPanel panel, String labelText, String hint
    ) {
        JLabel label = new JLabel(labelText);
        styleLabel(label);
        panel.add(label);
        panel.add(Box.createVerticalStrut(5));

        JTextField field = new JTextField();
        field.setFont(new Font("Arial", Font.PLAIN, 13));
        field.setToolTipText(hint);
        field.setBorder(new CompoundBorder(
                new LineBorder(new Color(210, 220, 235)),
                new EmptyBorder(6, 8, 6, 8)
        ));
        field.setMaximumSize(new Dimension(500, 34));
        field.setPreferredSize(new Dimension(500, 34));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(field);
        panel.add(Box.createVerticalStrut(12));

        return field;
    }

    private void styleLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(new Color(35, 45, 65));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private boolean validateForm() {
        if (nameField.getText().trim().isEmpty()
                || descriptionArea.getText().trim().isEmpty()
                || eligibilityField.getText().trim().isEmpty()
                || dateField.getText().trim().isEmpty()
                || amountField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this, "Please fill in all required fields!"
            );
            return false;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(dateField.getText().trim());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this, "Enter date in DD/MM/YYYY format."
            );
            return false;
        }

        try {
            double amount = Double.parseDouble(
                    amountField.getText().trim()
            );

            if (amount <= 0) {
                JOptionPane.showMessageDialog(
                        this, "Amount must be greater than zero."
                );
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "Enter a valid numeric amount."
            );
            return false;
        }

        return true;
    }

    private String[] getFormData() {
        return new String[] {
                nameField.getText().trim(),
                descriptionArea.getText().trim(),
                eligibilityField.getText().trim(),
                dateField.getText().trim(),
                amountField.getText().trim()
        };
    }

    private void refreshList() {
        listModel.clear();

        for (String[] data : scholarships) {
            listModel.addElement(
                    data[0] + " | ₹" + data[4]
                            + " | Last date: " + data[3]
            );
        }
    }

    private void clearForm() {
        nameField.setText("");
        descriptionArea.setText("");
        eligibilityField.setText("");
        dateField.setText("");
        amountField.setText("");

        scholarshipList.clearSelection();
        selectedIndex = -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ScholarshipManagementForm().setVisible(true);
        });
    }
}
