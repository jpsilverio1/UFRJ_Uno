import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<IPlayer> orderedPlayers;
	private ICard currentCard;
	private int roundDirection;
	private IPlayer currentPlayer;
	private IPlayer nextPlayer;
	private int numberOfPlayers;
	private String nextColorToPlay;
	
	public Game(List<IPlayer> players, ICard initialCard) {
		this.orderedPlayers = new ArrayList<>(players.size());
		for (IPlayer player: players) {
			orderedPlayers.add(player.getOrder()-1, player);
		}
		this.currentCard = initialCard;
		this.nextColorToPlay = initialCard.getColor();
		this.numberOfPlayers = players.size();
		this.nextPlayer = null;
		this.currentPlayer = null;
		if (initialCard.getID() == 2) {
			this.roundDirection = -1;
		} else {
			this.roundDirection = 1;
		}
	}
	public MoveOutput makeAMove(IPlayer currentPlayer, ICard cardPlayed, Action action, String newColor) {
		MoveOutput moveOutput = new MoveOutput();
		this.currentPlayer = currentPlayer;
		if (action == Action.MOVE) {
			this.currentCard = cardPlayed;
			changeGameDirection(cardPlayed);
		}
		this.nextPlayer = getNextPlayer();
		Action nextAction = getNextAction(action);
		int cardsToDraw = getNumberOfCardsToDraw(action);
		this.nextColorToPlay = getNextColorToPlay(action,newColor);
		moveOutput.setCardOnTopOnDiscardPile(currentCard);
		moveOutput.setCardsToDraw(cardsToDraw);
		moveOutput.setNextAction(nextAction);
		moveOutput.setNextColorToPlay(this.nextColorToPlay);
		moveOutput.setNextPlayer(this.nextPlayer);
		return moveOutput;
	}
	
	private String getNextColorToPlay(Action action,String newColor) {
		if (action == Action.MOVE) {
			int currentCardID = currentCard.getID();
			if (currentCardID == 5 || currentCardID == 4) {
				return newColor;
			}
			else if (currentCardID >=0 && currentCardID <=3) {
				return currentCard.getColor();
			}
		}
		return this.nextColorToPlay;
	}
	private Action getNextAction(Action action) {
		if (action == Action.MOVE) {
			int currentCardID = currentCard.getID();
			if (currentCardID == 1) {
				return Action.SKIP;
			}
			if (currentCardID == 3 || currentCardID == 5) {
				return Action.DRAW;
			}
			if (currentCardID == 0 || currentCardID == 2 || currentCardID == 4) {
				return Action.MOVE;
			}
		}
		return Action.MOVE;
	}
	private int getNumberOfCardsToDraw(Action action) {
		if (action == Action.MOVE) {
			switch (this.currentCard.getID()) {
			case 3: return 2;
			case 5: return 4;
			default: return 0;
			}
		}
		return 0;
	}
	private IPlayer getNextPlayer() {
		return this.orderedPlayers.get(getNextPlayerIndex(currentPlayer.getOrder()));
		
	}
	private void changeGameDirection (ICard cardPlayed) {
		if (cardPlayed.getID() == 2) {
			this.roundDirection = -1*this.roundDirection;
		}
		
	}
	private int getNextPlayerIndex (int currentPlayerOrder) {
		if (roundDirection  == 1 && currentPlayerOrder == numberOfPlayers){
			return 0;
		}
		if (roundDirection == -1 && currentPlayerOrder == 1) {
			return (numberOfPlayers - 1);
		}
		return (currentPlayerOrder + roundDirection -1);
	}
}
