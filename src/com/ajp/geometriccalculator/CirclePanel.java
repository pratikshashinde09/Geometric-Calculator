package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CirclePanel extends JPanel implements ActionListener {
    FloatTextField circleRadius;
    OutputTextField areaOutField;
    OutputTextField perimeterOutField;
    OutputTextField diameterOutField;
    DecimalFormat decimalFormat =new DecimalFormat("#.#####");

    CirclePanel() {
        super();
        BodyLabel squareHead = new BodyLabel("Circle");
        squareHead.setBounds(60, 20, 100, 16);
        add(squareHead);

        circleRadius = new FloatTextField("Radius", 40);
        circleRadius.setBounds(60, 56, 290, circleRadius.getHeight());
        circleRadius.setToolTipText("Enter circle radius here");
        add(circleRadius);

        CalculateButton circleCalBtn = new CalculateButton();
        circleCalBtn.setBounds(60, 100, 100, 30);
        circleCalBtn.addActionListener(this);
        add(circleCalBtn);

        //Area out
        BodyLabel areaLabel = new BodyLabel("Area :");
        areaLabel.setBounds(60, 150, 100, 34);
        areaLabel.setAlignmentY(CENTER_ALIGNMENT);
        add(areaLabel);

        areaOutField = new OutputTextField();
        areaOutField.setBounds(170, 150, areaOutField.getWidth(), areaOutField.getHeight());
        add(areaOutField);

        //Circumference out
        BodyLabel perimeterLabel = new BodyLabel("Perimeter :");
        perimeterLabel.setBounds(60, 204, 100, 34);
        add(perimeterLabel);

        perimeterOutField = new OutputTextField();
        perimeterOutField.setBounds(170, 204, areaOutField.getWidth(), areaOutField.getHeight());
        add(perimeterOutField);

        //Diagonal out
        BodyLabel diameterLabel = new BodyLabel("Diameter :");
        diameterLabel.setBounds(60, 258, 100, 34);
        add(diameterLabel);

        diameterOutField = new OutputTextField();
        diameterOutField.setBounds(170, 258, areaOutField.getWidth(), areaOutField.getHeight());
        add(diameterOutField);

        //Right image
        JLabel picLabel = new JLabel(new ImageIcon("assets/circle.png"));
        picLabel.setBounds(460, 100, 100, 100);
        add(picLabel);
        setLayout(null);
        setBounds(0, 80, 696, 448);
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!circleRadius.isTextEntered()) {
            circleRadius.makeRed();
        } else {
            double radius;
            try {
                radius = Double.parseDouble(circleRadius.getText());
                circleRadius.makeNormal();
                calcArea(radius);
                calcPerimeter(radius);
                calcDiameter(radius);
            } catch (Exception ex) {
                circleRadius.makeRed();
            }
        }
    }

    public void calcArea(Double radius) {
        areaOutField.setText(decimalFormat.format(3.14*radius*radius) + " Unit²");
    }

    public void calcPerimeter(Double radius) {
        perimeterOutField.setText(decimalFormat.format(2*3.14*radius) + " Units");
    }

    public void calcDiameter(Double radius) {
        diameterOutField.setText(decimalFormat.format(2*radius) + " Units");
    }
}