package com.smartquizpro.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.smartquizpro.logic.QuizManager;
import com.smartquizpro.models.Quiz;

public class CreateQuizFrame extends JFrame implements ActionListener {

    JLabel titleLabel;

    JTextField titleField;

    JButton saveButton;

    JButton backButton;

    QuizManager quizManager = new QuizManager();

    public CreateQuizFrame() {

        setTitle("Create Quiz");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240,248,255));
        //saveButton.setBackground(Color.BLUE);
        //saveButton.setForeground(Color.WHITE);
        //backButton.setBackground(Color.BLUE);
        //backButton.setForeground(Color.WHITE);

        titleLabel = new JLabel("Quiz Title:");

        titleLabel.setBounds(50,70,100,30);

        titleField = new JTextField();

        titleField.setBounds(150,70,180,30);

        saveButton = new JButton("Save Quiz");

        saveButton.setBounds(120,150,140,35);

        saveButton.addActionListener(this);

        backButton = new JButton("Back");

        backButton.setBounds(120,190,140,35);

        backButton.addActionListener(this);

        add(titleLabel);
        add(titleField);
        add(saveButton);
        add(backButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String title = titleField.getText();

        Quiz quiz = new Quiz(title);

        quizManager.addQuiz(quiz);
        quizManager.setCurrentQuiz(quiz);
        
        JOptionPane.showMessageDialog(this,
                "Quiz Created Successfully");
        
        new TeacherDashboard();
        dispose();
        
        if(e.getSource() == backButton) {

        new TeacherDashboard();
        dispose();
        }
    }
}