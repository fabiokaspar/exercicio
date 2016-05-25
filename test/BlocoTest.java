import static org.junit.Assert.*;

import org.junit.Test;


public class BlocoTest {
	
	Bloco bc;
	
	@Test
	public void testConverteBufferEmBloco() {
		Long[] t = new Long[4];
		t[0] = 0xbacL;
		t[1] = 0x1109L;
		t[2] = 0xccL;
		t[3] = 0xaaaaaaL;
		
		bc = new Bloco(t);
		
		byte[] v1 = Bloco.converteBlocoEmBuffer(bc);
		
		//System.out.println("bc = ");
		//bc.imprimeBloco();
		
		//bc.imprimeBlocoEmBinario();
		
		Bloco bc2 = Bloco.converteBufferEmBloco(v1);
		
		//System.out.println("bc2 = ");
		//bc2.imprimeBloco();
		//bc2.imprimeBlocoEmBinario();
		
		//byte[] v2 = Bloco.converteBlocoEmBuffer(bc2);
		
		//assertArrayEquals(v1, v2);
		
		/*System.out.print("v1 = ");
		for (int i = 0; i < 16; i++)
			System.out.print(v1[i]+ " ");
		
		System.out.println();
		System.out.print("v2 = ");
		for (int i = 0; i < 16; i++)
			System.out.print(v2[i]+ " "); */
	}

	//@Test
	public void testConverteBlocoEmBuffer() {
		
	}

	//@Test
	public void testCompletaBloco() {
		
	}

	//@Test
	public void testCalcula4BytesDecimais() {
		
	}

}
