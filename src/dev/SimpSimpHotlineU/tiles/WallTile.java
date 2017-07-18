package dev.SimpSimpHotlineU.tiles;

import java.awt.image.BufferedImage;

import dev.SimpSimpHotlineU.gfx.Assets;

public class WallTile extends Tile{

	public WallTile(int id) {
		super(Assets.stone, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSolid(){
		return true;
	}
	
}
