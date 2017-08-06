package dev.SimpSimpHotlineU.statics;

import java.awt.Graphics;

import dev.SimpSimpHotlineU.Handler;
import dev.SimpSimpHotlineU.gfx.Assets;
import dev.SimpSimpHotlineU.tiles.Tile;

public class Stone extends StaticEntity{

	public Stone(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.height = 32;
		bounds.width = 32;
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.stone, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height,null);
	}
	
	

}
