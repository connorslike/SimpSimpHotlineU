package dev.SimpSimpHotlineU.states;

import java.awt.Graphics;

import dev.SimpSimpHotlineU.Game;
import dev.SimpSimpHotlineU.Handler;

public abstract class State {

	private static State currentState = null;
	
	public  static void setState (State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	
	//Class
	
	protected Handler handler;
	
	protected Game game;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	
	
}
