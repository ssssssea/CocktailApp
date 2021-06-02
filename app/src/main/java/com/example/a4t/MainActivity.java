package com.example.a4t;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textInputEditText1, textInputEditText2;
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

       textInputEditText1 = findViewById(R.id.ingredient);

       textInputEditText2 = findViewById(R.id.cocktailName);

       button = findViewById(R.id.button);
       button2 = findViewById(R.id.button2);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String ingredient = textInputEditText1.getText().toString();
               Intent intent = new Intent(MainActivity.this, SearchActivity.class);
               intent.putExtra("ingredient", ingredient);
               startActivity(intent);
           }
       });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textInputEditText2.getText().toString();
                Intent intent = new Intent(MainActivity.this, NameSearchActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}


