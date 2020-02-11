package com.example.android.flashcards;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class WordListActivity extends AppCompatActivity {

    private CardFolder currentFolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        if(DataHolder.getData() != null) {
            setCurrentFolder(DataHolder.getData());
            //DataHolder.setData(null);
        }
        if(currentFolder == null){
            Toast toast = Toast.makeText(getApplicationContext(), "darn", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if(!currentFolder.getCardList().isEmpty()){
            LinearLayout buttonContainer = findViewById(R.id.addWordView);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            for(int i = 0; i < currentFolder.getCardList().size(); i ++){
                View v = inflater.inflate(R.layout.card_field, null);
                Button buttonView = v.findViewById(R.id.new_card_button);
                buttonView.setText(currentFolder.getCardList().get(i).getFront());
                buttonView.setTag(i);
                buttonContainer.addView(v, i);
            }
        }
    }

    public void addWord (View view){
        DataHolder.setData(currentFolder);
        Intent intent = new Intent(this, CardMaker.class);
        startActivity(intent);
    }

    public CardFolder getCurrentFolder() {
        return currentFolder;
    }

    public void setCurrentFolder(CardFolder currentFolder) {
        this.currentFolder = currentFolder;
    }

    public void startFlashCards(View view){
        Intent intent = new Intent(this, ScreenSlidePagerActivity.class);
        startActivity(intent);
    }

    public void editCard (View view){
        DataHolder.setCardTag((int) view.getTag());
        Intent intent = new Intent(this, EditCard.class);
        startActivity(intent);
    }
}