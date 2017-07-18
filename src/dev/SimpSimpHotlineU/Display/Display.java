package dev.SimpSimpHotlineU.Display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int windowWidth, windowHeight;
	
	public Display(String title, int width, int height){
		
		this.title = title;
		windowWidth = width;
		windowHeight = height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(windowWidth, windowHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(windowWidth,windowHeight));
		canvas.setMaximumSize(new Dimension(windowWidth,windowHeight));
		canvas.setMinimumSize(new Dimension(windowWidth,windowHeight));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
}
