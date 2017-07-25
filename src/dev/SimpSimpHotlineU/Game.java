package dev.SimpSimpHotlineU;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import dev.SimpSimpHotlineU.Display.Display;
import dev.SimpSimpHotlineU.gfx.Assets;
import dev.SimpSimpHotlineU.gfx.GameCamera;
import dev.SimpSimpHotlineU.gfx.ImageLoader;
import dev.SimpSimpHotlineU.input.KeyManager;
import dev.SimpSimpHotlineU.states.GameState;
import dev.SimpSimpHotlineU.states.MenuState;
import dev.SimpSimpHotlineU.states.State;

public class Game implements Runnable{
	
	private Display display;
	public String title;
	
	private int windowWidth = 1000;
	private int windowHeight = 800;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	private State gameState;
	private State menuState; 
	
	//input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	public Game(String title){

		this.title = title;
		keyManager = new KeyManager();
			
	}
	
	private void init(){
		
		display = new Display(title,windowWidth, windowHeight);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this,0,0);
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
	}
	
	private void update(){
		keyManager.update();
		
		if(State.getState() != null){
			State.getState().update();
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, windowWidth, windowHeight);
		// drawing
		if(State.getState() != null){
			State.getState().render(g);
		}
		//end drawing
		
		bs.show();
		g.dispose();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return windowWidth;
	}
	
	public int getHeight(){
		return windowHeight;
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
