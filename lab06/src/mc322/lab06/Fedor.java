package mc322.lab06;

public class Fedor extends Componente {

	Fedor(Caverna caverna, int iComponente, int jComponente) {
		super(caverna, iComponente, jComponente);
		this.prioridade = 2;
	}

	public char representacao() {
		return 'f';
	}
}
