

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ProfileUpdateForm extends JFrame {

    private final Color BLUE = new Color(29, 78, 190);
    private final Color BTN_BLUE = new Color(22, 99, 225);
    private final Color LIGHT_BLUE = new Color(239, 244, 255);
    private final Color ICON_BG = new Color(218, 231, 255);
    private final Color TEXT_BLUE = new Color(50, 80, 140);
    private final Color BORDER = new Color(210, 220, 237);

    private JTextField name = new JTextField();
    private JTextField dob = new JTextField();
    private JTextField email = new JTextField();
    private JTextField mobile = new JTextField();
    private JTextField address = new JTextField();
    private JTextField college = new JTextField();
    private JTextField course = new JTextField();
    private JTextField year = new JTextField();
    private JTextField marks = new JTextField();

    private JComboBox<String> gender = new JComboBox<>(
            new String[]{"Select Gender", "Male", "Female", "Other"}
    );

    public ProfileUpdateForm() {

        setTitle("Scholarship Management System - Profile Update");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 800);
        setMinimumSize(new Dimension(750, 600));
        setLocationRelativeTo(null);

        // MAIN BACKGROUND
        JPanel background = new JPanel(new BorderLayout(0, 0));
        background.setBackground(Color.WHITE);
        background.setBorder(new EmptyBorder(12, 12, 12, 12));

        // MAIN CARD
        JPanel card = new JPanel(new BorderLayout(0, 0));
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(BORDER, 1, true));

        // HEADER
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(BLUE);
        header.setBorder(new EmptyBorder(16, 18, 14, 18));

        JLabel heading = new JLabel("  5. Profile Update Form");
        heading.setFont(new Font("Arial", Font.BOLD, 19));
        heading.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Scholarship Management System");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(Color.WHITE);

        header.add(heading);
        header.add(Box.createVerticalStrut(7));
        header.add(subtitle);

        card.add(header, BorderLayout.NORTH);

        // CONTENT AREA
        JPanel content = new JPanel(new BorderLayout(0, 14));
        content.setBackground(Color.WHITE);
        content.setBorder(new EmptyBorder(16, 16, 16, 16));

        JLabel instruction = new JLabel(
                "Update your profile information using the sections below."
        );
        instruction.setFont(new Font("Arial", Font.PLAIN, 14));
        instruction.setForeground(TEXT_BLUE);

        content.add(instruction, BorderLayout.NORTH);

        // THREE SECTIONS SHARE AVAILABLE HEIGHT EQUALLY
        JPanel sections = new JPanel(new GridLayout(3, 1, 0, 12));
        sections.setBackground(Color.WHITE);

        sections.add(createSection(
                1,
                "Personal Information",
                "Name, date of birth, gender",
                this::editPersonal
        ));

        sections.add(createSection(
                2,
                "Contact Details",
                "Email, mobile number, address",
                this::editContact
        ));

        sections.add(createSection(
                3,
                "Educational Details",
                "College, course, year, marks",
                this::editEducation
        ));

        content.add(sections, BorderLayout.CENTER);

        // BOTTOM BUTTON
        JButton update = new JButton("Update Profile");
        update.setFont(new Font("Arial", Font.BOLD, 16));
        update.setForeground(Color.WHITE);
        update.setBackground(BTN_BLUE);
        update.setOpaque(true);
        update.setBorderPainted(false);
        update.setFocusPainted(false);
        update.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );
        update.setPreferredSize(new Dimension(200, 50));

        update.addActionListener(e -> updateProfile());

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(update, BorderLayout.CENTER);

        content.add(buttonPanel, BorderLayout.SOUTH);

        card.add(content, BorderLayout.CENTER);
        background.add(card, BorderLayout.CENTER);

        setContentPane(background);

        // OPEN MAXIMIZED
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    // SECTION DESIGN
    private JPanel createSection(
            int number,
            String title,
            String description,
            Runnable action
    ) {

        JPanel section = new JPanel(new BorderLayout(16, 0));
        section.setBackground(LIGHT_BLUE);
        section.setBorder(new EmptyBorder(14, 14, 14, 14));

        IconTile icon = new IconTile(number);
        icon.setPreferredSize(new Dimension(46, 46));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(
                textPanel, BoxLayout.Y_AXIS
        ));
        textPanel.setOpaque(false);

        JLabel titleLabel = new JLabel(number + ". " + title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setForeground(new Color(20, 30, 48));

        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setForeground(new Color(91, 116, 160));

        textPanel.add(titleLabel);
        textPanel.add(Box.createVerticalStrut(8));
        textPanel.add(descriptionLabel);

        JLabel arrow = new JLabel("\u203A");
        arrow.setFont(new Font("Arial", Font.PLAIN, 30));
        arrow.setForeground(BTN_BLUE);

        section.add(icon, BorderLayout.WEST);
        section.add(textPanel, BorderLayout.CENTER);
        section.add(arrow, BorderLayout.EAST);

        section.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        section.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                action.run();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                section.setBackground(new Color(228, 237, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                section.setBackground(LIGHT_BLUE);
            }
        });

        return section;
    }

    // CUSTOM ICONS
    private class IconTile extends JPanel {

        private final int type;

        IconTile(int type) {
            this.type = type;
            setOpaque(true);
            setBackground(ICON_BG);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(BLUE);
            g2.setStroke(new BasicStroke(1.8f));
            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int cx = getWidth() / 2;
            int cy = getHeight() / 2;

            if (type == 1) {
                // PERSON ICON
                g2.drawOval(cx - 5, cy - 12, 10, 10);
                g2.drawArc(cx - 10, cy, 20, 17, 0, 180);
            } else if (type == 2) {
                // CONTACT ICON
                g2.drawRoundRect(cx - 10, cy - 12, 20, 24, 3, 3);
                g2.drawOval(cx - 4, cy - 7, 8, 8);
                g2.drawLine(cx - 6, cy + 5, cx + 6, cy + 5);
                g2.drawLine(cx - 6, cy + 8, cx + 6, cy + 8);
            } else {
                // EDUCATION ICON
                int[] x = {cx - 12, cx, cx + 12, cx};
                int[] y = {cy - 4, cy - 10, cy - 4, cy + 2};

                g2.drawPolygon(x, y, 4);
                g2.drawLine(cx - 7, cy, cx - 7, cy + 7);
                g2.drawArc(cx - 7, cy + 1, 14, 10, 180, 180);
                g2.drawLine(cx + 12, cy - 4, cx + 12, cy + 7);
            }

            g2.dispose();
        }
    }

    // DIALOG HELPER
    private JPanel createDialogPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(12, 12, 12, 12));
        return panel;
    }

    private void addField(
            JPanel panel, String label, JComponent field
    ) {
        JLabel fieldLabel = new JLabel(label);
        fieldLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setPreferredSize(new Dimension(350, 34));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));

        if (field instanceof JTextField) {
            field.setBorder(new CompoundBorder(
                    new LineBorder(BORDER),
                    new EmptyBorder(5, 8, 5, 8)
            ));
        }

        panel.add(fieldLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(field);
        panel.add(Box.createVerticalStrut(12));
    }

    private void showEditor(String title, JPanel panel) {
        JOptionPane.showMessageDialog(
                this, panel, title, JOptionPane.PLAIN_MESSAGE
        );
    }

    // PERSONAL INFORMATION
    private void editPersonal() {
        JPanel p = createDialogPanel();
        addField(p, "Full Name", name);
        addField(p, "Date of Birth", dob);
        addField(p, "Gender", gender);
        showEditor("Personal Information", p);
    }

    // CONTACT DETAILS
    private void editContact() {
        JPanel p = createDialogPanel();
        addField(p, "Email Address", email);
        addField(p, "Mobile Number", mobile);
        addField(p, "Complete Address", address);
        showEditor("Contact Details", p);
    }

    // EDUCATIONAL DETAILS
    private void editEducation() {
        JPanel p = createDialogPanel();
        addField(p, "College Name", college);
        addField(p, "Course / Branch", course);
        addField(p, "Current Year", year);
        addField(p, "Previous Marks (%)", marks);
        showEditor("Educational Details", p);
    }

    // UPDATE PROFILE
    private void updateProfile() {

        if (name.getText().trim().isEmpty()
                || email.getText().trim().isEmpty()
                || mobile.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your name, email and mobile number.",
                    "Incomplete Profile",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Profile updated successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProfileUpdateForm::new);
    }
}
