package Aula7;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

    Scanner scan = new Scanner(System.in);
    private int tam = scan.nextInt();

    private String[][] tabuleiro = new String[tam][tam];
    // parametro do tabuleiro pronto
    private String[][] tabuleiroFeito = new String[tam][tam];
    private int[] posicaop = new int[2];// peca
    private int[] posicaov = new int[2];// vazio

    Random r = new Random();

    // Criamos um tabuleiro preenchendo-o em ordem crescente
    public void criaTabuleiro() {
        int cont = 1;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                tabuleiro[i][j] = Integer.toString(cont);
                tabuleiroFeito[i][j] = Integer.toString(cont);
                cont++;
            }
        }

        tabuleiro[tam - 1][tam - 1] = "0";
    }

    // Embaralhamos todas as pecas usandos os indices dos vetores
    public void embaralha() {
        // Embaralha as pecas
        int randomIndex1; // 1 indice do vetor
        int randomIndex2; // 2 indice do vetor
        String aux; // variavel auxiliar

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                // Define o ultimo como zero
                if (i == tam - 1 && j == tam - 1) {
                    break;
                } //
                // Randomiza indice 1
                randomIndex1 = r.nextInt(3);
                // Randomiza indice 2
                randomIndex2 = r.nextInt(3);

                // Auxiliar recebe intem random da matriz
                aux = tabuleiro[randomIndex1][randomIndex2];
                // Matriz random recebe matriz i j
                tabuleiro[randomIndex1][randomIndex2] = tabuleiro[i][j];
                // Matriz i j (original) recebe item random do auxiliar
                tabuleiro[i][j] = aux;
            }
        }
    }

    // Metodo para imprimir o tabuleiro
    public void imprime() {
        // Percorre o vetor e imprime cada item
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(tabuleiro[i][j] + "  ");
            }
            System.out.println();// Quebra linha
        }
    }

    public void posicaoVazia() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (tabuleiro[i][j].equals("0")) {
                    // salva o indice da posição da peça
                    posicaov[0] = i;
                    posicaov[1] = j;
                }
            }
        }
    }

    public void posicaoPeca() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (tabuleiro[i][j].equals(peca)) {
                    // salva o indice da posição da peça
                    posicaop[0] = i;
                    posicaop[1] = j;
                }
            }
        }
    }

    public boolean verificaMovimento() {
        // Retorna falso como padrao
        boolean res = false;
        // pega a posição das pecas
        posicaoPeca();
        posicaoVazia();
        // compara com a peca acima do espaço vazio
        if ((posicaop[0] == posicaov[0] - 1) && (posicaop[1] == posicaov[1])) {
            res = true;
            // compara com a peca abaixo do espaço vazio
        } else if ((posicaop[0] == posicaov[0] + 1) && (posicaop[1] == posicaov[1])) {
            res = true;
            // compara com a peca a esquerda do espaço vazio
        } else if ((posicaop[1] == posicaov[1] - 1) && (posicaop[0] == posicaov[0])) {
            res = true;
            // compara com a peca a direita do espaço vazio
        } else if ((posicaop[1] == posicaov[1] + 1) && (posicaop[0] == posicaov[0])) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public void mover() {
        verificaMovimento();
        if (verificaMovimento() == true) {
            // Movimento das peças
            posicaoPeca();
            posicaoVazia();
            String aux = tabuleiro[posicaop[0]][posicaop[1]];
            tabuleiro[posicaop[0]][posicaop[1]] = tabuleiro[posicaov[0]][posicaov[1]];
            tabuleiro[posicaov[0]][posicaov[1]] = aux;
        } else {
            System.out.println("Movimento invalido!\n");
        }
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public String[][] getTabuleiroFeito() {
        return tabuleiroFeito;
    }

}
