package com.example.testing_touch;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View cuadrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cuadrado = findViewById(R.id.cuadrado);

        View layout = findViewById(R.id.main_layout);
        layout.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();

                Rect bounds = new Rect();
                cuadrado.getGlobalVisibleRect(bounds);
                if (bounds.contains((int) x, (int) y)) {
                    Toast.makeText(MainActivity.this, "Tocado en el cuadrado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Tocaste fuera del cuadrado", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }
}