package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class folderMaker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder_maker);
    }

    public void createFolder(View view){
        EditText edt = findViewById(R.id.folderText);
        String result = edt.getText().toString();
        CardFolder temp = new CardFolder(result, new ArrayList<Card>());
        DataHolder.setData(temp);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
