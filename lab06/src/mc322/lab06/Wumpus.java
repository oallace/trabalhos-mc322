package mc322.lab06;

public class Wumpus extends Componente{
	
	Wumpus(Caverna caverna, int iComponente, int jComponente){
    	super(caverna, iComponente, jComponente);
		this.prioridade = 0;
	}

	public char representacao()
	{
		return 'W';
	}
}
