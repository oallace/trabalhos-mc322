package mc322.lab06;


public class Heroi extends Componente
{
    private String nome;
    private int pontuacao;
    private int numeroFlechas;
    private Ouro ouro;

    Heroi(Caverna caverna, int iComponente, int jComponente, String nome){
    	super(caverna, iComponente, jComponente);
        this.nome = nome;
        this.pontuacao = 0;
        this.numeroFlechas = 1;
        this.ouro = null;
        this.prioridade = 1;
    }
    
    // Realiza um movimento e retorna um ponteiro para o componente principal da sala de destino.
    public Componente movimento(char mov)
    {
        int iDestino, jDestino;

        iDestino = this.posicao[0];
        jDestino = this.posicao[1];
        switch (mov) {
            case 'w':
                iDestino--;
                break;
            case 's':
                iDestino++;
                break;
            case 'a':
                jDestino--;
                break;
            case 'd':
                jDestino++;
                break;
            }
        // checar se o destino é válido
        if (Caverna.ehEspacoValido(iDestino, jDestino))
        {
            // tirar heroi da origem (coordenadas atuais)
            caverna.removerComponente(this.posicao[0], this.posicao[1], this.prioridade);
            // mover para o destino
            caverna.setComponente(iDestino, jDestino, this);
            this.posicao[0] = iDestino;
            this.posicao[1] = jDestino;
            return caverna.getComponente(iDestino, jDestino, 0);
        }

        return null;
    }

    public char representacao()
    {
        return 'P';
    }

}
