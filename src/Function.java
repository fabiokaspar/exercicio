public class Function {
	OperadorBinario sq = new OperadorBinario();
	SBox sb = new SBox();
	Constants cts = new Constants();
	
	public int[] indicesCelulasSBox (Long x, Long KR5, Long KM32) {
		Long I;
		int[] indices;
		
		long N = Long.valueOf(KR5);
		
		I = sq.xor(x, KM32);
		I = sq.rotacionaEsquerda(I, (int) N);
		
		indices = sq.extratorDeBytes(I);
		
		return indices;
	}
	
	public Long[] celulasSBox (int[] indices) {
		Long celulas[] = new Long[4];
		
		celulas[0] = Long.valueOf(sb.S1[indices[0]], 16);
		celulas[1] = Long.valueOf(sb.S2[indices[1]], 16);
		celulas[2] = Long.valueOf(sb.S3[indices[2]], 16);
		celulas[3] = Long.valueOf(sb.S4[indices[3]], 16);
		
		return celulas;
	}
	
	public Long F1 (Long x, Long KR5, Long KM32) {
		Long[] cel;
		Long y;
		cel = celulasSBox(indicesCelulasSBox(x, KR5, KM32));
		
		y = sq.somaMod32(cel[0], cel[1]);
		y = sq.subMod32(y, cel[2]);
		y = sq.xor(y, cel[3]);
		
		return y;
	}
	
	public Long F2 (Long x, Long KR5, Long KM32) {
		Long[] cel;
		Long y;
		cel = celulasSBox(indicesCelulasSBox(x, KR5, KM32));
		
		y = sq.subMod32(cel[0], cel[1]);
		y = sq.xor(y, cel[2]);
		y = sq.somaMod32(y, cel[3]);
		
		return y;
	}
	
	public Long F3 (Long x, Long KR5, Long KM32) {
		Long[] cel;
		Long y;
		cel = celulasSBox(indicesCelulasSBox(x, KR5, KM32));
		
		y = sq.xor(cel[0], cel[1]);
		y = sq.somaMod32(y, cel[2]);
		y = sq.subMod32(y, cel[3]);
		
		return y;
	}
}
