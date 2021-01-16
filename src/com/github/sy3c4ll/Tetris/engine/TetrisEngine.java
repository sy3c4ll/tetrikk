package com.github.sy3c4ll.Tetris.engine;
import com.github.sy3c4ll.Tetris.parts.Rules;
import com.github.sy3c4ll.Tetris.screen.TetrisScreen;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
public class TetrisEngine implements Runnable,KeyListener,Rules{
	private LinkedList<TetrisScreen> screens;
	private TetrisBoard board;
	public TetrisEngine(){
		this.screens=new LinkedList<>();
		this.board=new TetrisBoard();
		new Thread(this).start();
	}
	@Override public void run(){
		
	}
	public void paintBoard(){
		Graphics g=this.board.display();
	}
	@Override public void keyPressed(KeyEvent event){
		
	}
	@Override public void keyReleased(KeyEvent event){
		
	}
	@Override public void keyTyped(KeyEvent event){
		
	}
	public TetrisScreen[] getScreens(){
		return (TetrisScreen[])this.screens.toArray();
	}
	public TetrisEngine addScreen(TetrisScreen targetScreen){
		this.screens.add(targetScreen.setEngine(this));
		return this;
	}
	public TetrisEngine removeScreen(TetrisScreen targetScreen){
		this.screens.remove(targetScreen.setEngine(null));
		return this;
	}
}
