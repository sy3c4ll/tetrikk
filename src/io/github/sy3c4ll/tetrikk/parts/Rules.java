package io.github.sy3c4ll.tetrikk.parts;
import java.awt.Color;
import java.awt.Dimension;
import java.security.SecureRandom;
public interface Rules{
	int[][][] BLOCK_POSITION={{{0,0},{0,0},{0,0},{0,0}},
			                  {{-1,0},{0,0},{1,0},{2,0}},
			                  {{0,0},{0,1},{1,0},{1,1}},
			                  {{-1,0},{0,0},{1,0},{0,-1}},
			                  {{-1,0},{0,0},{0,-1},{1,-1}},
			                  {{-1,-1},{-1,0},{0,0},{1,0}},
			                  {{-1,-1},{0,-1},{0,0},{1,0}},
			                  {{-1,0},{0,0},{1,0},{1,-1}}};
	int[] PIECE_POSITION={4,1};
	int COL=10,ROW=20,BLOCK_SIZE=28,BLOCK_EDGE=1,BOARD_EDGE=5;
	Color DEFAULT_COLOUR=Color.GRAY;
	Color[] BLOCK_COLOUR={DEFAULT_COLOUR,
			              Color.CYAN,
			              Color.YELLOW,
			              Color.PINK,
			              Color.GREEN,
			              Color.BLUE,
			              Color.RED,
			              Color.ORANGE};
	Dimension DIMENSION=new Dimension(BLOCK_SIZE*COL+BLOCK_EDGE*COL*2+BOARD_EDGE*2,BLOCK_SIZE*ROW+BLOCK_EDGE*ROW*2+BOARD_EDGE*2);
	int FRAME_INTERVAL=10,INTERVAL=500;
	SecureRandom RANDOM=new SecureRandom();
}
