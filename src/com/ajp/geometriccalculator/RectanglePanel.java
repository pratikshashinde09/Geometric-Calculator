package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RectanglePanel extends JPanel implements ActionListener {
    FloatTextField LengthInput;
    FloatTextField BreadthInput;
    OutputTextField areaOutField;
    OutputTextField perimeterOutField;
    OutputTextField diagonalOutField;
    DecimalFormat decimalFormat=new DecimalFormat("#.#####");

    RectanglePanel() {
        BodyLabel rectangleHead = new BodyLabel("Rectangle");
        rectangleHead.setBounds(60,20,100,19);
        add(rectangleHead);

        LengthInput = new FloatTextField("Length",20);
        LengthInput.setBounds(60,56,135, LengthInput.getHeight());
        LengthInput.setToolTipText("Enter rectangle length here");
        add(LengthInput);

        BreadthInput = new FloatTextField("Breadth",20);
        BreadthInput.setBounds(215,56,135, BreadthInput.getHeight());
        BreadthInput.setToolTipText("Enter rectangle breadth here");
        add(BreadthInput);

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

        //Perimeter out
        BodyLabel perimeterLabel = new BodyLabel("Perimeter :");
        perimeterLabel.setBounds(60,204,100,34);
        add(perimeterLabel);

        perimeterOutField = new OutputTextField();
        perimeterOutField.setBounds(170,204,areaOutField.getWidth(),areaOutField.getHeight());
        add(perimeterOutField);

        //Diagonal out
        BodyLabel diagonalLabel = new BodyLabel("Diagonal :");
        diagonalLabel.setBounds(60,258,100,34);
        add(diagonalLabel);

        diagonalOutField = new OutputTextField();
        diagonalOutField.setBounds(170,258,areaOutField.getWidth(),areaOutField.getHeight());
        add(diagonalOutField);

        //Right image
        JLabel picLabel = new JLabel(new ImageIcon("assets/rectangle.png"));
        picLabel.setBounds(420, 100, 188, 100);
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
                calcPerimeter(length,breadth);
                calcDiagonal(length,breadth);
            } catch (Exception ex) {
                if (length==0) {LengthInput.makeRed();}
                if (breadth==0 && length!=0){BreadthInput.makeRed();}
            }
        }
    }

    public void calcArea(Double length,Double breadth) {
        areaOutField.setText(decimalFormat.format(length*breadth)+" Unit²");
    }

    public void calcPerimeter(Double length,Double breadth) {
        perimeterOutField.setText(decimalFormat.format(2*(length+breadth))+" Units");
    }

    public void calcDiagonal(Double length,Double breadth) {
        diagonalOutField.setText(decimalFormat.format(Math.sqrt((length*length)+(breadth*breadth)))+" Units");
    }
}