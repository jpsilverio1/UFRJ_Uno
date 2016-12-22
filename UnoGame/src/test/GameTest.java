package test;

import org.junit.Before;
import org.junit.Test;

import main.Action;
import main.Card;
import main.Color;
import main.Game;
import main.IPlayer;
import main.MoveOutput;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class GameTest {
	
	private Game fixture;
	private IPlayer player1 = mock(IPlayer.class);
	private IPlayer player2 = mock(IPlayer.class);
	private IPlayer player3 = mock(IPlayer.class);
	private IPlayer player4 = mock(IPlayer.class);
	private IPlayer player5 = mock(IPlayer.class);
	private Card initialCard = mock(Card.class);
	
	@Before
	public void setUp() {
		mockPlayer(player1, 1, "Joao");
		mockPlayer(player2, 2, "Maria");
		mockPlayer(player3, 3, "Jose");
		mockPlayer(player4, 4, "Carolina");
		mockPlayer(player5, 5, "Beatriz");
		when(initialCard.getColor()).thenReturn(Color.RED);
		List<IPlayer> players = Arrays.asList(player1, player2, player3, player4, player5);
		fixture = new Game(players, initialCard);
	}
	/* ID 0 : A??o No Action
ID 1 : A??o Skip
ID 2 : A??o Reverse
ID 3 : A??o Draw 2
ID 4 : A??o Wild
ID 5 : A??o Wild Draw 4*/
	@Test 
	public void testGameDirection() {
		Card cardPlayed = mockGameCard(Color.BLUE, 0);
		Action action = Action.MOVE;
		MoveOutput output = fixture.makeAMove(player1, cardPlayed, action, null);
		assertOutputValues(output, player2, player2.getName(), Action.MOVE, 0, cardPlayed, Color.BLUE);				
	}
	
	@Test
	public void testReverseCard() {
		//reverse card
		Card cardPlayed = mockGameCard(Color.BLUE, 2);
		Action action = Action.MOVE;
		MoveOutput output = fixture.makeAMove(player1, cardPlayed, action, null);
		assertOutputValues(output, player5, player5.getName(), Action.MOVE, 0, cardPlayed, Color.BLUE);
		Card newCard = mockGameCard(Color.BLUE, 0);
		MoveOutput output2 = fixture.makeAMove(player5, newCard, action, null);
		assertOutputValues(output2, player4, player4.getName(), action, 0, newCard, Color.BLUE);
		Card secondNewCard = mockGameCard(Color.BLUE, 2);
		MoveOutput output3 = fixture.makeAMove(player4, secondNewCard, action, null);
		assertOutputValues(output3, player5, player5.getName(), action, 0, secondNewCard, Color.BLUE);
	}
	@Test
	public void testWildCard() {
		//wild card
		Card cardPlayed = mockGameCard(Color.MULTICOLOR, 4);
		Action action = Action.MOVE;
		MoveOutput output = fixture.makeAMove(player2, cardPlayed, action, Color.YELLOW);
		assertOutputValues(output, player3, player3.getName(), action, 0, cardPlayed, Color.YELLOW);
	}
	@Test
	public void testDrawCards() {
		Card cardPlayed = mockGameCard(Color.BLUE, 3);
		Card cardPlayed2 = mockGameCard(Color.MULTICOLOR, 5);
		Action action = Action.MOVE;
		MoveOutput output = fixture.makeAMove(player2, cardPlayed, action, null);
		assertOutputValues(output, player3, player3.getName(), Action.DRAW, 2, cardPlayed, cardPlayed.getColor());
		MoveOutput output2 = fixture.makeAMove(player4, cardPlayed2, action, Color.YELLOW);
		assertOutputValues(output2, player5, player5.getName(), Action.DRAW, 4, cardPlayed2, Color.YELLOW);
	}
	@Test
	public void testSkipCards() {
		Card cardPlayed = mockGameCard(Color.GREEN, 1);
		Action action = Action.MOVE;
		MoveOutput output = fixture.makeAMove(player5, cardPlayed, action, null);
		assertOutputValues(output, player1, player1.getName(), Action.SKIP, 0, cardPlayed, cardPlayed.getColor());
	}
	@Test
	public void testDrawWildCard() {
		//wild card + 4
		Card cardPlayed = mockGameCard(Color.MULTICOLOR, 5);
		Action action = Action.MOVE;
		MoveOutput output = fixture.makeAMove(player5, cardPlayed, action, Color.GREEN);
		assertOutputValues(output, player1, player1.getName(),Action.DRAW, 4, cardPlayed, Color.GREEN);
	}
	
	@Test
	public void testNextPlayer() {
		Card cardPlayed = mockGameCard(Color.BLUE, 0);
		Action action = Action.MOVE;
		MoveOutput output = fixture.makeAMove(player2, cardPlayed, action, null);
		assertOutputValues(output, player3, player3.getName(),Action.MOVE, 0, cardPlayed, Color.BLUE);
	}
	
	@Test
	public void testNextPlayerEdge() {
		Card cardPlayed = mockGameCard(Color.BLUE, 0);
		Action action = Action.MOVE;
		MoveOutput output = fixture.makeAMove(player5, cardPlayed, action, null);
		assertOutputValues(output, player1, player1.getName(),Action.MOVE, 0, cardPlayed, Color.BLUE);
			
	}
	
	@Test
	public void testPlayerDrew() {
		Action action = Action.DRAW;
		MoveOutput output = fixture.makeAMove(player1, null, action, null);
		assertOutputValues(output, player2, player2.getName(),Action.MOVE, 0, initialCard, initialCard.getColor());

	}
	
	@Test
	public void another() {
				
	}
	private void assertOutputValues(MoveOutput output,
			IPlayer expectedNextPlayer, 
			String expectedNextPlayerName, 
			Action expectedNextAction, 
			int expectedCardsToDraw, 
			Card expectedCardOnTopOfFile, 
			Color expectedNextColorToPlay) {
		assertEquals(expectedNextPlayer, output.getNextPlayer());
		assertEquals(expectedNextPlayerName, output.getNextPlayer().getName());
		assertEquals(expectedNextAction, output.getNextAction());
		assertEquals(expectedCardsToDraw, output.getCardsToDraw());
		assertEquals(expectedCardOnTopOfFile, output.getCardOnTopOnDiscardPile());
		assertEquals(expectedNextColorToPlay, output.getNextColorToPlay());
	}
	private Card mockGameCard(Color color, int id) {
		Card card = mock(Card.class);
		when(card.getID()).thenReturn(id);
		when(card.getColor()).thenReturn(color);
		return card;
	}
	private void mockPlayer(IPlayer player, int order, String name) {
		when(player.getOrder()).thenReturn(order);
		when(player.getName()).thenReturn(name);
	}
}
