package org.jmorla.render;

public interface GameConstants {
    public static final int DEFAULT_TILE_SIZE = 16;
    public static final int SCALE = 2;

    public static final int TILE_SIZE = DEFAULT_TILE_SIZE * SCALE;
    public static final int MAX_SCREEEN_ROW = 12;
    public static final int MAX_SCREEN_COL = 6;

    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEEN_ROW;
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_COL;

    public static final int FPS = 30;
}
