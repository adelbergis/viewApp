package ru.adelbergis.firsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private TextView answerTextView;
    private boolean isAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        isAnswer = getIntent().getBooleanExtra("answer",false);

        answerTextView = findViewById(R.id.answerTextView);
        answerTextView.setText(isAnswer?R.string.yes:R.string.no);
    }
}