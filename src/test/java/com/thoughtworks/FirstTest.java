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
    public void compareHighCard(){
        String[] blackCards = {"2H", "3D", "5S", "9C", "KD"};
        String[] whiteCards = {"2C", "3H", "4S", "8C", "AH"};
        Hand black = new Hand(blackCards);
        Hand white = new Hand(whiteCards);
        TexasHoldemPoker instance = new TexasHoldemPoker();
        Winner winner = instance.compare(black, white);
        String result = winner.getWinnerInfo();
        Assert.assertEquals("White wins - high_card: Ace", result);
    }
//    @Test
//    public void straight_vs_flush(){
//        String[] blackCards = {"2H", "3D", "4S", "5C", "6D"};
//        String[] whiteCards = {"AC", "QC", "JC", "8C", "2C"};
//        Hand black = new Hand(blackCards);
//        Hand white = new Hand(whiteCards);
//        TexasHoldemPoker instance = new TexasHoldemPoker();
//        Winner winner = instance.compare(black, white);
//        String result = winner.getWinnerInfo();
//        Assert.assertEquals("White wins - high_card: Ace", result);
//    }
}
