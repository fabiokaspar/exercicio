import static org.junit.Assert.*;

import org.junit.Test;


public class FunctionTest {
	OperadorBinario sq = new OperadorBinario();
	Function func = new Function();
	SBox sb = new SBox();
	
	public void testIndicesCelulasSBox() {
		int[] last = func.indicesCelulasSBox(1000L, 2L, 10000L);
		
		Long r = (10000L ^ 1000L);
		r = r * 2;
		int[] exp = sq.extratorDeBytes(r);
		
		assertArrayEquals(exp, last);
	}

	public void testCelulasSBox() {
		int[] ind = func.indicesCelulasSBox(1000L, 31L, 10000L);
		Long[] last = func.celulasSBox(ind);
		
	}

	@Test
	public void testF1() {
		Function func = new Function();
		Long y;
		
		long x = Long.valueOf("11001001011001110001011110000111", 2);
		long kr5 = Long.valueOf("11010", 2);
		long km32 = Long.valueOf("01001111011001010101011110100111", 2);
		
		long i = sq.rotacionaEsquerda(x ^ km32, (int) kr5);
		int[] ind = sq.extratorDeBytes(2182613248L);
		String s1 = Long.toBinaryString(2182613248L);
		
		int[] r = {  Integer.valueOf("10000010", 2),
				     Integer.valueOf("00011000", 2),
				     Integer.valueOf("00001001", 2),
				     Integer.valueOf("00000000", 2)
				  };
		// (130), (24), (9), (0)
		long v1 = Long.valueOf("bf64cddf", 16);
		long v2 = Long.valueOf("d1da4181", 16);
		long v3 = Long.valueOf("eefbcaea", 16);
		long v4 = Long.valueOf("9db30420", 16);
		//assertEquals(2182613248L, i);
		Long exp;
		
		System.out.println("SB1[130] = "+ sb.S1[130]);
		System.out.println("SB2[24] = "+  sb.S2[24]);
		System.out.println("SB3[9] = "+   sb.S3[9]);
		System.out.println("SB4[0] = "+   sb.S4[0]);
		
		exp = sq.somaMod32(v1, v2);
		exp = sq.subMod32(exp, v3);
		exp = sq.xor(exp, v4);
		
		y = func.F1(x, kr5, km32);
		
		System.out.println("y = "+y);
		System.out.println("exp = "+exp);
		
		assertEquals((long)exp, (long)y);
	}


	public void testF2() {
		
	}

	
	public void testF3() {
		
	}
}
