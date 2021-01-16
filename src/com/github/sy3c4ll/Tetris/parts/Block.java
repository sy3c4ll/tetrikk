package com.github.sy3c4ll.Tetris.parts;
import com.github.sy3c4ll.Tetris.screen.TetrisScreen;
import java.awt.Color;
public class Block implements Rules{
	private int[] position;
	private Color colour;
	protected Block(int x,int y){
		this.position[0]=x;this.position[1]=y;
		this.colour=DEFAULT_COLOUR;
	}
	public void display(TetrisScreen targetScreen){
		
	}
	public Block setPosition(int x,int y){
		this.position[0]=x;this.position[1]=y;
		return this;
	}
	public Block setColour(Color c){
		this.colour=c;
		return this;
	}
	public int[] getPosition(){
		return this.position;
	}
}
