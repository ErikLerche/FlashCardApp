package com.example.android.flashcards;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ScreenSlidePagerActivity extends FragmentActivity {

    Boolean isFlipped;
    int counter;
    ArrayList<Card> newcardlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        isFlipped = false;
        counter = 0;
        newcardlist = DataHolder.getData().getCardList();

        ((TextView) findViewById(R.id.card_text_button)).setText(newcardlist.get(0).getFront());

    }

    public void goNext(View view) {

        if (counter < newcardlist.size() - 1) {
            counter++;
            ((TextView) findViewById(R.id.card_text_button)).setText(newcardlist.get(counter).getFront());
        }
        else {
            counter = 0;
            ((TextView) findViewById(R.id.card_text_button)).setText(newcardlist.get(counter).getFront());
        }
    }

    public void goPrevious(View view) {
        if (counter > 0) {
            counter--;
            ((TextView) findViewById(R.id.card_text_button)).setText(newcardlist.get(counter).getFront());
        }
        else{
            counter = newcardlist.size() - 1;
            ((TextView) findViewById(R.id.card_text_button)).setText(newcardlist.get(counter).getFront());
        }
    }


    public void flipCard(View view) {
        if (!isFlipped) {
            ((TextView) findViewById(R.id.card_text_button)).setText(newcardlist.get(counter).getBack());
            isFlipped = true;
        }
        else {
            ((TextView) findViewById(R.id.card_text_button)).setText(newcardlist.get(counter).getFront());
            isFlipped = false;
        }
    }

    public void backToWordList(View view) {
        Intent intent = new Intent(this, WordListActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, WordListActivity.class);
        startActivity(intent);
        //super.onBackPressed();

    }
    /*
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount(){
        return DataHolder.getData().getCardList().size();

        }
    }
    */
}
