package com.kriskrause.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.kriskrause.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_IS_SHOWN = "com.kriskrause.geoquiz.answer_shown";

    private boolean _answerIsTrue;
    private TextView _answerTextView;
    private Button _showAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cheat);

        _answerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        _answerTextView = (TextView) findViewById(R.id.answerTextView);

        _showAnswer = (Button) findViewById(R.id.showAnswerButton);

        _showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_answerIsTrue) {
                    _answerTextView.setText(R.string.true_button);
                } else {
                    _answerTextView.setText(R.string.false_button);
                }

                setAnswerShownResult(true);
            }
        });

        setAnswerShownResult(false);
    }

    private void setAnswerShownResult(boolean answerIsShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_IS_SHOWN, answerIsShown);
        setResult(RESULT_OK, data);
    }
}