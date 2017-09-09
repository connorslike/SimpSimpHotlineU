package dev.SimpSimpHotlineU.states;

import java.awt.Graphics;

import dev.SimpSimpHotlineU.Handler;
import dev.SimpSimpHotlineU.gfx.Assets;
import dev.SimpSimpHotlineU.ui.ClickListener;
import dev.SimpSimpHotlineU.ui.UIImageButton;
import dev.SimpSimpHotlineU.ui.UIManager;

public class StartMenuState extends State {
	private UIManager uiManager;
	
	public StartMenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(400, 300, 128, 64, Assets.btn_start, new ClickListener(){
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}}));
	}
	
	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
