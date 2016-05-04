import static org.junit.Assert.*;

import org.junit.Test;


public class ConstantsTest {

	@Test
	public void testConstants() {
		Constants cts = new Constants();
		System.out.println("ConstR = ");
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(cts.ConstR[i][j]+ " ");
			}
			System.out.println();
		}
		
		System.out.println("\n\nConstM = ");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(cts.ConstM[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
