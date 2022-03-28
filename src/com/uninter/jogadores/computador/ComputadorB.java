package com.uninter.jogadores.computador;

import java.util.Random;

import com.uninter.Tabuleiro;
import com.uninter.jogadores.Computador;
import com.uninter.jogadores.Jogador;


/**
 * 	Classe que implementa o n�vel normal do Computador
 *  
 * 	@author Arthur Gonzaga
 */
public class ComputadorB extends Computador {
	
	public static final int NIVEL_NORMAL = 2;

	@Override
	public void jogar(Tabuleiro tabuleiro) {
		int posicao = calcularJogada(tabuleiro);
		tabuleiro.jogadas.set(posicao, Jogador.O);
	}

	/**
	 *  @return Retorna uma posi��o aleat�ria de um espa�o vazio.
	 */
	@Override
	public int calcularJogada(Tabuleiro tabuleiro) {
		int randomPosition; 
		while(true) {
			randomPosition = new Random().nextInt(tabuleiro.jogadas.size());
			if(tabuleiro.jogadas.get(randomPosition) == Jogador.VAZIO) {
				break;
			}
		}
		return randomPosition;
	}
	
}
