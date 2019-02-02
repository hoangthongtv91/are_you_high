package com.example.areyouhigh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        TextView mDescription = findViewById(R.id.description);
        Button mNextButton = findViewById(R.id.back_to_main_button);
        Intent intent = getIntent();
        String description = intent.getStringExtra(MainActivity.DESCRIPTION);
        mDescription.setText(description);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}
