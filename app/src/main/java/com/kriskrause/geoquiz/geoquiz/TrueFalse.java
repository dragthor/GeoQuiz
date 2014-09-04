package com.kriskrause.geoquiz.geoquiz;

public class TrueFalse {
    public int getQuestion() {
        return _question;
    }

    public void setQuestion(int _question) {
        this._question = _question;
    }

    public boolean isTrueQuestion() {
        return _trueQuestion;
    }

    public void setTrueQuestion(boolean _trueQuestion) {
        this._trueQuestion = _trueQuestion;
    }

    private int _question;
    private boolean _trueQuestion;

    public TrueFalse(int question, boolean trueQuestion) {
        _question = question;
        _trueQuestion = trueQuestion;
    }
}
