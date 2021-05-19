package mc322.lab06;

public class Sala {
	private boolean visitada;
	private int posicao[] = new int[2]; // é preciso?
	private Componente componentes []; //lista de componente onde o índice representa a prioridade do componente
	private static int numeroPrioridades = 4;

	
	Sala(int iSala, int jSala) {
		this.visitada = false;
		this.componentes = new Componente[numeroPrioridades];
		for (int i = 0; i < numeroPrioridades; i++)
			this.componentes[i] = null;
		this.posicao[0] = iSala;
		this.posicao[1] = jSala;
	}
	
	public int[] getPosicao() {
		return this.posicao;
	}
	
	public void visitar() {
		this.visitada = true;
	}

	public boolean foiVisidata()
	{
		if (visitada)
			return true;
		return false;
	}

	// Retorna o componente de prioridade informada se a sala foi visitada
	public Componente getComponente(int prioridade)
	{
		if (foiVisidata())
			return componentes[prioridade];
		else
			return null;
	}

	// Seta e retorna true quando a atribuição de um componente à sala for válida.
	public boolean setComponente(Componente c)
	{
		int i = c.getPrioridade();

		if(componentes[i] == null)
		{
			componentes[i] = c;
			if (i == 1) // componente do tipo heroi
				visitar();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// remove e retorna a componente da sala de acordo com a prioridade informada
	public Componente removerComponente(int prioridade)
	{
		Componente res;
		res = componentes[prioridade];
		componentes[prioridade] = null;
		return res;
	}

	// Retorna um caractere que representa a Sala.
	public char representacao() {
		if (visitada) {
			for (int i = 0; i < numeroPrioridades; i++)
				if (componentes[i] != null)
					return componentes[i].representacao();
			return '#';			
		}
		else
			return '-';
	}
}
