package com.example.android.flashcards;

import java.util.ArrayList;
import java.util.Collections;

public class CardFolder {
    private String name; //Stores name of the card folder
    private ArrayList<Card> cardList; //Stores list of Cards as Card objects in the Card Folder
    private ArrayList<Card> cardListClone; // Stores Clone of cardList to shuffle & reverse easier

    public CardFolder(String name, ArrayList<Card> cardList){
        this.name = name;
        this.cardList = cardList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    public void shuffleCardList(){
        cardListClone = cardList;
        Collections.shuffle(cardList);
    }

    public void reverseCardList(){
        cardListClone = cardList;
        Collections.reverse(cardList);
    }
    public void orderCardList(){
        cardList = cardListClone;
    }
}
