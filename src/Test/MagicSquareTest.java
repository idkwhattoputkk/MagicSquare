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
		int x = (int) (Math.random()*100);
	    x = x*2+1;
		magico.setX(x);
	}
	public void setupScenary3() {
		magico = new MagicSquare();
		int x = (int) (Math.random()*100);
	    x = x*2;
		magico.setX(x);
	}
	@Test
	public void testMethod1() {
		try {
			setupScenary1();
			magico.setX(3);
			magico.createMagicSquare(null, null);
			fail("Se esperaba excepcion IsNotOrNullException");
		}catch(Exception ex) {
			}
		}
		
	@Test
	public void testMethod2() {
		try {
			setupScenary2();
			magico.createMagicSquare("DOWN", "NO");
			fail("Se esperaba excepcion MyException");
		}catch(Exception ex) {}
		
	}
	@Test
	public void testMethod3() {
		try {
			setupScenary3();
			magico.createMagicSquare("DOWN", "SE");
			fail("Se esperaba excepcion IsNotOddOrNullException");
		}catch(Exception ex) {}
		
	}
	@Test
	public void testMethod4() {
		try {
			setupScenary2();
			magico.createMagicSquare(null, "SO");
			fail("se esperaba excepcion IsNotOddOrNullException");
		}catch(Exception ex) {}
	}
	@Test
	public void testMethod5() {
		try {
			setupScenary3();
			magico.createMagicSquare("UP", null);
			fail("se esperaba excepcion IsNotOddOrNullException");
		}catch(Exception ex) {}
	}
	@Test
	public void testMethod6(){
		try {
			setupScenary2();
			magico.createMagicSquare("LEFT", "NE");
			fail("se esperaba excepcion MyException");
		}catch(Exception ex) {}
	}
	@Test
	public void testMethod7() {
		try {
			setupScenary3();
			magico.createMagicSquare("RIGHT", "SE");
			fail("se esperaba excepcion IsNotNullOrNullException");
		}catch(Exception ex) {}
	}
	@Test
	public void testMethod8() {
		try {
			setupScenary2();
			magico.createMagicSquare("RIGHT", "SO");
			fail("se esperaba excepcion MyException");
		}catch(Exception ex) {}
	}
	@Test
	public void testMethod9() {
		try {
			setupScenary2();
			magico.createMagicSquare("RIGHT", null);
			fail("se esperaba excepcion IsNotOddOrNullException");
		}catch(Exception ex) {}
	}
	@Test
	public void testMethod10() {
		try {
			setupScenary1();
			magico.setX(2);
			magico.createMagicSquare("RIGHT", "SO");
			fail("se esperaba excepcion IsNotNullOrNullException");
		}catch(Exception ex) {}
	}
	
	

}
