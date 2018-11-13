package Controller;

import java.util.ArrayList;
import Model.*;
public class Controller{
	private Model m;

	public void setModel(Model m){
		this.m = m;
	}
	public void setRequest(ArrayList<Integer> position){
		m.updateBoard(position.get(0),position.get(1));
	}
	public void setRequest(){
		m.reset();
	}
}