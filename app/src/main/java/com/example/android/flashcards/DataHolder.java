package com.example.android.flashcards;

public  class DataHolder {
  private static CardFolder data = null;

  private static int cardTag = 0;

  public static CardFolder getData() {
      return data;
    }

  public static void setData(CardFolder data){
      DataHolder.data = data;
  }

  public static int getCardTag(){
      return cardTag;
  }

  public static void setCardTag (int cardTag){
      DataHolder.cardTag = cardTag;
    }
}
