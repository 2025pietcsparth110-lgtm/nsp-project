
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JTextField adminEmailField;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JRadioButton studentRadio;
    private JRadioButton adminRadio;

    private JLabel emailLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    private JButton loginButton;
    private JButton forgotPasswordButton;

    private JPanel mainPanel;

    public Login() {

        setTitle("Scholarship Management System");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        getContentPane().setBackground(
                new Color(229, 240, 252)
        );

        setLayout(new GridBagLayout());

        // Main panel
        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setPreferredSize(
                new Dimension(400, 540)
        );

        // Poornima College Logo
        JLabel logoLabel = new JLabel(
                "", SwingConstants.CENTER
        );

        java.net.URL logoURL =
                getClass().getResource(
                        "/images/poornima_logo.png"
                );

        if (logoURL != null) {

            ImageIcon originalIcon =
                    new ImageIcon(logoURL);

            Image scaledImage =
                    originalIcon.getImage()
                            .getScaledInstance(
                                    300, 75,
                                    Image.SCALE_SMOOTH
                            );

            logoLabel.setIcon(
                    new ImageIcon(scaledImage)
            );

        } else {

            logoLabel.setText("POORNIMA");
            logoLabel.setFont(
                    new Font("Serif", Font.BOLD, 32)
            );
            logoLabel.setForeground(
                    new Color(25, 75, 190)
            );
        }

        logoLabel.setBounds(40, 15, 320, 75);
        mainPanel.add(logoLabel);

        // Heading
        JLabel headingLabel = new JLabel(
                "<html><center>"
                        + "Scholarship Management<br>System"
                        + "</center></html>",
                SwingConstants.CENTER
        );

        headingLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        headingLabel.setBounds(35, 95, 330, 60);
        mainPanel.add(headingLabel);

        // Login type selection
        studentRadio = new JRadioButton("Student Login");
        adminRadio = new JRadioButton("Admin Login");

        studentRadio.setBounds(45, 165, 140, 30);
        adminRadio.setBounds(205, 165, 140, 30);

        studentRadio.setBackground(Color.WHITE);
        adminRadio.setBackground(Color.WHITE);

        ButtonGroup group = new ButtonGroup();
        group.add(studentRadio);
        group.add(adminRadio);

        studentRadio.setSelected(true);

        mainPanel.add(studentRadio);
        mainPanel.add(adminRadio);

        // Admin Email
        emailLabel = new JLabel("Admin Email Address");
        emailLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );
        emailLabel.setBounds(45, 205, 310, 25);
        mainPanel.add(emailLabel);

        adminEmailField = new JTextField();
        adminEmailField.setBounds(45, 230, 310, 38);
        adminEmailField.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );
        mainPanel.add(adminEmailField);

        // Username
        usernameLabel = new JLabel("Email / Username");
        usernameLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );
        usernameLabel.setBounds(45, 280, 310, 25);
        mainPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(45, 305, 310, 38);
        usernameField.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );
        mainPanel.add(usernameField);

        // Password
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );
        passwordLabel.setBounds(45, 355, 310, 25);
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(45, 380, 310, 38);
        passwordField.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );
        mainPanel.add(passwordField);

        // Forgot Password
        forgotPasswordButton =
                new JButton("Forgot Password?");

        forgotPasswordButton.setBounds(
                195, 420, 160, 25
        );

        forgotPasswordButton.setForeground(Color.BLUE);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setFocusPainted(false);
        forgotPasswordButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        mainPanel.add(forgotPasswordButton);

        // Login button
        loginButton = new JButton("LOGIN");

        loginButton.setBounds(45, 465, 310, 43);
        loginButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );
        loginButton.setBackground(
                new Color(25, 75, 185)
        );
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        mainPanel.add(loginButton);

        add(mainPanel);

        // Switch between Student and Admin forms
        studentRadio.addActionListener(e -> updateForm());
        adminRadio.addActionListener(e -> updateForm());

        // Initial form
        updateForm();

        // Login action
        loginButton.addActionListener(e -> handleLogin());

        // Forgot password action
        forgotPasswordButton.addActionListener(e -> {

            if (adminRadio.isSelected()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please contact the system administrator "
                                + "to reset your admin password.",
                        "Forgot Password",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Please contact the scholarship "
                                + "administrator to reset your password.",
                        "Forgot Password",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    // Show the correct fields for each login type
    private void updateForm() {

        boolean isAdmin = adminRadio.isSelected();

        emailLabel.setVisible(isAdmin);
        adminEmailField.setVisible(isAdmin);

        if (isAdmin) {

            emailLabel.setText("Admin Email Address");
            usernameLabel.setText("Admin Username");

            emailLabel.setBounds(45, 205, 310, 25);
            adminEmailField.setBounds(45, 230, 310, 38);

            usernameLabel.setBounds(45, 280, 310, 25);
            usernameField.setBounds(45, 305, 310, 38);

            passwordLabel.setBounds(45, 355, 310, 25);
            passwordField.setBounds(45, 380, 310, 38);

            forgotPasswordButton.setBounds(
                    195, 420, 160, 25
            );

            loginButton.setBounds(45, 465, 310, 43);

        } else {

            emailLabel.setVisible(false);
            adminEmailField.setVisible(false);

            usernameLabel.setText("Email / Username");

            usernameLabel.setBounds(45, 235, 310, 25);
            usernameField.setBounds(45, 260, 310, 38);

            passwordLabel.setBounds(45, 315, 310, 25);
            passwordField.setBounds(45, 340, 310, 38);

            forgotPasswordButton.setBounds(
                    195, 380, 160, 25
            );

            loginButton.setBounds(45, 425, 310, 43);
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Validate login details
    private void handleLogin() {

        String username = usernameField.getText().trim();

        String password =
                new String(passwordField.getPassword());

        boolean isAdmin = adminRadio.isSelected();

        if (isAdmin) {

            String email = adminEmailField.getText().trim();

            if (email.isEmpty()
                    || username.isEmpty()
                    || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter admin email, username "
                                + "and password.",
                        "Missing Details",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

        } else {

            if (username.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter username and password.",
                        "Missing Details",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }
        }

        boolean validLogin = false;
        try {
            String email = isAdmin ? adminEmailField.getText().trim() : "";
            validLogin = SelectData.checkLogin(isAdmin, username, email, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Fallback for demo credentials if database is offline
        if (!validLogin) {
            if (isAdmin) {
                String email = adminEmailField.getText().trim();
                validLogin = email.equalsIgnoreCase("admin@poornima.org")
                        && username.equals("admin")
                        && password.equals("admin123");
            } else {
                validLogin = username.equals("student") && password.equals("student123");
            }
        }

        if (!validLogin) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid login details!",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        try {

            // Opens your existing dashboard
            DashboardFrame dashboard = new DashboardFrame();

            dashboard.setLocationRelativeTo(null);
            dashboard.setVisible(true);

            dispose();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Dashboard open nahi hua: "
                            + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
