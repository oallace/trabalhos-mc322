package mc322.lab06;

public class Sala {
	private char visivel;   // '#' Uma sala é visível (Já foi percorrida pelo herói) ; '-' A sala ainda não é visível.
	private int posicao[] = new int[2];
	private Componente componentePrimario;
	private Componente componenteSecundario;
	private Caverna caverna;
	
	
	
	Sala(Caverna caverna, int iSala, int jSala, Componente componentePrimario, Componente componenteSecundario) {
		this.caverna = caverna;
		this.visivel = '-';
		this.componentePrimario = componentePrimario;
		this.componenteSecundario = componenteSecundario;
		this.posicao[0] = iSala;
		this.posicao[1] = jSala;
	}
	
	
	public int[] getPosicao() {
		return this.posicao;
	}
	
	public void setVisivel() {
		this.visivel = '#';
	}
	
	
	public Componente getComponentePrimario(){
		return this.componentePrimario;
	}
	
	
	public boolean setComponentePrimario(Componente componente){
		if (this.componentePrimario == null) {
			this.componentePrimario = componente;
			return true;
		}
		
		return false;
	}
	
	
	public Componente getComponenteSecundario(){
		return this.componenteSecundario;
	}
	
	
	public boolean setComponenteSecundario(Componente componente){
		if (this.componenteSecundario == null || this.componenteSecundario instanceof Brisa) {
			this.componenteSecundario = componente;
			return true;
		}
		
		return false;
	}
	
	
	public char representacao() {
		if (this.visivel == '#') {
			if (this.componentePrimario != null) {
				return this.componentePrimario.representacao();
			}
			else if (this.componenteSecundario != null) {
				return this.componenteSecundario.representacao();
			}
			else {
				return '#';
			}
			
		}
		
		return '-';
	}
}
