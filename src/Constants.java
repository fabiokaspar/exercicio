
public class Constants {
	long[][] ConstR;
	long[][] ConstM;
	long CM;
	final long MM;
	long CR;
	final long MR;
	
	Constants() {
		ConstR = new long[12][4];
		ConstM = new long[12][4];
		CM = Long.valueOf("5a827999", 16);
		MM = Long.valueOf("6ed9eba1", 16);
		CR = 11;
		MR = 19;
		calculaConstantes();
	}
	
	private void calculaConstantes() {
		int i, j;
		long pot = (long) Math.pow(2, 32);
		
		for (i = 0; i < 12; i++) {
			for (j = 0; j < 4; j++) {
				ConstM[i][j] = CM;
				CM = (CM + MM) % pot;
				ConstR[i][j] = CR;
				CR = (CR + MR) % 32;
			}
		}
	}
}
