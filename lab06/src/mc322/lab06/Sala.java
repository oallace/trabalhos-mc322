package mc322.lab06;

public class Sala {
	private boolean visitada;
	private int posicao[] = new int[2]; // a sala precisa ter conhecimento de sua posição?
	// pensar melhor essa listagem de componentes
	private Componente componentePrimario;
	private Componente componenteSecundario;

	
	Sala(int iSala, int jSala) {
		this.visitada = false;
		this.componentePrimario = null;
		this.componenteSecundario = null;
		this.posicao[0] = iSala;
		this.posicao[1] = jSala;
	}
	
	
	public int[] getPosicao() {
		return this.posicao;
	}
	
	public void visitar() {
		this.visitada = true;
	}
	
	
	public Componente getComponentePrimario(){
		return this.componentePrimario;
	}
	
	
	public boolean setComponentePrimario(Componente componente){
		if (this.componentePrimario == null) {
			this.componentePrimario = componente;
			componente.setSala(this);
			return true;
		}
		
		return false;
	}
	
	
	public Componente getComponenteSecundario(){
		return this.componenteSecundario;
	}
	
	
	public boolean setComponenteSecundario(Componente componente){
		// deve admitir mais de um componente secundario: caso em que o wunmpus é morto e temos que por brisa
		if (this.componenteSecundario == null || (this.componenteSecundario instanceof Brisa && componente instanceof Fedor)) {
			this.componenteSecundario = componente;
			componente.setSala(this);
			return true;
		}
		
		return false;
	}
	
	
	// Retorna um caractere que representa a Sala.
	public char representacao() {
		if (visitada) {
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
