package com.kriskrause.geoquiz.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

    private Button _trueButton;
    private Button _falseButton;
    private ImageButton _nextButton;
    private ImageButton _prevButton;
    private TextView _questionTextView;
    private int _currentIndex = 0;

    private TrueFalse[] _questionBank = new TrueFalse[]{
        new TrueFalse(R.string.question_oceans, true),
        new TrueFalse(R.string.question_mideast, false),
        new TrueFalse(R.string.question_africa, false),
        new TrueFalse(R.string.question_americas, true),
        new TrueFalse(R.string.question_asia, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        _trueButton = (Button) findViewById(R.id.true_button);
        _falseButton = (Button) findViewById(R.id.false_button);
        _questionTextView = (TextView) findViewById(R.id.question_text_view);
        _nextButton = (ImageButton) findViewById(R.id.next_button);
        _prevButton = (ImageButton) findViewById(R.id.previous_button);

        _nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            _currentIndex = (_currentIndex + 1) % _questionBank.length;
            updateQuestion();
            }
        });

        _prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_currentIndex == 0) {
                    // Back to the last question.
                    _currentIndex = _questionBank.length - 1;
                } else {
                    _currentIndex = _currentIndex - 1;
                }

                updateQuestion();
            }
        });

        _trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        _falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        _questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _currentIndex = (_currentIndex + 1) % _questionBank.length;
                updateQuestion();
            };
        });

        updateQuestion();
    }

    private void updateQuestion() {
        int question = _questionBank[_currentIndex].getQuestion();

        _questionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = _questionBank[_currentIndex].isTrueQuestion();
        int messageResId = 0;

        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }
        else{
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}