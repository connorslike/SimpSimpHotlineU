package dev.SimpSimpHotlineU.states;

import java.awt.Graphics;

public abstract class State {

	private static State currentState = null;
	
	public  static void setState (State state){
		currentState = state;
	}
	
	private static State getState(){
		return currentState;
	}
	
	
	//Class
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	
	
}
