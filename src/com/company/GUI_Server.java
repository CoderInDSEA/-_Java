package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.WindowEvent;

public class GUI_Server extends JFrame {
    public GUI_Server() {
        super("Lines Drawing Demo");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    public void paint(Graphics g) {
        super.paint(g);
    }
}
