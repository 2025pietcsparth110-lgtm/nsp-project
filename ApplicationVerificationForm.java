
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ApplicationVerificationForm extends JFrame {

    private final Color blue = new Color(23, 75, 185);
    private final Color background = new Color(244, 248, 255);

    private JTextField applicationIdField;
    private JTextField studentNameField;
    private JCheckBox aadhaarCheck;
    private JCheckBox incomeCheck;
    private JCheckBox marksheetCheck;
    private JTextArea remarksArea;
    private JComboBox<String> statusCombo;

    public ApplicationVerificationForm() {

        setTitle("Scholarship Management System - Application Verification");
        setSize(650, 750);
        setMinimumSize(new Dimension(550, 650));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(background);

        // HEADER
        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBackground(blue);
        header.setPreferredSize(new Dimension(650, 85));

        JLabel title = new JLabel(
                "Scholarship Management System",
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 21));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel(
                "9. Application Verification Form",
                SwingConstants.CENTER
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(Color.WHITE);

        header.add(title);
        header.add(subtitle);
        mainPanel.add(header, BorderLayout.NORTH);

        // FORM PANEL
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(215, 225, 240)),
                new EmptyBorder(22, 25, 22, 25)
        ));

        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(background);
        outerPanel.setBorder(new EmptyBorder(18, 18, 18, 18));

        JLabel heading = new JLabel("Verify Application");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(blue);
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(heading);

        JLabel description = new JLabel(
                "Review student documents and application status."
        );
        description.setFont(new Font("Arial", Font.PLAIN, 12));
        description.setForeground(Color.GRAY);
        description.setAlignmentX(Component.LEFT_ALIGNMENT);

        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(description);
        formPanel.add(Box.createVerticalStrut(20));

        // APPLICATION ID
        applicationIdField = addField(
                formPanel, "Application ID *", "Enter application ID"
        );

        // STUDENT NAME
        studentNameField = addField(
                formPanel, "Student Name *", "Enter student name"
        );

        // DOCUMENT VERIFICATION
        JLabel documentLabel = new JLabel("Verify Documents *");
        styleLabel(documentLabel);
        formPanel.add(documentLabel);
        formPanel.add(Box.createVerticalStrut(8));

        aadhaarCheck = new JCheckBox("Aadhaar Card");
        incomeCheck = new JCheckBox("Income Certificate");
        marksheetCheck = new JCheckBox("Academic Marksheet");

        styleCheckBox(aadhaarCheck);
        styleCheckBox(incomeCheck);
        styleCheckBox(marksheetCheck);

        formPanel.add(aadhaarCheck);
        formPanel.add(incomeCheck);
        formPanel.add(marksheetCheck);
        formPanel.add(Box.createVerticalStrut(15));

        // APPROVAL STATUS
        JLabel statusLabel = new JLabel("Approve / Reject *");
        styleLabel(statusLabel);
        formPanel.add(statusLabel);
        formPanel.add(Box.createVerticalStrut(6));

        String[] statuses = {
                "Pending", "Approved", "Rejected"
        };

        statusCombo = new JComboBox<>(statuses);
        statusCombo.setFont(new Font("Arial", Font.PLAIN, 13));
        statusCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        statusCombo.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(statusCombo);
        formPanel.add(Box.createVerticalStrut(15));

        // REMARKS
        JLabel remarksLabel = new JLabel("Remarks");
        styleLabel(remarksLabel);
        formPanel.add(remarksLabel);
        formPanel.add(Box.createVerticalStrut(6));

        remarksArea = new JTextArea(3, 20);
        remarksArea.setFont(new Font("Arial", Font.PLAIN, 13));
        remarksArea.setLineWrap(true);
        remarksArea.setWrapStyleWord(true);
        remarksArea.setBorder(new EmptyBorder(7, 7, 7, 7));

        JScrollPane remarksScroll = new JScrollPane(remarksArea);
        remarksScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        remarksScroll.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 85)
        );
        remarksScroll.setPreferredSize(new Dimension(400, 85));

        formPanel.add(remarksScroll);
        formPanel.add(Box.createVerticalStrut(18));

        // BUTTONS
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 12, 0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 42)
        );

        JButton approveButton = createButton(
                "Approve", new Color(22, 130, 70)
        );

        JButton rejectButton = createButton(
                "Reject", new Color(205, 55, 55)
        );

        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);

        formPanel.add(buttonPanel);
        formPanel.add(Box.createVerticalStrut(10));

        JButton submitButton = createButton(
                "Submit Verification", blue
        );
        submitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitButton.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 42)
        );

        formPanel.add(submitButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);

        outerPanel.add(formPanel, gbc);

        JScrollPane mainScroll = new JScrollPane(outerPanel);
        mainScroll.setBorder(null);
        mainScroll.getVerticalScrollBar().setUnitIncrement(16);

        mainPanel.add(mainScroll, BorderLayout.CENTER);
        setContentPane(mainPanel);

        // APPROVE BUTTON
        approveButton.addActionListener(e -> {
            statusCombo.setSelectedItem("Approved");
        });

        // REJECT BUTTON
        rejectButton.addActionListener(e -> {
            statusCombo.setSelectedItem("Rejected");
        });

        // SUBMIT VERIFICATION
        submitButton.addActionListener(e -> submitVerification());
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

        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(field);
        panel.add(Box.createVerticalStrut(15));

        return field;
    }

    private void styleLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(new Color(35, 45, 65));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    private void styleCheckBox(JCheckBox checkBox) {
        checkBox.setFont(new Font("Arial", Font.PLAIN, 13));
        checkBox.setBackground(Color.WHITE);
        checkBox.setFocusPainted(false);
        checkBox.setAlignmentX(Component.LEFT_ALIGNMENT);
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

    private void submitVerification() {

        String applicationId =
                applicationIdField.getText().trim();

        String studentName =
                studentNameField.getText().trim();

        String status =
                (String) statusCombo.getSelectedItem();

        String remarks =
                remarksArea.getText().trim();

        if (applicationId.isEmpty() || studentName.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Application ID and Student Name.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (!aadhaarCheck.isSelected()
                || !incomeCheck.isSelected()
                || !marksheetCheck.isSelected()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please verify all three documents before submitting.",
                    "Document Verification",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if ("Pending".equals(status)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select Approved or Rejected status.",
                    "Status Required",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if ("Rejected".equals(status) && remarks.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter remarks for the rejected application.",
                    "Remarks Required",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String message =
                "Application Verification Submitted Successfully!\n\n"
                        + "Application ID: " + applicationId + "\n"
                        + "Student Name: " + studentName + "\n"
                        + "Documents: All Verified\n"
                        + "Status: " + status + "\n"
                        + "Remarks: "
                        + (remarks.isEmpty() ? "None" : remarks);

        JOptionPane.showMessageDialog(
                this,
                message,
                "Verification Result",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ApplicationVerificationForm().setVisible(true);
        });
    }
}
