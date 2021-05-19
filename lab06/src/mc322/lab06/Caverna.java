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
		if ((i >= 0 && i < 4) && (j >= 0 && j < 4))
            return true;
        else
            return false;
	}
    
    // Requisita o componente de salas já visitadas:
    public Componente getComponente(int i, int j, int prioridade)
    {
        return salas[i][j].getComponente(prioridade);
    }
	
    public boolean setComponente(int iComponente, int jComponente, Componente componente) {
    	if (ehEspacoValido(iComponente, jComponente))
            return this.salas[iComponente][jComponente].setComponente(componente);
        return false;
    }

    // É a melhor forma de implementar?
    public Componente removerComponente(int i, int j, int prioridade)
    {
        return salas[i][j].removerComponente(prioridade);
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
    		System.out.print("  " + (i+1));
    	}
    }
}
