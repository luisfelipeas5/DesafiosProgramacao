import java.util.Random;

public class TesteDasSolucoes{
	public static void main(String[] args){
		Random random = new Random();
		for(int i = 1; i < Integer.MAX_VALUE; i++){
			int a = random.nextInt(1000000 - 2) + 1;
			int b = random.nextInt(1000000 - 2) + 1;
			
			if(b < a){
				int aux = a;
				a = b;
				b = aux;
			}
						
			String saidaSimplista = solucaoSimplista(a, b);
			String saidaAlternativa = solucaoAlternativa(a, b);
			if(!saidaSimplista.equals(saidaAlternativa)){
				System.out.println(a + ", " + b);
				System.out.println(saidaSimplista);
				System.out.println(saidaAlternativa);
				System.out.println();
			}
		}
	}
	
	//dado limiteA e limiteB, sendo que limiteA < limiteB
	static String solucaoSimplista(int limiteA, int limiteB){
		long[] ocorrencias = new long[10];
		
		//iteração sobre todos os itens do intervalo
		for(int i = limiteA;  i <= limiteB; i++ ){			
			int iCopia = i;
			while(iCopia > 0){
				int sobra = iCopia%10; //separa o ultimo algarismo
			
				ocorrencias[sobra] += 1; //conta a ocorrencia do numero separado
				iCopia = iCopia/10;
			}
		}
		
		String saida = "";
		for(int i = 0; i < ocorrencias.length; i++){
			saida += ocorrencias[i] + " ";
		}
		
		return saida.trim();
	}
	
	static String solucaoAlternativa(long limiteA, long limiteB){
		long[] ocorrencias = new long[10];		
		
		int ordem = 1;
		
		while(limiteA > 0 || limiteB > 0){
		
			//Aproxima o limiteA até ser por divisível por 10
			while(limiteA <= limiteB && limiteA%10 != 0){			
				for(long i = limiteA; i > 0; i = i/10){
					int sobra = (int) (i%10);
					ocorrencias[sobra] += 1 * ordem;
				}
			
				limiteA++;
			}
		
			//Aproxima o limiteB até ser por divisível por 10
			while(limiteA <= limiteB && limiteB%10 != 0){
				for(long i = limiteB; i > 0; i = i/10){
					int sobra = (int) (i%10);
					ocorrencias[sobra] += 1 * ordem;
				}
			
				limiteB--;
			}
			
			if(limiteA > limiteB){
				break;
			}
			
			if(limiteB%10 == 0){
				for(long i = limiteB; i > 0; i = i/10){
					int sobra = (int) (i%10);
					ocorrencias[sobra] += 1 * ordem;
				}
			}
			
			long gap = (limiteB - limiteA)/10;
			for(int i = 0; i < ocorrencias.length; i++){
				ocorrencias[i] += gap * ordem;
			}
		
			limiteA = limiteA/10;
			limiteB = limiteB/10 - 1;
			
			ordem = ordem*10;
		}
		
		String saida = "";
		for(int i = 0; i < ocorrencias.length; i++){
			saida += ocorrencias[i] + " ";
		}
		
		return saida.trim();
	}
}
