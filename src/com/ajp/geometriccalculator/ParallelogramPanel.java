package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ParallelogramPanel extends JPanel implements ActionListener {
    FloatTextField LengthInput;
    FloatTextField BreadthInput;
    OutputTextField areaOutField;

    DecimalFormat decimalFormat=new DecimalFormat("#.#####");

    ParallelogramPanel() {
        BodyLabel parallelogramHead = new BodyLabel("Parallelogram");
        parallelogramHead.setBounds(60,20,150,19);
        add(parallelogramHead);

        LengthInput = new FloatTextField("Length",20);
        LengthInput.setBounds(60,56,135, LengthInput.getHeight());
        LengthInput.setToolTipText("Enter Parallelogram length here");
        add(LengthInput);

        BreadthInput = new FloatTextField("Breadth",20);
        BreadthInput.setBounds(215,56,135, BreadthInput.getHeight());
        BreadthInput.setToolTipText("Enter Parallelogram breadth here");
        add(BreadthInput);

        CalculateButton parallelogramCalBtn = new CalculateButton();
        parallelogramCalBtn.setBounds(60,100,100,30);
        parallelogramCalBtn.addActionListener(this);
        add(parallelogramCalBtn);

        //Area out
        BodyLabel areaLabel = new BodyLabel("Area :");
        areaLabel.setBounds(60,150,100,34);
        areaLabel.setAlignmentY(CENTER_ALIGNMENT);
        add(areaLabel);

        areaOutField = new OutputTextField();
        areaOutField.setBounds(170,150,areaOutField.getWidth(),areaOutField.getHeight());
        add(areaOutField);


        //Right image
        JLabel picLabel = new JLabel(new ImageIcon("assets/pargram.png"));
        picLabel.setBounds(420, 100, 218, 100);
        add(picLabel);

        setLayout(null);
        setBounds(0,80,696,448);
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!LengthInput.isTextEntered() || !BreadthInput.isTextEntered()) {
            if (!LengthInput.isTextEntered() && !BreadthInput.isTextEntered()) {
                LengthInput.makeRed();
                BreadthInput.makeRed();
            }
            else if(!BreadthInput.isTextEntered()) {
                BreadthInput.makeRed();
                LengthInput.makeNormal();
            }
            else {
                LengthInput.makeRed();
                BreadthInput.makeNormal();
            }
        } else {
            double length=0;
            double breadth=0;
            try {
                length = Double.parseDouble(LengthInput.getText());
                LengthInput.makeNormal();
                breadth = Double.parseDouble(BreadthInput.getText());
                BreadthInput.makeNormal();
                calcArea(length,breadth);
            } catch (Exception ex) {
                if (length==0) {LengthInput.makeRed();}
                if (breadth==0 && length!=0){BreadthInput.makeRed();}
            }
        }
    }

    public void calcArea(Double length,Double breadth) {
        areaOutField.setText(decimalFormat.format(length*breadth)+" Unit²");
    }

}