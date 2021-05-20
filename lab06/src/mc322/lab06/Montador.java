package mc322.lab06;

public class Montador {
    private CSVHandling csv;
    private String entrada;
    Heroi heroi;

    Montador() {
        csv = new CSVHandling();
        entrada = null;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public Caverna montarCaverna(String jogador) {
        String comandos[][];
        Caverna caverna;
        int buracos, wumpus, ouros, herois;
        int iSala, jSala;

        csv.setDataSource(entrada);
        comandos = csv.requestCommands();
        caverna = new Caverna();
        buracos = wumpus = ouros = herois = 0;

        for (int c = 0; c < comandos.length; c++) {
            iSala = Integer.valueOf(comandos[c][0].substring(0, 1)) - 1;
            jSala = Integer.valueOf(comandos[c][0].substring(2)) - 1;
            switch (comandos[c][1].charAt(0)) {
                case 'P':
                    heroi = new Heroi(caverna, iSala, jSala, jogador);
                    if (herois < 1 && heroi.acomodarCompontente())
                        herois++;
                    else
                        return null;
                    break;

                case 'B':
                    Buraco b = new Buraco(caverna, iSala, jSala);
                    if (buracos < 3 && b.acomodarCompontente())
                        buracos++;
                    else
                        return null;
                    break;

                case 'W':
                    Wumpus w = new Wumpus(caverna, iSala, jSala);
                    if (wumpus < 1 && w.acomodarCompontente())
                        wumpus++;
                    else
                        return null;
                    break;

                case 'O':
                    Ouro o = new Ouro(caverna, iSala, jSala);
                    if (ouros < 1 && o.acomodarCompontente())
                        ouros++;
                    else
                        return null;
                    break;

                default:
                    break;
            }
        }
        if (buracos < 2 || wumpus < 1 || herois < 1 || ouros < 1)
            return null;
        return caverna;
    }
}
