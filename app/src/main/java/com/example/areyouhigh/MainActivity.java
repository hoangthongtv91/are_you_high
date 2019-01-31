package com.example.areyouhigh;

import android.content.Intent;
import android.graphics.Color;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String SCORE = "total score";
    private TextView mQuestionNumber, mQuestionDescription;
    private Button mNextButton;
    private int number = 0;
    private int score = 0;
    private Question mQuestion = new Question();
    private List<Integer> positionList = mQuestion.getShufflePositions();
    private boolean answered;
    private int answerIndex;
    private Button[] mChoices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionNumber = findViewById(R.id.question_num);
        mQuestionDescription = findViewById(R.id.question_des);
        mNextButton = findViewById(R.id.next_button);

        mChoices = new Button[]{
                findViewById(R.id.choice1), findViewById(R.id.choice2),
                findViewById(R.id.choice3), findViewById(R.id.choice4)};

        setQuestion(0);
    }

    public void setQuestion(int number) {
        answered = false;
        int q_num = positionList.get(number);
        mQuestionNumber.setText("Number " + Integer.toString(number + 1));
        mQuestionDescription.setText(mQuestion.getQuestion(q_num));
        for(int i = 0; i < mChoices.length; i++) {
            mChoices[i].setText(mQuestion.getChoices()[q_num][i]);
            mChoices[i].setEnabled(true);
            mChoices[i].setBackgroundResource(R.drawable.button_background);
        }
        answerIndex = mQuestion.getCorrectIndex()[q_num];
        mNextButton.setVisibility(View.INVISIBLE);
    }

    public void checkAnswer(View view) {
        if (!answered) {
            int choice = Integer.parseInt(view.getTag().toString());
            if (choice == answerIndex) {
                mChoices[choice].setBackgroundResource(R.drawable.true_choice_background);
                score++;
            } else {
                mChoices[answerIndex].setBackgroundResource(R.drawable.true_choice_background);
                mChoices[choice].setBackgroundResource(R.drawable.false_choice_background);
            }

            mNextButton.setVisibility(View.VISIBLE);
            for(int i = 0; i < mChoices.length; i++) {
                if (i != choice && i != answerIndex) {
                    mChoices[i].setEnabled(false);
                }
            }
            answered = true;
        }
    }

    public void updateQuestion(View view) {
        if (number < 9) {
            number++;
            setQuestion(number);
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



