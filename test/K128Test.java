import static org.junit.Assert.*;

import org.junit.Test;


public class K128Test {
	OperadorBinario sq = new OperadorBinario();
	
	//@Test
	public void testAlgoritmoK128() {
		String senha = "senhamalucasenha";
		K128 alg = new K128(senha);
		
		System.out.println("k = ");
		alg.k.imprimeBloco();
		
		for (int i = 0; i < 12; i++) {
			Bloco bl = alg.skey.ch.ki[i];
			System.out.print("KEYS[" +i+ "] = ");	
			bl.imprimeBloco();
		}	
	}
	
	public void testFinalCripto () {
		//Bloco acima XOR 0xFFFFFFff : 76696d20 3e20656d 6163730a f000000c
		
		//String senha = "mac0336mac0336ma";
		String senha = "senhamalucasenha";
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
		
		Bloco y = alg.algoritmoK128Round0(xf);
		System.out.print("y = ");
		y.imprimeBloco();
	}
	
	@Test
	public void testFinalDecripto () {
		/*
		 * 
		 Lembre que o bloco a ser enciptado é o bloco do arquivo   
	   	 xor FFFFFFFFFF.... por causa do CBC.                      
	
			Bloco Plain^FFF...:               899692df    c1df9a92    9e9c8cf5    fffffff3
			Bloco acima XOR 0xFFFFFFff :      76696d20    3e20656d    6163730a    f000000c
			Bloco acima ascii:                v i m       >   e m     a c s 
		 * 
		 */
		
		String senha = "senhaM41Ucasenha";
		//String senha = "mac0336MA";
		K128 alg = new K128(senha);

		
		//Bloco acima XOR 0xFFFFFFff :      76696d20    3e20656d    6163730a    f000000c
		Long[] t = new Long[4];
		t[0] = Long.valueOf("76696d20", 16);
		t[1] = Long.valueOf("3e20656d", 16);
		t[2] = Long.valueOf("6163730a", 16);
		t[3] = Long.valueOf("f000000c", 16);
		Bloco x = new Bloco(t);
		
		Bloco xf = sq.xor2(x, alg.ff);
		
		System.out.print("xf = ");
		xf.imprimeBloco();
		
		Bloco y = alg.algoritmoK128(xf);
		System.out.print("y = ");
		y.imprimeBloco();
		
		Bloco xf2 = alg.algoritmoK128Inverso(y);
		System.out.print("xf2 = ");
		xf2.imprimeBloco();
	}
}
