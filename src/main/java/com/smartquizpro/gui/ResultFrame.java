package com.smartquizpro.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultFrame extends JFrame implements ActionListener{

    JButton backButton;

    public ResultFrame(int score) {

        setTitle("Result");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setLayout(null);
        //getContentPane().setBackground(new java.awt.Color(240,248,255));

        backButton = new JButton("Back");

        backButton.addActionListener(this);
        add(backButton);

        JLabel label =
                new JLabel("Your Score : " + score);

        add(label);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {

            new StudentDashboard();
            dispose();

        }
    }
}