package com.smartquizpro.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.smartquizpro.logic.AuthManager;
import com.smartquizpro.models.User;

public class SignupFrame extends JFrame implements ActionListener {

    AuthManager authManager = new AuthManager();

    JLabel titleLabel, userLabel, passLabel, roleLabel;
    JTextField usernameField;
    JPasswordField passwordField;

    JComboBox<String> roleBox;

    JButton signupButton, backButton;

    public SignupFrame() {

        setTitle("Signup");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240,248,255));

        // Title
        titleLabel = new JLabel("Create Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(110, 20, 200, 30);
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
        passLabel.setBounds(50, 130, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 180, 25);
        add(passwordField);

        // Role
        roleLabel = new JLabel("Role:");
        roleLabel.setBounds(50, 180, 100, 25);
        add(roleLabel);

        String roles[] = {"Student", "Teacher"};
        roleBox = new JComboBox<>(roles);
        roleBox.setBounds(150, 180, 180, 25);
        add(roleBox);

        // Signup Button
        signupButton = new JButton("Signup");
        signupButton.setBounds(60, 240, 110, 35);
        signupButton.addActionListener(this);
        add(signupButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(210, 240, 110, 35);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signupButton) {


            String username = usernameField.getText();

            String password =
                    new String(passwordField.getPassword());
            String role = 
                    roleBox.getSelectedItem().toString();
            User user =
                    new User(username, password, role);

            authManager.signup(user);

            JOptionPane.showMessageDialog(this, 
                            "Account created successfully!");
        }

        if (e.getSource() == backButton) {

            new LoginFrame();
            dispose();

        }
    }
}