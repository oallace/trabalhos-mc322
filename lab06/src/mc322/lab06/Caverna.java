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
        
        setComponente(0, 0, new Heroi());
    }
    
    
    public void setComponente(int iComponente, int jComponente, Componente componente) {
    	this.salas[iComponente][jComponente].setComponentePrimario(componente);
    }
    
    public Sala getSala(int iSala, int jSala) {
    	return this.salas[iSala][jSala];
    }

    // recebe uma solicitação e executa a movimentação do herói se for possivel.
    public void SolicitaMovimento(char comando)
    {
        //
    }
}
