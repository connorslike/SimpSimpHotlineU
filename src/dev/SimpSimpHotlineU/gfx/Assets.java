package dev.SimpSimpHotlineU.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 64, height = 64;
	
	public static BufferedImage grass, hero, stone, wall;
	
	//loads every asset into the game
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadimage("/textures/spriteSheet.jpg"));
		
		grass = sheet.crop(0, 0, width, height);
		hero = sheet.crop(width, 0, width, height);
		stone = sheet.crop(2*width, 0, width, height);
		wall = sheet.crop(3*width, 0, width, height);
	}
	
}
