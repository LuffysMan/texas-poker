package com.thoughtworks;

import java.lang.String;

public class Winner {
    public Side side;
    public Rank rank;
    public Card winCard;
    public  Winner(){
        side = Side.Tie;
        rank = Rank.high_card;
        winCard = new Card("2S");
    }

    public String getWinnerInfo(){
        String winnerInfo = side.toString() + " wins - " + rank.toString() + ": " + winCard.getString();
        return winnerInfo;
    }
}
