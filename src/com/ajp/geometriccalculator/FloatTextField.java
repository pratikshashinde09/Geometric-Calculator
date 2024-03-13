package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FloatTextField extends JTextField implements KeyListener, FocusListener {

    String DefaultText;

    FloatTextField(String DefaultText, int columns) {
        super(DefaultText, columns);
        this.DefaultText = DefaultText;
        this.setFont(new Font("Poppins regular", Font.PLAIN, 14));
        this.addKeyListener(this);
        this.addFocusListener(this);
        this.setBounds(0, 0, 200, 34);
        this.setMargin(new Insets(0, 10, 0, 0));
    }

    public double getNumber() {
        return Double.parseDouble(this.getText());
    }

    public boolean isTextEntered() {
        return !this.getText().equals(DefaultText);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() >= KeyEvent.VK_0 && e.getKeyChar() <= KeyEvent.VK_9 || e.getKeyChar() == KeyEvent.VK_PERIOD) {
        } else {
            e.setKeyChar('\0');
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().equals(DefaultText)) {
            this.setText("");
            makeNormal();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            this.setText(DefaultText);
        }
    }

    public void makeRed() {
        this.setBackground(Color.decode("#FA5858"));
        this.setForeground(Color.decode("#FFFFFF"));
    }

    public void makeNormal() {
        this.setBackground(Color.white);
        this.setForeground(Color.BLACK);
    }

}