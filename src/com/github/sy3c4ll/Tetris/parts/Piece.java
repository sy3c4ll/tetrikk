package com.github.sy3c4ll.Tetris.parts;
import com.github.sy3c4ll.Tetris.screen.TetrisScreen;
public class Piece implements Rules{
	private int[] position;
	private Block[] block;
	public Piece(Tetromino tet){
		this.position=PIECE_POSITION[tet.ordinal()];this.block=new Block[4];
		for(int i=0;i<4;i++)this.block[i]=new Block(this.position[0]+BLOCK_POSITION[tet.ordinal()][i][0],this.position[1]+BLOCK_POSITION[tet.ordinal()][i][1]).setColour(BLOCK_COLOUR[tet.ordinal()]);
	}
	public void display(TetrisScreen targetScreen){
		for(int i=0;i<4;i++)this.block[i].display(targetScreen);
	}
	public void rotateLeft(){
		int[] temp;
		for(int i=0;i<4;i++){
			temp=this.block[i].getPosition();
			this.block[i].setPosition(-temp[1],temp[0]);
		}
	}
	public void rotateRight(){
		int[] temp;
		for(int i=0;i<4;i++){
			temp=this.block[i].getPosition();
			this.block[i].setPosition(temp[1],-temp[0]);
		}
	}
	public Block[] getBlocks(){
		return this.block;
	}
}
