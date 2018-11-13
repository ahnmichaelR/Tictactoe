import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
import Model.*;
import Controller.*;
import View.*;

public class testview{
	@Test
	public void testGameState(){
		Controller c = new Controller();
		View v = new View();
		v.setActionListener(c);
		v.update(1,1,"'O': Player 2", 'X');
		assertEquals("X", v.toString(1,1));
	}
}