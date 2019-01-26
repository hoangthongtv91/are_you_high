package com.example.areyouhigh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String mQuestions[] = {
            "Adriana's mom had four kids: Marta, Anna, Justina...",
            "A man pushed his car past a hotel, only to realize he was bankrupt. How did he figure this out? (He did not have his wallet on him, or in the car)",
            "If there are 100000000 bricks on a plane, and one falls off, how many are left?",
            "The dead bodies of Bob and Ann are lying on the floor. They are naked and wet. Their bodies have absolutely no cuts. The windows are open to the house they live in, and it is stormy. How did they die?",
            "Imagine you're in a dark room that is perfectly empty with nothing in it. There are no windows or doors. What is the easiest way to escape?",
            "A woman is walking, then suddenly dies in the middle of the street. How?",
            "If you look you cannot see me. And if you see me you cannot see anything else. I can make anything you want happen, but later everything goes back to normal. What am I?",
            "A man is going to a party. Along the way he meets a man with seven wives. Each of the wives as seven bags. Each of the bags have seven cats. Each of the cats has seven kittens. Each of the kittens has seven toys. How many people are going to the party?",
            "What walks on four legs in the morning, two in the afternoon and three in the evening?",
            "This has beautiful marble-white walls and beautiful gold. Many thieves, like yourself, want the gold. The thing has no doors or windows. However, it breaks easily to reveal the gold. It is a what?"
    };

    private String mChoices[][] = {
            {"Annabell", "Chloe", "Adriana", "Cleopatra"},
            {"He was mugged as he pushed the car into the parking lot", "He was playing a board game", "His pockets were empty", "There was a text alert"},
            {"99999999", "100000000", "3749875", "1", "0"},
            {"Struck by lightning", "Poisoned", "Drowned", "They aren't human"},
            {"Stop imagining you are in that room", "Die", "Wait", "Dig a hole in the ground with your bare hands"},
            {"She was run over by a car", "She was hit with a brick", "She was shot", "She was poisoned"},
            {"Air", "Nothing", "Imagination", "Other"},
            {"1", "0", "16.857", "9"},
            {"A robot with special programming", "A human", "A monkey who gets his leg cut off, grows them back, then loses them again", "Someone demented"},
            {"Old palace", "Museum attic", "Egg", "Ball"}
    };

    private String mCorrectAnswers[] = {"Adriana", "He was playing a board game", "99999999", "They aren't human", "Stop imagining you are in that room", "She was hit with a brick",
            "Imagination", "1", "A human", "Egg"};

    public String getQuestion(int x) {
        return mQuestions[x];
    }

    public String getChoice1(int x) {
        return mChoices[x][0];
    }

    public String getChoice2(int x) {
        return mChoices[x][1];
    }

    public String getChoice3(int x) {
        return mChoices[x][2];
    }

    public String getChoice4(int x) {
        return mChoices[x][3];
    }

    public String getCorrectAnswer(int x) {
        return mCorrectAnswers[x];
    }

    public int getQuestionLength() {
        return mQuestions.length;
    }

    public List<Integer> getShufflePositions() {
        List<Integer> integerList = new ArrayList<>();
        int x = 0;
        while (x < mQuestions.length) {
            integerList.add(x++);
        }
        Collections.shuffle(integerList);
        return integerList;

    }
}
