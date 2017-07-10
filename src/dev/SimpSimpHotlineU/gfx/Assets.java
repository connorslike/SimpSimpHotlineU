package dev.SimpSimpHotlineU.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 41, height = 50;
	
	public static BufferedImage player, tree, grass, stone;
	
	//loads every asset into the game
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadimage("/textures/basic_sprite.jpg"));
		
		player = sheet.crop(0, height, width, height);
		tree = sheet.crop(width, height, width, height);
		grass = sheet.crop(2*width, height, width, height);
		stone = sheet.crop(3*width, height, width, height);
	}
	
}
