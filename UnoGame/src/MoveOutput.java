
public class MoveOutput {
	private Card cardOnTopOnDiscardPile;
	public enum Action {
		MOVE,
		DRAW,
		SKIP
	}
	private Action nextAction;
	private int cardsToDraw;
	private Player nextPlayer;
	private String nextColorToPlay;
	public Card getCardOnTopOnDiscardPile() {
		return cardOnTopOnDiscardPile;
	}
	public void setCardOnTopOnDiscardPile(Card cardOnTopOnDiscardPile) {
		this.cardOnTopOnDiscardPile = cardOnTopOnDiscardPile;
	}
	public Action getNextAction() {
		return nextAction;
	}
	public void setNextAction(Action nextAction) {
		this.nextAction = nextAction;
	}
	public int getCardsToDraw() {
		return cardsToDraw;
	}
	public void setCardsToDraw(int cardsToDraw) {
		this.cardsToDraw = cardsToDraw;
	}
	public Player getNextPlayer() {
		return nextPlayer;
	}
	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
	public String getNextColorToPlay() {
		return nextColorToPlay;
	}
	public void setNextColorToPlay(String nextColorToPlay) {
		this.nextColorToPlay = nextColorToPlay;
	}
	
	
}
