package dev.SimpSimpHotlineU.states;

import dev.SimpSimpHotlineU.entities.creatures.Player;
import dev.SimpSimpHotlineU.gfx.Assets;

import java.awt.Graphics;

public class GameState extends State{

	private Player player;
	
	
	public GameState(){
		player = new Player(100,100);
	}
	
	@Override
	public void update() {
		player.update();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}
}
