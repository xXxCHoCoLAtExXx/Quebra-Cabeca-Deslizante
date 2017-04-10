package Aula7;

import java.util.Random;

public class Tabuleiro extends Peca {
	private int[][] tabuleiro = new int[4][4];
	private int[][] tabuleiroFeito = new int[4][4];
	private int[] posicaop = new int[2];//peca
	private int[] posicaov = new int[2];//vazio
	Random r = new Random();

	public int[] posicaoVazia() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tabuleiro[i][j] == 0) {
					// salva o indice da posição vazia
					posicaov[0] = i;
					posicaov[1] = j;
				}
			}
		}
		return posicaov;
	}

	public int[] posicaoPeca() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (super.peca == tabuleiro[i][j]) {
					// salva o indice da posição da peça
					posicaop[0] = i;
					posicaop[1] = j;
				}
			}
		}
		return posicaop;
	}

	public void embaralha() {
		// Cria tabuleiro em ordem crescente
		int cont = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// Define o ultimo como zero
				if (i == 3 && j == 3) {
					break;
				} //
				tabuleiro[i][j] = cont;
				tabuleiroFeito[i][j] = cont;
				cont++;
			}
		}
		// Embaralha as pecas
		int randomIndex1; // 1 indice do vetor
		int randomIndex2; // 2 indice do vetor
		int randomValor; // variavel auxiliar

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// Define o ultimo como zero
				if (i == 3 && j == 3) {
					break;
				} //
					// Randomiza indice 1
				randomIndex1 = r.nextInt(3);
				// Randomiza indice 2
				randomIndex2 = r.nextInt(3);

				// Auxiliar recebe intem random da matriz
				randomValor = tabuleiro[randomIndex1][randomIndex2];
				// Matriz random recebe matriz i j
				tabuleiro[randomIndex1][randomIndex2] = tabuleiro[i][j];
				// Matriz i j (original) recebe item random do auxiliar
				tabuleiro[i][j] = randomValor;
			}
		}
	}

	public void imprime() {
		// Percorre o vetor e imprime cada item
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(tabuleiro[i][j] + "  ");
			}
			System.out.println();// Quebra linha
		}
	}

	public void mover() {
		posicaoPeca();
		posicaoVazia();
		verificaMovimento();
		if (verificaMovimento() == true) {
			// Movimento das peças
			posicaoPeca();
			posicaoVazia();
			int aux = tabuleiro[posicaop[0]][posicaop[1]];
			tabuleiro[posicaop[0]][posicaop[1]] = tabuleiro[posicaov[0]][posicaov[1]];
			tabuleiro[posicaov[0]][posicaov[1]] = aux;
		} else {
			System.out.println("Movimento invalido!\n");
		}
	}

	public boolean verificaMovimento() {
		boolean res = false;
		if((posicaop[0]==posicaov[0]-1)&&(posicaop[1]==posicaov[1])){
			res = true;
		}else if((posicaop[0]==posicaov[0]+1)&&(posicaop[1]==posicaov[1])){
			res = true;
		}else if((posicaop[1]==posicaov[1]-1)&&(posicaop[0]==posicaov[0])){
			res = true;
		}else if((posicaop[1]==posicaov[1]+1)&&(posicaop[0]==posicaov[0])){
			res = true;
		}
		
		return res;
	}

	public int[][] getTabuleiro() {
		return tabuleiro;
	}

	public int[][] getTabuleiroFeito() {
		return tabuleiroFeito;
	}

}
