package com.smartquizpro.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.smartquizpro.logic.QuizManager;
import com.smartquizpro.models.Quiz;

public class ViewQuizFrame extends JFrame implements ActionListener {

    QuizManager quizManager = new QuizManager();
    JButton backButton;

    public ViewQuizFrame() {

        setTitle("View Quizzes");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        add(backButton);

        JTextArea area = new JTextArea();

        String text = "";

        for(Quiz quiz : quizManager.getQuizzes()) {

            text += quiz.getTitle() + "\n";

        }

        area.setText(text);

        add(new JScrollPane(area));

        setVisible(true);


        }
        @Override
        public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            new TeacherDashboard();
            dispose();
            }
        }
    }

