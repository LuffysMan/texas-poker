package com.thoughtworks;

public class TexasHoldemPoker {
//    public static enum RANK{
//        tie, high_card, pair, two_pairs, three_of_a_kind, straight, flush, full_house, four_of_a_kind, straight_flush;
//    }
    public Winner compare(Hand black, Hand white) {
        Winner winner = new Winner();
        int nEqualsRank = black.equalsType(white);
        int nEqualsNum = black.equalsNum(white);
        int nSide = (0 == nEqualsRank) ? (nEqualsNum) : nEqualsRank;
        if(0 == nSide){
            winner.side = Side.Tie;
            winner.rank = black.rank;
            winner.winCard = black.winCard;
        }
        else if(0 > nSide){
            winner.side = Side.White;
            winner.rank = white.rank;
            winner.winCard = black.winCard;
        }
        else {
            winner.side = Side.Black;
            winner.rank = black.rank;
            winner.winCard = black.winCard;
        }

        return  winner;
    }
}
