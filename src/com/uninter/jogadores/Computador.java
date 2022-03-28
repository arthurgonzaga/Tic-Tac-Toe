package com.uninter.jogadores;

import com.uninter.Tabuleiro;

/**
 * 	Classe abstrata que representa o oponente do jogador humano.
 * 	
 *	@author Arthur Gonzaga
 */
public abstract class Computador extends Jogador {
	
	/**
	 * Calcula a posi��o a ser jogada pelo computador
	 * 
	 * @return posi��o da jogada
	 */
	public abstract int calcularJogada(Tabuleiro tabuleiro);

	
}
