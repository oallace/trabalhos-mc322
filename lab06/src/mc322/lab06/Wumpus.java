package mc322.lab06;

public class Wumpus extends Componente{
	
	Wumpus(Caverna caverna, int iComponente, int jComponente){
    	super(caverna, iComponente, jComponente);
		this.prioridade = 0;
	}

	public boolean acomodarCompontente()
	{
		Fedor f; 
		f = new Fedor(caverna, posicao[0] - 1, posicao[1]);
		f.acomodarCompontente();
		f = new Fedor(caverna, posicao[0] + 1, posicao[1]);
		f.acomodarCompontente();
		f = new Fedor(caverna, posicao[0], posicao[1] - 1);
		f.acomodarCompontente();
		f = new Fedor(caverna, posicao[0], posicao[1] + 1);
		f.acomodarCompontente();
		return super.acomodarCompontente();
	}

	public char representacao()
	{
		return 'W';
	}
}
