package io.github.sy3c4ll.tetrikk.engine;
import io.github.sy3c4ll.tetrikk.parts.Rules;
import io.github.sy3c4ll.tetrikk.parts.Tetromino;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TetrisEngine implements ActionListener,KeyListener,Rules{
	private TetrisBoard board;
	private boolean running;
	public TetrisEngine(){
		this.board=new TetrisBoard();
		this.running=true;
		new Timer(INTERVAL,this).start();
	}
	public Graphics display(Graphics g){
		this.board.display(g);
		return g;
	}
	@Override public void actionPerformed(ActionEvent event){
		if(this.running){
			if(!board.pieceExists())board.fall();
			else board.spawn(Tetromino.values()[RANDOM.nextInt(Tetromino.values().length-1)+1]);
		}
	}
	@Override public void keyPressed(KeyEvent event){}
	@Override public void keyReleased(KeyEvent event){}
	@Override public void keyTyped(KeyEvent event){
		//handle keyboard input
		//only unicode characters can be accepted- no Shift, Ctrl, Function keys etc
		//TODO
	}
}
