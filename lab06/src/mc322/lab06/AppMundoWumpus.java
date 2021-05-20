package mc322.lab06;

import java.util.Scanner;

public class AppMundoWumpus
{
    public static void main(String[] args) {
        Montador m = new Montador();
        Caverna c;
        Scanner teclado = new Scanner(System.in);

        m.setEntrada("lab06/data/caverna1.csv");
        c = m.montarCaverna();
        c.imprimir();
        System.out.println();
        Heroi h = m.getHeroi();
        Controle controle = new Controle(h);
        char comando;
        boolean vivo = true;
        while (vivo)
        {
            comando = teclado.next().charAt(0);
            System.out.println(comando);
            switch (comando) {
                case 'e':
                    controle.equiparFlecha();
                    break;
                case 'c':
                    controle.capturarOuro();
                    break;
                default:
                    vivo = controle.movimento(comando);
                    break;
            }
            controle.apresentar();
        }
        
        

        // m.setEntrada("lab06/data/caverna2.csv");
        // c.imprimir();
        // System.out.println();
        // m.setEntrada("lab06/data/caverna3.csv");
        // c = m.montarCaverna();
        // c.imprimir();

    }
}