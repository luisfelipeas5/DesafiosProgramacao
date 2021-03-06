import java.util.Scanner;

public class SolucaoAlternativa{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		String entrada = scanner.nextLine();
		while(!entrada.equals("0 0")){
			String[] split = entrada.split(" ");
			
			long limiteA, limiteB;
			if(Integer.parseInt(split[0]) < Integer.parseInt(split[1])){
				limiteA = Integer.parseInt(split[0]);
				limiteB = Integer.parseInt(split[1]);	
			} else{
				limiteA = Integer.parseInt(split[1]);
				limiteB = Integer.parseInt(split[0]);
			}

			String saida = solucaoAlternativa(limiteA, limiteB);
			System.out.println(saida);
			
			entrada = scanner.nextLine();
		}
		
		scanner.close();
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
