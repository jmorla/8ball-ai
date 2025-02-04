package org.jmorla.render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    
    private final Thread thread;
    private Player player;

    public GamePanel() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT));
        this.setDoubleBuffered(true);

        this.thread = new Thread(this);
        player = new Player();
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        double refreshRate = 1000.0 / GameConstants.FPS;
        long lastTime = System.currentTimeMillis();
        double delta = 0;
        long currentTime;

        while (true) {
            currentTime = System.currentTimeMillis();
            delta += (currentTime - lastTime) / refreshRate;
            lastTime = currentTime;

            if (delta >= 1) {
                System.out.println("Hello world");
                update();
                repaint();
                delta--;
            }
        }
    }
    
    private void update() {
        player.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2 = (Graphics2D) g;
        player.render(g2);
        g2.dispose();
    }
    

    
}
