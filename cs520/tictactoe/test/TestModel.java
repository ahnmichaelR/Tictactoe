import org.junit.Test;
import static org.junit.Assert.*;
import View.*;
import Model.*;

public class TestModel {
	@Test
	public void testModel(){
	View v = new View();
	Model m = new Model();
	m.initialize(v);
	m.updateBoard(1,1);
	assertEquals(8, m.getmovesCount());
	assertEquals('X', m.getBoard()[1][1]);
	m.reset();
	assertEquals(9, m.getmovesCount());
}
}