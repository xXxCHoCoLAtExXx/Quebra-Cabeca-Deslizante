package Aula7;

import java.util.Scanner;

public class QuebraCabeca {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("QUEBRA CABECA DESLIZANTE\n\n");

		Tabuleiro tab = new Tabuleiro();
		tab.embaralha();
		tab.imprime();
		

		while (tab.getTabuleiro() != tab.getTabuleiroFeito()) {
			System.out.println("\nEscolha a peça que deseja mover: ");
			tab.setPeca(scan.nextInt());
			tab.mover();
			tab.imprime();
		}
	}

}
