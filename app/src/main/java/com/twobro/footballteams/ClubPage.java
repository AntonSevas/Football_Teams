package com.twobro.footballteams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ClubPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_page);

        ConstraintLayout clubBg = findViewById(R.id.clubPageBg);
        ImageView clubImage = findViewById(R.id.clubPageImage);
        TextView clubTitle = findViewById(R.id.clubTitle);
        TextView clubCountry = findViewById(R.id.clubPageCountry);
        TextView clubTrainer = findViewById(R.id.clubPageTrainerID);
        TextView clubText = findViewById(R.id.clubDescription);

        clubBg.setBackgroundColor(getIntent().getIntExtra("clubBG", 0));
        clubImage.setImageResource(getIntent().getIntExtra("clubImage",0));
        clubCountry.setText(getIntent().getStringExtra("clubCountry"));
        clubTitle.setText(getIntent().getStringExtra("clubTitle"));
        clubTrainer.setText(getIntent().getStringExtra("clubTrainer"));
        clubText.setText(getIntent().getStringExtra("clubText"));

    }
}