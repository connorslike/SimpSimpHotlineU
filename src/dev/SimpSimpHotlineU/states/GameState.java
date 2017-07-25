package dev.SimpSimpHotlineU.states;

import dev.SimpSimpHotlineU.Game;
import dev.SimpSimpHotlineU.entities.creatures.Player;
import dev.SimpSimpHotlineU.gfx.Assets;
import dev.SimpSimpHotlineU.tiles.Tile;
import dev.SimpSimpHotlineU.worlds.World;

import java.awt.Graphics;

public class GameState extends State{

	private Player player;
	private World world;
	
	public GameState(Game game){
		super (game);
		player = new Player(game, 100,100);
		world = new World(game, "res/worlds/world1.txt");
	}
	
	@Override
	public void update() {
		world.update();
		player.update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}
}
