package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class KitePanel extends JPanel implements ActionListener {
    FloatTextField ShortDiagonal;
    FloatTextField LongDiagonal;
    OutputTextField areaOutField;

    DecimalFormat decimalFormat=new DecimalFormat("#.#####");

    KitePanel() {
        BodyLabel rectangleHead = new BodyLabel("Kite");
        rectangleHead.setBounds(60,20,100,19);
        add(rectangleHead);

        ShortDiagonal = new FloatTextField("Short diagonal",20);
        ShortDiagonal.setBounds(60,56,135, ShortDiagonal.getHeight());
        ShortDiagonal.setToolTipText("Enter short diagonal length here");
        add(ShortDiagonal);

        LongDiagonal = new FloatTextField("Long diagonal",20);
        LongDiagonal.setBounds(215,56,135, LongDiagonal.getHeight());
        LongDiagonal.setToolTipText("Enter long diagonal breadth here");
        add(LongDiagonal);

        CalculateButton rectangleCalBtn = new CalculateButton();
        rectangleCalBtn.setBounds(60,100,100,30);
        rectangleCalBtn.addActionListener(this);
        add(rectangleCalBtn);

        //Area out
        BodyLabel areaLabel = new BodyLabel("Area :");
        areaLabel.setBounds(60,150,100,34);
        areaLabel.setAlignmentY(CENTER_ALIGNMENT);
        add(areaLabel);

        areaOutField = new OutputTextField();
        areaOutField.setBounds(170,150,areaOutField.getWidth(),areaOutField.getHeight());
        add(areaOutField);

        //Right image
        JLabel picLabel = new JLabel(new ImageIcon("assets/kite.png"));
        picLabel.setBounds(450, 80, 84, 168);
        add(picLabel);

        setLayout(null);
        setBounds(0,80,696,448);
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ShortDiagonal.isTextEntered() || !LongDiagonal.isTextEntered()) {
            FloatTextField[] inputs = {ShortDiagonal,LongDiagonal};
            for (FloatTextField temp:inputs) {
                if (temp.isTextEntered()) {
                    temp.makeNormal();
                }
                else {
                    temp.makeRed();
                }
            }
        } else {
            double shortDiagonalValue=0;
            double longDiagonalValue=0;
            try {
                shortDiagonalValue = Double.parseDouble(ShortDiagonal.getText());
                ShortDiagonal.makeNormal();
                longDiagonalValue = Double.parseDouble(LongDiagonal.getText());
                LongDiagonal.makeNormal();
                calcArea(shortDiagonalValue,longDiagonalValue);
            } catch (Exception ex) {
                if (shortDiagonalValue==0) {
                    ShortDiagonal.makeRed();}
                if (longDiagonalValue==0 && shortDiagonalValue!=0){
                    LongDiagonal.makeRed();}
            }
        }
    }

    public void calcArea(Double shortDiagonalValue,Double longDiagonalValue) {
        areaOutField.setText(decimalFormat.format((shortDiagonalValue*longDiagonalValue)/2)+" Unit²");
    }

}