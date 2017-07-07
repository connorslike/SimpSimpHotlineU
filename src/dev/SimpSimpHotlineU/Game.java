package dev.SimpSimpHotlineU;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import dev.SimpSimpHotlineU.Display.Display;
import dev.SimpSimpHotlineU.gfx.ImageLoader;

public class Game implements Runnable{
	
	private Display display;
	public String title;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int windowWidth = screenSize.width;
	private int windowHeight = screenSize.height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title){

		this.title = title;
			
	}
	
	private void init(){
		display = new Display(title);
	}
	
	public void run(){
		
		init();
		
		while(running){
			update();
			render();
		}
		
	}
	
	private void update(){
		
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

		
		//end drawing
		
		bs.show();
		g.dispose();
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
