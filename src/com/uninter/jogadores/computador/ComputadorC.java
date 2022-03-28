package com.uninter.jogadores.computador;

import java.util.ArrayList;
import java.util.Random;

import com.uninter.Tabuleiro;
import com.uninter.jogadores.Computador;
import com.uninter.jogadores.Jogador;


/**
 * 	Classe que implementa o n�vel dif�cil do Computador
 *  
 * 	@author Arthur Gonzaga
 */
public class ComputadorC extends Computador {
	
	public static final int NIVEL_DIFICIL = 3;

	@Override
	public void jogar(Tabuleiro tabuleiro) {
		int posicao = calcularJogada(tabuleiro);
		tabuleiro.jogadas.set(posicao, Jogador.O);
	}

	/**
	 * 	Faz uso de aleatoridade para decidir se a posi��o a ser retornada
	 *  � randomica ou a posi��o do primeiro espa�o vazio que encontrar.
	 */
	@Override
	public int calcularJogada(Tabuleiro tabuleiro) {
		int position; 
		
		while(true) {
			boolean shouldUseRandomPosition = new Random().nextBoolean();
			
			if(shouldUseRandomPosition) { 
				// Retorna uma posi��o aleat�ria
				
				position = new Random().nextInt(tabuleiro.jogadas.size());
				if(tabuleiro.jogadas.get(position) == Jogador.VAZIO) {
					break;
				}
			} else { 
				// Retorna posicao do primeiro espa�o vazio
				
				position = tabuleiro.jogadas.indexOf(VAZIO);
			}
		}
		return position;
	}
	
}
