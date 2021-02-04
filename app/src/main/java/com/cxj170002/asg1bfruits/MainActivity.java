package com.cxj170002.asg1bfruits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

// Written by Christy Jacob for CS4301.002, assignment 1B, starting February 2nd, 2021.
//    NetID: cxj170002
// This program displays the names of 5 specific, unique fruits and has the names disappear
// when clicked. Then a button appears which, if clicked, shows the fruits in the order that
// they were clicked.
// We get practice with onclick, views, buttons, intent, and constraint layout with this program.
public class MainActivity extends AppCompatActivity {

    Button btnShowlist;
    ArrayList<String> fruits = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // finds the show list button by id and sets it to invisible until all the fruits are clicked
        btnShowlist = findViewById(R.id.btnShowlistButton);
        btnShowlist.setVisibility(View.INVISIBLE);
    }

    // you only need one handle Click method for each of the TextViews to avoid
    // repetitive code
    // this method has the text view of the fruit that was clicked disappear
    // the input is a View object
    public void helloClick(View view) {
        // I found on the android developer docs and stackoverflow that you can use
        // setVisibility(View.INVISIBLE)
        // sets the visibility of the view to invisible when clicked
        ((TextView) view).setVisibility(View.INVISIBLE);
        // adds the fruit that was clicked to the fruits ArrayList to keep track of the order
        // in which the fruits were clicked
        fruits.add((String) ((TextView) view).getText());
        // if all 5 fruits have been clicked, make the show list button visible
        if(fruits.size()==5)
            btnShowlist.setVisibility(View.VISIBLE);
    }

    // this method, that's enacted when the show list button is clicked, brings up the second activity
    public void btnShowList(View view) {
        // creates a new intent and passes an arraylist as an extra to the second activity in the intent
        Intent intent = new Intent(this, ShowFruitActivity.class);
        intent.putExtra("fruitList", fruits);
        // starts the second activity using intent
        startActivity(intent);
    }
}