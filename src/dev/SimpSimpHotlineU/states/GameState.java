package dev.SimpSimpHotlineU.states;

import dev.SimpSimpHotlineU.Game;
import dev.SimpSimpHotlineU.entities.creatures.Player;
import dev.SimpSimpHotlineU.gfx.Assets;
import dev.SimpSimpHotlineU.tiles.Tile;

import java.awt.Graphics;

public class GameState extends State{

	private Player player;
	
	
	public GameState(Game game){
		super (game);
		player = new Player(game, 100,100);
	}
	
	@Override
	public void update() {
		player.update();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
		Tile.tiles[0].render(g,10,10);
	}
}
