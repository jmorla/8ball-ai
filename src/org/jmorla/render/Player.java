package org.jmorla.render;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity {

    public Player() {
            super(0, 100);
        }
    
        @Override
    public void update() {
        this.y++;
        this.x++;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.white);
        g.fillOval(x, y, GameConstants.TILE_SIZE, GameConstants.TILE_SIZE);
    }
    
}
