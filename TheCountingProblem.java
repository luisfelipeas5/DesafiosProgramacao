import java.util.Scanner;

class TheCountingProblem{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		String entrada = scanner.nextLine();
		while(!entrada.equals("0 0")){
			String[] split = entrada.split(" ");
			
			int limiteA = Integer.parseInt(split[0]);
			int limiteB = Integer.parseInt(split[1]);
			
			int[] ocorrencias = new int[10];
			int passo = 1;
			if(limiteA > limiteB){
				passo = -1;
			}
			
			for(int i = limiteA;  i != limiteB + passo; i += passo ){
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
			//System.out.println(limiteA + " -> " + limiteB);
			System.out.println(saida.trim());
			
			entrada = scanner.nextLine();
		}
		
		scanner.close();
	}
}
