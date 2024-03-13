package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class InitialViewManager extends JFrame {

    //Panels
    static SplashScreen splashScreen;
    static DashboardScreen dashboardScreen;

    //Caught exception for ImageIO in splashScreen
    static {
        try {
            splashScreen = new SplashScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    InitialViewManager() {
        super("Geometric Calculator");
        //Added SplashScreen First
        add(splashScreen);
        //Added Dashboard behind the SplashScreen
        dashboardScreen = new DashboardScreen();
        dashboardScreen.setVisible(false);
        add(dashboardScreen);

        //Add windows listener using adapter class
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                System.exit(-1);
            }
        });

        setSize(696, 528);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new InitialViewManager();
    }

    public static void hideSplashShowDashboard() {
        dashboardScreen.setVisible(true);
        splashScreen.setVisible(false);
        splashScreen = null;
        System.gc();
    }

}