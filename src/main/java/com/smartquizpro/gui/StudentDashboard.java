package com.smartquizpro.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StudentDashboard extends JFrame implements ActionListener {

    JButton startQuizButton;
    JButton viewResultButton;
    JButton logoutButton;

    public StudentDashboard() {

        setTitle("Student Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240,248,255));

        startQuizButton = new JButton("Start Quiz");
        startQuizButton.setBounds(150,80,180,35);
        //startQuizButton.setBackground(Color.BLUE);
        //startQuizButton.setForeground(Color.WHITE);

        viewResultButton = new JButton("View Result");
        viewResultButton.setBounds(150,150,180,35);
        //viewResultButton.setBackground(Color.BLUE);
        //viewResultButton.setForeground(Color.WHITE);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(150,220,180,35);
        //logoutButton.setBackground(Color.BLUE);
        //logoutButton.setForeground(Color.WHITE);

        add(startQuizButton);
        add(viewResultButton);
        add(logoutButton);

        startQuizButton.addActionListener(this);
        viewResultButton.addActionListener(this);
        logoutButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startQuizButton) {

            new QuizFrame();
            dispose();

        }

        if(e.getSource() == viewResultButton) {

            new ResultFrame(0);

        }

        if(e.getSource() == logoutButton) {

            new LoginFrame();
            dispose();

        }
    }
}