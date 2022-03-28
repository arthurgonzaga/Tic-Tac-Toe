package com.uninter;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.uninter.jogadores.Computador;
import com.uninter.jogadores.Jogador;
import com.uninter.jogadores.computador.ComputadorA;
import com.uninter.jogadores.computador.ComputadorB;
import com.uninter.jogadores.computador.ComputadorC;
import com.uninter.jogadores.humano.JogadorHumano;

/**
 * Classe que compõe toda a lógica de input da dificuldade do computador e
 * output do vencedor.
 * 
 * @author Arthur Gonzaga
 */
public class Jogo {


	/** Inteiro que é indica o input para mostrar o tutorial **/
	private static final int TUTORIAL = 0;
	
	/** Inteiro que é indica a vez do jogador **/
	private static final int VEZ_JOGADOR = 1;

	/** Inteiro que é indica a vez do computador **/
	private static final int VEZ_COMPUTADOR = 2;
	

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		Tabuleiro tabuleiro = new Tabuleiro();
		Jogador jogadorHumano = new JogadorHumano(keyboard);
		Computador computador = getDificuldade(keyboard);

		startGame(tabuleiro, jogadorHumano, computador);

		keyboard.close();
	}

	/**
	 * Começa o jogo em um looping e intercala a vez da jogada entre o computador e
	 * o humano. O jogo só acaba, quando algum jogador vencer.
	 * 
	 * @see Tabuleiro#isGameRunning()
	 * @see Tabuleiro#isComputadorWinner()
	 * @see Tabuleiro#isJogadorWinner()
	 */
	public static void startGame(Tabuleiro tabuleiro, Jogador jogadorHumano, Computador computador) {
		int vez = VEZ_JOGADOR;
		tabuleiro.visualizarTabuleiro();

		while (tabuleiro.isGameRunning()) {
			if (vez == VEZ_JOGADOR) {
				System.out.print("\nSua vez: ");
				jogadorHumano.jogar(tabuleiro);
				vez = VEZ_COMPUTADOR;
			} else {
				computador.jogar(tabuleiro);
				vez = VEZ_JOGADOR;
			}

			tabuleiro.visualizarTabuleiro();
		}

		finishGame(tabuleiro);
	}

	/**
	 * Faz verificação de qual jogador foi o vencedor e mostra uma mensagem na tela
	 */
	public static void finishGame(Tabuleiro tabuleiro) {
		if (tabuleiro.isComputadorWinner()) {
			System.out.println("\nO Computador ganhou, você perdeu :(");
		} else if(tabuleiro.isJogadorWinner()){
			System.out.println("\nParabéns você ganhou!");
		} else {
			System.out.println("\nDeu velha :P");
		}
	}

	/**
	 * 	Faz o input da dificuldade a ser enfrentada pelo jogador
	 * 	@param teclado
	 * 	@return Retorna um {@link Computador}
	 * 
	 *  @see {@link ComputadorA}
	 *  @see {@link ComputadorB}
	 *  @see {@link ComputadorC}
	 */
	public static Computador getDificuldade(Scanner keyboard) {
		System.out.println("==".repeat(10));
		System.out.println("   Jogo da velha   ");
		System.out.println("==".repeat(10));
		
		boolean tutorialShowed = false;
		while(true) {
			if(tutorialShowed == false) System.out.println("Pressione 0 para ver o tutorial");
			System.out.print("Escolha a dificuldade entre 1, 2 ou 3: ");
			
			try {			
				int dificuldade = keyboard.nextInt();
					
				switch(dificuldade) {
					case TUTORIAL: {
						tutorialShowed = true;
						showTutorial();
						continue;
					}
					case ComputadorA.NIVEL_FACIL: {
						return new ComputadorA();
					}
					case ComputadorB.NIVEL_NORMAL: {
						return new ComputadorB();
					}
					case ComputadorC.NIVEL_DIFICIL: {
						return new ComputadorC();
					}
					default: {
						continue;
					}
				}
			} catch (InputMismatchException e) {
				continue;
			}
		}
	}
	
	/**
	 *  Mostra o tutorial na tela
	 */
	public static void showTutorial() {
		System.out.print("\n".repeat(50));
		System.out.println("============== TUTORIAL ==============");
		System.out.print("\n");
		System.out.println("Para jogar, precione no teclado\no número da posição que deseja jogar:\n");
        System.out.println("       |       |       ");
        System.out.println("  [1]  |  [2]  |  [3]  ");
        System.out.println("_______|_______|_______");
        System.out.println("       |       |       ");
        System.out.println("  [4]  |  [5]  |  [6]  ");
        System.out.println("_______|_______|_______");
        System.out.println("       |       |       ");
        System.out.println("  [7]  |  [8]  |  [9]  ");
        System.out.println("       |       |       ");
		System.out.print("\n");
		System.out.println("==".repeat(19));
		System.out.print("\n");
	}
	
}
