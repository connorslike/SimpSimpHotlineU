package dev.SimpSimpHotlineU.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 70, height = 70;
	
	public static BufferedImage grass, hero, stone, wall;
	
	//loads every asset into the game
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadimage("/textures/spriteSheet.jpg"));
		
		grass = sheet.crop(0, height, width, height);
		hero = sheet.crop(width, height, width, height);
		stone = sheet.crop(2*width, height, width, height);
		wall = sheet.crop(3*width, height, width, height);
	}
	
}
