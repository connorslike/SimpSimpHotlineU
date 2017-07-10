package dev.SimpSimpHotlineU.states;

import java.awt.Graphics;

import dev.SimpSimpHotlineU.gfx.Assets;

public class GameState extends State{

	public GameState(){
		
	}
	
	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.grass, 0, 0, null);
	}

}
