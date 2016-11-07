import java.util.List;

public interface Player {
	public List<Card> getHand();
	public int getOrder();
	public String getName();
	boolean validateMove(Card currentCardOnTable, Card cardToBePlayed);
}
