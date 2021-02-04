package com.cxj170002.asg1bfruits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

// This is the second activity that displays a list of the fruits in the order that they were
// clicked. This second activity appears after the show list button is clicked in the first activity

public class ShowFruitActivity extends AppCompatActivity {

    TextView fruitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fruit);
        // finding the fruitList textView by id
        fruitView = findViewById(R.id.fruitList);
        // getting the arraylist that was passed through the put extra method of the intent class
        ArrayList<String> fruits = (ArrayList<String>) getIntent().getSerializableExtra("fruitList");
        // string to hold the fruits with a newline character in between each
        String fruitString = "";
        // goes through the fruits arraylist and adds each fruit with a newline to the fruitString
        for(String fruit: fruits)
        {
            fruitString += fruit + "\n";
        }
        // setting the fruitView textView to fruitString to display the fruit list
        fruitView.setText(fruitString);

    }
}