package com.uninter;

import java.util.ArrayList;
import java.util.Collections;

import com.uninter.jogadores.Jogador;

/**
 * 	Classe que contém todas as jogadas atuais do jogo e 
 * 	toda a lógica de quem ganhou e mostrar as jogadas na tela.
 * 
 * 	@author Arthur Gonzaga
 */
public class Tabuleiro {

	/** Boolean que representa o jogo rolando **/
	public static final boolean GAME_RUNNING = true;
	
	/** Boolean que representa o jogo finalizado **/
	public static final boolean GAME_FINISHED = false;
	
	/**
	 *  ArrayList que contém todas as jogadas atuais do jogo.
	 *  
	 *  @see {@link Jogador.X}
	 *  @see {@link Jogador.O}
	 *  @see  {@link Jogador.VAZIO}
	 */
	public ArrayList<String> jogadas = new ArrayList<String>(Collections.nCopies(9, Jogador.VAZIO));
	
	/**
	 * Verifica se o jogo ainda não acabou.
	 * @return retorna false se nenhum jogador tiver ganhado e true um dos dois ganhou.
	 */
	public boolean isGameRunning() {
		if(isJogadorWinner() || isComputadorWinner() || !isJogadaLeft()) {
			return GAME_FINISHED;
		}
		return GAME_RUNNING;
	}
	
	/**
	 *  Mostra o tabuleiro na tela com as jogadas atuais
	 */
	public void visualizarTabuleiro() {
		System.out.print("\n".repeat(50));
        System.out.println("     |     |     ");
        System.out.printf("  %s  |  %s  |  %s  \n", jogadas.get(0), jogadas.get(1), jogadas.get(2));
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.printf("  %s  |  %s  |  %s  \n", jogadas.get(3), jogadas.get(4), jogadas.get(5));
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.printf("  %s  |  %s  |  %s  \n", jogadas.get(6), jogadas.get(7), jogadas.get(8));
        System.out.println("     |     |     ");
	}
	
	/**
	 * 	Verifica se o Computador ganhou
	 * 	@return Retorna true se o {@link Computador} ganhou
	 */
	public boolean isComputadorWinner() {
		return hasWon(Jogador.O);
	}
	
	/**
	 * 	Verifica se o Humano ganhou
	 * 	@return Retorna true se o {@link JogadorHumano} ganhou
	 */
	public boolean isJogadorWinner() {
		return hasWon(Jogador.X);
	}
	
	/**
	 *  Verifica se ainda há jogadas restantes nas jogadas atuais
	 */
	public boolean isJogadaLeft() {
		return jogadas.contains(Jogador.VAZIO);
	}
	
	/**
	 * 	Faz a verificação das jogadas se algum jogador ganhou
	 * 
	 * 	@param jogada é {@link Jogador.X} ou {@link Jogador.O}
	 *	@return Retorna true se algum dos padrões de ganhar for verdadeira
	 */
	private boolean hasWon(String jogada) {
        if (
    		jogadas.get(0).equals(jogada) && jogadas.get(1).equals(jogada) && jogadas.get(2).equals(jogada) ||
    		jogadas.get(3).equals(jogada) && jogadas.get(4).equals(jogada) && jogadas.get(5).equals(jogada) ||
    		jogadas.get(6).equals(jogada) && jogadas.get(7).equals(jogada) && jogadas.get(8).equals(jogada) ||
    		jogadas.get(0).equals(jogada) && jogadas.get(3).equals(jogada) && jogadas.get(6).equals(jogada) ||
    		jogadas.get(1).equals(jogada) && jogadas.get(4).equals(jogada) && jogadas.get(7).equals(jogada) ||
    		jogadas.get(2).equals(jogada) && jogadas.get(5).equals(jogada) && jogadas.get(8).equals(jogada) ||
    		jogadas.get(0).equals(jogada) && jogadas.get(4).equals(jogada) && jogadas.get(8).equals(jogada) ||
    		jogadas.get(2).equals(jogada) && jogadas.get(4).equals(jogada) && jogadas.get(6).equals(jogada)
		) {
            return true;
        }
        return false;
	}

}
