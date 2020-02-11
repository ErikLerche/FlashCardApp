package com.example.android.flashcards;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ScreenSlidePageFragment extends Fragment {
    public static int position = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        Button buttonView = rootView.findViewById(R.id.front_to_back_button);
        buttonView.setText(DataHolder.getData().getCardList().get(position).getFront());
        position ++;
        return rootView;
    }
}
