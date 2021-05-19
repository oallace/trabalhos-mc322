package mc322.lab06;


public class Heroi extends Componente
{
    /**
     * O herói deve ser uma componente do tipo agente inteligente, ou seja,
     * deve ter conhecimento sobre si e sobre a caverna.
     * Portanto deve ser capaz de se comunicar com a caverna e solicitar
     * informações. 
     * Além disso, o herói é quem recebe os comandos no teclado e realiza
     * as movimentações do jogo*/
    Heroi(Caverna caverna, int iComponente, int jComponente, String Name){
    	super(caverna, iComponente, jComponente, Name);
    }

}
