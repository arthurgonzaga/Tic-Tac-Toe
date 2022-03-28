package com.uninter.jogadores.humano;

import java.util.Scanner;

import com.uninter.Tabuleiro;
import com.uninter.jogadores.Jogador;

/**
 * 	Classe que representa o jogador humano que est� jogando
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
			// Faz input da posi��o a ser jogada
			int posicao = teclado.nextInt() - 1;
			
			// Verifica se a jogada � poss�vel, se n�o, faz o input novamente
			if(tabuleiro.jogadas.get(posicao) == Jogador.VAZIO) {			
				tabuleiro.jogadas.set(posicao, Jogador.X);
				break;
			} else {
				System.out.print("Posi��o inv�lida, tente novamente ");
			}
		}
	}

}
