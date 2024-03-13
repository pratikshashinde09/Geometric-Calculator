package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class PentagonPanel extends JPanel implements ActionListener {
    FloatTextField pentagonSide;
    OutputTextField areaOutField;
    OutputTextField perimeterOutField;

    DecimalFormat decimalFormat =new DecimalFormat("#.#####");

    PentagonPanel() {
        super();
        BodyLabel pentagonHead = new BodyLabel("Regular Pentagon");
        pentagonHead.setBounds(60, 20, 150, 19);
        add(pentagonHead);

        pentagonSide = new FloatTextField("Side", 40);
        pentagonSide.setBounds(60, 56, 290, pentagonSide.getHeight());
        pentagonSide.setToolTipText("Enter pentagon side here");
        add(pentagonSide);

        CalculateButton pentagonCal = new CalculateButton();
        pentagonCal.setBounds(60, 100, 100, 30);
        pentagonCal.addActionListener(this);
        add(pentagonCal);

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


        //Right image
        JLabel picLabel = new JLabel(new ImageIcon("assets/pentagon.png"));
        picLabel.setBounds(440, 80, 153, 153);
        add(picLabel);
        setLayout(null);
        setBounds(0, 80, 696, 448);
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!pentagonSide.isTextEntered()) {
            pentagonSide.makeRed();
        } else {
            double side;
            try {
                side = Double.parseDouble(pentagonSide.getText());
                pentagonSide.makeNormal();
                calcArea(side);
                calcPerimeter(side);
            } catch (Exception ex) {
                pentagonSide.makeRed();
            }
        }
    }

    public void calcArea(Double side) {
        areaOutField.setText(decimalFormat.format(0.25*6.881*side*side) + " Unit²");
    }

    public void calcPerimeter(Double side) {
        perimeterOutField.setText(decimalFormat.format(5 * side) + " Unit");
    }


}