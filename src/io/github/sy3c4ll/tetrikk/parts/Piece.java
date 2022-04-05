package io.github.sy3c4ll.tetrikk.parts;
import java.awt.Graphics;
public class Piece implements Rules{
	final public Tetromino tetromino;
	private int[] position;
	private int rotation;
	public Piece(Tetromino tet){
		tetromino=tet;position=new int[]{PIECE_POSITION[0],PIECE_POSITION[1]};rotation=0;
	}
	public Piece(Piece p){
		tetromino=p.tetromino;position=p.position.clone();rotation=p.rotation;
	}
	public void display(Graphics g){
		for(int i=0;i<4;i++)if(block(i)[1]>=0){
			g.setColor(BLOCK_COLOUR[tetromino.ordinal()]);
			g.fillRect(BLOCK_SIZE*block(i)[0]+BLOCK_EDGE*(block(i)[0]*2+1)+BOARD_EDGE,
					  BLOCK_SIZE*block(i)[1]+BLOCK_EDGE*(block(i)[1]*2+1)+BOARD_EDGE,
					     BLOCK_SIZE,BLOCK_SIZE);
		}
	}
	public int[] block(int i){
		return new int[]{
			position[0]+rotateBlock(BLOCK_POSITION[tetromino.ordinal()][i],rotation)[0],
			position[1]+rotateBlock(BLOCK_POSITION[tetromino.ordinal()][i],rotation)[1]
		};
	}
	public void rotate(int amount){
		rotation=(rotation=(rotation+amount)%4)>=0?rotation:rotation+4;
	}
	public void translate(int c,int r){
		position[0]+=c;
		position[1]+=r;
	}
	private int[] rotateBlock(int[] pos,int rot){
		switch(rot){
			case 0:return new int[]{pos[0],pos[1]};
			case 1:return new int[]{-pos[1],pos[0]};
			case 2:return new int[]{-pos[0],-pos[1]};
			case 3:return new int[]{pos[1],-pos[0]};
			default:return new int[]{0,0};
		}
	}
}
