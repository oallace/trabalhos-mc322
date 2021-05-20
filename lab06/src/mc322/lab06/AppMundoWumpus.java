package mc322.lab06;

import java.util.Scanner;

public class AppMundoWumpus {
    public static void main(String[] args) {
        Montador m = new Montador();
        Caverna c;
        Scanner teclado = new Scanner(System.in);

        m.setEntrada("lab06/data/caverna3.csv");
        c = m.montarCaverna("Wall-e");
        Heroi h = m.getHeroi();
        Controle controle = new Controle(h);
        controle.apresentar();
        char comando;
        boolean vivo = true;
        while (vivo) {
            String mensagem = "-";
            comando = teclado.next().charAt(0);
            switch (comando) {
                case 'e':
                    if (controle.equiparFlecha())
                        mensagem = "-";
                    else
                        mensagem = "As flechas acabaram :O";
                    break;
                case 'c':
                    if (controle.capturarOuro()) {
                        mensagem = "Você Ganhou :D!!!";
                    } else {
                        mensagem = "Não há nenhum ouro aqui :(\nQuem sabe na próxima sala?";
                    }

                    break;
                case 'q':
                    if (controle.deixarCaverna()) {
                        vivo = false;
                        mensagem = "Volte Sempre!";
                    } else {
                        mensagem = "Você não pode deixar a caverna sem o Ouro!";
                    }
                    break;
                default:
                    switch (controle.movimento(comando)) {
                        case 's': // movimento executado
                            vivo = true;
                            mensagem = "-";
                            break;
                        case 'v':
                            vivo = true;
                            mensagem = "Você derrotou o Wumpus!!! ><";
                            break;
                        case 'w':
                            vivo = false;
                            mensagem = "Parece que o Wumpus te pegou :\\";
                            break;
                        case 'b':
                            vivo = false;
                            mensagem = "Cuidado onde pisa!";
                    }
                    break;
            }
            controle.apresentar();
            System.out.println(mensagem);
        }

    }
}