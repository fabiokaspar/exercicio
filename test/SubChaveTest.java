import static org.junit.Assert.*;

import org.junit.Test;


public class SubChaveTest {

	@Test
	public void testSubChave() {

	}

	@Test
	public void testGeraSubChavesIter() {

	}

	@Test
	public void testGeraTabelaSubChaves() {
		K128 alg = new K128("mac0336mac0336ma");
		SubChave sch = alg.skey;
						
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println("KR5[" +i+"][" +j+"] = " +Long.toHexString(sch.KR5[i][j]));
				System.out.println("KM32[" +i+"][" +j+"] = " +Long.toHexString(sch.KM32[i][j]));
			}
			System.out.println();
		}
	}

}
