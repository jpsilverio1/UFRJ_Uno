package test;

import main.Color;
import org.junit.Before;
import org.junit.Test;

import main.Card;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CardTest {

    /**
     * Autores: new Grupo 5 (André Tardelli, Hylson Kobayashi, Josué Pereira)
     *
     * Nome: Teste do metodo Shuffle
     * Descricao: O metodo recebe um conjunto de CARDs e embaralha
     *
     * Entrada: Conjunto de CARDs
     * Retorno esperado: Conjunto de CARDs ordenados diferente da entrada
     *
     */
    @Test
	public void testShuffle() {
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Color.BLUE, 0, 2, 2));
		cards.add(new Card(Color.GREEN, 2, 0, 20));
		cards.add(new Card(Color.RED, 0, 5, 5));
		cards.add(new Card(Color.GREEN, 0, 7, 7));
		cards.add(new Card(Color.BLUE, 3, 0, 20));
		cards.add(new Card(Color.MULTICOLOR, 5, 0, 50));

		List<Card> cardsShuffled = Card.shuffle(cards);


		System.out.println("Ordem da entrada:");

		for(Card item: cards){
			System.out.println(item.getColor()+" "+item.getID()+" "+item.getNumber()+" "+item.getScore());
		}

		System.out.println("\nOrdem da saida:");

		for(Card item: cardsShuffled){
			System.out.println("Card: "+item.getColor()+" "+item.getID()+" "+item.getNumber()+" "+item.getScore());
		}

        assertNotEquals(cards, cardsShuffled);
	}

}