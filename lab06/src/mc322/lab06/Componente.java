package mc322.lab06;

public abstract class Componente {
	protected Caverna caverna;
	protected int posicao[] = new int[2];
	protected int prioridade;

	/**
	 * @param prioridade: indica a prioridade do componente sendo elas 0: Wumpus,
	 *                    Buraco e Ouro; 1: Herói; 2: Fedor; 3: Brisa. Uma sala não
	 *                    suporta dois componentes de mesma prioridade.
	 */

	Componente(Caverna caverna, int iComponente, int jComponente) {
		this.caverna = caverna;
		setPosicao(iComponente, jComponente);
		this.prioridade = -1;
	}

	public int[] getPosicao() {
		return this.posicao;
	}

	public void setPosicao(int i, int j) {
		this.posicao[0] = i;
		this.posicao[1] = j;
	}

	public int getPrioridade() {
		return this.prioridade;
	}

	// Acomoda o componente na sua sala correspondente.
	// Retorna true se o componente pôde ser alocado.
	public boolean acomodarCompontente() {
		return caverna.setComponente(posicao[0], posicao[1], this);
	}

	// Remove o componente da sala
	public void removerComponente() {
		caverna.removerComponente(this.posicao[0], this.posicao[1], this.prioridade);
	}

	public abstract char representacao();

}
