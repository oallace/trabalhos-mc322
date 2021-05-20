package mc322.lab06;

import java.util.Scanner;

public class AppMundoWumpus {
    public static void main(String[] args) {
        Montador m = new Montador();
        Heroi heroi;
        Controle controle;
        char comando;
        boolean executando; // informa se o jogo está executando.
        String mensagem = "-";
        Scanner teclado = new Scanner(System.in);

        if (args.length != 2) {
            System.out.println("Você deve fornecer nome e arquivo de caverna!");
            teclado.close();
            return;
        }
        m.setEntrada(args[1]); // args[1]
        heroi = m.montarCaverna(args[0]); // args[0]
        controle = new Controle(heroi);
        controle.apresentar();
        executando = true;
        if (heroi == null) // não é possível montar a caverna
        {
            executando = false;
            System.out.println("Caverna inválida!");
        }
        while (executando) {
            comando = teclado.next().charAt(0);
            if (comando == 'w' || comando == 'a' || comando == 's' || comando == 'd') {
                switch (controle.movimento(comando)) {
                    case 's': // movimento executado
                        executando = true;
                        mensagem = "-";
                        break;
                    case 'v':
                        executando = true;
                        mensagem = "Você derrotou o Wumpus!!! ><";
                        break;
                    case 'w':
                        executando = false;
                        mensagem = "Parece que o Wumpus te pegou :\\";
                        break;
                    case 'b':
                        executando = false;
                        mensagem = "Cuidado onde pisa!";
                }
            } else if (comando == 'k') {
                if (controle.equiparFlecha())
                    mensagem = "-";
                else
                    mensagem = "As flechas acabaram :O";

            } else if (comando == 'c') {
                if (controle.capturarOuro()) {
                    mensagem = "Você Ganhou :D!!!";
                } else {
                    mensagem = "Não há nenhum ouro aqui :(\nQuem sabe na próxima sala?";
                }

            } else if (comando == 'q') {
                if (controle.deixarCaverna()) {
                    executando = false;
                    mensagem = "Volte Sempre!";
                } else {
                    mensagem = "Você não pode deixar a caverna sem o Ouro!";
                }

            } else {
                mensagem = "Comando inválido!";
            }
            controle.apresentar();
            System.out.println(mensagem);
        }
        teclado.close();

    }
}