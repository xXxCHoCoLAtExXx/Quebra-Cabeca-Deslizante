package Aula7;

import java.util.Scanner;

public class QuebraCabeca {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		System.out.println("QUEBRA CABECA DESLIZANTE\n");
		System.out.println("Esolha sua dificuldade: ");
		System.out.print("N linhas: ");
		tab.setLinha(scan.nextInt());
		System.out.print("N colunas: ");
		tab.setColuna(scan.nextInt());
		
		tab.embaralha();
		tab.imprime();
		
		while (tab.getTabuleiro() != tab.getTabuleiroFeito()) {
			System.out.println("\nEscolha a peça que deseja mover: ");
			tab.setPeca(scan.nextInt());
			tab.mover();
			tab.imprime();
		}
		System.out.println("\nPARABÉNS VOCE VENCEU!!!");
	}

}
