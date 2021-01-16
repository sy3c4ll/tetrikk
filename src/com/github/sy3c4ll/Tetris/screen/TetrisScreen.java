package com.github.sy3c4ll.Tetris.screen;
import com.github.sy3c4ll.Tetris.engine.TetrisEngine;
import com.github.sy3c4ll.Tetris.parts.Rules;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.Graphics;
public class TetrisScreen extends JPanel implements Rules{
	private static final long serialVersionUID=-8117396660156707780L;
	private TetrisEngine engine;
	public TetrisScreen(TetrisEngine controllerEngine){
		engine=controllerEngine;
		this.addKeyListener(controllerEngine);
	}
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		engine.paintBoard();
	}
	public void addPaneltoFrame(Container container){
		container.add(this);
	}
	public TetrisEngine getEngine(){
		return this.engine;
	}
	public TetrisScreen setEngine(TetrisEngine controllerEngine){
		this.engine=controllerEngine;
		this.addKeyListener(this.engine);
		return this;
	}
}
