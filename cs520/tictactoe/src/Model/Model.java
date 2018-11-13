package Model;

import View.*;

public class Model{
	private View v;
	private int player;
	private int movesCount;
	private char[][] board;
	private String str;

	public Model(){
		this.board = new char[3][3];
		this.movesCount = 9;
		this.player = 1;
	}

	public void initialize(View v){
		this.v = v;
	}
	public int getplayer(){
		return player;
	}
	public void setplayer(int player){
		this.player = player;
	}
	public int getmovesCount() {
		return movesCount;
	}
	public void setmovesCount(int movesCount) {
		this.movesCount = movesCount;
	}
	public char[][] getBoard(){
		return board;
	}
	public String getstr(){
		return str;
	}
	public void setstr(String str){
		this.str = str;
	}
	//check the if statement
	public void updateBoard(int x, int y){
		if(getmovesCount() > 0 ){
			if(player == 1){
			board[x][y] = 'X';
		}
		else{
			board[x][y] = 'O';
		}
		int newcount = movesCount -1;
		setmovesCount(newcount);
		if(checkWinner(x,y)){
			String a = "Player " + player +" wins!";
			setstr(a);
			v.checkWinner(x,y,getstr(),board[x][y]);
		}
		else if(getmovesCount()== 0){
			String b = "Game ends in a draw";
			setstr(b);
			v.checkWinner(x,y,getstr(),board[x][y]);
		}
		else {
			if(player == 1){
				setplayer(2);
				String c = "'O': Player 2";
				setstr(c);
			}
			else {
				setplayer(1);
				String d = "'X': Player 1";
				setstr(d);
			}
			v.update(x,y,getstr(), board[x][y]);
		}
	}
}
	public boolean checkWinner(int x, int y){
		char symbol = board[x][y];
		int colcount = 0;
		int rowcount = 0;
		int diagcount = 0;
		int revdiag = 0;
		// check col
		for(int i = 0; i < 3; i++){
			if(board[x][i] != symbol){
				break;
			}
			colcount++;
		}
		for(int i = 0; i < 3; i++){
			if(board[i][y] != symbol){
				break;
			}
			rowcount++;
		}
		for(int i = 0; i < 3; i++){
			if(board[i][i] != symbol){
				break;
			}
			diagcount ++;
		}
		for(int i =0; i < 3; i++){
			if(board[i][(3-1)-i] != symbol){
				break;
			}
			revdiag++;
		}
		if(colcount == 3 || rowcount == 3 || diagcount == 3 || revdiag == 3){
			return true;
		}
		else{
			return false;
		}
	}
	public void reset(){
		movesCount = 9;
		setplayer(1);
		setstr("");
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = '\0';
			}
		}
		v.resetGame();
	}
}