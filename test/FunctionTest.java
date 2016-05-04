import static org.junit.Assert.*;

import org.junit.Test;


public class FunctionTest {

	@Test
	public void testDivideParticao() {
		fail("Not yet implemented");
	}

	@Test
	public void testListaCelulasBinarias() {
		fail("Not yet implemented");
	}

	@Test
	public void testF1() {
		Function func = new Function();
		String y;
		
		y = func.F1("11001001011001110001011110000111", "11010", "01001111011001010101011110100111");
		System.out.println("f1(x) = "+ y);
	}

	@Test
	public void testF2() {
		Function func = new Function();
		String y;
		
		y = func.F2("11001001011001110001011110000111", "11010", "01001111011001010101011110100111");
		System.out.println("f2(x) = "+ y);
	}

	@Test
	public void testF3() {
		Function func = new Function();
		String y;
		y = func.F3("11001001011001110001011110000111", "11010", "01001111011001010101011110100111");
		System.out.println("f3(x) = "+ y);
	}

}
