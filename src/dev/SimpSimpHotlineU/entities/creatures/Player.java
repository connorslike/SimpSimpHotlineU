package dev.SimpSimpHotlineU.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.SimpSimpHotlineU.Game;
import dev.SimpSimpHotlineU.Handler;
import dev.SimpSimpHotlineU.gfx.Animation;
import dev.SimpSimpHotlineU.gfx.Assets;

public class Player extends Creature{
	
	private Animation moveDown, moveUp, moveLeft, moveRight, moveStatic;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 64;
		bounds.height = 64;
		
		//Animations
		moveDown = new Animation(200, Assets.hero_down);
		moveUp = new Animation(200, Assets.hero_up);
		moveLeft = new Animation(200, Assets.hero_left);
		moveRight = new Animation(200, Assets.hero_right);
		moveStatic = new Animation(200, Assets.hero_static);
	}

	@Override
	public void update() {
		//Animation
		moveDown.update();
		moveUp.update();
		moveLeft.update();
		moveRight.update();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);]
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0){
			return moveLeft.getCurrentFrame();
		}else if(xMove > 0){
			return moveRight.getCurrentFrame();
		}else if(yMove < 0){
			return moveUp.getCurrentFrame();
		}else if(yMove > 0){
			return moveDown.getCurrentFrame();
		}else {
			return moveStatic.getCurrentFrame();
		}
	}

}
