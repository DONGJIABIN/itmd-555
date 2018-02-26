package com.example.star.hw4slideshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by STAR on 2/26/2018.
 */

public class SlideActivity extends Activity {

    private TextView titleTextView, descriptionTextView;
    private ImageView imageView;

    private CountDownTimer countDownTimer;
    private int imageNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        this.initControl();
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageNumber = 1;

        this.SlideImage();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }

    private void initControl() {
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    private void SlideImage() {
        if (imageNumber == 1){
            titleTextView.setText("Beijing");
            descriptionTextView.setText("I used to work here.");
            imageView.setImageResource(R.drawable.beijing);
        } else if (imageNumber == 2) {
            titleTextView.setText("San Francisco");
            descriptionTextView.setText("I like SF very much.");
            imageView.setImageResource(R.drawable.francisco);
        } else if (imageNumber == 3) {
            titleTextView.setText("Paris");
            descriptionTextView.setText("Good French food and wine!");
            imageView.setImageResource(R.drawable.paris);
        } else if (imageNumber == 4) {
            titleTextView.setText("Chicago");
            descriptionTextView.setText("I enjoy the holiday here.");
            imageView.setImageResource(R.drawable.chicago);
        } else if (imageNumber == 5) {
            titleTextView.setText("Dandong");
            descriptionTextView.setText("I have never gone there.");
            imageView.setImageResource(R.drawable.dandong);
        } else if (imageNumber == 6) {
            titleTextView.setText("Moscow");
            descriptionTextView.setText("Moscow is very beautiful city.");
            imageView.setImageResource(R.drawable.moscow);
        } else if (imageNumber == 7) {
            titleTextView.setText("Mumbai");
            descriptionTextView.setText("Mumbai is a capital of India.");
            imageView.setImageResource(R.drawable.mumbai);
        } else if (imageNumber == 8) {
            titleTextView.setText("New York");
            descriptionTextView.setText("New York is very large city.");
            imageView.setImageResource(R.drawable.newyork);
        } else if (imageNumber == 9) {
            titleTextView.setText("Shenyang");
            descriptionTextView.setText("Shenyang is one of large cities in China.");
            imageView.setImageResource(R.drawable.shenyang);
        } else if (imageNumber == 10) {
            titleTextView.setText("Tokyo");
            descriptionTextView.setText("Tokyo is a capiatal of Japan.");
            imageView.setImageResource(R.drawable.tokyo);
            imageNumber = 0;
        }

        Toast.makeText(SlideActivity.this, "Index => " + Integer.toString(imageNumber), Toast.LENGTH_SHORT).show();

        SliderTimer(GlobalApplication.timeValue * 1000);
    }

    private void SliderTimer(int timeValue) {

        countDownTimer = new CountDownTimer(timeValue, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                countDownTimer.cancel();
                imageNumber = imageNumber + 1;

                SlideImage();
            }
        }.start();
    }
}
