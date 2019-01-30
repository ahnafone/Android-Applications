package com.example.android.bengali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the View that shows the numbers category
        TextView mainMenuView = (TextView) findViewById(R.id.numbers);

        //Set a clickListener on that view
        mainMenuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@Link NumbersActivity}
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                startActivity(numbersIntent);
            }
        });

        //For TextView family
        mainMenuView = (TextView) findViewById(R.id.family);

        mainMenuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);

                startActivity(intent);
            }
        });

        //For TextView colors
        mainMenuView = (TextView) findViewById(R.id.colors);

        mainMenuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorsActivity.class);

                startActivity(intent);
            }
        });

        //For TextView phrases
        mainMenuView = (TextView) findViewById(R.id.phrases);

        mainMenuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);

                startActivity(intent);
            }
        });
    }



}
