package com.github.sy3c4ll.Tetris.parts;
import java.awt.Color;
import java.awt.Dimension;
import java.security.SecureRandom;
public interface Rules{
	public final int[][][] BLOCK_POSITION={{{}}};
	public final int[][] PIECE_POSITION={{}};
	public final int WIDTH=0,HEIGHT=0,BLOCK_SIZE=0,BLOCK_EDGE=0,BOARD_EDGE=0;
	public final Color[] BLOCK_COLOUR={};
	public final Color DEFAULT_COLOUR=new Color(128,128,128);
	public final Dimension DIMENSION=new Dimension(BLOCK_SIZE*WIDTH,BLOCK_SIZE*HEIGHT);
	public final SecureRandom RANDOM=new SecureRandom();
}
