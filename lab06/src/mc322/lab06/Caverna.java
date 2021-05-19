package mc322.lab06;

public class Caverna
{
    private Sala salas[][];

    
    Caverna()
    {
        salas = new Sala[4][4];
        
        for (int i = 0; i < 4; i++) {
        	for (int j = 0; j < 4; j++) {
        		salas[i][j] = new Sala(this, i, j, null, null);
        	}
        }
        
        setComponente(0, 0, new Heroi()); // setar a posicao na variavel heroi
    }
    
    
    public boolean setComponente(int iComponente, int jComponente, Componente componente) {
    	if (this.salas[iComponente][jComponente].setComponentePrimario(componente)) {
    		if (componente instanceof Buraco || componente instanceof Wumpus) {
    			componente.setComponentesSecundarios();
    		}
    		return true;
    	}
    	return false;
    }
    
    
    public Sala getSala(int iSala, int jSala) {
    	return this.salas[iSala][jSala];
    }
    
    
    // Falta analisar o caso em que ele tenta sair da caverna sem o Ouro.
    public int analisarFimDeMovimento(int iComponente, int jComponente, Componente Heroi) {
    	if (this.salas[iComponente][jComponente].getComponentePrimario() instanceof Buraco) {
    		return 0;
    	}
    	
    	else if (this.salas[iComponente][jComponente].getComponentePrimario() instanceof Wumpus) {
    		return Heroi.iniciarLuta();
    	}
    	
    	else if (this.salas[iComponente][jComponente].getComponentePrimario() instanceof Ouro) {
    		Heroi.pegarOuro();
    		return 1;
    	}
    	
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
