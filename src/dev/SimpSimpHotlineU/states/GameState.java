package dev.SimpSimpHotlineU.states;

import dev.SimpSimpHotlineU.Game;
import dev.SimpSimpHotlineU.Handler;
import dev.SimpSimpHotlineU.entities.creatures.Player;
import dev.SimpSimpHotlineU.gfx.Assets;
import dev.SimpSimpHotlineU.statics.Stone;
import dev.SimpSimpHotlineU.tiles.Tile;
import dev.SimpSimpHotlineU.worlds.World;

import java.awt.Graphics;

public class GameState extends State{

	private World world;
	
	public GameState(Handler handler){
		super (handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void update() {
		world.update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
}
