import static org.junit.Assert.*;

import org.junit.Test;


public class BlocoTest {
	
	Bloco bc;
	
	//@Test
	public void testConverteBufferEmBloco() {
		Long[] t = new Long[4];
		t[0] = 0x00000000L;
		t[1] = 0xaaaaaaaaL;
		t[2] = 0xbbbbbbbbL;
		t[3] = 0xcdcdcdcdL;
		
		bc = new Bloco(t);
		
		byte[] v1 = Bloco.converteBlocoEmBuffer(bc);
		
		Bloco bc2 = Bloco.converteBufferEmBloco(v1);
				
		byte[] v2 = Bloco.converteBlocoEmBuffer(bc2);
		
		assertArrayEquals(v1, v2);
	}

	@Test
	public void testAlteraIesimoBit() {
		Long[] t = new Long[4];
		t[0] = 0x55L;
		t[1] = 0xaaL;
		t[2] = 0xbbL;
		t[3] = 0xccL;
		Bloco b = new Bloco(t);
		
		b.alteraIesimoBit(0);
		b.alteraIesimoBit(31);
		
		b.alteraIesimoBit(32);
		b.alteraIesimoBit(63);
		
		b.alteraIesimoBit(64);
		b.alteraIesimoBit(95);
		
		b.alteraIesimoBit(96);
		b.alteraIesimoBit(127);
	}

	//@Test
	public void testCompletaBloco() {
		
	}

	//@Test
	public void testCalcula4BytesDecimais() {
		
	}

}
