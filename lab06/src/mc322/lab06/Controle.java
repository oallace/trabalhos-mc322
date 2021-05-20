package mc322.lab06;

import java.util.Random;

public class Controle {
    private Heroi heroi;
    private Componente componenteAtual; // Componente de prioridade zero da casa sobre a qual o heroi está

    Controle(Heroi heroi)
    {
        this.heroi = heroi;
        this.componenteAtual = null;
    }

    public boolean movimento(char mov)
    {
        componenteAtual = heroi.movimento(mov);
        if (componenteAtual != null)
            if (componenteAtual.representacao() == 'W')
            {
                // enfrenta o Wumpus;
                if (heroi.dispararFlecha())
                {
                    Random gerador = new Random();
                    if (gerador.nextBoolean())
                    {
                        componenteAtual.removerComponente();
                        componenteAtual = null;
                        return true;
                    }
                }
                return false;
            }
            else if (componenteAtual.representacao() == 'B')
            {
                // cai no buraco;
                return false;
            }
            heroi.dispararFlecha();
            return true;
    }

    public void equiparFlecha()
    {
        heroi.equiparFlecha();
    }

    public void capturarOuro()
    {
        if (componenteAtual != null && componenteAtual.representacao() == 'O')
        {
            heroi.capturarOuro(componenteAtual);
        }
    }

    public void apresentar()
    {
        heroi.caverna.imprimir();
        heroi.apresentar();
    }
}
