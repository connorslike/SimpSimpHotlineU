package dev.SimpSimpHotlineU.worlds;

import java.awt.Graphics;

import dev.SimpSimpHotlineU.Game;
import dev.SimpSimpHotlineU.Handler;
import dev.SimpSimpHotlineU.entities.EntityManager;
import dev.SimpSimpHotlineU.entities.creatures.Player;
import dev.SimpSimpHotlineU.statics.Stone;
import dev.SimpSimpHotlineU.tiles.Tile;
import dev.SimpSimpHotlineU.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entites
	private EntityManager entityManager;
	
	
	public World(Handler handler,String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler,100,100));
		entityManager.addEntity(new Stone(handler,100,300));
		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void update(){
		entityManager.update();
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x,y).render(g, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		//Entities
		entityManager.render(g);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Tile getTile (int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.wallTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}