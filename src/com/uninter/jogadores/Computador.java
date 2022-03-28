package com.uninter.jogadores;

import com.uninter.Tabuleiro;

/**
 * 	Classe abstrata que representa o oponente do jogador humano.
 * 	
 *	@author Arthur Gonzaga
 */
public abstract class Computador extends Jogador {
	
	/**
	 * Calcula a posição a ser jogada pelo computador
	 * 
	 * @return posição da jogada
	 */
	public abstract int calcularJogada(Tabuleiro tabuleiro);

	
}
