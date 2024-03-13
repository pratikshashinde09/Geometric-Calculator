package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TrapeziumPanel extends JPanel implements ActionListener {
    FloatTextField topBase;
    FloatTextField bottomBase;
    FloatTextField height;
    OutputTextField areaOutField;
    DecimalFormat decimalFormat=new DecimalFormat("#.#####");

    TrapeziumPanel() {
        BodyLabel trapeziumHead = new BodyLabel("Trapezium");
        trapeziumHead.setBounds(60,20,100,19);
        add(trapeziumHead);

        topBase = new FloatTextField("Top base",20);
        topBase.setBounds(60,56,135, topBase.getHeight());
        topBase.setToolTipText("Enter trapezium top base here");
        add(topBase);

        bottomBase = new FloatTextField("Bottom base",20);
        bottomBase.setBounds(215,56,135, bottomBase.getHeight());
        bottomBase.setToolTipText("Enter trapezium bottom base here");
        add(bottomBase);

        height = new FloatTextField("Height",20);
        height.setBounds(60,100,135, height.getHeight());
        height.setToolTipText("Enter trapezium height here");
        add(height);

        CalculateButton trapeziumCal = new CalculateButton();
        trapeziumCal.setBounds(215,100,135,30);
        trapeziumCal.addActionListener(this);
        add(trapeziumCal);

        //Area out
        BodyLabel areaLabel = new BodyLabel("Area :");
        areaLabel.setBounds(60,150,100,34);
        areaLabel.setAlignmentY(CENTER_ALIGNMENT);
        add(areaLabel);

        areaOutField = new OutputTextField();
        areaOutField.setBounds(170,150,areaOutField.getWidth(),areaOutField.getHeight());
        add(areaOutField);

        JLabel picLabel = new JLabel(new ImageIcon("assets/trap.png"));
        picLabel.setBounds(420, 100, 188, 100);
        add(picLabel);

        setLayout(null);
        setBounds(0,80,696,448);
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!topBase.isTextEntered() || !bottomBase.isTextEntered() || !height.isTextEntered()) {
            FloatTextField[] inputs = {topBase,bottomBase,height};

            for (FloatTextField temp:inputs) {
                if (temp.isTextEntered()) {
                    temp.makeNormal();
                }
                else {
                    temp.makeRed();
                }
            }
        } else {
            double topBase=0;
            double bottomBase=0;
            double heightVal=0;
            try {
                topBase = Double.parseDouble(this.topBase.getText());
                this.topBase.makeNormal();
                bottomBase = Double.parseDouble(this.bottomBase.getText());
                this.bottomBase.makeNormal();
                heightVal = Double.parseDouble(this.height.getText());
                height.makeNormal();
                calcArea(topBase,bottomBase,heightVal);
            } catch (Exception ex) {
                if (topBase==0) {
                    this.topBase.makeRed();}
                if (bottomBase==0 && topBase!=0){
                    this.bottomBase.makeRed();}
                if (heightVal==0 && bottomBase!=0 && topBase!=0){
                    height.makeRed();}
            }
        }
    }

    public void calcArea(Double topBase,Double bottomBase,Double heightVal) {
        areaOutField.setText(decimalFormat.format((((topBase+bottomBase)/2)*heightVal))+" Unit²");
    }

}