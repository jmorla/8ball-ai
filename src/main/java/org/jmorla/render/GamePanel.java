package org.jmorla.render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    
    private final Thread thread;
    private PoolBoard map;
    private Ball ball;

    public GamePanel() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT));
        this.setDoubleBuffered(true);

        this.thread = new Thread(this);
        map = new PoolBoard();
        ball = new Ball(10);


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
                update();
                repaint();
                delta--;
            }
        }
    }
    
    private void update() {
        map.update();
        ball.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2 = (Graphics2D) g;
        map.render(g2);
        ball.render(g2);
        g2.dispose();
    }
    

    
}
