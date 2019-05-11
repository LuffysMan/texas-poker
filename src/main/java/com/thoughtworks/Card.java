package com.thoughtworks;

public class Card {
    public int cardNum;
    public char cardSuit;
//    private static HashMap<Integer, String> mapKeyNum = new HashMap<Integer, String>();
    public static final int numOfSuits = 13;
    private static String[] cNums;
    private static String[] fullNames;

    public Card(){
        cNums = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "J","Q", "K","A"};
        fullNames = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "Jack","Queen", "King","Ace"};
        cardNum = 2;
        cardSuit = 'S';
    }

    public Card(final String card){
        cNums = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "J","Q", "K","A"};
        fullNames = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "Jack","Queen", "King","Ace"};
        cardNum = convertToNum(card.substring(0, card.length()-1));
        cardSuit = card.charAt(1);
    }
    public  Card(Card other){
        cNums = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "J","Q", "K","A"};
        fullNames = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "Jack","Queen", "King","Ace"};
        cardNum = other.cardNum;
        cardSuit = other.cardSuit;
    }
    public int convertToNum(String cardNum){
        int nResult = 0;
        for(int i = 0; i < cNums.length; ++i){
            if(0 == cNums[i].compareTo(cardNum)){
                nResult = i;
            }
        }
        return nResult;
    }
    public String num2ShortName(int cardNum){
        return cNums[cardNum];
    }

    public String num2FullName(int cardNum){
        return fullNames[cardNum];
    }
    public String getString(){
//        return Character.toString(cardNum) + Character.toString(cardSuit);
//        return num2ShortName(cardNum) + Character.toString(cardSuit);
        return num2FullName(cardNum);
    }
    public int compareNumber(Card other){
        return (cardNum < other.cardNum) ? -1 : ((cardNum == other.cardNum) ? 0 : 1);
    }

    public boolean equalsColor(Card other){
        return  cardSuit == other.cardSuit ? true : false;
    }

    public void copy(Card other){
        cardNum = other.cardNum;
        cardSuit = other.cardSuit;
    }
}
