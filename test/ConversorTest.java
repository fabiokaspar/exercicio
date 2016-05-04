import static org.junit.Assert.*;
import org.junit.Test;

public class ConversorTest {

	@Test
	public void testBinToDec() {
		String v1 = Conversor.binToDec("0110");
		assertTrue("ok", v1.equals("6"));
	}

	@Test
	public void testDecToBin() {
		String v1 = Conversor.decToBin("10");
		assertTrue("ok", v1.equals("1010"));
	}

	@Test
	public void testHexToBin() {
		String v1 = Conversor.hexToBin("AF0");
		assertTrue("ok", v1.equals("101011110000"));
	}
	
	@Test
	public void testHexToDec() {
		String last = Conversor.hexToDec("AF0");
		long v = 10 * ((long) Math.pow(16, 2)) + 15 * ((long) Math.pow(16, 1));
		assertEquals(v, Integer.parseInt(last));
	}

	@Test
	public void testHexToDec2() {
		long last = Conversor.hexToDec2("AF09");
		long v = 10 * (16 * 16 * 16) + 15 * 16 * 16 + 9;
		assertEquals(v, last);
	}
	
	@Test
	public void testBinToHex() {
		String v1 = Conversor.binToHex("111110100110");
		assertTrue("ok", v1.equals("fa6"));
	}

}
