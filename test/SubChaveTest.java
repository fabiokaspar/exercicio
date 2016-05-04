import static org.junit.Assert.*;

import org.junit.Test;


public class SubChaveTest {

	@Test
	public void testSubChave() {
		String k = "10010110100101101001011010010110100101101001011010010110100101101001011010010110100101101001011010010110100101101001011010010110";
		SubChave sch = new SubChave(k);
		assertTrue(true);
	}

	@Test
	public void testGeraSubChavesIter() {
		String k = "10010110100101101001011010010110100101101001011010010110100101101001011010010110100101101001011010010110100101101001011010010110";
		SubChave sch = new SubChave(k);
		//sch.geraSubChavesIter(1, );
	}

	@Test
	public void testGeraTabelaSubChaves() {
		String k = "01100001011000010110000101100001011000010110000101100010011000100110001001100010001100010111000101100001011110100111100001110011";
		SubChave sch = new SubChave(k);
		
		System.out.println("KR5 = ");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(Conversor.binToDec(sch.KR5[i][j])+ " ");
			}
			System.out.println();
		}
		
		System.out.println("\n\nKM32 = ");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(Conversor.binToDec(sch.KM32[i][j])+ " ");
			}
			System.out.println();
		}
	}

}
