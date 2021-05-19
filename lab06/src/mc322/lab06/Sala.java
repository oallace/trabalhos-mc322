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
			this.componentes = null;
		this.posicao[0] = iSala;
		this.posicao[1] = jSala;
	}
	
	public int[] getPosicao() {
		return this.posicao;
	}
	
	public void visitar() {
		this.visitada = true;
	}
	
	// Seta e retorna true quando a atribuição de um componente à sala for válida.
	public boolean setComponente(Componente c)
	{
		int i = c.getPrioridade();

		if(componentes[i] == null)
		{
			componentes[i] = c;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	// Retorna um caractere que representa a Sala.
	public char representacao() {
		if (visitada) {
			for (int i = 0; i < numeroPrioridades; i++)
				if (componentes[i] != null)
					return componentes[i].representacao();
			return '#';			
		}
		return '-';
	}
}
