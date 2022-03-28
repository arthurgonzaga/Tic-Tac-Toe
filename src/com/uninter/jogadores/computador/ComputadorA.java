package com.uninter.jogadores.computador;

import com.uninter.Tabuleiro;
import com.uninter.jogadores.Computador;
import com.uninter.jogadores.Jogador;

/**
 * 	Classe que implementa o nível fácil do Computador
 *  
 * 	@author Arthur Gonzaga
 */
public class ComputadorA extends Computador {

	public static final int NIVEL_FACIL = 1;

	@Override
	public void jogar(Tabuleiro tabuleiro) {
		int posicao = calcularJogada(tabuleiro);
		tabuleiro.jogadas.set(posicao, Jogador.O);
	}

	/**
	 *  @return Retorna na primeira posição vazia que encontrar.
	 */
	@Override
	public int calcularJogada(Tabuleiro tabuleiro) {
		return tabuleiro.jogadas.indexOf(VAZIO);
	}
	
}
