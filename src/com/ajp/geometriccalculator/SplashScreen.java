package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SplashScreen extends JPanel implements ActionListener {

    SplashScreen() throws IOException {
        //Two child panels for left and right view of splash panel

        //All about topSplash----------------------------------------------------------------------------
        HeaderLabel gCalHeader = new HeaderLabel("Geometric");
        gCalHeader.setBounds(80, 120, 348, 100);
        gCalHeader.setAlignmentX(CENTER_ALIGNMENT);
        gCalHeader.setForeground(Color.white);
        gCalHeader.setFont(new Font("Poppins bold", Font.PLAIN, 56));
        HeaderLabel gCalHeader2 = new HeaderLabel("Calculator");

        gCalHeader2.setBounds(80, 170, 348, 100);
        gCalHeader2.setAlignmentX(CENTER_ALIGNMENT);
        gCalHeader2.setForeground(Color.decode("#B2B2B2"));
        gCalHeader2.setFont(new Font("Poppins medium", Font.PLAIN, 36));

        JButton btnLetsCal = new JButton("Let's Calculate");
        btnLetsCal.addActionListener(this);
        btnLetsCal.setFocusPainted(false);
        btnLetsCal.setToolTipText("Click here to start calculating");
        btnLetsCal.setBounds(80, 270, 140, 38);
        btnLetsCal.setFont(new Font("Poppins medium", Font.PLAIN, 14));
        btnLetsCal.setBackground(Color.WHITE);

        add(gCalHeader);
        add(gCalHeader2);
        add(btnLetsCal);

        JLabel picLabel = new JLabel(new ImageIcon("assets/splash2.png"));
        picLabel.setBounds(0, 0, 696, 528);
        add(picLabel);

        //SplashPanel properties---------------------------------------------------------------------------
        setLayout(null);
        setBackground(Color.blue);
        setBounds(0, 0, 696, 528);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InitialViewManager.hideSplashShowDashboard();
    }
}