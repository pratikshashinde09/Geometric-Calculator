package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TrianglePanel extends JPanel implements ActionListener {
    FloatTextField HeightInput;
    FloatTextField BaseInput;
    OutputTextField areaOutField;

    DecimalFormat decimalFormat = new DecimalFormat("#.#####");

    TrianglePanel() {
        BodyLabel triangleHead = new BodyLabel("Triangle");
        triangleHead.setBounds(60, 20, 100, 19);
        add(triangleHead);

        HeightInput = new FloatTextField("Height", 20);
        HeightInput.setBounds(60, 56, 135, HeightInput.getHeight());
        HeightInput.setToolTipText("Enter triangle's perpendicular height here");
        add(HeightInput);

        BaseInput = new FloatTextField("Base", 20);
        BaseInput.setBounds(215, 56, 135, BaseInput.getHeight());
        BaseInput.setToolTipText("Enter triangle's base here");
        add(BaseInput);

        CalculateButton rectangleCalBtn = new CalculateButton();
        rectangleCalBtn.setBounds(60, 100, 100, 30);
        rectangleCalBtn.addActionListener(this);
        add(rectangleCalBtn);

        //Area out
        BodyLabel areaLabel = new BodyLabel("Area :");
        areaLabel.setBounds(60, 150, 100, 34);
        areaLabel.setAlignmentY(CENTER_ALIGNMENT);
        add(areaLabel);

        areaOutField = new OutputTextField();
        areaOutField.setBounds(170, 150, areaOutField.getWidth(), areaOutField.getHeight());
        add(areaOutField);


        //Right image
        JLabel picLabel = new JLabel(new ImageIcon("assets/triangle.png"));
        picLabel.setBounds(440, 80, 142, 142);
        add(picLabel);

        setLayout(null);
        setBounds(0, 80, 696, 448);
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!HeightInput.isTextEntered() || !BaseInput.isTextEntered()) {
            FloatTextField[] inputs = {HeightInput, BaseInput};

            for (FloatTextField temp : inputs) {
                if (temp.isTextEntered()) {
                    temp.makeNormal();
                } else {
                    temp.makeRed();
                }
            }
        } else {
            double height = 0;
            double base = 0;
            try {
                height = Double.parseDouble(HeightInput.getText());
                HeightInput.makeNormal();
                base = Double.parseDouble(BaseInput.getText());
                BaseInput.makeNormal();
                calcArea(height, base);
            } catch (Exception ex) {
                if (height == 0) {
                    HeightInput.makeRed();
                }
                if (base == 0 && height != 0) {
                    BaseInput.makeRed();
                }
            }
        }
    }

    public void calcArea(Double height, Double base) {
        areaOutField.setText(decimalFormat.format(base * height * 0.5) + " Unit²");
    }

}