package com.example.areyouhigh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mQuestionNumber;
    private TextView mQuestionDescription;
    private Button mChoice1;
    private Button mChoice2;
    private Button mChoice3;
    private Button mChoice4;
    private int number;
    private Question mQuestion = new Question();
    private int mQuestionLength = mQuestion.getQuestionLength();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionNumber = findViewById(R.id.question_num);
        mQuestionDescription = findViewById(R.id.question_des);
        mChoice1 = findViewById(R.id.choice1);
        mChoice2 = findViewById(R.id.choice2);
        mChoice3 = findViewById(R.id.choice3);
        mChoice4 = findViewById(R.id.choice4);
        updateQuestion();
    }

    public void chooseAnswer1(View view) {
    }

    public void chooseAnswer2(View view) {
    }

    public void chooseAnswer3(View view) {
    }

    public void chooseAnswer4(View view) {
    }

    private void updateQuestion(){
        number++;
        mQuestionNumber.setText(Integer.toString(number));
        Random r = new Random();
        int x = r.nextInt(mQuestionLength);
        mQuestionDescription.setText(mQuestion.getQuestion(x));
        mChoice1.setText(mQuestion.getChoice1(x));
        mChoice2.setText(mQuestion.getChoice2(x));
        mChoice3.setText(mQuestion.getChoice3(x));
        mChoice4.setText(mQuestion.getChoice4(x));
    }
}
