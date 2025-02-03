package org.jmorla;

import javax.swing.JFrame;

import org.jmorla.render.GamePanel;

public class App {


    static {
        System.load("/usr/lib/jni/libopencv_java454d.so"); // Load native opencv library at runtime
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("8 Ball Simulator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        var gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setVisible(true);

        gamePanel.start();
    }
}