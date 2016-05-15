public class SubChave {
	Long KR5[][] = new Long[12][4];
	Long KM32[][] = new Long[12][4];
	OperadorBinario op = new OperadorBinario();
	ChaveInter ch;
	
	public SubChave (Bloco k) {
		ch = new ChaveInter(k);
		geraTabelaSubChaves();
	}
	
	public void geraSubChavesIter (int iter, Bloco ki) {
		Long seg[] = op.separaBloco(ki);
		
		KR5[iter][0] = op.cincoBitsDaDireita(seg[0]);
		KR5[iter][1] = op.cincoBitsDaDireita(seg[1]);
		KR5[iter][2] = op.cincoBitsDaDireita(seg[2]);
		KR5[iter][3] = op.cincoBitsDaDireita(seg[3]);
		
		KM32[iter][0] = seg[3];
		KM32[iter][1] = seg[2];
		KM32[iter][2] = seg[1];
		KM32[iter][3] = seg[0];
	}
	
	public void geraTabelaSubChaves () {
		for (int i = 0; i <= 11; i++) {
			geraSubChavesIter(i, ch.ki[i]);
		}
	}
}
