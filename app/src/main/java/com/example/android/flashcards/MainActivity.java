package com.example.android.flashcards;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<CardFolder> FolderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(DataHolder.getData() != null){
            FolderList.add(DataHolder.getData());
            DataHolder.setData(null);
        }

        if(!FolderList.isEmpty()){
            LinearLayout buttonContainer =  findViewById(R.id.addFolderField);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            for (int i = 0; i <FolderList.size(); i++){
                View v = inflater.inflate(R.layout.folder_field, null);
                Button buttonview = v.findViewById(R.id.folder_button);
                buttonview.setText(FolderList.get(i).getName());
                buttonview.setTag(i);
                buttonContainer.addView(v, buttonContainer.getChildCount() - 1);
            }
        }
    }

        public void openFolderMaker (View view){
            Intent intent = new Intent(this, folderMaker.class);
            startActivity(intent);
        }

        public void openWordList (View view){
            DataHolder.setData(FolderList.get((int) view.getTag()));
            Intent intent = new Intent(this, WordListActivity.class);
            startActivity(intent);
        }

    public ArrayList<CardFolder> getFolderList() {
        return FolderList;
    }

    public void setFolderList(ArrayList<CardFolder> folderList) {
        FolderList = folderList;
    }

    @Override
    public void onBackPressed(){

    }

}

