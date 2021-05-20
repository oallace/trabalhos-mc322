package mc322.lab06;

public class Heroi extends Componente {
    private String nome;
    private int pontuacao;
    private int numeroFlechas;
    private boolean flechaEquipada;
    private Componente ouro;

    Heroi(Caverna caverna, int iComponente, int jComponente, String nome) {
        super(caverna, iComponente, jComponente);
        this.nome = nome;
        this.pontuacao = 0;
        this.numeroFlechas = 1;
        this.flechaEquipada = false;
        this.ouro = null;
        this.prioridade = 1;
    }

    // Realiza um movimento e retorna um ponteiro para o componente principal da
    // sala de destino.
    public Componente movimento(char mov) {
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
        if (Caverna.ehEspacoValido(iDestino, jDestino)) {
            // tirar heroi da origem (coordenadas atuais)
            this.removerComponente();
            // mover para o destino
            caverna.setComponente(iDestino, jDestino, this);
            this.posicao[0] = iDestino;
            this.posicao[1] = jDestino;
            marcarPontuacao(-15);
            return caverna.getComponente(iDestino, jDestino, 0); // Retorna o componente de prioridade 0 na sala para
                                                                 // qual o heroi se movimentou
        }

        return null;
    }

    public void marcarPontuacao(int soma) {
        this.pontuacao += soma;
    }

    public boolean equiparFlecha() {
        if (numeroFlechas > 0) {
            flechaEquipada = true;
            numeroFlechas--;
            marcarPontuacao(-100);
            return true;
        }
        return false;
    }

    public boolean dispararFlecha() {
        boolean res = flechaEquipada;
        flechaEquipada = false;
        return res;
    }

    public void capturarOuro(Componente ouro) {
        ouro.removerComponente();
        this.ouro = ouro;
    }

    public Componente getOuro() {
        return ouro;
    }

    public char representacao() {
        return 'P';
    }

    public void apresentar() {
        System.out.println("Player: " + nome);
        System.out.println("Score: " + pontuacao);
        System.out.println("Flechas: " + numeroFlechas);
        if (flechaEquipada)
            System.out.println("]--->");

    }

}
