package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    // Variable to store the color resource ID argument passed into this method
    private int mColor;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0,words);
        mColor = colorResourceID;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View list_item = convertView;
        if(list_item == null){
            list_item = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) list_item.findViewById(R.id.translation_image);
        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceID());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        View textContainer = list_item.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColor);
        textContainer.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID english_text_view
        TextView miwokTextView = (TextView) list_item.findViewById(R.id.miwok_text_view);
        // Get the default (English) word from the current Word object and
        // set this text on the English TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID Miwok_text_view
        TextView defaultTextView = (TextView) list_item.findViewById(R.id.english_text_view);
        // Get the Miwok word from the current Word object and
        // set this text on the Miwok TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        return list_item;
    }
}
