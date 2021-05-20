package mc322.lab06;

public class Buraco extends Componente {

	Buraco(Caverna caverna, int iComponente, int jComponente) {
		super(caverna, iComponente, jComponente);
		prioridade = 0;
	}

	public boolean acomodarCompontente() {
		Brisa b;
		// Cria as Brisas geradas pelo buraco:
		b = new Brisa(caverna, posicao[0] - 1, posicao[1]);
		b.acomodarCompontente();
		b = new Brisa(caverna, posicao[0] + 1, posicao[1]);
		b.acomodarCompontente();
		b = new Brisa(caverna, posicao[0], posicao[1] - 1);
		b.acomodarCompontente();
		b = new Brisa(caverna, posicao[0], posicao[1] + 1);
		b.acomodarCompontente();
		// Acomoda o buraco:
		return super.acomodarCompontente();
	}

	public char representacao() {
		return 'B';
	}
}
