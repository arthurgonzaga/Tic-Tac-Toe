package com.uninter.jogadores.humano;

import java.util.Scanner;

import com.uninter.Tabuleiro;
import com.uninter.jogadores.Jogador;

/**
 * 	Classe que representa o jogador humano que está jogando
 *  contra o computador.
 *  
 *  @author Arthur Gonzaga
 */
public class JogadorHumano extends Jogador {
	
	Scanner teclado = null;

	public JogadorHumano(Scanner teclado) {
		this.teclado = teclado;
	}
	
	
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		while(true) {
			// Faz input da posição a ser jogada
			int posicao = teclado.nextInt() - 1;
			
			// Verifica se a jogada é possível, se não, faz o input novamente
			if(tabuleiro.jogadas.get(posicao) == Jogador.VAZIO) {			
				tabuleiro.jogadas.set(posicao, Jogador.X);
				break;
			} else {
				System.out.print("Posição inválida, tente novamente ");
			}
		}
	}

}
