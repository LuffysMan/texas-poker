package com.thoughtworks;

public class TexasHoldemPoker {
//    public static enum RANK{
//        tie, high_card, pair, two_pairs, three_of_a_kind, straight, flush, full_house, four_of_a_kind, straight_flush;
//    }
    public Winner compare(Hand black, Hand white) {
        Winner winner = new Winner();
        int nEqualsRank = black.equalsRank(white);
        int nEqualsNum = black.equalsNum(white);
        int nSide = (0 == nEqualsRank) ? (nEqualsNum) : nEqualsRank;
        if(0 == nSide){
            winner.m_Side = Side.Tie;
            winner.m_Rank = black.rank;
            if( 0 == nEqualsRank){
                winner.winCard = black.winCard;
            }
        }
        else if(0 > nSide){
            winner.m_Side = Side.White;
            winner.m_Rank = white.rank;
            if( 0 == nEqualsRank){
                winner.winCard = black.winCard;
            }        }
        else {
            winner.m_Side = Side.Black;
            winner.m_Rank = black.rank;
            if( 0 == nEqualsRank){
                winner.winCard = black.winCard;
            }        }

        return  winner;
    }
}
