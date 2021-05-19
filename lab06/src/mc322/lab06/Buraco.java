package mc322.lab06;

public class Buraco extends Componente {

	Buraco(Caverna caverna, int iComponente, int jComponente){
    	super(caverna, iComponente, jComponente);
		prioridade = 0;
	}


	public void removerComponente()
	{
		super.removerComponente();
		// remover brisas
	}

	public char representacao()
	{
		return 'B';
	}
}
