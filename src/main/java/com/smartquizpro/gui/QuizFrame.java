package com.smartquizpro.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.smartquizpro.logic.QuizManager;
import com.smartquizpro.models.Question;
import com.smartquizpro.models.Quiz;

public class QuizFrame extends JFrame implements ActionListener {

    JLabel questionLabel;

    JRadioButton optionA;
    JRadioButton optionB;
    JRadioButton optionC;
    JRadioButton optionD;

    ButtonGroup group;

    JButton nextButton;

    QuizManager quizManager = new QuizManager();

    Quiz quiz;

    int currentIndex = 0;
    int score = 0;

    public QuizFrame() {

        setTitle("Quiz");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //nextButton.setBackground(Color.BLUE);
        //nextButton.setForeground(Color.WHITE);
        getContentPane().setBackground(new Color(240,248,255));

        quiz = quizManager.getCurrentQuiz();

        if (quiz == null || quiz.getTotalQuestions() == 0) {

            JOptionPane.showMessageDialog(this,
                    "No Questions Available");

            new StudentDashboard();
            dispose();

            return;
        }

        questionLabel = new JLabel();
        questionLabel.setBounds(50,40,600,30);

        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();

        optionA.setBounds(50,100,300,30);
        optionB.setBounds(50,150,300,30);
        optionC.setBounds(50,200,300,30);
        optionD.setBounds(50,250,300,30);

        group = new ButtonGroup();

        group.add(optionA);
        group.add(optionB);
        group.add(optionC);
        group.add(optionD);

        nextButton = new JButton("Next");

        nextButton.setBounds(250,340,120,40);

        nextButton.addActionListener(this);

        add(questionLabel);

        add(optionA);
        add(optionB);
        add(optionC);
        add(optionD);

        add(nextButton);

        loadQuestion();

        setVisible(true);
    }

    private void loadQuestion() {

        Question q = quiz.getQuestion(currentIndex);

        questionLabel.setText(q.getQuestionText());

        optionA.setText(q.getOptionA());
        optionB.setText(q.getOptionB());
        optionC.setText(q.getOptionC());
        optionD.setText(q.getOptionD());

        group.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {

        Question q = quiz.getQuestion(currentIndex);

        String selected = "";

        if(optionA.isSelected())
            selected = optionA.getText();

        else if(optionB.isSelected())
            selected = optionB.getText();

        else if(optionC.isSelected())
            selected = optionC.getText();

        else if(optionD.isSelected())
            selected = optionD.getText();

        if(selected.equals(q.getCorrectAnswer())) {

            score++;

        }

        currentIndex++;

        if(currentIndex < quiz.getTotalQuestions()) {

            loadQuestion();

        }
        else {

            new ResultFrame(score);

            dispose();

        }
    }
}