package mc322.lab06;

public class Caverna
{
    private Sala salas[][];

    
    Caverna()
    {
        salas = new Sala[4][4];
        
        for (int i = 0; i < 4; i++) {
        	for (int j = 0; j < 4; j++) {
        		salas[i][j] = new Sala(i, j);
        	}
        }
    }
    
    public static boolean ehEspacoValido(int i, int j)
	{
		return true;
	}
    
	public boolean setComponente(int iComponente, int jComponente, Componente componente) {
    	return this.salas[iComponente][jComponente].setComponente(componente);
    }
    
    // Falta analisar o caso em que ele tenta sair da caverna sem o Ouro.
    public int analisarFimDeMovimento(int iComponente, int jComponente, Componente Heroi) {
    	return 1;
    }

    
    // recebe uma solicitação e executa a movimentação do herói se for possivel.
    public void solicitaMovimento(char comando)
    {
        //
    }
    
    
    public void imprimir() {
    	for (int i = 0; i < 4; i++) {
    		System.out.print(i+1);
    		for (int j = 0; j < 4; j++) {
    			System.out.print(" " + this.salas[i][j].representacao());
    		}
    		System.out.println();
    	}
    	for (int i = 0; i < 4; i++) {
    		System.out.print(" " + i+1);
    	}
    }
}
