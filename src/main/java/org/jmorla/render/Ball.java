package org.jmorla.render;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Entity {
    private Tile tiles;

    public Ball(int radius) {
        super(70, 35);
        TileManager tileManager = new TileManager();
        tiles = tileManager.loadTile("/wball.png");
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawImage(tiles.getImage(), x, y, null);
    }
    
}
