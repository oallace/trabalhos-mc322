package mc322.lab06;

public class Montador {
    private CSVHandling csv;
    private String entrada;

    Montador() {
        csv = new CSVHandling();
        entrada = null;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    // Valida a entrada setada.
    public boolean entradaValida() {
        return (entrada != null);
    }

    // Monta uma caverna com a entrada setada e a atribui a um heroi. Retorna um
    // ponteiro para o heroi. Retorna null se a caverna não pode ser montada.
    public Heroi montarCaverna(String jogador) {
        String comandos[][];
        Caverna caverna;
        Heroi heroi = null;
        int buracos, wumpus, ouros, herois;
        int iSala, jSala;

        if (!entradaValida())
            return null;
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
        return heroi;
    }
}
