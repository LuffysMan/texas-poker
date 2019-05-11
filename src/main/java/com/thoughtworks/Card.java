package com.thoughtworks;

public class Card {
    public int nNum;
    public char cSuit;
//    private static HashMap<Integer, String> mapKeyNum = new HashMap<Integer, String>();
    private static String[] cNums;
    private static String[] fullNames;

    public Card(){
        cNums = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "J","Q", "K","A"};
        fullNames = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "Jack","Queen", "King","Ace"};
        nNum = 2;
        cSuit = 'S';
    }

    public Card(final String card){
        cNums = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "J","Q", "K","A"};
        fullNames = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "Jack","Queen", "King","Ace"};
        nNum = convertToNum(card.substring(0, card.length()-1));
        cSuit = card.charAt(1);
    }
    public  Card(Card other){
        cNums = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "J","Q", "K","A"};
        fullNames = new String[]{"2", "3", "4", "5","6", "7","8", "9","10", "Jack","Queen", "King","Ace"};
        nNum = other.nNum;
        cSuit = other.cSuit;
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
//        return Character.toString(nNum) + Character.toString(cSuit);
//        return num2ShortName(nNum) + Character.toString(cSuit);
        return num2FullName(nNum);
    }
    public int equalsNum(Card other){
        return (nNum < other.nNum) ? -1 : ((nNum == other.nNum) ? 0 : 1);
    }
    public void copy(Card other){
        nNum = other.nNum;
        cSuit = other.cSuit;
    }
}
