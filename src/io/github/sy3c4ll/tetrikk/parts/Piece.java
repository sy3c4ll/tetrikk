package io.github.sy3c4ll.tetrikk.parts;
import java.awt.Graphics;
public class Piece implements Rules{
	final public Tetromino tetromino;
	private int[] position;
	private int rotation;
	public Piece(Tetromino tet){
		this.tetromino=tet;this.position=new int[]{PIECE_POSITION[0],PIECE_POSITION[1]};this.rotation=0;
	}
	public Graphics display(Graphics g){
		for(int i=0;i<4;i++)if(this.block(i)[1]>=0){
			g.setColor(BLOCK_COLOUR[this.tetromino.ordinal()]);
			g.fillRect(BLOCK_SIZE*this.block(i)[0]+BLOCK_EDGE*(this.block(i)[0]*2+1)+BOARD_EDGE,
					  BLOCK_SIZE*this.block(i)[1]+BLOCK_EDGE*(this.block(i)[1]*2+1)+BOARD_EDGE,
					     BLOCK_SIZE,BLOCK_SIZE);
		}
		return g;
	}
	public int[] block(int i){
		return new int[]{
			this.position[0]+this.rotateBlock(BLOCK_POSITION[this.tetromino.ordinal()][i],this.rotation)[0],
			this.position[1]+this.rotateBlock(BLOCK_POSITION[this.tetromino.ordinal()][i],this.rotation)[1]
		};
	}
	public void fall(){
		this.position[1]++;
	}
	public void rotate(int amount){
		this.rotation=(this.rotation+amount)%4;
	}
	public void translate(int c,int r){
		this.position[0]+=c;
		this.position[1]+=r;
	}
	private int[] rotateBlock(int[] pos,int rot){
		switch(rot){
			case 0:return new int[]{pos[0],pos[1]};
			case 1:return new int[]{pos[1],-pos[0]};
			case 2:return new int[]{-pos[0],-pos[1]};
			case 3:return new int[]{-pos[1],pos[0]};
			default:return new int[]{0,0};
		}
	}
}
