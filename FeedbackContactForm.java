
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class FeedbackContactForm extends JFrame {

    private final Color blue = new Color(23, 75, 185);
    private final Color bg = new Color(244, 248, 255);
    private final Color border = new Color(215, 225, 240);

    private JTextField nameField;
    private JTextField emailField;
    private JTextField subjectField;
    private JTextArea messageArea;

    public FeedbackContactForm() {

        setTitle("Scholarship Management System - Feedback / Contact");
        setSize(900, 760);
        setMinimumSize(new Dimension(750, 650));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // MAIN BACKGROUND
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(bg);

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
                "12. Feedback / Contact Form",
                SwingConstants.CENTER
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(Color.WHITE);

        header.add(title);
        header.add(subtitle);

        mainPanel.add(header, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(bg);
        centerPanel.setBorder(new EmptyBorder(20, 15, 20, 15));

        // WHITE FORM CARD
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(border, 1),
                new EmptyBorder(22, 25, 22, 25)
        ));

        // FIXED CARD WIDTH
        card.setPreferredSize(new Dimension(500, 545));
        card.setMinimumSize(new Dimension(500, 545));
        card.setMaximumSize(new Dimension(500, 545));

        // FORM HEADING
        JLabel heading = new JLabel("Get in Touch");
        heading.setFont(new Font("Arial", Font.BOLD, 23));
        heading.setForeground(blue);
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(heading);
        card.add(Box.createVerticalStrut(5));

        JLabel description = new JLabel(
                "Have a question? Send us your feedback or message."
        );
        description.setFont(new Font("Arial", Font.PLAIN, 12));
        description.setForeground(Color.GRAY);
        description.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(description);
        card.add(Box.createVerticalStrut(22));

        // NAME
        nameField = addField(card, "Name *");

        // EMAIL
        emailField = addField(card, "Email *");

        // SUBJECT
        subjectField = addField(card, "Subject *");

        // MESSAGE
        JLabel messageLabel = new JLabel("Message *");
        styleLabel(messageLabel);

        card.add(messageLabel);
        card.add(Box.createVerticalStrut(6));

        messageArea = new JTextArea(4, 20);
        messageArea.setFont(new Font("Arial", Font.PLAIN, 13));
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setBorder(new EmptyBorder(7, 8, 7, 8));

        JScrollPane messageScroll = new JScrollPane(messageArea);
        messageScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        messageScroll.setPreferredSize(new Dimension(448, 85));
        messageScroll.setMaximumSize(new Dimension(448, 85));
        messageScroll.setMinimumSize(new Dimension(448, 85));

        card.add(messageScroll);
        card.add(Box.createVerticalStrut(18));

        // SUBMIT BUTTON
        JButton submitButton = new JButton("✉  Submit Feedback");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(blue);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitButton.setPreferredSize(new Dimension(448, 42));
        submitButton.setMinimumSize(new Dimension(448, 42));
        submitButton.setMaximumSize(new Dimension(448, 42));

        card.add(submitButton);
        card.add(Box.createVerticalStrut(12));

        JLabel footer = new JLabel(
                "We appreciate your feedback!"
        );
        footer.setFont(new Font("Arial", Font.PLAIN, 11));
        footer.setForeground(Color.GRAY);
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(footer);

        // KEEP CARD CENTERED, NOT FULL WIDTH
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;

        centerPanel.add(card, gbc);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);

        // SUBMIT ACTION
        submitButton.addActionListener(e -> submitFeedback());
    }

    private JTextField addField(JPanel panel, String labelText) {

        JLabel label = new JLabel(labelText);
        styleLabel(label);

        panel.add(label);
        panel.add(Box.createVerticalStrut(5));

        JTextField field = new JTextField();
        field.setFont(new Font("Arial", Font.PLAIN, 13));

        field.setBorder(new CompoundBorder(
                new LineBorder(border),
                new EmptyBorder(5, 8, 5, 8)
        ));

        field.setAlignmentX(Component.LEFT_ALIGNMENT);
        field.setPreferredSize(new Dimension(448, 34));
        field.setMinimumSize(new Dimension(448, 34));
        field.setMaximumSize(new Dimension(448, 34));

        panel.add(field);
        panel.add(Box.createVerticalStrut(13));

        return field;
    }

    private void styleLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(new Color(35, 45, 65));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    private void submitFeedback() {

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String subject = subjectField.getText().trim();
        String message = messageArea.getText().trim();

        if (name.isEmpty() || email.isEmpty()
                || subject.isEmpty() || message.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields!",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        )) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid email address.",
                    "Invalid Email",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Thank you for your feedback, " + name + "!\n\n"
                        + "Subject: " + subject + "\n"
                        + "Your message has been received.",
                "Feedback Submitted",
                JOptionPane.INFORMATION_MESSAGE
        );

        nameField.setText("");
        emailField.setText("");
        subjectField.setText("");
        messageArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FeedbackContactForm().setVisible(true);
        });
    }
}

