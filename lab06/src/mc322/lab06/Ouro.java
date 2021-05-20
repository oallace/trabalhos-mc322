package mc322.lab06;

public class Ouro extends Componente {

	Ouro(Caverna caverna, int iComponente, int jComponente) {
		super(caverna, iComponente, jComponente);
		this.prioridade = 0;
	}

	public char representacao() {
		return 'O';
	}
}
