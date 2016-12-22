package test;

import main.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de teste para métodos relativos ao player
 */
public class PlayerTest {

    /**
     * Autores: Felipe Gonçalves, Igor Vaz, Victor Peres
     *
     * Método que testa se o número de cartas é igual a zero
     */

    @Test
    public void testNumberOfCardsEqualToZero() {
        List<Card> cards = new ArrayList<Card>();
        Player player1 = new Player();
        player1.getHand().addAll(cards);
        Assert.assertEquals(player1.getNOfCards(), 0);
    }


    /**
     * Autores: Felipe Gonçalves, Igor Vaz, Victor Peres
     *
     * Método que testa se o número de cartas é igual a 1
     */

    @Test
    public void testNumberOfCardsEqualToOne() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Color.BLUE, 0, 2, 2));
        Player player1 = new Player();
        player1.getHand().addAll(cards);
        Assert.assertEquals(player1.getNOfCards(), 1);
    }


}
