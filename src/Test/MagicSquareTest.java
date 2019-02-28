package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.MagicSquare;

class MagicSquareTest {
	private MagicSquare magico;
	public void setupScenary1() {
		magico = new MagicSquare();
	}
	public void setupScenary2() {
		magico = new MagicSquare();
		int x=(int) (Math.random()*100);
	    x = x*2+1;
		magico.setX(x);
	}
	public void setupScenary3() {
		magico = new MagicSquare();
		int x=(int) (Math.random()*100);
	    x = x*2;
		magico.setX(x);
	}
	@Test
	public void testMethod1() {
		try {
			setupScenary1();
			magico.createMagicSquare(null, null);
			fail("Se esperaba excepcion IsNotOrNullException");
		}catch(Exception ex) {
			}
		}
		
	@Test
	public void testMethod2() {
		try {
			setupScenary2();
			magico.createMagicSquare("DOWN", "SO");
			fail("Se esperaba excepcion IsNotOrNullException");
		}catch(Exception ex) {}
		
	}
	@Test
	public void testMethod3() {
		try {
			setupScenary3();
			magico.createMagicSquare(null, null);
		}catch(Exception ex) {}
		
	}

}
