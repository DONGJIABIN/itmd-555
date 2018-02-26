package com.example.star.hw4slideshow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView timerTextView;
    private SeekBar seekBar;
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initControl();

        this.setControl();

        this.initUI();
    }

    private void initControl() {
        timerTextView = (TextView) findViewById(R.id.timeTextView);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        startBtn = (Button) findViewById(R.id.startBtn);
    }

    private void setControl() {
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, SlideActivity.class);
                startActivity(mainIntent);
            }
        });
    }

    private void initUI() {

        seekBar.setProgress(5);
        seekBar.setMax(30);

        timerTextView.setText(Integer.toString(5));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                // Please enter the code when you change the seek bar value
                int timevalue = seekBar.getProgress();
                if (timevalue == 0) {
                    timerTextView.setText(Integer.toString(1));
                    GlobalApplication.timeValue = 1;
                } else {
                    timerTextView.setText(Integer.toString(timevalue));
                    GlobalApplication.timeValue = timevalue;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
