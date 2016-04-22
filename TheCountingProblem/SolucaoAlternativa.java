import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SolucaoAlternativa{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		String entrada = scanner.nextLine();
		while(!entrada.equals("0 0")){
			String[] split = entrada.split(" ");
			
			int limiteA, limiteB;
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
	
	static String solucaoAlternativa(int limiteA, int limiteB){
		long[] ocorrencias = new long[10];
		
		for(int i = limiteA;  i <= limiteB; i++ ){			
			int iCopia = i;
			while(iCopia > 0){
				int sobra = iCopia%10;
			
				ocorrencias[sobra] += 1;
				iCopia = iCopia/10;
			}
		}
		
		String saida = "";
		for(int i = 0; i < ocorrencias.length; i++){
			saida += ocorrencias[i] + " ";
		}
		
		return saida.trim();
	}
}
