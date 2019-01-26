package com.example.areyouhigh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mQuestionNumber, mQuestionDescription;
    private Button mChoice1, mChoice2, mChoice3, mChoice4;
    private int number = 0;
    private Question mQuestion = new Question();
    private int mQuestionLength = mQuestion.getQuestionLength();
    private int score;
    private String correctAnswer;
    public static final String SCORE = "total score";

    List <Integer> positionList = mQuestion.getShufflePositions();

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
        if (mChoice1.getText() == correctAnswer) {
            score++;
            updateQuestion();
        } else {
            updateQuestion();
        }
    }

    public void chooseAnswer2(View view) {
        if (mChoice2.getText() == correctAnswer) {
            score++;
            updateQuestion();
        } else {
            updateQuestion();
        }

    }

    public void chooseAnswer3(View view) {
        if (mChoice3.getText() == correctAnswer) {
            score++;
            updateQuestion();
        } else {
            updateQuestion();
        }
    }

    public void chooseAnswer4(View view) {
        if (mChoice4.getText() == correctAnswer) {
            score++;
            updateQuestion();
        } else {
            updateQuestion();
        }
    }

    private void updateQuestion() {
        if (number < 10) {
            number++;
            mQuestionNumber.setText("Number " + Integer.toString(number));
//            Random r = new Random();
//            int x = r.nextInt(mQuestionLength);
            Log.d("POSITION", Integer.toString(positionList.get(number-1)));
            mQuestionDescription.setText(mQuestion.getQuestion(positionList.get(number-1)));
            mChoice1.setText(mQuestion.getChoice1(positionList.get(number-1)));
            mChoice2.setText(mQuestion.getChoice2(positionList.get(number-1)));
            mChoice3.setText(mQuestion.getChoice3(positionList.get(number-1)));
            mChoice4.setText(mQuestion.getChoice4(positionList.get(number-1)));
            correctAnswer = mQuestion.getCorrectAnswer(positionList.get(number-1));
        } else {
            launchResultActivity();
        }
    }

    private void launchResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(SCORE, Integer.toString(score));
        startActivity(intent);
    }
}
