package com.smartquizpro.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.smartquizpro.logic.AuthManager;
import com.smartquizpro.models.User;

public class LoginFrame extends JFrame implements ActionListener {

    AuthManager authManager = new AuthManager();

    JLabel titleLabel, userLabel, passLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, signupButton;

    public LoginFrame() {
        setTitle("SMARTQUIZ PRO - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240,248,255));

        // Title
        titleLabel = new JLabel("SMARTQUIZ PRO");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(120, 20, 300, 40);
        add(titleLabel);

        // Username
        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 80, 180, 25);
        add(usernameField);

        // Password
        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 120, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 120, 180, 25);
        add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(70, 180, 100, 35);
        loginButton.addActionListener(this);
        add(loginButton);

        // Signup button
        signupButton = new JButton("Signup");
        signupButton.setBounds(220, 180, 100, 35);
        signupButton.addActionListener(this);
        add(signupButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (e.getSource() == loginButton) {

            User user = authManager.login(username, password);

                if (user != null) {

                    if (user.getRole().equals("Teacher")) {

                        new TeacherDashboard();
                        dispose();
                    } else {
                        new StudentDashboard();
                        dispose();

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password");
                }

        }

        if (e.getSource() == signupButton) {
            //JOptionPane.showMessageDialog(this, "Signup page coming soon");
            new SignupFrame();
            dispose();
        }
    }
}
