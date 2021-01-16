package com.github.sy3c4ll.Tetris;
import com.github.sy3c4ll.Tetris.engine.TetrisEngine;
import com.github.sy3c4ll.Tetris.screen.TetrisScreen;
import com.github.sy3c4ll.Tetris.parts.Rules;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class Main implements Rules{
	public static void main(String[] args){
		JFrame frame=new JFrame("Tetris");
		TetrisEngine engine=new TetrisEngine();
		engine.addScreen(new TetrisScreen(engine));
		engine.getScreens()[0].addPaneltoFrame(frame.getContentPane());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(DIMENSION);frame.pack();
		frame.setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-frame.getWidth())/2),(int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-frame.getHeight())/2));
		frame.setVisible(true);
	}
}
