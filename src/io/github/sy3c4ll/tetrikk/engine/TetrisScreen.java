package io.github.sy3c4ll.tetrikk.engine;
import io.github.sy3c4ll.tetrikk.parts.Rules;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
public class TetrisScreen extends JPanel implements Rules{
	private static final long serialVersionUID=-8117396660156707780L;
	private TetrisEngine engine;
	public TetrisScreen(TetrisEngine eng){
		this.setEngine(eng);
		this.setPreferredSize(DIMENSION);
		new Timer(FRAME_INTERVAL,e->this.repaint()).start();
	}
	public TetrisScreen(){
		new Timer(FRAME_INTERVAL,e->this.repaint()).start();
	}
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		engine.display(g);
	}
	public TetrisEngine getEngine(){
		return this.engine;
	}
	public TetrisScreen setEngine(TetrisEngine eng){
		this.engine=eng;
		this.addKeyListener(eng);
		return this;
	}
}
