package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RhombusPanel extends JPanel implements ActionListener {
    FloatTextField longDiagonal;
    FloatTextField shortDiagonal;
    OutputTextField sideOutField;
    OutputTextField perimeterOutField;
    OutputTextField areaOutField;
    OutputTextField heightOutField;
    DecimalFormat decimalFormat =new DecimalFormat("#.#####");

    RhombusPanel() {
        super();
        BodyLabel rhombusHead = new BodyLabel("Rhombus");
        rhombusHead.setBounds(60, 20, 100, 16);
        add(rhombusHead);

        longDiagonal = new FloatTextField("Long diagonal",20);
        longDiagonal.setBounds(60,56,135, longDiagonal.getHeight());
        longDiagonal.setToolTipText("Enter Long diagonal here");
        add(longDiagonal);

        shortDiagonal = new FloatTextField("Short diagonal",20);
        shortDiagonal.setBounds(215,56,135, shortDiagonal.getHeight());
        shortDiagonal.setToolTipText("Enter Short diagonal here");
        add(shortDiagonal);

        CalculateButton rhombusCal = new CalculateButton();
        rhombusCal.setBounds(60, 100, 100, 30);
        rhombusCal.addActionListener(this);
        add(rhombusCal);

        //Area out
        BodyLabel sideLabel = new BodyLabel("Side :");
        sideLabel.setBounds(60, 150, 100, 34);
        sideLabel.setAlignmentY(CENTER_ALIGNMENT);
        add(sideLabel);

        sideOutField = new OutputTextField();
        sideOutField.setBounds(170, 150, sideOutField.getWidth(), sideOutField.getHeight());
        add(sideOutField);

        //Perimeter out
        BodyLabel perimeterLabel = new BodyLabel("Perimeter :");
        perimeterLabel.setBounds(60, 204, 100, 34);
        add(perimeterLabel);

        perimeterOutField = new OutputTextField();
        perimeterOutField.setBounds(170, 204, sideOutField.getWidth(), sideOutField.getHeight());
        add(perimeterOutField);

        //Area out
        BodyLabel areaLabel = new BodyLabel("Area :");
        areaLabel.setBounds(60, 258, 100, 34);
        add(areaLabel);

        areaOutField = new OutputTextField();
        areaOutField.setBounds(170, 258, sideOutField.getWidth(), sideOutField.getHeight());
        add(areaOutField);

        //Height out
        BodyLabel heightLabel = new BodyLabel("Height :");
        heightLabel.setBounds(60, 312, 100, 34);
        add(heightLabel);

        heightOutField = new OutputTextField();
        heightOutField.setBounds(170, 312, sideOutField.getWidth(), sideOutField.getHeight());
        add(heightOutField);

        //Right image
        JLabel picLabel = new JLabel(new ImageIcon("assets/rhombus.png"));
        picLabel.setBounds(460, 100, 128, 100);
        add(picLabel);
        setLayout(null);
        setBounds(0, 80, 696, 448);
        setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent e) {
        if (!longDiagonal.isTextEntered() || !shortDiagonal.isTextEntered()) {
            if (!longDiagonal.isTextEntered() && !shortDiagonal.isTextEntered()) {
                longDiagonal.makeRed();
                shortDiagonal.makeRed();
            }
            else if(!shortDiagonal.isTextEntered()) {
                shortDiagonal.makeRed();
                longDiagonal.makeNormal();
            }
            else {
                longDiagonal.makeRed();
                shortDiagonal.makeNormal();
            }
        } else {
            double longDiagonalValue=0;
            double shortDiagonalValue=0;
            try {
                longDiagonalValue = Double.parseDouble(longDiagonal.getText());
                longDiagonal.makeNormal();
                shortDiagonalValue = Double.parseDouble(shortDiagonal.getText());
                shortDiagonal.makeNormal();

                //Calculations
                double side = Math.sqrt((shortDiagonalValue*shortDiagonalValue + (longDiagonalValue*longDiagonalValue))) / 2;
                double area=((shortDiagonalValue*longDiagonalValue)/2);
                double height=  (side*Math.sin(Math.asin(area/(side*side))));

                calcSide(side);
                calcArea(area);
                calcPerimeter(4*side);
                calcHeight(height);
            } catch (Exception ex) {
                if (longDiagonalValue==0) {longDiagonal.makeRed();}
                if (shortDiagonalValue==0 && longDiagonalValue!=0){
                    shortDiagonal.makeRed();}
            }
        }
    }

    public void calcSide(Double side) {
        sideOutField.setText(decimalFormat.format(side) + " Unit");
    }

    public void calcArea(Double area) {
        areaOutField.setText(decimalFormat.format(area) + " Unit²");
    }

    public void calcPerimeter(Double perimeter) {
        perimeterOutField.setText(decimalFormat.format(perimeter) + " Unit");
    }

    public void calcHeight(Double height) {
        heightOutField.setText(decimalFormat.format(height) + " Unit");
    }
}