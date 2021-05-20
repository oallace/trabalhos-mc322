# Sobre
Programa em Java que simula o jogo **Mundo de Wumpus**.  

O projeto foi desenvolvido como um trabalho da disciplina MC322, Programação Orientada a Objetos, no Instituto de Computação da UNICAMP.

# Arquivos Java do Jogo
## Executando
Para executar o jogo você deve fornecer, em ordem, dois argumentos: *nome* e *caminho*.  

Onde *nome* é o nome do jogador e *caminho* contém um caminho para um arquivo que monta a caverna.  

Na **data/** há alguns arquivos para montar a caverna.  

Por exemplo, na pasta **bin/**, executar:  
~~~
$ java mc322.lab06.AppMundoWumpus Andre ../data/caverna1.csv
~~~ 
## Lendo
Você pode ler o código do projeto em [src/mc322/lab06](./src/mc322/lab06).

# Destaques de Arquitetura:

## Componentes das salas:
~~~java
public class Sala {
  ...
	private Componente componentes[]; // lista de componente onde o índice representa a prioridade do componente
	...
}
~~~
Os componentes da sala são armazenados em um vetor de Componentes cujo o índice é de acordo com a prioridade, sendo menores índices referentes a elementos de maior
prioridade. 
Dessa forma, a comunicação da sala com seus componentes fica facilidada, uma vez que, com o uso de polimorfismo, podemos realizar comandos em componenntes de diversas classes, sem saber a que classe em específico estamos nos reportando.
Além disso, essa forma de armazenar as componentes permite uma fácil expansão: para criar uma nova classe de componentes basta atribuir a ele uma prioridade e ele será então tratado de acordo com ela. Poderíamos inclusive adicionar novos níveis de prioridade, caso seja necessário, com poucas alterações no código já escrito.
As salas possuem um vetor que armazena os diferentes tipos de componentes. Assim, ela pode se comunicar com eles através dos endereços nesse vetor.

## Descentralizando os papéis:
As classes do projeto foram pensadas para executar o máximo de processos específicos nas classes a que eles se referem.
~~~java
public boolean setComponente(int iComponente, int jComponente, Componente componente) {
if (ehEspacoValido(iComponente, jComponente))
    return this.salas[iComponente][jComponente].setComponente(componente);
return false;
}
~~~
No trecho acima podemos notar, por exemplo, uma característica da Caverna que foi desenvolvida nesse sentido: o objeto Caverna dos componentes é responsável apenas pelas comunicação adequada do componente com as Salas. Assim, ao solicitar uma ação para a caverna, esta pede para que a sala execute efetivamente a ação e retorna um código que informa o que houve em decorrência da ação solicitada, o qual será retornado ao componente para ser processado.
