import static org.junit.Assert.*;
import org.junit.Test;

public class SBoxTest {
	@Test
	public void testGetElementFromS1() {
		SBox sb = new SBox();
		String v1;
		
		v1 = sb.getElementFromS1(0);
		assertTrue("passou", v1.equals("30fb40d4"));
		
		v1 = sb.getElementFromS1(8);
		assertTrue("passou", v1.equals("bfd4af27"));
		
		v1 = sb.getElementFromS1(255);
		assertTrue("passou", v1.equals("5c8165bf"));
	}

	@Test
	public void testGetElementFromS2() {
		SBox sb = new SBox();
		String v1;
		
		v1 = sb.getElementFromS2(0);
		assertTrue("passou", v1.equals("1f201094"));
		
		v1 = sb.getElementFromS2(8);
		assertTrue("passou", v1.equals("ada7ef79"));
		
		v1 = sb.getElementFromS2(255);
		assertTrue("passou", v1.equals("4523ecf1"));
	}

	@Test
	public void testGetElementFromS3() {
		SBox sb = new SBox();
		String v1;
		
		v1 = sb.getElementFromS3(0);
		assertTrue("passou", v1.equals("8defc240"));
		
		v1 = sb.getElementFromS3(8);
		assertTrue("passou", v1.equals("beb1f9bf"));
		
		v1 = sb.getElementFromS3(255);
		assertTrue("passou", v1.equals("ee353783"));
	}

	@Test
	public void testGetElementFromS4() {
		SBox sb = new SBox();
		String v1;
		
		v1 = sb.getElementFromS4(0);
		assertTrue("passou", v1.equals("9db30420"));
		
		v1 = sb.getElementFromS4(8);
		assertTrue("passou", v1.equals("7e287aff"));
		
		v1 = sb.getElementFromS4(255);
		assertTrue("passou", v1.equals("0aef7ed2"));
	}
}
