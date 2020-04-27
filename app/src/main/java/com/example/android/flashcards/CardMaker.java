package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CardMaker extends AppCompatActivity {

    private CardFolder currentFolder;
    private String FILE_NAME;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FILE_NAME= "file.txt";
        setContentView(R.layout.activity_card_maker);
        setCurrentFolder(DataHolder.getData());


        //DataHolder.setData(null);

    }
    public void addAnother(View view) throws IOException {
        EditText frontText = findViewById(R.id.first_edit_text);
        EditText backText = findViewById(R.id.second_edit_text);
        if (frontText.getText().toString().length() > 0 && backText.getText().toString().length() > 0) {
            saveData(frontText,backText);
            ArrayList<Card> listOfCards = currentFolder.getCardList();
            listOfCards.add(new Card(frontText.getText().toString(), backText.getText().toString()));
            Toast toasty = Toast.makeText(getApplicationContext(), frontText.getText().toString() + " added", Toast.LENGTH_SHORT);
            toasty.show();
            Toast.makeText(this,"Save to"+getFilesDir()+"/"+FILE_NAME,Toast.LENGTH_LONG).show();
            frontText.setText("");
            backText.setText("");
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "The Front and Back need Text", Toast.LENGTH_SHORT);
            toast.show();
    }
}
    public void done(View view) throws IOException {
        EditText frontText = findViewById(R.id.first_edit_text);
        EditText backText = findViewById(R.id.second_edit_text);
        if (frontText.getText().toString().length() > 0 && backText.getText().toString().length() > 0) {
            saveData(frontText,backText);
            ArrayList<Card> listOfCards = currentFolder.getCardList();
            listOfCards.add(new Card(frontText.getText().toString(), backText.getText().toString()));
            Toast.makeText(this,"Save to"+getFilesDir()+"/"+FILE_NAME,Toast.LENGTH_LONG).show();
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

    public void saveData(EditText frontText, EditText backText) throws IOException, IOException {
        String front = frontText.getText().toString();
        String back = backText.getText().toString();
        FileOutputStream fos = null;

        fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
        fos.write(front.getBytes());
        fos.write(back.getBytes());
        fos.close();
    }


    public StringBuilder loadData() throws IOException {
        FileInputStream fis = null;
        fis = openFileInput(FILE_NAME);

        InputStreamReader stream = new InputStreamReader(fis);
        BufferedReader buff = new BufferedReader(stream);
        StringBuilder builder = new StringBuilder();
        String text;

        while ((text = buff.readLine()) != null) {
            builder.append(text).append("\n");
        }
        fis.close();
        return builder;
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, WordListActivity.class);
        startActivity(intent);
    }

}
