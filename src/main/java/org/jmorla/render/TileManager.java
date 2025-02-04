package org.jmorla.render;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileManager {

    private Tile[] tiles;

    public TileManager() {

    }

    public Tile loadTile(String path) {
        try {
            var image = ImageIO.read(getClass().getResourceAsStream(path));
            return new Tile(image, false);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error loading tile image: " + e.getMessage());
        }
    }
    
    
    public Tile[] loadTiles(String path) {
        try {
            var image = ImageIO.read(getClass().getResourceAsStream(path));
            return loadTiles(image);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error loading tileset image: " + e.getMessage());
        }
    }

    private Tile[] loadTiles(BufferedImage image) {
        int cols = image.getWidth() / GameConstants.TILE_SIZE;
        int rows = image.getHeight() / GameConstants.TILE_SIZE;
        int tilesCount = cols * rows;
        tiles = new Tile[tilesCount];

        int i = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                var subimage = image.getSubimage(x * GameConstants.TILE_SIZE, y * GameConstants.TILE_SIZE,
                        GameConstants.TILE_SIZE, GameConstants.TILE_SIZE);

                tiles[i] = new Tile(subimage, false);
                i++;
            }
        }
        
        return tiles;
    }
}
