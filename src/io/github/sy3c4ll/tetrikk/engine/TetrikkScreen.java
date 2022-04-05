package io.github.sy3c4ll.tetrikk.engine;
import io.github.sy3c4ll.tetrikk.parts.Rules;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
public class TetrikkScreen extends JPanel implements Rules{
	private static final long serialVersionUID=-8117396660156707780L;
	private TetrikkEngine engine;
	public TetrikkScreen(TetrikkEngine eng){
		setEngine(eng);
		setPreferredSize(DIMENSION);
		new Timer(FRAME_INTERVAL,e->repaint()).start();
	}
	public TetrikkScreen(){
		new Timer(FRAME_INTERVAL,e->repaint()).start();
	}
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		engine.display(g);
	}
	public TetrikkEngine getEngine(){
		return engine;
	}
	public void setEngine(TetrikkEngine eng){
		engine=eng;
		eng.createKeyBindings(this);
	}
}
