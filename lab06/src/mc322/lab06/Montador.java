package mc322.lab06;

public class Montador {
    private CSVHandling csv;
    private String entrada;
    Heroi h;
    
    Montador()
    {
        csv = new CSVHandling();
        entrada = null;
    }

    public void setEntrada(String entrada)
    {
        this.entrada = entrada;
    }

    public Heroi getHeroi()
    {
        return h;
    }

    public Caverna montarCaverna()
    {
        String comandos[][];
        Caverna caverna;
        int iSala, jSala;
        
        csv.setDataSource(entrada);
        comandos = csv.requestCommands();
        caverna = new Caverna();

        for (int c = 0; c < comandos.length; c++)
        {
            iSala = Integer.valueOf(comandos[c][0].substring(0, 1)) - 1;
            jSala = Integer.valueOf(comandos[c][0].substring(2)) - 1;
            switch (comandos[c][1].charAt(0)) {
                case 'P':
                    h = new Heroi(caverna, iSala, jSala, "Player");
                    h.acomodarCompontente();
                    break;
            
                case 'B':
                    Buraco b = new Buraco(caverna, iSala, jSala);
                    b.acomodarCompontente();
                    break;
                
                case 'W':
                Wumpus w = new Wumpus(caverna, iSala, jSala);
                w.acomodarCompontente();
                    break;
                case 'O':
                Ouro o = new Ouro(caverna, iSala, jSala);
                o.acomodarCompontente();
                    break;
                default:
                    break;
            }
        }   

        return caverna;
    }
}
