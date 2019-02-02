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
            "This has beautiful marble-white walls and beautiful gold. Many thieves, like yourself, want the gold. The thing has no doors or windows. However, it breaks easily to reveal the gold. It is a what?",
            "A man is standing in front of a painting of a man, and he tells us the following: \"Brothers and sisters have I none, but this man's father is my father's son\". Who is on the painting?",
            "Imagine you are on an island called Texel, with inhabitants that look the same from the outside, but differ in their truthfulness. We distinguish the following types:\n" +
                    "\n" +
                    ". Knights, who always tell the truth.\n" +
                    ". Knaves, who never tell the truth.\n" +
                    ". Normals, who sometimes tell the truth and sometimes lie.\n" +
                    "\n" +
                    "Assume you meet one of these inhabitants, and he tells you: \"I'm no Knight\". Then, of what type is inhabitant?",
            "A certain street contains 100 buildings. They are numbered from 1 to 100. How many times does the digit 9 occur in these numbers?",
            "One day Alice meets the Lion and the Unicorn in the Forest of Forgetfulness. She knows that the Lion lies on Mondays, Tuesdays, and Wednesdays, and tells the truth on the other days of the week. The Unicorn, on the other hand, lies on Thursdays, Fridays, and Saturdays, but tells the truth on the other days of the week. Now they make the following statements to Alice:\n" +
                    "\n" +
                    ". Lion: Yesterday was one of my lying days.\n" +
                    ". Unicorn: Yesterday was one of my lying days too.\n" +
                    "\n" +
                    "What day is it?",
            "A snail is at the bottom of a 12 meters deep pit. Every day the snail climbs 3 meters upwards, but at night, it slides 2 meters back downwards. How many days does it take before the snail reaches the top of the pit?",
            "The day after tomorrow is the third day after Wednesday. Which day was the day before yesterday?",
            "In the Tour de France, what is the position of a rider, after he passes the second placed rider?",
            "At the start of a beautiful Sunday afternoon the lord of castle Loevestein walked into his study. He wanted to put a piece of jewelry, which he took out of the safe an hour before, back into the safe. He noticed that the safe had been cracked open and he called the police immediately.\n" +
                    "\n" +
                    "When the police interrogated the staff on their activities during the hour in which the safe had been cracked, they gave the following alibis:\n" +
                    "\n" +
                    ". The cook was preparing lunch;\n" +
                    ". The gardener was pruning the hedge;\n" +
                    ". The butler was fetching the mail;\n" +
                    ". The maid was making the beds.\n" +
                    "\n" +
                    "Who was the culprit?",
            "The poor have it,\n" +
                    "the rich want it,\n" +
                    "but if you eat it, you will die.\n" +
                    "What is this?",
            "After an encounter with a malicious wizard, you find yourself on a crossroads in the middle of a dark forest. A signpost tells you that you that the forest has four exits: north, west, south, and east:\n" +
                    "\n" +
                    ". in the north, there is a swamp full of crocodiles, from which nobody has ever escaped;\n" +
                    ". in the west, there is a ravine too big for you to cross even by rope;\n" +
                    ". in the south, there are four giant lions that haven't eaten for three months;\n" +
                    ". in the east, there is an enormous mountain that is too steep and high to climb.\n" +
                    "\n" +
                    "Which way do you go to escape from the forest?"
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
            {"Old palace", "Museum attic", "Egg", "Ball"},
            {"His father", "He himself", "His son", "His grandfather"},
            {"Knights", "Knaves", "Normals", "Indeterminable"},
            {"10", "11", "19", "20"},
            {"Monday", "Thursday", "Saturday", "Sunday"},
            {"9.5", "10", "11.5", "12"},
            {"Monday", "Tuesday", "Wednesday", "Thursday"},
            {"First", "Second", "He won", "He's a dead man"},
            {"The cook", "The gardener", "The butler", "The maid"},
            {"Imagination", "Passion", "Nothing", "Ambition"},
            {"North", "West", "South", "East"}
    };

    private String[] mAnswerDescription = {"", "", "", "Bob and Ann are fish", "", "", "", "", "", "", "We can replace \"my father's son\" by \"myself\" since he is the only child. Now remains: \"This man's father is myself\", so this man is his son.",
            "A Knight cannot make the statement \"I'm no Knight\", since this would be a lie and a Knight always tells the truth. A Knave could also not make the statement, since that would be a true statement, and a Knave never tells the truth. A Normal however can say, \"I'm no Knight\". It is true, and Normals sometimes tell the truth.",
            "Note: 99 contains TWO nines!",
            "The only days the Lion can say that he lied on the previous day are Mondays and Thursdays. The only days the Unicorn can say this, are Thursdays and Sundays. Therefore, the only day they both say that is on Thursday.",
            "", "The third day after Wednesday is Saturday. If the day after tomorrow is Saturday, then today is Thursday. Therefore, the solution is: the day before yesterday was Tuesday.",
            "", "The butler was the culprit. He said that the he was fetching the mail, but on Sunday, there is no mail delivery!",
            "", "The south. If the lions haven't eaten in three months, they are dead!"};

    private int[] mCorrectIndex = {2, 1, 0, 3, 0, 1, 2, 0, 1, 2, 2, 2, 3, 1, 0, 1, 1, 2, 2, 2};

    public String getQuestion(int x) {
        return mQuestions[x];
    }

    public String[][] getChoices() {
        return mChoices;
    }

    public String[] getAnswerDescription() {
        return mAnswerDescription;
    }

    public int[] getCorrectIndex() {
        return mCorrectIndex;
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
