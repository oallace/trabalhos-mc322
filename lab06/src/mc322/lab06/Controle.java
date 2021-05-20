package mc322.lab06;

import java.util.Random;

public class Controle {
    private Heroi heroi;
    private Componente componenteAtual; // Componente de prioridade zero da casa sobre a qual o heroi está

    Controle(Heroi heroi) {
        this.heroi = heroi;
        this.componenteAtual = null;
    }

    public char movimento(char mov) {
        componenteAtual = heroi.movimento(mov);
        if (componenteAtual != null)
            if (componenteAtual.representacao() == 'W') {
                // enfrenta o Wumpus;
                if (heroi.dispararFlecha()) {
                    Random gerador = new Random();
                    if (gerador.nextBoolean()) {
                        componenteAtual.removerComponente();
                        componenteAtual = null;
                        heroi.marcarPontuacao(500);
                        return 'v';
                    }
                }
                heroi.marcarPontuacao(-1000);
                return 'w';
            } else if (componenteAtual.representacao() == 'B') {
                // cai no buraco;
                heroi.marcarPontuacao(-1000);
                return 'b';
            }
        heroi.dispararFlecha();
        return 's';
    }

    public boolean deixarCaverna() {
        if (heroi.getOuro() != null) {
            heroi.marcarPontuacao(1000);
            return true;
        }
        return false;
    }

    public boolean equiparFlecha() {
        return heroi.equiparFlecha();
    }

    public boolean capturarOuro() {
        if (componenteAtual != null && componenteAtual.representacao() == 'O') {
            heroi.capturarOuro(componenteAtual);
            return true;
        }
        return false;
    }

    public void apresentar() {
        heroi.caverna.imprimir();
        heroi.apresentar();
    }
}
