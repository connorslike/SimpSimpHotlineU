package dev.SimpSimpHotlineU.states;

import java.awt.Graphics;

import dev.SimpSimpHotlineU.Game;
import dev.SimpSimpHotlineU.Handler;

public class MenuState extends State {

	public MenuState(Handler handler){
		super(handler);
	}
	
	@Override
	public void update() {
		if(handler.getMouseManager().isLeftPressed())
			State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
