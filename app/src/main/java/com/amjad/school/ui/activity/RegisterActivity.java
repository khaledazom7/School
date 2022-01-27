package com.amjad.school.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.school.R;

public class RegisterActivity extends AppCompatActivity {
    EditText nameEditeText,emailEditeText,passwordEditeText;
    String name,email,password;
    Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameEditeText = findViewById(R.id.editTextTextName);
        emailEditeText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditeText = findViewById(R.id.editTextTextPassword);
        registerButton = findViewById(R.id.buttonregister);
        name = nameEditeText.getText().toString().trim();
        email = emailEditeText.getText().toString().trim();
        password = passwordEditeText.getText().toString().trim();


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(count==3) {

                    checkInputInfo();
                }
            }
        });


}
   int count =3;
private int checkInputInfo(){
    count =3;
    if (name.isEmpty()) {
        nameEditeText.setError("Yuor name is Required");
        nameEditeText.hasFocus();
        count --;
        return;
    }
    if (email.isEmpty()) {
        emailEditeText.setError("Yuor email is Required");
        nameEditeText.hasFocus();
        count --;
        return;
    }
    if (password.isEmpty()) {
        passwordEditeText.setError("Yuor password is Required");
        nameEditeText.hasFocus();
        count --;
        return;
    }
    }
}