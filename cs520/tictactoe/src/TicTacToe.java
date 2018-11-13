import Model.*;
import View.*;
import Controller.*;

public class TicTacToe{
    public static void main(String[] args){
        Model m = new Model();
        View v = new View();
        Controller c = new Controller();

        m.initialize(v);
        c.setModel(m);
        v.setActionListener(c);
    }
}
