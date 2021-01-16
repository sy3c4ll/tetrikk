package com.github.sy3c4ll.Tetris.engine;
import com.github.sy3c4ll.Tetris.parts.Piece;
import com.github.sy3c4ll.Tetris.parts.Rules;
import java.awt.Graphics;
public class TetrisBoard implements Rules{
	private int[][] board;
	private Piece piece;
	public TetrisBoard(){
		board=new int[WIDTH][HEIGHT];
	}
	public Graphics display(){
		return null;
	}
}
