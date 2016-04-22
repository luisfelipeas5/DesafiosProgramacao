import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SolucaoProgramacaoDinamica{
	static Map<Integer, Intervalo> intervalosCalculados = new HashMap<>();

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
			
			String saida = solucaoProgramacaoDinamica(limiteA, limiteB);
			System.out.println(saida);
			
			entrada = scanner.nextLine();
		}
		
		scanner.close();
	}
	
	static String solucaoProgramacaoDinamica(int limiteA, int limiteB){
		long[] ocorrencias = new long[10];
		
		for(int i = limiteA;  i <= limiteB; i++ ){
			//Conferir se um intervalo a partir de i já foi calculado
			Intervalo intervalo = intervalosCalculados.get(i);
			if(intervalo != null){
				int intervaloLimiteB = intervalo.getLimiteB();
				//System.out.println("\tIntervalo Calculado encontrado " + intervaloLimiteB);
				if(intervaloLimiteB < limiteB){
					//adicionar as ocorrencias do intervalo já calculado as ocorrencias corrente
					long[] intervaloOcorrencias = intervalo.getOcorrencias();
					for(int j = 0; j < ocorrencias.length; j++){
						ocorrencias[j] += intervaloOcorrencias[j];
					}
			
					//int intervaloLimiteA = intervalo.getLimiteA();
					i = intervaloLimiteB;
					continue;
				}
			}				
		
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
		
		//adicionar intervalo as Ocorrencias dos Intervalos Calculados
		Intervalo intervaloCorrente = intervalosCalculados.get(limiteA);
		if(intervaloCorrente == null){
			intervaloCorrente = new Intervalo(limiteA, limiteB, ocorrencias);
			intervalosCalculados.put(limiteA, intervaloCorrente);
		} else{
			if(intervaloCorrente.getLimiteB() < limiteB){
				intervaloCorrente.setLimiteB(limiteB);
				intervaloCorrente.setOcorrencias(ocorrencias);
				intervalosCalculados.put(limiteA, intervaloCorrente);
			}
		}
		
		
		return saida.trim();
	}
}

class Intervalo{
	private int limiteA;
	private int limiteB;
	private long[] ocorrencias;
	
	public Intervalo(int limiteA, int limiteB, long[] ocorrencias){
		this.limiteA = limiteA;
		this.limiteB = limiteB;
		this.ocorrencias = ocorrencias;
	}
	
	public int getLimiteB(){
		return limiteB;
	}
	
	public void setLimiteB(int limiteB){
		this.limiteB = limiteB;
	}
	
	public long[] getOcorrencias(){
		return ocorrencias;
	}	
	
	public void setOcorrencias(long[] ocorrencias){
		this.ocorrencias = ocorrencias;
	}
}
