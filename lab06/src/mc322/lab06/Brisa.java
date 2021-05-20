package mc322.lab06;

public class Brisa extends Componente {

	Brisa(Caverna caverna, int iComponente, int jComponente) {
		super(caverna, iComponente, jComponente);
		this.prioridade = 3;
	}

	public char representacao() {
		return 'b';
	};
}
