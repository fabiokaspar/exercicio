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
		
		Bloco bc2 = Bloco.converteBufferEmBloco(v1);
				
		byte[] v2 = Bloco.converteBlocoEmBuffer(bc2);
		
		assertArrayEquals(v1, v2);
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
