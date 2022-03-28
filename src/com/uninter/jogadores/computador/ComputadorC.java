package com.uninter.jogadores.computador;

import java.util.ArrayList;
import java.util.Random;

import com.uninter.Tabuleiro;
import com.uninter.jogadores.Computador;
import com.uninter.jogadores.Jogador;


/**
 * 	Classe que implementa o nível difícil do Computador
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
	 * 	Faz uso de aleatoridade para decidir se a posição a ser retornada
	 *  é randomica ou a posição do primeiro espaço vazio que encontrar.
	 */
	@Override
	public int calcularJogada(Tabuleiro tabuleiro) {
		int position; 
		
		while(true) {
			boolean shouldUseRandomPosition = new Random().nextBoolean();
			
			if(shouldUseRandomPosition) { 
				// Retorna uma posição aleatória
				
				position = new Random().nextInt(tabuleiro.jogadas.size());
				if(tabuleiro.jogadas.get(position) == Jogador.VAZIO) {
					break;
				}
			} else { 
				// Retorna posicao do primeiro espaço vazio
				
				position = tabuleiro.jogadas.indexOf(VAZIO);
			}
		}
		return position;
	}
	
}
