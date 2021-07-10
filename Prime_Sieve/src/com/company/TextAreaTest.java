package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaTest implements ActionListener{

    JTextField field;
    JLabel label1;
    JLabel label2;

    public static void main(String[] args){
        TextAreaTest text = new TextAreaTest();
        text.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Prime or Not?");
        button.addActionListener(this);
        field = new JTextField(20);
        label1 = new JLabel();
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label2 = new JLabel();

        panel.add(field);

        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, label1);

        frame.setSize(350,300);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String val = field.getText();
        if(val != null) {
            long prime = Integer.parseInt(val);
            if (PrimeCalc.sieveRet(prime)) {
                label1.setText(prime + " " + "is a prime number!");
            } else {
                label1.setText(prime + " " + "is not a prime number");
            }
        }
    }
}
