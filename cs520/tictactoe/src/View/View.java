package View;

/** This is the View Class, which creates the gui and shows the state of teh game. 
The View is affected by the model.*/

import Controller.*;
import Adapter.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class View{
	private Adapter adapt;
	private JFrame gui;
    private JButton[][] blocks;
    private JButton reset;
    private JTextArea playerturn= new JTextArea();
//Constructor
    public View(){
    	this.gui = new JFrame("Tic Tac Toe");
    	this.blocks = new JButton[3][3];
    	this.reset  = new JButton("Reset");
    	this.playerturn = new JTextArea();
    	construct();

    }
    public void setActionListener(Controller c){
    	this.adapt = new Adapter(c, this);
    	for(int row = 0; row < 3; row++){
    		for(int column = 0; column < 3; column++){
    			blocks[row][column].addActionListener(adapt);
    		}
    	}
    	reset.addActionListener(adapt);
    }
    public void construct(){
    	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");
         for(int row = 0; row<3 ;row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                blocks[row][column].setText("");
                game.add(blocks[row][column]);
            }
        }
        gui.setVisible(true);
    }
    public boolean isReset(ActionEvent e){
    	if(e.getSource()== reset){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    //returns pos of button pressed
    public ArrayList<Integer> getpos(ActionEvent e){
    	ArrayList<Integer> pos = new ArrayList<Integer>();
    	for(int row = 0; row < 3; row ++){
    		for(int column = 0; column < 3; column ++){
    			if(e.getSource() == blocks[row][column]){
    				pos.add(row);
    				pos.add(column);
    			}
    		}
    	}
    	return pos;
    }
    public void update(int x, int y, String str, char mark){
    	blocks[x][y].setText(Character.toString(mark));
    	blocks[x][y].setEnabled(false);
    	playerturn.setText(str);
    }
    public void checkWinner(int x, int y, String str, char mark){
    	blocks[x][y].setText(Character.toString(mark));
    	blocks[x][y].setEnabled(false);
    	for(int row = 0; row < 3; row ++){
    		for(int column = 0; column < 3; column ++){
    			blocks[row][column].setEnabled(false);
    		}
    	}
    	playerturn.setText(str);

    }
        public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                blocks[row][column].setText("");
                blocks[row][column].setEnabled(true);
            }
        }
        playerturn.setText("Player 1 to play 'X'");
    }
    public String toString(int x, int y){
    	String a = blocks[x][y].getText();
    	return a;
    }



}