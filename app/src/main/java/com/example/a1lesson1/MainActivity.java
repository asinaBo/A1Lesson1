package com.example.a1lesson1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email, theme, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        theme = findViewById(R.id.theme);
        body = findViewById(R.id.body);
        Button btSend = findViewById(R.id.btSend);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

    }

    private void sendMail() {
        if (!email.getText().toString().isEmpty() && !theme.getText().toString().isEmpty()
                && !body.getText().toString().isEmpty()) {


        String to = email.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
        intent.setType("text/plain");


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Gmail App is not installed", Toast.LENGTH_SHORT).show();

        }
        }
        else {
            Toast.makeText(MainActivity.this, "Please fill all the fields",
                    Toast.LENGTH_SHORT).show();
    }}
}