package dev.SimpSimpHotlineU.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.SimpSimpHotlineU.Game;
import dev.SimpSimpHotlineU.Handler;
import dev.SimpSimpHotlineU.entities.Entity;
import dev.SimpSimpHotlineU.gfx.Animation;
import dev.SimpSimpHotlineU.gfx.Assets;

public class Player extends Creature{
	
	//animations
	private Animation moveDown, moveUp, moveLeft, moveRight, moveStatic;
	
	//interact cooldown
	private long lastInteractTimer, interactCooldown = 800, interactTimer = interactCooldown;
	
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
		//interact
		checkInteract();
	}
	
	private void checkInteract(){
		interactTimer += System.currentTimeMillis() - lastInteractTimer;
		lastInteractTimer = System.currentTimeMillis();
		if(interactTimer < interactCooldown)
			return;
		
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().interact){
			if(handler.getKeyManager().up){
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y - arSize;
			}
			else if(handler.getKeyManager().down){
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y + cb.height;
			}
			else if(handler.getKeyManager().left){
				ar.x = cb.x - arSize ;
				ar.y = cb.y + cb.height / 2 - arSize / 2;
			}
			else if(handler.getKeyManager().right){
				ar.x = cb.x + cb.width ;
				ar.y = cb.y + cb.height / 2 - arSize / 2;
			}
			else {
				return;
			}
			
			interactTimer = 0;
			
			for(Entity e : handler.getWorld().getEntityManager().getEntities()){
				if(e.equals(this))
					continue;
				if(e.getCollisionBounds(0, 0).intersects(ar)){
					e.hurt(1);
					return;
				}
			}
		}
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
	
	@Override
	public void die(){
		System.out.println("You lose");
	}

}
