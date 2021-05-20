package mc322.lab06;

public class Wumpus extends Componente {

	Wumpus(Caverna caverna, int iComponente, int jComponente) {
		super(caverna, iComponente, jComponente);
		this.prioridade = 0;
	}

	public boolean acomodarCompontente() {
		Fedor f;
		// Cria os Fedores do Wumpus:
		f = new Fedor(caverna, posicao[0] - 1, posicao[1]);
		f.acomodarCompontente();
		f = new Fedor(caverna, posicao[0] + 1, posicao[1]);
		f.acomodarCompontente();
		f = new Fedor(caverna, posicao[0], posicao[1] - 1);
		f.acomodarCompontente();
		f = new Fedor(caverna, posicao[0], posicao[1] + 1);
		f.acomodarCompontente();
		// Acomoda o Wumpus:
		return super.acomodarCompontente();
	}

	public void removerComponente() {
		super.removerComponente();
		// Remove os fedores do Wumpus:
		caverna.removerComponente(this.posicao[0] - 1, this.posicao[1], 2);
		caverna.removerComponente(this.posicao[0] + 1, this.posicao[1], 2);
		caverna.removerComponente(this.posicao[0], this.posicao[1] - 1, 2);
		caverna.removerComponente(this.posicao[0], this.posicao[1] + 1, 2);

	}

	public char representacao() {
		return 'W';
	}
}
