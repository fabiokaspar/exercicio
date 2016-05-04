import static org.junit.Assert.*;

import org.junit.Test;


public class ChaveInterTest {

	@Test
	public void testChaveInter() {
		String k = "01100001011000010110000101100001011000010110000101100010011000100110001001100010001100010111000101100001011110100111100001110011";
		ChaveInter chi = new ChaveInter(k);
		assertEquals(128, chi.k0.length());
	}

	@Test
	public void testGeraTabelaChavesInter() {
		String k = "01100001011000010110000101100001011000010110000101100010011000100110001001100010001100010111000101100001011110100111100001110011";
		ChaveInter chi = new ChaveInter(k);
		
		System.out.println("ki = ");
		for (int i = 0; i < 12; i++) {
			System.out.println(chi.ki[i]);
		}
	}

	@Test
	public void testGeraChaveIteracao() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculaSegmentoD() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculaSegmentoC() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculaSegmentoB() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculaSegmentoA() {
		fail("Not yet implemented");
	}

}
