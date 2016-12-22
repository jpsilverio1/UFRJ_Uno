package main;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer {

	private int score = 0; //pontuação total do jogador
	List<ICard> hand = new ArrayList<>();

	@Override
	public List<ICard> getHand() {
		return hand;
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateMove(ICard currentCardOnTable, ICard cardToBePlayed) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void addScore(int points) {
		score+=points;
	}

	@Override
	public int getNOfCards() {
		return getHand().size();
	}

}
