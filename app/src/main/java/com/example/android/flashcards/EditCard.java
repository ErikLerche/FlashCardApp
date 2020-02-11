package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EditCard extends AppCompatActivity {
    TextView frontText = findViewById(R.id.front_text_view2);
    TextView backText = findViewById(R.id.back_text_view2);
    int xInList = DataHolder.getCardTag();
    Card card = DataHolder.getData().getCardList().get(xInList);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);
        frontText.setText(card.getFront());
        backText.setText(card.getBack());
    }

    public void changeCard(View view){
        if (frontText.getText().length() > 0 && backText.getText().length() > 0){
            card.setFront(frontText.getText().toString());
            card.setBack(backText.getText().toString());
            Intent intent = new Intent(this, WordListActivity.class);
            startActivity(intent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "The Front and Back need Text", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
