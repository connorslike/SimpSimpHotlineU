package dev.SimpSimpHotlineU.entities;

import java.awt.Graphics;

import dev.SimpSimpHotlineU.Game;

public abstract class Entity {
	
	protected Game game;
	protected float x ,y;
	protected int width, height;

	
	public Entity(Game game, float x, float y, int width, int height){
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getEntitiyWidth() {
		return width;
	}

	public void setEntitiyWidth(int width) {
		this.width = width;
	}

	public int getEntityHeight() {
		return height;
	}

	public void setEntityHeight(int height) {
		this.height = height;
	}

	
	public abstract void update();
	
	public abstract void render(Graphics g);
}
