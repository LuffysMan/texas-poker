package com.thoughtworks;

public class Hand {
    public Rank rank;
    public Card[] cards;
    public Card winCard;
    public  Hand(String[] cardsValue){
        rank = getRank();
        cards = new Card[]{new Card(cardsValue[0]), new Card(cardsValue[1]), new Card(cardsValue[2]),
                new Card(cardsValue[3]), new Card(cardsValue[4])};
        winCard = new Card();
        sort();
    }
    private Rank getRank(){
        return Rank.high_card;
    }
    private void sort(){
        boolean changedFlag = false;
        for(int j = cards.length - 1; j > 0; --j){
            changedFlag = false;
            for(int i = 0; i < j; ++i){
                if(cards[i].nNum >= cards[i+1].nNum){
                    continue;
                }
                else{
                    Card tmp = new Card(cards[i]);
                    cards[i].copy(cards[i+1]);
                    cards[i+1].copy(tmp);
                    changedFlag = true;
                }
            }
            if(false == changedFlag){
                break;
            }
        }
    }
    public int equalsType(Hand other){
//        return rank == other.rank ? 0 : rank < other.rank ? -1 : 1;
        return rank.compareTo(other.rank);
    }
    public  int equalsNum(Hand other){
        int result = 0;
        for(int iCard = 0; iCard < cards.length; ++iCard){
            result = cards[iCard].equalsNum(other.cards[iCard]);
            if(0 == result){
                continue;
            }
            else if(0 < result){
                winCard.copy(cards[iCard]);
            }
            else {
                winCard.copy(other.cards[iCard]);
            }
            break;
        }
        return result;
    }

}
