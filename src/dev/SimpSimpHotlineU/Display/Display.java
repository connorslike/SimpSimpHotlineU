package dev.SimpSimpHotlineU.Display;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	
	private String title;
	private int windowWidth, windowHeight;
	
	public Display(String title){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.title = title;
		windowWidth = screenSize.width;
		windowHeight = screenSize.height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(windowWidth, windowHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
