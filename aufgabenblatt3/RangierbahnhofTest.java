package aufgabenblatt3;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangierbahnhofTest {

	@Test
	public void testExceptionLeeresGleis(){
		Bahnhof bahnhof = new Rangierbahnhof(3);	
	    
	    try {
	        bahnhof.zugBearbeiten(null, 3);
	        fail("Es sollte eine IndexOutOfBoundsException gewurfen werden.");
	    } catch (IndexOutOfBoundsException e) {
	    	assertEquals(e instanceof IndexOutOfBoundsException, true);
	    }
	}

}
