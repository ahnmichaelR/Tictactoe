import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
import Model.*;
import Controller.*;
import View.*;

public class TestController {
    @Test
    public void testNewGame() {
    	Controller c = new Controller();
    	Model m = new Model();
    	View v = new View();
    	m.initialize(v);
    	c.setModel(m);
    	ArrayList<Integer> pos = new ArrayList<Integer>();
    	pos.add(1);
    	pos.add(1);
    	c.setRequest(pos);
    	assertEquals('X', m.getBoard()[1][1]);
    }
}
