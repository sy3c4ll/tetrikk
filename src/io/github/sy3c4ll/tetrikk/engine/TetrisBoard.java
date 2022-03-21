package io.github.sy3c4ll.tetrikk.engine;
import io.github.sy3c4ll.tetrikk.parts.Piece;
import io.github.sy3c4ll.tetrikk.parts.Rules;
import io.github.sy3c4ll.tetrikk.parts.Tetromino;
import java.awt.Graphics;
public class TetrisBoard implements Rules{
	private Tetromino[][] state;
	private Piece piece;
	public TetrisBoard(){
		this.state=new Tetromino[COL][ROW];
		for(int i=0;i<COL;i++)for(int j=0;j<ROW;j++)this.state[i][j]=Tetromino.X;
	}
	public Graphics display(Graphics g){
		for(int i=0;i<COL;i++)for(int j=0;j<ROW;j++){
			g.setColor(BLOCK_COLOUR[this.state[i][j].ordinal()]);
			g.fillRect(BLOCK_SIZE*i+BLOCK_EDGE*(i*2+1)+BOARD_EDGE,BLOCK_SIZE*j+BLOCK_EDGE*(j*2+1)+BOARD_EDGE,BLOCK_SIZE,BLOCK_SIZE);
		}
		if(this.piece!=null)piece.display(g);
		return g;
	}
	public boolean pieceExists(){
		return this.piece==null;
	}
	public void spawn(Tetromino tet){
		Piece tmp=new Piece(tet);
		boolean overlapped=true;
		while(overlapped){
			tmp.translate(0,-1);
			overlapped=false;
			for(int j=0;j<4;j++)if(tmp.block(j)[1]>=0&&this.state[tmp.block(j)[0]][tmp.block(j)[1]]!=Tetromino.X)overlapped=true;
			if(!overlapped)this.piece=tmp;
		}
	}
	public void merge(){
		for(int i=0;i<4;i++)if(this.piece.block(i)[1]>=0)this.state[this.piece.block(i)[0]][this.piece.block(i)[1]]=this.piece.tetromino;
		this.piece=null;
	}
	public void fall(){
		boolean blocked=false;
		for(int i=0;i<4;i++)if(this.piece.block(i)[1]+1>=ROW||(this.piece.block(i)[1]+1>=0&&this.piece.block(i)[1]+1<ROW&&this.state[this.piece.block(i)[0]][this.piece.block(i)[1]+1]!=Tetromino.X))blocked=true;
		if(blocked)this.merge();
		else this.piece.fall();
	}
	public void rotate(int amount){
		this.piece.rotate(amount);
	}
}
