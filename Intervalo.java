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
