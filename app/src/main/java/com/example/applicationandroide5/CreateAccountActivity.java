package com.example.applicationandroide5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccountActivity extends AppCompatActivity {
    private TextView alreadyHasAccountBtn;
    private TextView errorCreateAccountTextView;
    private Button createAccountBtn;

    private EditText usernameEditText;
    private EditText passwordEditText;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        alreadyHasAccountBtn = findViewById(R.id.alreadyHasAccountBtn);
        createAccountBtn = findViewById(R.id.createAccountBtn);
        usernameEditText = findViewById(R.id.createusernameEditText);
        passwordEditText = findViewById(R.id.createpasswordEditText);
        errorCreateAccountTextView = findViewById(R.id.errorCreateAccountTextVieuw);

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
            }
        });
        alreadyHasAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent connectToAccountActivity = new Intent(getApplicationContext(), ConnexionAccounteActivity.class);
                startActivity(connectToAccountActivity);
            }
        });


    }
}