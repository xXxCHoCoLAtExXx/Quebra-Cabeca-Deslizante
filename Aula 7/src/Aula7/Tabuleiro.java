package Aula7;

import java.util.Random;

public class Tabuleiro extends Peca {
	private int[][] tabuleiro = new int[4][4];
	// parametro do tabuleiro pronto
	private int[][] tabuleiroFeito = new int[4][4];
	private int[] posicaop = new int[2];// peca
	private int[] posicaov = new int[2];// vazio
	private int linha;
	private int coluna;
	Random r = new Random();

	public int[] posicaoVazia() {

		posicaov[0] = linha-1;
		posicaov[1] = coluna-1;

		return posicaov;
	}

	public int[] posicaoPeca() {
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				if (tabuleiro[i][j] == peca) {
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
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				tabuleiro[i][j] = cont;
				tabuleiroFeito[i][j] = cont;
				cont++;
			}
		}
		cont = 0;
		tabuleiro[linha-1][coluna-1] = 0;
		// Embaralha as pecas
		int randomIndex1; // 1 indice do vetor
		int randomIndex2; // 2 indice do vetor
		int aux; // variavel auxiliar

		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				// Define o ultimo como zero
				if (i == linha-1 && j == coluna-1) {
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

	public void imprime() {
		// Percorre o vetor e imprime cada item
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				System.out.print(tabuleiro[i][j] + "  ");
			}
			System.out.println();// Quebra linha
		}
	}

	public boolean verificaMovimento() {
		boolean res = false;
		posicaoPeca();
		posicaoVazia();
		if ((posicaop[0] == posicaov[0] - 1) && (posicaop[1] == posicaov[1])) {
			res = true;
		} else if ((posicaop[0] == posicaov[0] + 1) && (posicaop[1] == posicaov[1])) {
			res = true;
		} else if ((posicaop[1] == posicaov[1] - 1) && (posicaop[0] == posicaov[0])) {
			res = true;
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
			int aux = tabuleiro[posicaop[0]][posicaop[1]];
			tabuleiro[posicaop[0]][posicaop[1]] = tabuleiro[posicaov[0]][posicaov[1]];
			tabuleiro[posicaov[0]][posicaov[1]] = aux;
		} else {
			System.out.println("Movimento invalido!\n");
		}
	}

	public int[][] getTabuleiro() {
		return tabuleiro;
	}

	public int[][] getTabuleiroFeito() {
		return tabuleiroFeito;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

}
