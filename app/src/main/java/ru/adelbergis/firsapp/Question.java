package ru.adelbergis.firsapp;

public class Question {
    private int textId;
    private boolean answer;

    public Question(int textId, boolean answer) {
        this.textId = textId;
        this.answer = answer;
    }

    public int getTextId() {
        return textId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
