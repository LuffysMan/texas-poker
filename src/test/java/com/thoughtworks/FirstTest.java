package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class FirstTest {
    @Test
    public void setupShouldBeReady(){
        Assert.assertEquals(0, 0);
    }
    @Test
    public void highcard_vs_highcard(){
        String[] blackCards = {"2H", "3D", "5S", "9C", "KD"};
        String[] whiteCards = {"2C", "3H", "4S", "8C", "AH"};
        execute_coparation(blackCards, whiteCards, "White wins - high_card: Ace");
    }
    @Test
    public void straight_vs_flush(){
        String[] blackCards = {"2H", "3D", "4S", "5C", "6D"};
        String[] whiteCards = {"AC", "QC", "JC", "8C", "2C"};
        execute_coparation(blackCards, whiteCards, "White wins - flush");
    }
    @Test
    public void fullhouse_vs_fullhouse(){
        String[] blackCards = {"2H", "4D", "2S", "4C", "2D"};
        String[] whiteCards = {"AC", "AD", "AH", "3S", "3C"};
        execute_coparation(blackCards, whiteCards, "White wins - full_house: Ace");
    }
    @Test
    public void four_vs_four_tie(){
        String[] blackCards = {"2H", "2D", "2S", "2C", "4D"};
        String[] whiteCards = {"2H", "2D", "2S", "2C", "4D"};
        execute_coparation(blackCards, whiteCards, "Tie");
    }
    private void execute_coparation(String[] blackCards, String[] whiteCards, String s) {
        Hand black = new Hand(blackCards);
        Hand white = new Hand(whiteCards);
        TexasHoldemPoker instance = new TexasHoldemPoker();
        Winner winner = instance.compare(black, white);
        String result = winner.getWinnerInfo();
        Assert.assertEquals(s, result);
    }
}
