package com.example.popcat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView sm;
    TextView count;
    Long clickCount = 0L;
    Button button;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sm = findViewById(R.id.sm);
        count = findViewById(R.id.count);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCount = Long.valueOf(0);
                count.setText(clickCount.toString());
            }
        });

        sm.setOnTouchListener(((view, motionEvent) -> {
            switch (motionEvent.getAction()){
                case (MotionEvent.ACTION_UP):
                    this.sm.setImageResource(R.drawable.shutmouse);
                    return true;
                case (MotionEvent.ACTION_DOWN):
                    this.sm.setImageResource(R.drawable.openmouth);
                    clickCount++;
                    count.setText(clickCount.toString());
                    return true;
            }
            return false;
        }));

    }
}