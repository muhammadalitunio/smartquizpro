package com.smartquizpro.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TeacherDashboard extends JFrame implements ActionListener {

    JButton createQuizButton;
    JButton addQuestionButton;
    JButton viewQuizButton;
    JButton logoutButton;

    public TeacherDashboard() {

        setTitle("Teacher Dashboard");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240,248,255));

        createQuizButton = new JButton("Create Quiz");
        createQuizButton.setBounds(150,50,180,35);
        //createQuizButton.setBackground(Color.BLUE);
        //createQuizButton.setForeground(Color.WHITE);

        addQuestionButton = new JButton("Add Question");
        addQuestionButton.setBounds(150,110,180,35);
        //addQuestionButton.setBackground(Color.BLUE);
        //addQuestionButton.setForeground(Color.WHITE);

        viewQuizButton = new JButton("View Quizzes");
        viewQuizButton.setBounds(150,170,180,35);
        //viewQuizButton.setBackground(Color.BLUE);
        //viewQuizButton.setForeground(Color.WHITE);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(150,230,180,35);
        //logoutButton.setBackground(Color.BLUE);
        //logoutButton.setForeground(Color.WHITE);

        add(createQuizButton);
        add(addQuestionButton);
        add(viewQuizButton);
        add(logoutButton);

        createQuizButton.addActionListener(this);
        addQuestionButton.addActionListener(this);
        viewQuizButton.addActionListener(this);
        logoutButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == createQuizButton) {

            new CreateQuizFrame();
            dispose();

        }

        if(e.getSource() == addQuestionButton) {

            new AddQuestionFrame();
            dispose();

        }

        if(e.getSource() == viewQuizButton) {

            new ViewQuizFrame();
            dispose();

        }

        if(e.getSource() == logoutButton) {

            new LoginFrame();
            dispose();

        }
    }
}