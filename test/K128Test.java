import static org.junit.Assert.*;

import org.junit.Test;


public class K128Test {
	OperadorBinario sq = new OperadorBinario();
	
	public void testAlgoritmoK128() {
		String senha = "mac0336mac0336ma";
		K128 alg = new K128(senha);
		
		System.out.println("k = ");
		alg.k.imprimeBloco();
		
		for (int i = 0; i < 12; i++) {
			Long[] bl = alg.skey.ch.ki[i].bloco;
			System.out.print("KEYS[" +i+ "] = ");
			
			for (int j = 0; j < 4; j++) {
				System.out.print(Long.toHexString(bl[j]) +" ");
			}
			
			System.out.println();
		} 
		
	}
	
	@Test
	public void testFinalCripto () {
		//Bloco acima XOR 0xFFFFFFff : 76696d20 3e20656d 6163730a f000000c
		
		String senha = "mac0336mac0336ma";
		K128 alg = new K128(senha);
		
		Long[] FF = new Long[4];
		FF[0] = Long.valueOf("ffffffff", 16);
		FF[1] = Long.valueOf("ffffffff", 16);
		FF[2] = Long.valueOf("ffffffff", 16);
		FF[3] = Long.valueOf("0fffffff", 16);
		Bloco z1 = new Bloco(FF);
			
		Long[] t = new Long[4];
		t[0] = Long.valueOf("76696d20", 16);
		t[1] = Long.valueOf("3e20656d", 16);
		t[2] = Long.valueOf("6163730a", 16);
		t[3] = Long.valueOf("f000000c", 16);
		Bloco x = new Bloco(t);
		
		Bloco xf = sq.xor2(x, z1);
		
		System.out.print("xf = ");
		xf.imprimeBloco();
		
		x = alg.algoritmoK128(xf);
		System.out.print("y = ");
		x.imprimeBloco();
	}
}
