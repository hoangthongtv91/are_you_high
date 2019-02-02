package com.example.areyouhigh;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String SCORE = "total score";
    public static final String DESCRIPTION = "Answer description";
    public static final int REQUEST = 1;
    public String mAnswerDescription;
    private TextView mQuestionNumber, mQuestionDescription;
    private Button mNextButton, mAnswerButton;
    private int number = 0;
    private int score = 0;
    private Question mQuestion = new Question();
    private List<Integer> positionList = mQuestion.getShufflePositions();
    private boolean answered;
    private int answerIndex;
    private Button[] mChoices;
    private int[] AnswerDescriptionIndex = {3, 10, 11, 12, 13, 15, 17, 19};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionNumber = findViewById(R.id.question_num);
        mQuestionDescription = findViewById(R.id.question_des);
        mNextButton = findViewById(R.id.next_button);
        mAnswerButton = findViewById(R.id.answer_button);

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
        for (int i = 0; i < mChoices.length; i++) {
            mChoices[i].setText(mQuestion.getChoices()[q_num][i]);
            mChoices[i].setEnabled(true);
            mChoices[i].setBackgroundResource(R.drawable.button_background);
        }
        answerIndex = mQuestion.getCorrectIndex()[q_num];
        mNextButton.setVisibility(View.INVISIBLE);
        mAnswerButton.setVisibility(View.INVISIBLE);
        mAnswerDescription = mQuestion.getAnswerDescription()[q_num];
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
            for (int i : AnswerDescriptionIndex)
                if (positionList.get(number) == i)
                    mAnswerButton.setVisibility(View.VISIBLE);
            for (int i = 0; i < mChoices.length; i++) {
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

    public void showAnswerDetail(View view) {
        launchAnswerActivity();
    }

    private void launchAnswerActivity() {
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra(DESCRIPTION,mAnswerDescription);
        startActivityForResult(intent,REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST){
            if (resultCode == RESULT_OK)
                if (number < 9) {
                    number++;
                    setQuestion(number);
                } else {
                    launchResultActivity();
                }
        }
    }
}



