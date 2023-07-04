package com.example.androidpracticewithjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ImageView displayImg;
    Button showBtn, hideBtn, nextBtn;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.constraintLayout);
        displayImg = findViewById(R.id.displayImg);
        showBtn = findViewById(R.id.showImg);
        hideBtn = findViewById(R.id.hideImg);
        nextBtn = findViewById(R.id.nextBtn);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayImg.setVisibility(View.VISIBLE);
                Snackbar snackbar = Snackbar.make(constraintLayout, "Image visible", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        displayImg.setVisibility(View.GONE);
                        Snackbar redo = Snackbar.make(constraintLayout, "Action Reverse", Snackbar.LENGTH_SHORT);
                        redo.setAction("Redo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                displayImg.setVisibility(View.VISIBLE);
                                Snackbar.make(constraintLayout, "Action redone", Snackbar.LENGTH_SHORT).show();
                            }
                        });
                        redo.show();
                    }
                });
                snackbar.show();
            }
        });

        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayImg.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Image hidden", Toast.LENGTH_SHORT).show();

            }
        });

        displayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Drawable current = displayImg.getDrawable();
                Drawable savana = getResources().getDrawable(R.drawable.savana);

                if (current.getConstantState().equals(savana.getConstantState())){
                    displayImg.setImageDrawable(getResources().getDrawable(R.drawable.waterfall));
                }else {
                    displayImg.setImageDrawable(getResources().getDrawable(R.drawable.savana));
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(nextPage);

            }
        });


    }
}