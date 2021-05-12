package mc322.lab06;

public class Componente
{
	Caverna caverna;
	int posicao[] = new int[2];
	
	
	
	Componente(Caverna caverna, int iComponente, int jComponente) {
		this.caverna = caverna;
		this.posicao[0] = iComponente;
		this.posicao[1] = jComponente;
	}
	
	
	
	public Caverna getCaverna() {
		return this.caverna;
	}
	
	
	public int[] getPosicao() {
		return this.posicao;
	}
	
	
	public void setPosicao(int iPosicaoFinal, int jPosicaoFinal) {
		this.posicao[0] = iPosicaoFinal;
		this.posicao[1] = jPosicaoFinal;
	}
	
	
	// Determinado Componente Primário inicializa seus componentes secundários nas salas.
	public void setComponentesSecundarios() {
		if (this instanceof Buraco)
			Brisa componenteSecundario = new Brisa();
		
		else (this instanceof Wumpu)
			Fedor componenteSecundario = new Fedor();
		
		// Colocar abaixo o componenteSecundario nas posicoes disponiveis ao redor do componente primario (this)
		
	}
	
	
	public char representacao() {
		return '0';
	}
}
