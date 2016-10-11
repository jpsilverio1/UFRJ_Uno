import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
	private List<Player> orderedPlayers;
	private Card currentCard;
	private int gameDirection;
	private Player currentPlayer;
	private Player nextPlayer;
	private int numberOfPlayers;
	
	public Game(List<Player> players, Card initialCard) {
		this.orderedPlayers = new ArrayList<>(players.size());
		for (Player player: players) {
			orderedPlayers.add((player.getOrder()-1), player);
		}
		this.currentCard = initialCard;
		this.numberOfPlayers = players.size();
		this.nextPlayer = null;
		this.currentPlayer = null;
		this.gameDirection = 1;
	}
	public Map<String,Object> makeAMove(Player currentPlayer, Card cardPlayed) {
		this.currentCard = cardPlayed;
		this.currentPlayer = currentPlayer;
		String gameState = getGameState();
		int cardsToDraw = 0;
		Player playerThatShouldDrawCards = null;
		this.nextPlayer = null;
		if (gameIsNotFinished(gameState)) {
			this.nextPlayer = getNextPlayer();
			//TODO: transform into a single method and return a pair of int, Player
			cardsToDraw = getNumberOfCardsToDraw();
			playerThatShouldDrawCards = getPlayerThatShouldDraw();
		}
		return buildGameMoveReturn(gameState, cardsToDraw, playerThatShouldDrawCards);
	}
	
	private Map<String, Object> buildGameMoveReturn(String gameState, int cardsToDraw,
			Player playerThatShouldDrawCards) {
		Map<String, Object>  gameMap = new HashMap<>();
		gameMap.put("gameState", gameState);
		gameMap.put("cardsToDraw", cardsToDraw);
		gameMap.put("nextPlayer", this.nextPlayer);
		gameMap.put("winner", gameIsNotFinished(gameState) ? null : currentPlayer);
		gameMap.put("playerThatShouldDraw", playerThatShouldDrawCards);
		gameMap.put("currentCard", this.currentCard);
		return gameMap;
	}
	private int getNumberOfCardsToDraw() {
		switch (this.currentCard.getValue()) {
			case "+2": return 2;
			case "+4": return 4;
			default: return 0;
		}
	}
	private Player getPlayerThatShouldDraw() {
		switch (this.currentCard.getValue()) {
			case "+2": 
			case "+4": return this.orderedPlayers.get(getNextPlayerIndex(currentPlayer.getOrder(), 0));
			default: return null;
		}
	}
	private Player getNextPlayer() {
		List<String> specialCardsValues = Arrays.asList("+2", "+4", "skip");
		String currentCardValue = this.currentCard.getValue();
		if (specialCardsValues.contains(currentCardValue)) {
			return this.orderedPlayers.get(getNextPlayerIndex(currentPlayer.getOrder(), 1));
		} else {
			if (currentCardValue.equals("reverse") {
				changeGameDirection();
			}
			return this.orderedPlayers.get(getNextPlayerIndex(currentPlayer.getOrder(), 0));
		}
		
	}
	private void changeGameDirection () {
		this.gameDirection = -1*this.gameDirection;
	}
	private int getNextPlayerIndex (int currentPlayerIndex, int positionsToSkip) {
		return (currentPlayerIndex -1 + numberOfPlayers + gameDirection*(1+positionsToSkip)) % numberOfPlayers;	
	}
	private boolean gameIsNotFinished(String gameState) {
		return !gameState.equals("finished");
	}
	private String getGameState() {
		if (currentPlayer.getHand().isEmpty()) {
			return "finished";
		}
		return "active";
	}	
}
