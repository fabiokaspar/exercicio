import static org.junit.Assert.*;

import org.junit.Test;


public class ConstantsTest {

	@Test
	public void testConstants() {
		Constants cts = new Constants();
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println("ConstR[" +i+ "][" +j+ "] = "+ Long.toHexString(cts.ConstR[i][j]));
				System.out.println("ConstM[" +i+ "][" +j+ "] = "+ Long.toHexString(cts.ConstM[i][j]));
			}
			System.out.println();
		}
	}

}
