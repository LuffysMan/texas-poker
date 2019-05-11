package com.thoughtworks;

public class Hand {
    public Rank rank;
    public Card[] cards;
    public Card winCard;
    public  Hand(String[] cardsValue){
        cards = new Card[]{new Card(cardsValue[0]), new Card(cardsValue[1]), new Card(cardsValue[2]),
                new Card(cardsValue[3]), new Card(cardsValue[4])};
        winCard = new Card();
        sort();
        getRank();
    }
    private void getRank(){
        if(isStraight() && isFlush()){
           rank = Rank.straight_flush;
        }
        else if(isFour()){
            rank = Rank.four_of_a_kind;
        }
        else if(isFullhouse()){
            rank = Rank.full_house;
        }
        else if (isFlush()){
            rank = Rank.flush;
        }
        else if (isStraight()){
            rank = Rank.straight;
        }
        else if(isThree()){
            rank = Rank.three_of_a_kind;
        }
        else if(isTwoPairs()){
            rank = Rank.two_pairs;
        }
        else if(isPair()){
            rank = Rank.pair;
        }
        else{
            rank = Rank.high_card;
        }
    }

    private boolean isFlush(){
        boolean bFlush = true;
        for (int i = 1; i < cards.length; ++i) {
            if (false == cards[i].equalsColor(cards[0])){
                bFlush = false;
                break;
            }
        }
        return bFlush;
    }

    private boolean isStraight(){
        boolean bStraight = true;
        for (int i = 0; i < cards.length-1; ++i) {
            if (1 == (cards[i].cardNum - cards[i+1].cardNum)){
                continue;
            }
            bStraight = false;
            break;
        }
        return bStraight;
    }

    private boolean isFour(){
        boolean bFour = false;
        if(8 == countPairs()){
            bFour = true;
        }
        return bFour;
    }

    private boolean isFullhouse(){
        boolean bFullouse = false;
        if(5 == countPairs()){
            bFullouse = true;
        }
        return bFullouse;
    }

    private boolean isThree(){
        boolean bThree = false;
        if(4 == countPairs()){
            bThree = true;
        }
        return bThree;
    }

    private boolean isTwoPairs(){
        boolean bTwoPairs = false;
        if(2 == countPairs()){
            bTwoPairs = true;
        }
        return bTwoPairs;
    }

    private boolean isPair(){
        boolean bPair = false;
        if(1 == countPairs()){
            bPair = true;
        }
        return bPair;
    }

    private int countPairs(){
        int[] cardNumCounter = new int[Card.numOfSuits];
        for(int nCount: cardNumCounter){
            nCount = 0;
        }
        for (int i = 0; i < cards.length; ++i) {
            cardNumCounter[cards[i].cardNum]++;
        }
        int nRankFlag = 0;
        for(int j = 0; j < Card.numOfSuits; ++j){
            if(4 == cardNumCounter[j]){
                nRankFlag += 8;
            }
            if(3 == cardNumCounter[j]){
                nRankFlag += 4;
            }
            if(2 == cardNumCounter[j]){
                nRankFlag += 1;
            }
        }
        //对手牌进行重构排序
        for(int i = 0; i < cards.length; ){
            for(int nCardNumber = Card.numOfSuits - 1; nCardNumber >= 0; --nCardNumber){
                for( ; cardNumCounter[nCardNumber] > 0; --cardNumCounter[nCardNumber]){
                    cards[i].cardNum = nCardNumber;
                    ++i;
                }
            }
        }

        return nRankFlag;
    }


    private void sort(){
        boolean changedFlag = false;
        for(int j = cards.length - 1; j > 0; --j){
            changedFlag = false;
            for(int i = 0; i < j; ++i){
                if(cards[i].cardNum >= cards[i+1].cardNum){
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
    public int equalsRank(Hand other){
//        return m_Rank == other.m_Rank ? 0 : m_Rank < other.m_Rank ? -1 : 1;
        return rank.compareTo(other.rank);
    }
    public  int equalsNum(Hand other){
        int result = 0;
        for(int iCard = 0; iCard < cards.length; ++iCard){
            result = cards[iCard].compareNumber(other.cards[iCard]);
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
