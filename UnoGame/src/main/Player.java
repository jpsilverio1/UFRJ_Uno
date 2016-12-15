package main;

import java.util.List;

public class Player implements IPlayer {

	@Override
	public List<ICard> getHand() {
		// TODO Auto-generated method stub
		return null;
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
		return 0;
	}

}
