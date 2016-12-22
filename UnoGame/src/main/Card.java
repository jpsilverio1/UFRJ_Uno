package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements ICard {
    private Color color;
    private int ID;
    private int number;
    private int score;

    public Card(Color color, int ID, int number, int score) {
        this.color = color;
        this.ID = ID;
        this.number = number;
        this.score = score;
    }

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return this.number;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}

	@Override
	public Object getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Necessario para a comparacao de listagem
	 */
	public int compareTo(Object o) {
		if (o instanceof Color){
			return getColor().compareTo((Color) o);
		}
		return compareTo(o);
	}


	/**
     * Autores: new Grupo 5 (André Tardelli, Hylson Kobayashi, Josué Pereira)
     *
     * Entrada: Conjunto de CARDs
     * Saida: Conjunto de CARDs com os objetos diferentemente ordenados do conjunto de CARDs da entrada
     *
     * Descricao: Embaralha os CARDs de entrada
     *
	 */
	public static List<Card> shuffle(List<Card> cards) {
	    List<Card> cardsShuffled = new ArrayList<Card>(cards);
	    do {
            Collections.shuffle(cardsShuffled);
        } while(cardsShuffled.equals(cards));
		return cardsShuffled;
	}
}
