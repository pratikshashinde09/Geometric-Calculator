package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;

public class BodyLabel extends JLabel {
    BodyLabel(String text) {
        super(text);
        this.setFont(new Font("Poppins regular", Font.PLAIN, 16));
    }
}