import static org.junit.Assert.*;

import org.junit.Test;


public class OperadorBinarioTest {
	@Test
	public void testXor() {
		OperadorBinario sb = new OperadorBinario();
		String res;
		res = sb.xor("1111", "0000");
		assertEquals("1111", res);
		
		res = sb.xor("111100001111111100001111111100001111111100001111", "111111111111111111111111111111111111111111111111");
		assertEquals("000011110000000011110000000011110000000011110000", res);
	}

	@Test
	public void testRotacionaEsquerda() {
		OperadorBinario sb = new OperadorBinario();
		String last = sb.rotacionaEsquerda("011001", 3);
		assertEquals("001011", last);
	}
	
	@Test
	public void testCincoBitsDaDireita() {
		OperadorBinario sb = new OperadorBinario();
		
		String last = sb.cincoBitsDaDireita("0100110100011111");
		String expected = "11111";
		assertEquals(expected, last);
		
		last = sb.cincoBitsDaDireita("011111");
		expected = "11111";
		assertEquals(expected, last);
	
		last = sb.cincoBitsDaDireita("00000");
		expected = "00000";
		assertEquals(expected, last);
	}
	
	@Test
	public void testSeparaBits() {
		OperadorBinario sb = new OperadorBinario();
		String[] last;
		String[] expected = {"0000", "1101", "0000", "1110", "1101", "1110", "0001", "0000"};
	
		last = sb.separaBits("00001101000011101101111000010000", 8);
		assertArrayEquals(expected, last); 
	}

	@Test
	public void testComprimentoBinario() {
		OperadorBinario sb = new OperadorBinario();
		String k = "10010110100101101001011010010110100101101001011010010110100101101001011010010110100101101001011010010110100101101001011010010110";
	
		assertEquals(128, sb.comprimentoBinario(k));
	}
	@Test
	public void testConcatenaBits() {
		OperadorBinario sb = new OperadorBinario();
		String[] v = {"0100", "1101", "0000", "1110"};
		String last = sb.concatenaBits(v);
		String expected = "0100110100001110";
	
		assertEquals(expected, last);
	}
	
	@Test
	public void testSomaMod32() {
		OperadorBinario sb = new OperadorBinario();
		String res1 = sb.somaMod32("11111111111111111111111111111111", "010");
		assertEquals("00000000000000000000000000000001", res1);
		
		res1 = sb.somaMod32("11111111111111111111111111111111", "00001");
		assertEquals("00000000000000000000000000000000", res1);
		
		res1 = sb.somaMod32("11111111111111111111111111111011", "100");
		assertEquals("11111111111111111111111111111111", res1);
	}
	
	@Test
	public void testSubMod32() {
		OperadorBinario sb = new OperadorBinario();
		String res1 = sb.subMod32("0", "1");
		assertEquals(sb.somaMod32("11111111111111111111111111111111", "0"), res1);
		
		res1 = sb.subMod32("11111111111111111111111111111111", "111");
		assertEquals("11111111111111111111111111111000", res1);
		
		res1 = sb.subMod32("00000000000000000000000000000000", "0");
		assertEquals("00000000000000000000000000000000", res1);
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
