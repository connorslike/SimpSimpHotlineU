package dev.SimpSimpHotlineU.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 64, height = 64;
	
	public static BufferedImage grass, stone, wall;
	public static BufferedImage[] hero_down, hero_up, hero_left, hero_right;
	
	
	//loads every asset into the game
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadimage("/textures/spriteSheet.png"));
		
		hero_down = new BufferedImage[9];
		hero_left = new BufferedImage[9];
		hero_right = new BufferedImage[9];
		hero_up = new BufferedImage[9];
		
		//Hero movement
		//hero_down[0] = sheet.crop(width * 4, height * 2, width, height);
		for(int i = 0; i < 9; i++){
			hero_up[i] = sheet.crop(width * i, 0, width, height);
		}
		for(int i = 0; i < 9; i++){
			hero_left[i] = sheet.crop(width * i, height, width, height);
		}
		for(int i = 0; i < 9; i++){
			hero_down[i] = sheet.crop(width * i, height*2, width, height);
		}
		for(int i = 0; i < 9; i++){
			hero_right[i] = sheet.crop(width * i, height*3, width, height);
		}
		
		grass = sheet.crop(0, 0, width, height);
		stone = sheet.crop(2*width, 0, width, height);
		wall = sheet.crop(3*width, 0, width, height);
	}
	
}
