
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class StudentRegistrationForm extends JFrame {

    private final Color blue = new Color(20, 75, 190);
    private final Color buttonBlue = new Color(13, 96, 225);
    private final Color lightBlue = new Color(229, 239, 255);
    private final Color borderColor = new Color(215, 223, 235);

    private JTextField nameField, emailField, mobileField, dobField;
    private JTextArea addressField;
    private JPasswordField passwordField;
    private JRadioButton male, female, other;

    public StudentRegistrationForm() {
        setTitle("Scholarship Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(540, 730);
        setMinimumSize(new Dimension(500, 680));
        setLocationRelativeTo(null);

        JPanel background = new JPanel(new GridBagLayout());
        background.setBackground(new Color(244, 248, 255));

        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(420, 660));
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(new Color(220, 228, 240)));

        // HEADER
        JPanel header = new JPanel(new GridLayout(2, 1, 0, 0));
        header.setBackground(blue);
        header.setPreferredSize(new Dimension(420, 70));

        JLabel title = new JLabel(
                "🎓 Scholarship Management System",
                SwingConstants.CENTER
        );
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 17));

        JLabel subtitle = new JLabel(
                "Student Registration Form",
                SwingConstants.CENTER
        );
        subtitle.setForeground(Color.WHITE);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 13));

        header.add(title);
        header.add(subtitle);
        card.add(header, BorderLayout.NORTH);

        // FORM BODY
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBackground(Color.WHITE);
        body.setBorder(new EmptyBorder(12, 18, 10, 18));

        // INTRODUCTION
        JPanel intro = new JPanel();
        intro.setLayout(new BoxLayout(intro, BoxLayout.Y_AXIS));
        intro.setBackground(lightBlue);
        intro.setBorder(new EmptyBorder(9, 11, 9, 8));
        intro.setAlignmentX(Component.LEFT_ALIGNMENT);
        intro.setMaximumSize(new Dimension(380, 55));

        JLabel introTitle = new JLabel("Create Your Account");
        introTitle.setFont(new Font("Arial", Font.BOLD, 13));

        JLabel introText = new JLabel(
                "Fill in the details below to register for the scholarship portal."
        );
        introText.setFont(new Font("Arial", Font.PLAIN, 10));

        intro.add(introTitle);
        intro.add(Box.createVerticalStrut(3));
        intro.add(introText);

        body.add(intro);
        body.add(Box.createVerticalStrut(10));

        // TEXT FIELDS
        nameField = new JTextField();
        emailField = new JTextField();
        mobileField = new JTextField();
        dobField = new JTextField();
        passwordField = new JPasswordField();

        styleField(nameField, "Enter your full name");
        styleField(emailField, "Enter your email address");
        styleField(mobileField, "Enter your mobile number");
        styleField(dobField, "dd-mm-yyyy");
        styleField(passwordField, "Create a password");

        addField(body, "Name *", nameField);
        addField(body, "Email *", emailField);
        addField(body, "Mobile Number *", mobileField);
        addField(body, "Date of Birth *", dobField);

        // GENDER
        body.add(Box.createVerticalStrut(1));
        body.add(makeLabel("Gender *"));
        body.add(Box.createVerticalStrut(3));

        JPanel genderPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 10, 0)
        );
        genderPanel.setBackground(Color.WHITE);
        genderPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        genderPanel.setMaximumSize(new Dimension(380, 28));

        male = new JRadioButton("Male", true);
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        for (JRadioButton option :
                new JRadioButton[]{male, female, other}) {
            option.setBackground(Color.WHITE);
            option.setFont(new Font("Arial", Font.PLAIN, 12));
            genderPanel.add(option);
        }

        body.add(genderPanel);
        body.add(Box.createVerticalStrut(5));

        // ADDRESS
        addressField = new JTextArea(2, 20);
        addressField.setFont(new Font("Arial", Font.PLAIN, 12));
        addressField.setLineWrap(true);
        addressField.setWrapStyleWord(true);

        JScrollPane addressScroll = new JScrollPane(addressField);
        addressScroll.setPreferredSize(new Dimension(380, 45));
        addressScroll.setMaximumSize(new Dimension(380, 45));
        addressScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        addressScroll.setBorder(new LineBorder(borderColor));

        addField(body, "Address *", addressScroll);

        // PASSWORD
        addField(body, "Password *", passwordField);

        // REGISTER BUTTON
        JButton register = new JButton("♙  Register");
        register.setFont(new Font("Arial", Font.BOLD, 14));
        register.setBackground(buttonBlue);
        register.setForeground(Color.WHITE);
        register.setFocusPainted(false);
        register.setBorderPainted(false);
        register.setCursor(new Cursor(Cursor.HAND_CURSOR));
        register.setPreferredSize(new Dimension(380, 36));
        register.setMaximumSize(new Dimension(380, 36));
        register.setAlignmentX(Component.LEFT_ALIGNMENT);

        body.add(Box.createVerticalStrut(5));
        body.add(register);

        // LOGIN TEXT
        JLabel login = new JLabel(
                "<html>Already have an account? "
                        + "<font color='#0969da'><u>Login here</u></font></html>"
        );
        login.setFont(new Font("Arial", Font.PLAIN, 11));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);

        body.add(Box.createVerticalStrut(10));
        body.add(login);

        card.add(body, BorderLayout.CENTER);
        background.add(card);
        setContentPane(background);

        // REGISTER ACTION
        register.addActionListener(e -> {
            if (nameField.getText().trim().isEmpty()
                    || emailField.getText().trim().isEmpty()
                    || mobileField.getText().trim().isEmpty()
                    || dobField.getText().trim().isEmpty()
                    || addressField.getText().trim().isEmpty()
                    || passwordField.getPassword().length == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill in all required fields!",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                String sName = nameField.getText().trim();
                String sEmail = emailField.getText().trim();
                String sMobile = mobileField.getText().trim();
                String sCourse = "B.Tech";
                String sId = "STU-" + (int)(Math.random() * 9000 + 1000);
                String pwd = new String(passwordField.getPassword());

                InsertData.insertStudent(sId, sName, sEmail, sMobile, sCourse, "1st Year", "General");
                InsertData.insertUser(sEmail, sEmail, pwd, "STUDENT");

                JOptionPane.showMessageDialog(
                        this,
                        "Registration submitted successfully!\n\nYour Student ID: " + sId + "\nYou can now login with your Email & Password.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                dispose();
            }
        });
    }

    private JLabel makeLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private void styleField(JComponent field, String hint) {
        field.setFont(new Font("Arial", Font.PLAIN, 12));
        field.setToolTipText(hint);
        field.setPreferredSize(new Dimension(380, 30));
        field.setMaximumSize(new Dimension(380, 30));
        field.setBorder(new CompoundBorder(
                new LineBorder(borderColor),
                new EmptyBorder(4, 7, 4, 7)
        ));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    private void addField(
            JPanel body, String title, JComponent field) {

        body.add(makeLabel(title));
        body.add(Box.createVerticalStrut(3));
        body.add(field);
        body.add(Box.createVerticalStrut(7));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentRegistrationForm frame =
                    new StudentRegistrationForm();
            frame.setVisible(true);
        });
    }
}

