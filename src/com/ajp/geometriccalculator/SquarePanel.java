package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class SquarePanel extends JPanel implements ActionListener {
    FloatTextField squareSide;
    OutputTextField areaOutField;
    OutputTextField perimeterOutField;
    OutputTextField diagonalOutField;
    DecimalFormat decimalFormat =new DecimalFormat("#.#####");

    SquarePanel() {
        super();
        BodyLabel squareHead = new BodyLabel("Square");
        squareHead.setBounds(60, 20, 100, 16);
        add(squareHead);

        squareSide = new FloatTextField("Side", 40);
        squareSide.setBounds(60, 56, 290, squareSide.getHeight());
        squareSide.setToolTipText("Enter square side here");
        add(squareSide);

        CalculateButton squareCalBtn = new CalculateButton();
        squareCalBtn.setBounds(60, 100, 100, 30);
        squareCalBtn.addActionListener(this);
        add(squareCalBtn);

        //Area out
        BodyLabel areaLabel = new BodyLabel("Area :");
        areaLabel.setBounds(60, 150, 100, 34);
        areaLabel.setAlignmentY(CENTER_ALIGNMENT);
        add(areaLabel);

        areaOutField = new OutputTextField();
        areaOutField.setBounds(170, 150, areaOutField.getWidth(), areaOutField.getHeight());
        add(areaOutField);

        //Perimeter out
        BodyLabel perimeterLabel = new BodyLabel("Perimeter :");
        perimeterLabel.setBounds(60, 204, 100, 34);
        add(perimeterLabel);

        perimeterOutField = new OutputTextField();
        perimeterOutField.setBounds(170, 204, areaOutField.getWidth(), areaOutField.getHeight());
        add(perimeterOutField);

        //Diagonal out
        BodyLabel diagonalLabel = new BodyLabel("Diagonal :");
        diagonalLabel.setBounds(60, 258, 100, 34);
        add(diagonalLabel);

        diagonalOutField = new OutputTextField();
        diagonalOutField.setBounds(170, 258, areaOutField.getWidth(), areaOutField.getHeight());
        add(diagonalOutField);

        //Right image
        JLabel picLabel = new JLabel(new ImageIcon("assets/square.png"));
        picLabel.setBounds(460, 100, 100, 100);
        add(picLabel);
        setLayout(null);
        setBounds(0, 80, 696, 448);
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!squareSide.isTextEntered()) {
            squareSide.makeRed();
        } else {
            double side;
            try {
                side = Double.parseDouble(squareSide.getText());
                squareSide.makeNormal();
                calcArea(side);
                calcPerimeter(side);
                calcDiagonal(side);
            } catch (Exception ex) {
                squareSide.makeRed();
            }
        }
    }

    public void calcArea(Double side) {
        areaOutField.setText(decimalFormat.format(side * side) + " Unit²");
    }

    public void calcPerimeter(Double side) {
        perimeterOutField.setText(decimalFormat.format(4 * side) + " Units");
    }

    public void calcDiagonal(Double side) {
        diagonalOutField.setText(decimalFormat.format(side * 1.412) + " Units");
    }
}