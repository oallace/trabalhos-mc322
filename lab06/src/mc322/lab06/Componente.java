package mc322.lab06;

public abstract class Componente
{
	protected Caverna caverna;
	protected Sala sala;
	protected int posicao[] = new int[2];
	protected int score;
	protected boolean flecha;
	protected String Name;
	
	
	Componente(Caverna caverna, int iComponente, int jComponente, String Name) {
		this.caverna = caverna;
		this.sala = null;
		this.posicao[0] = iComponente;
		this.posicao[1] = jComponente;
		this.score = 0;
		this.flecha = true;
		this.Name = Name;
	}
	
	
	public Caverna getCaverna() {
		return this.caverna;
	}
	
	public Sala getSala() {
		return this.sala;
	}
	
	public void setSala(Sala sala) {
		this.sala = sala;
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
		Componente componente;
		int iAtual = this.posicao[0];
		int jAtual = this.posicao[1];
		
		if ((iAtual-1) >= 0) {
			componente = (this instanceof Wumpus) ? new Fedor(this.caverna, iAtual-1, jAtual, "Fedor") : new Brisa(this.caverna, iAtual-1, jAtual, "Brisa");
			this.caverna.getSala(iAtual-1, jAtual).setComponenteSecundario(componente);
		}
		if ((iAtual+1) < 4) {
			componente = (this instanceof Wumpus) ? new Fedor(this.caverna, iAtual-1, jAtual, "Fedor") : new Brisa(this.caverna, iAtual-1, jAtual, "Brisa");
			this.caverna.getSala(iAtual+1, jAtual).setComponenteSecundario(componente);
		}
		if ((jAtual-1) >= 0) {
			componente = (this instanceof Wumpus) ? new Fedor(this.caverna, iAtual-1, jAtual, "Fedor") : new Brisa(this.caverna, iAtual-1, jAtual, "Brisa");
			this.caverna.getSala(iAtual, jAtual-1).setComponenteSecundario(componente);
		}
		if ((jAtual+1) < 4) {
			componente = (this instanceof Wumpus) ? new Fedor(this.caverna, iAtual-1, jAtual, "Fedor") : new Brisa(this.caverna, iAtual-1, jAtual, "Brisa");
			this.caverna.getSala(iAtual, jAtual+1).setComponenteSecundario(componente);
		}
		
		
	}
	
	
	public abstract void iniciarLuta();
	
	public abstract void pegarOuro();
	
	public abstract void destruirComponente();
	
	public abstract char representacao();
}
