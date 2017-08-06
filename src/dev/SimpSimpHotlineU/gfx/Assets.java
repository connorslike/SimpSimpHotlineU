package dev.SimpSimpHotlineU.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 64, height = 64;
	
	public static BufferedImage grass, stone, wall, badGuy;
	public static BufferedImage[] hero_down, hero_up, hero_left, hero_right, hero_static;
	
	
	//loads every asset into the game
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadimage("/textures/spriteSheet.png"));
		SpriteSheet heroSheet = new SpriteSheet(ImageLoader.loadimage("/textures/HeroSprite.png"));
		
		hero_down = new BufferedImage[9];
		hero_left = new BufferedImage[9];
		hero_right = new BufferedImage[9];
		hero_up = new BufferedImage[9];
		hero_static = new BufferedImage[1];
		
		//Hero movement
		//hero_down[0] = heroSheet.crop(width * 4, height * 2, width, height);
		for(int i = 0; i < 9; i++){
			hero_up[i] = heroSheet.crop(width * i, 0, width, height);
		}
		for(int i = 0; i < 9; i++){
			hero_left[i] = heroSheet.crop(width * i, height, width, height);
		}
		for(int i = 0; i < 9; i++){
			hero_down[i] = heroSheet.crop(width * i, height*2, width, height);
		}
		for(int i = 0; i < 9; i++){
			hero_right[i] = heroSheet.crop(width * i, height*3, width, height);
		}
		hero_static[0] = heroSheet.crop(0, height * 2, width, height);
		
		grass = sheet.crop(0, 0, width, height);
		badGuy = sheet.crop(width, 0, width, height);
		stone = sheet.crop(2*width, 0, width, height);
		wall = sheet.crop(3*width, 0, width, height);
	}
	
}
