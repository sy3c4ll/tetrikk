package io.github.sy3c4ll.tetrikk.engine;
import io.github.sy3c4ll.tetrikk.parts.Piece;
import io.github.sy3c4ll.tetrikk.parts.Rules;
import io.github.sy3c4ll.tetrikk.parts.Tetromino;
import java.awt.Graphics;
public class TetrikkBoard implements Rules{
	private Tetromino[][] state;
	private Piece piece;
	private Tetromino next;
	private boolean defeat;
	private int[] count;
	public TetrikkBoard(){
		state=new Tetromino[COL][ROW];
		for(int i=0;i<COL;i++)for(int j=0;j<ROW;j++)state[i][j]=Tetromino.X;
		next=Tetromino.values()[RANDOM.nextInt(Tetromino.values().length-1)+1];
		defeat=false;
		count=new int[ROW];
	}
	public void display(Graphics g){
		for(int i=0;i<COL;i++)for(int j=0;j<ROW;j++){
			g.setColor(BLOCK_COLOUR[state[i][j].ordinal()]);
			g.fillRect(BLOCK_SIZE*i+BLOCK_EDGE*(i*2+1)+BOARD_EDGE,BLOCK_SIZE*j+BLOCK_EDGE*(j*2+1)+BOARD_EDGE,BLOCK_SIZE,BLOCK_SIZE);
		}
		if(piece!=null)piece.display(g);
	}
	public boolean running(){
		return !defeat;
	}
	public boolean pieceExists(){
		return piece!=null;
	}
	public void spawn(Tetromino tet){
		Piece ghost=new Piece(next);
		while(overlap(ghost))ghost.translate(0,-1);
		piece=ghost;
		next=tet;
	}
	public void soft_drop(){
		if(pieceExists()){
			Piece ghost=new Piece(piece);
			ghost.translate(0,1);
			if(overlap(ghost))merge();
			else piece.translate(0,1);
		}
	}
	public void hard_drop(){
		while(pieceExists())soft_drop();
	}
	public void move(int amount){
		if(pieceExists()){
			Piece ghost=new Piece(piece);
			ghost.translate(amount,0);
			if(!overlap(ghost))piece.translate(amount,0);
		}
	}
	public void rotate(int amount){
		if(pieceExists()){
			Piece ghost=new Piece(piece);
			ghost.rotate(amount);
			if(!overlap(ghost))piece.rotate(amount);
		}
	}
	public void hold(){
		if(pieceExists()) {
			Tetromino ghost=piece.tetromino;
			piece=new Piece(next);
			next=ghost;
		}
	}
	private void merge(){
		int[] block;
		for(int i=0;i<4;i++){
			block=piece.block(i);
			if(block[1]>=0){
				state[block[0]][block[1]]=piece.tetromino;
				if(++count[block[1]]>=COL)clear(block[1]);
			}
			else defeat=true;
		}
		piece=null;
	}
	private void clear(int r){
		if(count[r]>=COL){
			for(int i=r;i>0;i--){
				for(int j=0;j<COL;j++)state[j][i]=state[j][i-1];
				count[i]=count[i-1];
			}
		}
	}
	private boolean overlap(Piece p){
		boolean overlapped=false;
		for(int i=0;i<4;i++)if(p.block(i)[0]<0||p.block(i)[0]>=COL||p.block(i)[1]>=ROW||(p.block(i)[0]>=0&&p.block(i)[0]<COL&&p.block(i)[1]>=0&&p.block(i)[1]<ROW&&state[p.block(i)[0]][p.block(i)[1]]!=Tetromino.X))overlapped=true;
		return overlapped;
	}
}
