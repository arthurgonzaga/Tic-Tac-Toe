package com.uninter.jogadores;

import com.uninter.Tabuleiro;

/**
 * 	Classe abstrata que representa todos os jogadores do jogo.
 * 
 * 	@author Arthur Gonzaga
 */
public abstract class Jogador {
	

	public static final String X = "X";
	public static final String O = "O";
	public static final String VAZIO = " ";

	/**
	 * Função responsável por realizar a jogada no {@link Tabuleiro#jogadas}
	 */
	public abstract void jogar(Tabuleiro tabuleiro);
}
