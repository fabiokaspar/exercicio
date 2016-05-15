import static org.junit.Assert.*;

import org.junit.Test;


public class OperadorBinarioTest {
	
	@Test
	public void testXor() {
		OperadorBinario sb = new OperadorBinario();
		Long res;
		res = sb.xor(31L, 19L);
		assertEquals(12L, (long)res);
		
	}

	public void testRotacionaEsquerda() {
		OperadorBinario sb = new OperadorBinario();
		Long v = sb.rotacionaEsquerda(27L, 3);
		assertEquals(30L, (long)v);
	}
	
	@Test
	public void testCincoBitsDaDireita() {
		OperadorBinario sb = new OperadorBinario();
		
		Long last = sb.cincoBitsDaDireita(115L);
		assertEquals(19L, (long)last);
	}
	
	@Test
	public void testExtratorDeBytes () {
		OperadorBinario sb = new OperadorBinario();
		
		Long op = Long.valueOf("01101100111101011110001100000000", 2);
		
		int[] v = sb.extratorDeBytes(op);
		int[] exp = {(int)Integer.valueOf("01101100", 2), (int)Integer.valueOf("11110101", 2),
				(int)Integer.valueOf("11100011", 2), (int)Integer.valueOf("00000000", 2)};
	
		assertArrayEquals(exp, v);
	}
	
	public void testSeparaBits() {
		
	}

	
	public void testComprimentoBinario() {
		
	}
	
	
	public void testConcatenaBits() {
	
	}
	
	@Test
	public void testSomaMod32() {
		long pot = (long)Math.pow(2, 32);
		OperadorBinario sb = new OperadorBinario();
		Long r = sb.somaMod32(pot-2, 1L);
		assertEquals(pot-1, (long)r);
		
		r = sb.somaMod32(3L, 2L);
		assertEquals(5L, (long)r);
	}
	
	@Test
	public void testSubMod32() {
		long pot = (long)Math.pow(2, 32);
		OperadorBinario sb = new OperadorBinario();
		Long r = sb.subMod32(pot-2, 1L);
		assertEquals(pot-3, (long)r);
		
		r = sb.subMod32(3L, 3L);
		assertEquals(0L, (long)r);
		
		r = sb.subMod32(3L, pot);
		assertEquals(3L, (long)r);
	}
	
	@Test
	public void testCompletaComZero() {
		OperadorBinario sb = new OperadorBinario();
		String res1 = sb.completaComZero("111", 10);
		assertEquals("0000000111", res1);
		
		res1 = sb.completaComZero("111", 3);
		assertEquals("111", res1);
	}
}
