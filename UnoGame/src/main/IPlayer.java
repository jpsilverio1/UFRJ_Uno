package main;
import java.util.List;

public interface IPlayer {
    public List<ICard> getHand();
	public int getOrder();
	public String getName();
	boolean validateMove(ICard currentCardOnTable, ICard cardToBePlayed);
	int getScore();
	void addScore(int points);
}
