public class SubChave {
	String KR5[][];
	String KM32[][];
	OperadorBinario op;
	ChaveInter ch;
	
	public SubChave (String key) {
		KR5 = new String[12][4];
		KM32 = new String[12][4];
		op = new OperadorBinario();
		ch = new ChaveInter(key);
		geraTabelaSubChaves();
	}
	
	public void geraSubChavesIter (int iter, String ki) {
		String seg[] = op.separaBits(ki,4);
		
		KR5[iter][0] = op.cincoBitsDaDireita(seg[0]);
		KR5[iter][1] = op.cincoBitsDaDireita(seg[1]);
		KR5[iter][2] = op.cincoBitsDaDireita(seg[2]);
		KR5[iter][3] = op.cincoBitsDaDireita(seg[3]);
		
		KM32[iter][0] = String.valueOf(seg[3]);
		KM32[iter][1] = String.valueOf(seg[2]);
		KM32[iter][2] = String.valueOf(seg[1]);
		KM32[iter][3] = String.valueOf(seg[0]);
	}
	
	public void geraTabelaSubChaves () {
		for (int i = 0; i <= 11; i++) {
			geraSubChavesIter(i, this.ch.ki[i]);
		}
	}
}
