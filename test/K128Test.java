import static org.junit.Assert.*;

import org.junit.Test;


public class K128Test {
		
	@Test
	public void testAlgoritmoK128() {
		String senha = "mac0336mac0336ma";
		K128 alg = new K128(senha);
		
		System.out.println("k = "
		+Long.toHexString(alg.k.bloco[0])+ " "+ Long.toHexString(alg.k.bloco[1]) + " " + Long.toHexString(alg.k.bloco[2]) + " "+ Long.toHexString(alg.k.bloco[3]));
		
		
		for (int i = 0; i < 12; i++) {
			Long[] bl = alg.skey.ch.ki[i].bloco;
			System.out.print("KEYS[" +i+ "] = ");
			
			for (int j = 0; j < 4; j++) {
				System.out.print(Long.toHexString(bl[j]) +" ");
			}
			
			System.out.println();
		}
	}
	
}
