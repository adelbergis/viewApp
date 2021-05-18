package ru.adelbergis.firsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueBtn;
    private Button falseBtn;
    private Button showAnswer;
    private TextView questionView;

    private Question[] questions = new Question[] {
            new Question(R.string.question_text, true),
            new Question(R.string.question_text1, false),
            new Question(R.string.question_text2, false),
            new Question(R.string.question_text3, false),
            new Question(R.string.question_text4, true),
    };

    private String[] results = new String[questions.length];

    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("SYSTEM INFO: ", "Метод onCreate() запущен");

        if(savedInstanceState != null){
            questionIndex = savedInstanceState.getInt("questionIndex",0);
        }

        trueBtn = (Button) findViewById(R.id.true_btn);
        falseBtn = findViewById(R.id.false_btn);
        showAnswer = findViewById(R.id.get_answer);
        questionView = findViewById(R.id.question_view);

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                questionIndex = (questionIndex + 1) % questions.length;
                if (questionIndex == 0) {
                    Intent intent = new Intent(MainActivity.this, Results.class);
                    intent.putExtra("resutlts",results);
                    startActivity(intent);
                }
                updateQuestion();
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                questionIndex = (questionIndex + 1) % questions.length;
                if (questionIndex == 0) {
                    Intent intent = new Intent(MainActivity.this, Results.class);
                    intent.putExtra("resutlts",results);
                    startActivity(intent);
                }
                updateQuestion();
            }
        });
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer",questions[questionIndex].isAnswer());
                startActivity(intent);
            }
        });
        updateQuestion();
    }

    private void updateQuestion() {
        int questionId = questions[questionIndex].getTextId();
        questionView.setText(questionId);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean answer = questions[questionIndex].isAnswer();
        if (userAnswer == answer) {
            Toast.makeText(MainActivity.this,R.string.correct_toast, Toast.LENGTH_SHORT).show();
            results[questionIndex] = "правильно";
        } else {
            Toast.makeText(MainActivity.this,R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            results[questionIndex] = "неправильно";
        }
    }

    //События

    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO: ", "Метод onStart() запущен");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO: ", "Метод onResume() запущен");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex",questionIndex);
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO: ", "Метод onPause() запущен");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO: ", "Метод onStop() запущен");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO: ", "Метод onDestroy() запущен");
    }
}