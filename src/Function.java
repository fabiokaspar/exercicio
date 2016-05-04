public class Function {
	OperadorBinario sq = new OperadorBinario();
	SBox sb = new SBox();
	Constants cts = new Constants();
	
	public String[] divideParticao (String x, String KR5, String KM32) {
		String i;
		String[] partes;
		
		if (KR5.length() != 5 || KM32.length() != 32)
			System.exit(0);
		
		int N = Integer.valueOf(KR5, 2);
		
		i = sq.xor(x, KM32);
		i = sq.rotacionaEsquerda(i, N);
		partes = sq.separaBits(i,4);
		
		return partes;
	}
	
	public String[] listaCelulasBinarias (String[] particao) {
		String celBin[] = new String[4];
		long i1 = Integer.parseInt(Conversor.binToDec(particao[0]));
		long i2 = Integer.parseInt(Conversor.binToDec(particao[1]));
		long i3 = Integer.parseInt(Conversor.binToDec(particao[2]));
		long i4 = Integer.parseInt(Conversor.binToDec(particao[3]));
		
		celBin[0] = sq.completaComZero(Conversor.hexToBin(sb.S1[(int)i1]), 32);
		celBin[1] = sq.completaComZero(Conversor.hexToBin(sb.S2[(int)i2]), 32);
		celBin[2] = sq.completaComZero(Conversor.hexToBin(sb.S3[(int)i3]), 32);
		celBin[3] = sq.completaComZero(Conversor.hexToBin(sb.S4[(int)i4]), 32);
		
		return celBin;
	}
	
	public String F1 (String x, String KR5, String KM32) {
		String[] celBin;
		String y;
		celBin = listaCelulasBinarias(divideParticao(x, KR5, KM32));
		
		y = sq.somaMod32(celBin[0], celBin[1]);
		y = sq.subMod32(y, celBin[2]);
		y = sq.xor(y, celBin[3]);
		
		return y;
	}
	
	public String F2 (String x, String KR5, String KM32) {
		String[] celBin;
		String y;
		celBin = listaCelulasBinarias(divideParticao(x, KR5, KM32));
		
		y = sq.subMod32(celBin[0], celBin[1]);
		y = sq.xor(y, celBin[2]);
		y = sq.somaMod32(y, celBin[3]);
		
		return y;
	}
	
	public String F3 (String x, String KR5, String KM32) {
		String[] celBin;
		String y;
		celBin = listaCelulasBinarias(divideParticao(x, KR5, KM32));
		
		y = sq.xor(celBin[0], celBin[1]);
		y = sq.somaMod32(y, celBin[2]);
		y = sq.subMod32(y, celBin[3]);
		
		return y;
	}
}
