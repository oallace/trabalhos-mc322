package mc322.lab06;

public abstract class Componente
{
	protected Caverna caverna;
	protected int posicao[] = new int[2];
	protected int prioridade;	
	
	Componente(Caverna caverna, int iComponente, int jComponente) {
		this.caverna = caverna;
		this.posicao[0] = iComponente;
		this.posicao[1] = jComponente;
		this.prioridade = -1;
	}
	
	public int[] getPosicao() {
		return this.posicao;
	}
	
	public void setPosicao(int iPosicaoFinal, int jPosicaoFinal) {
		this.posicao[0] = iPosicaoFinal;
		this.posicao[1] = jPosicaoFinal;
	}
	
	public int getPrioridade()
	{
		return this.prioridade;
	}

	// Acomoda o componente na sua sala correspondente
	public boolean acomodarCompontente()
	{
		return caverna.setComponente(posicao[0], posicao[1], this);
	}
	
	public abstract char representacao();

}
