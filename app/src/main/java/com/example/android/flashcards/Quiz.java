package com.example.android.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
    CardFolder data;
    CardFolder clone_data;
    String front;
    String back;
    String string_score;
    int scores=0;
    int index=0;
    int size=0;
    TextView scoring;
    EditText question;
    EditText answer;
    ArrayList<Card> cardList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        question = findViewById(R.id.first_edit_text);
        answer = findViewById(R.id.second_edit_text);
        scoring =findViewById(R.id.score);
        data= DataHolder.getData();
        data.shuffleCardList();
        cardList=data.getCardList();
        size=cardList.size();
        front = cardList.get(index).getFront();
        back = cardList.get(index).getBack();
        question.setText(front);
        Button btn = (Button) findViewById(R.id.submit_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore();
                }
        });




    }
    public void increaseScore() {
        Toast toast;
        string_score = Integer.toString(scores);

        if(answer.getText().toString().isEmpty()){
            toast = Toast.makeText(getApplicationContext(), "Please enter something on the answer box", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (back.equals(answer.getText().toString())) {
            scores++;
            index++;
            string_score = Integer.toString(scores);
            scoring.setText("Score: " + string_score + "/" + size);
            //you answered right!
            toast = Toast.makeText(getApplicationContext(), "Good, You got that correct!", Toast.LENGTH_SHORT);
            toast.show();
            if (index < size) {
                front = cardList.get(index).getFront();
                back = cardList.get(index).getBack();
                question.setText(front);
                answer.getText().clear();
             }
            else{
                question.setText("Good job! you attempted all question");
                answer.setText("Check your score above");
            }

        }
        else if(!back.equals(answer.getText().toString()) && !answer.getText().toString().isEmpty()) {
            index++;
            scoring.setText("Score: " + string_score + "/" + size);
            //you got that incorrect
            if(index<size) {
                toast = Toast.makeText(getApplicationContext(), "Sorry, You got that incorrect!", Toast.LENGTH_SHORT);
                toast.show();
                front = cardList.get(index).getFront();
                back = cardList.get(index).getBack();
                question.setText(front);
                answer.getText().clear();
            }
            else{
                question.setText("Good job! you attempted all question");
                answer.setText("Check your score above");
            }

        }
        else if(index==size) {
            question.setText("Good job! you attempted all question");
            answer.setText("Check your score above");
         }


    }
}
