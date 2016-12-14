package main;

public class MoveOutput {
	private ICard cardOnTopOnDiscardPile;
	private Action nextAction;
	private int cardsToDraw;
	private IPlayer nextPlayer;
	private Color nextColorToPlay;
	public ICard getCardOnTopOnDiscardPile() {
		return cardOnTopOnDiscardPile;
	}
	public void setCardOnTopOnDiscardPile(ICard cardOnTopOnDiscardPile) {
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
	public IPlayer getNextPlayer() {
		return nextPlayer;
	}
	public void setNextPlayer(IPlayer nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
	public Color getNextColorToPlay() {
		return nextColorToPlay;
	}
	public void setNextColorToPlay(Color nextColorToPlay) {
		this.nextColorToPlay = nextColorToPlay;
	}
	
	
}
