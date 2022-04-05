package io.github.sy3c4ll.tetrikk.engine;
import io.github.sy3c4ll.tetrikk.parts.Rules;
import io.github.sy3c4ll.tetrikk.parts.Tetromino;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrikkEngine implements ActionListener,Rules{
	final private TetrikkBoard board;
	private boolean paused;
	public TetrikkEngine(){
		board=new TetrikkBoard();
		paused=false;
		new Timer(INTERVAL,this).start();
	}
	public void display(Graphics g){
		board.display(g);
		if(!board.running()){
			g.setColor(Color.WHITE);
			g.setFont(new Font("Monospaced",Font.BOLD,48));
			g.drawString("GAME",100,275);
			g.drawString("OVER",100,325);
		}else if(paused){
			g.setColor(Color.WHITE);
			g.setFont(new Font("Monospaced",Font.BOLD,48));
			g.drawString("GAME",100,275);
			g.drawString("PAUSED",70,325);
		}
	}
	public void createKeyBindings(TetrikkScreen screen){
		InputMap im=screen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am=screen.getActionMap();
		im.put(KeyStroke.getKeyStroke("DOWN"),Command.SOFT_DROP);
		im.put(KeyStroke.getKeyStroke("SPACE"),Command.HARD_DROP);
		im.put(KeyStroke.getKeyStroke("LEFT"),Command.MOVE_LEFT);
		im.put(KeyStroke.getKeyStroke("RIGHT"),Command.MOVE_RIGHT);
		im.put(KeyStroke.getKeyStroke("Z"),Command.ROTATE_LEFT);
		im.put(KeyStroke.getKeyStroke("ctrl CONTROL"),Command.ROTATE_LEFT);
		im.put(KeyStroke.getKeyStroke("X"),Command.ROTATE_RIGHT);
		im.put(KeyStroke.getKeyStroke("UP"),Command.ROTATE_RIGHT);
		im.put(KeyStroke.getKeyStroke("C"),Command.HOLD);
		im.put(KeyStroke.getKeyStroke("SHIFT"),Command.HOLD);
		im.put(KeyStroke.getKeyStroke("ESCAPE"),Command.PAUSE);
		am.put(Command.SOFT_DROP,new TetrisAction(this,Command.SOFT_DROP));
		am.put(Command.HARD_DROP,new TetrisAction(this,Command.HARD_DROP));
		am.put(Command.MOVE_LEFT,new TetrisAction(this,Command.MOVE_LEFT));
		am.put(Command.MOVE_RIGHT,new TetrisAction(this,Command.MOVE_RIGHT));
		am.put(Command.ROTATE_LEFT,new TetrisAction(this,Command.ROTATE_LEFT));
		am.put(Command.ROTATE_RIGHT,new TetrisAction(this,Command.ROTATE_RIGHT));
		am.put(Command.HOLD,new TetrisAction(this,Command.HOLD));
		am.put(Command.PAUSE,new TetrisAction(this,Command.PAUSE));
	}
	public enum Command{SOFT_DROP,HARD_DROP,MOVE_LEFT,MOVE_RIGHT,ROTATE_LEFT,ROTATE_RIGHT,HOLD,PAUSE}
	private static class TetrisAction extends AbstractAction{
		final private TetrikkEngine engine;
		final private Command cmd;
		public TetrisAction(TetrikkEngine e, Command c){
			engine=e;
			cmd=c;
		}
		@Override public void actionPerformed(ActionEvent actionEvent) {
			switch(cmd){
				case SOFT_DROP:engine.board.soft_drop();break;
				case HARD_DROP:engine.board.hard_drop();break;
				case MOVE_LEFT:engine.board.move(-1);break;
				case MOVE_RIGHT:engine.board.move(1);break;
				case ROTATE_LEFT:engine.board.rotate(-1);break;
				case ROTATE_RIGHT:engine.board.rotate(1);break;
				case HOLD:engine.board.hold();break;
				case PAUSE:engine.paused=!engine.paused;break;
			}
		}
	}
	@Override public void actionPerformed(ActionEvent event){
		if(board.running()&&!paused){
			if(board.pieceExists())board.soft_drop();
			else board.spawn(Tetromino.values()[RANDOM.nextInt(Tetromino.values().length-1)+1]);
		}
	}
}
