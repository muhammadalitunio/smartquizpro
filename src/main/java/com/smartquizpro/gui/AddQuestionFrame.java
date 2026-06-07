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
import com.smartquizpro.models.Question;
import com.smartquizpro.models.Quiz;

public class AddQuestionFrame extends JFrame implements ActionListener {

    JTextField questionField;
    JTextField optionAField;
    JTextField optionBField;
    JTextField optionCField;
    JTextField optionDField;
    JTextField correctAnswerField;

    JButton saveButton;
    JButton backButton;

    QuizManager quizManager = new QuizManager();

    public AddQuestionFrame() {

        setTitle("Add Question");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240,248,255));
        //saveButton.setBackground(Color.BLUE);
        //saveButton.setForeground(Color.WHITE);
        //backButton.setBackground(Color.BLUE);
        //backButton.setForeground(Color.WHITE);

        questionField = new JTextField();
        questionField.setBounds(150,40,300,30);

        optionAField = new JTextField();
        optionAField.setBounds(150,90,300,30);

        optionBField = new JTextField();
        optionBField.setBounds(150,140,300,30);

        optionCField = new JTextField();
        optionCField.setBounds(150,190,300,30);

        optionDField = new JTextField();
        optionDField.setBounds(150,240,300,30);

        correctAnswerField = new JTextField();
        correctAnswerField.setBounds(150,290,300,30);

        saveButton = new JButton("Save Question");
        saveButton.setBounds(200,360,150,35);

        saveButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(200,410,150,35);
        backButton.addActionListener(this);
        add(backButton);

        add(new JLabel("Question")).setBounds(50,40,100,30);
        add(new JLabel("Option A")).setBounds(50,90,100,30);
        add(new JLabel("Option B")).setBounds(50,140,100,30);
        add(new JLabel("Option C")).setBounds(50,190,100,30);
        add(new JLabel("Option D")).setBounds(50,240,100,30);
        add(new JLabel("Correct")).setBounds(50,290,100,30);

        add(questionField);
        add(optionAField);
        add(optionBField);
        add(optionCField);
        add(optionDField);
        add(correctAnswerField);
        add(saveButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        Quiz quiz = quizManager.getCurrentQuiz();

        if(quiz != null) {

            Question question = new Question(

                    questionField.getText(),
                    optionAField.getText(),
                    optionBField.getText(),
                    optionCField.getText(),
                    optionDField.getText(),
                    correctAnswerField.getText()

            );

            quiz.addQuestion(question);

            JOptionPane.showMessageDialog(this,
                    "Question Added Successfully");

        }
        else {

            JOptionPane.showMessageDialog(this,
                    "Create Quiz First");
            
            new TeacherDashboard();
            dispose();

        }
        if(e.getSource() == backButton) {

            new TeacherDashboard();
            dispose();

        }
    }
}