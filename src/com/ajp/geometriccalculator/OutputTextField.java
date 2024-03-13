package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;

public class OutputTextField extends JTextField {
    OutputTextField() {
        this.setFont(new Font("Poppins regular", Font.PLAIN, 14));
        this.setBounds(0, 0, 180, 34);
        this.setEditable(false);
        this.setMargin(new Insets(0, 10, 0, 0));
    }
}