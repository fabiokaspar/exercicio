
public class Main {
	static String senha;
	static K128 alg;
	static ReadFileCBC rf; 
	
	public static void main (String args[]) {
		leiaEntradaTerminal(args);
	}
	
	public static void leiaEntradaTerminal (String args[]) {
		int senhaValida = 0;
		
		if (args.length == 7 || args.length == 8) {
			
			// Modo 1: criptografar
			if (args[0].equals("-c") && args[1].equals("-i")) {
				if (args[3].equals("-o") && args[5].equals("-p")) {		
					
					senhaValida = defineSenha16Bytes(args[6]);
					if (senhaValida < 0)
						System.exit(0);
					
					alg = new K128(senha);
					rf = new ReadFileCBC(alg); 
					rf.criptaArquivoEmCBC(args[2], args[4], null);
	
					if (args.length == 8 && args[7].equals("-a")) {
						// efetuar a gravação de brancos e deleção da entrada
						
					}
				}
			}
			
			// Modo 2: decriptografar
			else if (args[0].equals("-d") && args[1].equals("-i")) {
				if (args[3].equals("-o") && args[5].equals("-p")) {
					
					senhaValida = defineSenha16Bytes(args[6]);
					if (senhaValida < 0)
						System.exit(0);
					
					alg = new K128(senha);
					rf = new ReadFileCBC(alg);
					rf.decriptaArquivoEmCBC(args[2], args[4]);
				}
			}
		}
		
		if (args.length == 5) {
			
			// Modo 3: aleatoriedade método 1
			if (args[0].equals("-1") && args[1].equals("-i")) {
				if (args[3].equals("-p")) {
	
					senhaValida = defineSenha16Bytes(args[4]);				
					if (senhaValida < 0)
						System.exit(0);
					
					alg = new K128(senha);
					//rf = new ReadFile(alg, args[2], "saida.txt");
					
				}
			}
			
			// Modo 4: aleatoriedade método 2
			else if (args[0].equals("-2") && args[1].equals("-i")) {
				if (args[3].equals("-p")) {
					
					senhaValida = defineSenha16Bytes(args[4]);
					if (senhaValida < 0)
						System.exit(0);
					
					alg = new K128(senha);
					//rf = new ReadFile(alg, args[2], "saida.txt");
				}
			}
		}
	}
	
	public static int defineSenha16Bytes (String pass) {
		int qtdLetrasGrandes = 0;
		int qtdAlgarismos = 0;
		int code;
		
		String ret = new String();
		int n = pass.length();
		
		if (n < 8) {
			System.out.println("A senha deve conter (no mínimo):\n\n1) 2 letras maiúsculas\n2) 2 dígitos decimais" +
					"\n3) 8 bytes de comprimento");
			return -1;
		}
		else if (n >= 16) {
			ret = new String(String.valueOf(pass.substring(0, 16)));
		}
		else {
			ret = new String(String.valueOf(pass));
		}
		
		n = ret.length();
		
		for (int i = 0; i < n; i++) {
			code = (int)ret.charAt(i);
			
			if (code >= 48 && code <= 57) {
				qtdAlgarismos++;
			}
			
			else if (code >= 65 && code <= 90) {
				qtdLetrasGrandes++;
			}
		}
		
		if (qtdAlgarismos < 2 || qtdLetrasGrandes < 2) {
			System.out.println("A senha deve conter (no mínimo):\n\n1) 2 letras maiúsculas\n2) 2 dígitos decimais" +
					"\n3) 8 bytes de comprimento");
			return -2;
		}
		
		if (n < 16) {
			int faltam = 16-n;
			ret = new String(String.valueOf(ret.concat(ret.substring(0, faltam))));
		}
		
		senha = ret;
		System.out.println("senha final = "+ senha);
		
		return 1;
	}
	
}
