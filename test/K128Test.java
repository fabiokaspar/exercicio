import static org.junit.Assert.*;

import org.junit.Test;


public class K128Test {
	
	@Test
	public void testK128() {
		String k = "aaaaaabbbb1qazxs";
		K128 alg = new K128(k);
		assertNotNull("não null!", alg.skey);
	}
	
	@Test
	public void testAlgoritmoK128() {
		String senha = "aaaaaabbbb1qazxs";
		K128 alg = new K128(senha);
		String y = alg.algoritmoK128("abcdefghabcdefgh");
		assertEquals(128, y.length());
		System.out.println("x = "+alg.xbin);
		System.out.println("y = "+y);
		//alg.setOtherKey("!@#qawertyKhJYtg");
		//y = alg.algoritmoK128("abcdefghabcdefgh");
		//assertEquals(128, y.length());
		//System.out.println("\nx = "+alg.xbin);
		//System.out.println("y = "+y);
	
		//alg.setOtherKey("1234566543210987");
		//y = alg.algoritmoK128("abcdefghabcdefgh");
		//assertEquals(128, y.length());
		//System.out.println("\nx = "+alg.xbin);
		//System.out.println("y = "+y);
		
	}
	
}
