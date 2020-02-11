package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CardMaker extends AppCompatActivity {

    private CardFolder currentFolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_maker);
        setCurrentFolder(DataHolder.getData());
        //DataHolder.setData(null);
    }

    public void addAnother(View view){
        EditText frontText = findViewById(R.id.first_edit_text);
        EditText backText = findViewById(R.id.second_edit_text);
        if (frontText.getText().toString().length() > 0 && backText.getText().toString().length() > 0) {
            ArrayList<Card> listOfCards = currentFolder.getCardList();
            listOfCards.add(new Card(frontText.getText().toString(), backText.getText().toString()));
            Toast toasty = Toast.makeText(getApplicationContext(), frontText.getText().toString() + " added", Toast.LENGTH_SHORT);
            toasty.show();
            frontText.setText("");
            backText.setText("");
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "The Front and Back need Text", Toast.LENGTH_SHORT);
            toast.show();
    }
}
    public void done(View view){
        EditText frontText = findViewById(R.id.first_edit_text);
        EditText backText = findViewById(R.id.second_edit_text);
        if (frontText.getText().toString().length() > 0 && backText.getText().toString().length() > 0) {
            ArrayList<Card> listOfCards = currentFolder.getCardList();
            listOfCards.add(new Card(frontText.getText().toString(), backText.getText().toString()));
            frontText.setText("");
            backText.setText("");
            DataHolder.setData(currentFolder);
            Intent intent = new Intent(this, WordListActivity.class);
            startActivity(intent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "The Front and Back need Text", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public CardFolder getCurrentFolder() {
        return currentFolder;
    }

    public void setCurrentFolder(CardFolder currentFolder) {
        this.currentFolder = currentFolder;
    }
}
