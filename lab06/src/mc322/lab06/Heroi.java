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
    }

    public char representacao()
    {
        return 'P';
    }

}
