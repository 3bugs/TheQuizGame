package com.example.quizgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizgame.model.Question;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    private Button mChoice1Button, mChoice2Button, mChoice3Button;

    private List<Question> mQuestionList;
    private Question mCurrentQuestion;
    private int mCurrentQuestionIndex = 0;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setupViews();

        prepareQuestionList();

        nextQuestion();
    }

    private void nextQuestion() {
        if (mCurrentQuestionIndex >= mQuestionList.size()) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(GameActivity.this);
            dialog.setTitle("สรุปผล");
            dialog.setMessage("คุณได้ " + mScore + " คะแนน");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dialog.show();
            return;
        }

        mCurrentQuestion = mQuestionList.get(mCurrentQuestionIndex);

        mQuestionTextView.setText(mCurrentQuestion.questionText);
        mChoice1Button.setText(mCurrentQuestion.choice1);
        mChoice2Button.setText(mCurrentQuestion.choice2);
        mChoice3Button.setText(mCurrentQuestion.choice3);
    }

    private void setupViews() {
        mQuestionTextView = findViewById(R.id.question_text_view);
        mChoice1Button = findViewById(R.id.choice_1_button);
        mChoice2Button = findViewById(R.id.choice_2_button);
        mChoice3Button = findViewById(R.id.choice_3_button);

        mChoice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentQuestion.answer == 1) {
                    handleCorrectAnswer();
                } else {
                    handleWrongAnswer();
                }
            }
        });
        mChoice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentQuestion.answer == 2) {
                    handleCorrectAnswer();
                } else {
                    handleWrongAnswer();
                }
            }
        });
        mChoice3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentQuestion.answer == 3) {
                    handleCorrectAnswer();
                } else {
                    handleWrongAnswer();
                }
            }
        });
    }

    private void handleWrongAnswer() {
        Toast.makeText(GameActivity.this, "ผิดครับ", Toast.LENGTH_LONG).show();
        mCurrentQuestionIndex++;
        nextQuestion();
    }

    private void handleCorrectAnswer() {
        mScore++;
        Toast.makeText(GameActivity.this, "ถูกต้องนะครับ", Toast.LENGTH_LONG).show();
        mCurrentQuestionIndex++;
        nextQuestion();
    }

    private void prepareQuestionList() {
        mQuestionList = new ArrayList<>();

        mQuestionList.add(
                new Question(
                        "จังหวัดใดอยู่เหนือสุดของประเทศไทย",
                        "เชียงใหม่",
                        "เชียงราย",
                        "แม่ฮ่องสอน",
                        2
                )
        );
        mQuestionList.add(
                new Question(
                        "จังหวัดใดอยู่ใต้สุดของประเทศไทย",
                        "ปัตตานี",
                        "ยะลา",
                        "นราธิวาส",
                        3
                )
        );
        mQuestionList.add(
                new Question(
                        "จังหวัดใดของประเทศไทยมีจำนวนประชากรน้อยที่สุด",
                        "ระนอง",
                        "ภูเก็ต",
                        "สมุทรสงคราม",
                        1
                )
        );
    }
}
