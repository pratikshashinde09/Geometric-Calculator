package com.ajp.geometriccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DashboardScreen extends JPanel implements ItemListener {

    JComboBox<String> shapesComboBox;
    JPanel[] shapesCollection = {new SquarePanel(), new RectanglePanel(), new RhombusPanel(), new ParallelogramPanel(),new TrapeziumPanel(), new CirclePanel(), new TrianglePanel(), new KitePanel(), new PentagonPanel()};

    DashboardScreen() {
        //Top permanent panel------------------
        JPanel topBarPanel = new JPanel();
        topBarPanel.setLayout(null);
        topBarPanel.setBackground(Color.decode("#F3F3F3"));
        topBarPanel.setBounds(0, 0, 696, 80);

        HeaderLabelSemibold gCalHeader = new HeaderLabelSemibold("Geometric Calculator");
        gCalHeader.setBounds(30, 20, 300, 40);
        topBarPanel.add(gCalHeader);

        BodyLabel selectShapeLabel = new BodyLabel("Select shape");
        selectShapeLabel.setBounds(360, 20, 300, 40);
        topBarPanel.add(selectShapeLabel);

        //ComboBox
        String[] shapesList = {"Square", "Rectangle", "Rhombus", "Parallelogram", "Trapezium", "Circle", "Triangle","Kite","Pentagon"};
        shapesComboBox = new JComboBox<>(shapesList);
        shapesComboBox.setBounds(480, 25, 120, 30);
        shapesComboBox.setFont(new Font("Poppins regular", Font.PLAIN, 12));
        shapesComboBox.setToolTipText("Select shape here");
        shapesComboBox.addItemListener(this);
        shapesComboBox.setMaximumRowCount(9);
        shapesComboBox.setFocusable(false);
        topBarPanel.add(shapesComboBox);

        //Adding panels and hiding visibility
        for (var shape : shapesCollection) {
            add(shape);
            shape.setVisible(false);
        }
        shapesCollection[0].setVisible(true);

        //DashboardScreen Properties
        add(topBarPanel);
        setLayout(null);
        setBounds(0, 0, 696, 528);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        shapePanelsHandler(shapesComboBox.getSelectedIndex());
    }

    private void shapePanelsHandler(int shapeIndex) {
        //Hide visible panels
        for (var shape : shapesCollection) {
            shape.setVisible(false);
        }
        try {
            shapesCollection[shapeIndex].setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}