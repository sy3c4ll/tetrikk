package io.github.sy3c4ll.tetrikk;
import io.github.sy3c4ll.tetrikk.engine.TetrikkEngine;
import io.github.sy3c4ll.tetrikk.engine.TetrikkScreen;
import io.github.sy3c4ll.tetrikk.parts.Rules;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class Tetrikk implements Rules {
	public static void main(String[] args){
		JFrame frame=new JFrame("Tetris");
		frame.add(new TetrikkScreen(new TetrikkEngine()));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();frame.setResizable(false);
		frame.setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-frame.getWidth())/2),(int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-frame.getHeight())/2));
		frame.setVisible(true);
	}
}
