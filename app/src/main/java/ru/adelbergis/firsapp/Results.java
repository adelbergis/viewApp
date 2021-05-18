package ru.adelbergis.firsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String[] resultsArray = getIntent().getStringArrayExtra("resutlts");

        resultTextView = findViewById(R.id.resultTextView);

        String resultString = "";

        for (int i = 0; i < resultsArray.length;i++) {
            resultString = resultString + "Вопрос " + i + " - " + resultsArray[i] + "\n";
        }
        resultTextView.setText(resultString);
    }
}