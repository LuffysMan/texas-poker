package com.thoughtworks;

import java.lang.String;

public class Winner {
    public Side m_Side;
    public Rank m_Rank;
    public Card winCard;
    public  Winner(){
        m_Side = Side.Tie;
        m_Rank = Rank.high_card;
        winCard = null;
    }

    public String getWinnerInfo(){
        String winnerInfo = null;
        if (Side.Tie == m_Side){
//            winnerInfo = m_Side.toString() + " wins - " + m_Rank.toString() + ": " + winCard.getString();
            winnerInfo = "Tie";
        }
        else if(null == winCard){
            winnerInfo = m_Side.toString() + " wins - " + m_Rank.toString();
        }
        else{
            winnerInfo = m_Side.toString() + " wins - " + m_Rank.toString() + ": " + winCard.getString();
        }

        return winnerInfo;
    }
}
