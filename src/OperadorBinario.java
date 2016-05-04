
public class OperadorBinario {
	public String xor (String bin1, String bin2) {
		int n = bin1.length();
		int val1, val2, res;
		String resp = "";
		
		for (int i = 0; i < n; i++) {
			val1 = bin1.charAt(i);
			val2 = bin2.charAt(i);
			res = val1 ^ val2;
			resp = resp.concat(String.valueOf(res));
		}
		return resp;
	}
	
	public int comprimentoBinario (String seq) {
		return seq.length();
	}
	
	public String rotacionaEsquerda (String seq, int off) {
		int n = seq.length();
		off = off % n;
		String last;
		String sufixo = seq.substring(0, off);
		last = seq.substring(off, n);
		last = last.concat(sufixo);
		return last;
	}
	
	public String cincoBitsDaDireita (String str) {
		String res;
		
		int n = str.length();
		res = str.substring(n-5, n);
		
		return res;
	}
	
	public String[] separaBits (String seq, int numIntervalos) {
		String res[] = new String[numIntervalos];
		int n = seq.length();
		int offset = n/numIntervalos;
		int j = 0;
		
		for (int i = 0; i+offset <= n; i += offset) {
			res[j++] = seq.substring(i, i+offset);
		}	
		return res;
	}
	
	public String concatenaBits (String segs[]) {
		String res = String.valueOf(segs[0]);
		
		for (int i = 1; i <= 3; i++) {
			res = res.concat(segs[i]);
		}
		
		return res;
	}
	
	public String somaMod32 (String bin1, String bin2) {
		long dec1 = Long.parseLong(Conversor.binToDec(bin1));
		long dec2 = Long.parseLong(Conversor.binToDec(bin2));
		long soma = (dec1+dec2) % ((long) Math.pow(2, 32));
				
		String res = Conversor.decToBin(String.valueOf(soma));
		res = completaComZero(res, 32);
		
		return res;
	}
	
	public String subMod32 (String bin1, String bin2) {
		long dec1 = Long.parseLong(Conversor.binToDec(bin1));
		long dec2 = Long.parseLong(Conversor.binToDec(bin2));
		long sub = dec1-dec2;
		long size = ((long) Math.pow(2, 32)); 
		
		if (sub < 0) sub += size;
		
		sub %=  size;
				
		String res = Conversor.decToBin(String.valueOf(sub));
		res = completaComZero(res, 32);
		
		return res;
	}
	
	public String completaComZero (String seq, int total) {
		int qtd_atual = seq.length();
		int dif = total - qtd_atual;
		String last = String.valueOf(seq);
		String zero = "0";
		
		for (int i = 1; i <= dif; i++) {
			last = zero + last;
		}
		return last;
	}
}
