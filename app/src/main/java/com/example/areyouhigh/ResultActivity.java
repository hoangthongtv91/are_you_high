package com.example.areyouhigh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView mScore = findViewById(R.id.score_view);
        Intent intent = getIntent();
        String score =intent.getStringExtra(MainActivity.SCORE);
        mScore.setText(score);
    }
}
