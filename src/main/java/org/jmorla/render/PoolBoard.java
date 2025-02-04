package org.jmorla.render;

import java.awt.Graphics2D;

public class PoolBoard extends Entity {

    private TileManager tileManager;
    private Tile[] tiles;

    private int[][] map = new int[][] {
            { 36, 37, 1, 1, 1, 38, 39, 1, 1, 1, 40, 41 },
            { 42, 43, 44, 45, 45, 45, 45, 45, 45, 45, 46, 47 },
            { 6, 49, 50, 51, 51, 51, 51, 51, 51, 51, 52, 17 },
            { 6, 55, 56, 57, 57, 57, 57, 57, 57, 57, 58, 17 },
            { 60, 61, 62, 63, 63, 63, 63, 63, 63, 63, 64, 65 },
            { 66, 67, 33, 33, 33, 68, 69, 33, 33, 33, 70, 71 },
    };

    public PoolBoard() {
        super(0, 0);
        tileManager = new TileManager();
        tiles = tileManager.loadTiles("/sprite2.png");
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics2D g) {
        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[y].length; x++) {
                var tile = tiles[map[y][x]];
                g.drawImage(tile.getImage(), x * GameConstants.TILE_SIZE, y * GameConstants.TILE_SIZE, null);
            }
        }
    }
}
