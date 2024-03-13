package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;

public class HeaderLabelSemibold extends JLabel {
    HeaderLabelSemibold(String text) {
        super(text);
        this.setFont(new Font("Poppins semibold", Font.PLAIN, 26));
    }
}