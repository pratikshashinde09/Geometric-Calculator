package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;

public class CalculateButton extends JButton {

    CalculateButton() {
        super("Calculate");
        this.setFont(new Font("Poppins medium", Font.PLAIN, 12));
        this.setFocusPainted(false);
        this.setBackground(Color.decode("#2990EF"));
        this.setForeground(Color.white);
    }

}