package com.amjad.school.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.amjad.school.R;
import com.amjad.school.databinding.ActivityRegisterBinding;
import com.amjad.school.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Calendar;


public class RegisterActivity extends AppCompatActivity {
    private String name, email, password, date, acountType, view;
    private Button registerButton;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseUser firebaseUser;

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
                name = binding.editTextTextName.getText().toString().trim();
                email = binding.editTextTextEmailAddress.getText().toString().trim();
                password = binding.editTextTextPassword2.getText().toString().trim();
                acountType = "";

                checkInputInfo();
                if (count == 3) {

                    registerUserByEmailAndPassword(email, password);
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        });
    }


    private void registerUserByEmailAndPassword(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(getApplicationContext(), "Failed to register! Try again!", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void addNewUserOnDbFirebase() {
        User user = new User(name, email, "", "", "", "acountType", "", "", "", date, true);
        // save on cloudFireStore
        //storge user in datd pase
        DocumentReference documentReference = firebaseFirestore.collection("Users")
                .document(firebaseUser.getUid());
        documentReference.set(user);
        verifyEmail();
    }

    private void verifyEmail() {
        assert firebaseUser != null;
        firebaseUser.sendEmailVerification();
        Toast.makeText(getApplicationContext(), "Registered Successfully!\nCheck your email to verify your account!", Toast.LENGTH_LONG).show();
    }

    int count = 3;

    private void checkInputInfo() {
        count = 3;
        if (name.isEmpty()) {
            binding.editTextTextName.setError("Yuor name is Required");
            binding.editTextTextName.hasFocus();
            count--;
            return;
        }
        if (email.isEmpty()) {
            binding.editTextTextEmailAddress.setError("Yuor email is Required");
            binding.editTextTextEmailAddress.hasFocus();
            count--;
            return;
        }
        if (password.isEmpty()) {
            binding.editTextTextPassword2.setError("Yuor password is Required");
            binding.editTextTextPassword2.hasFocus();
            count--;
            return;


        }
        if (acountType.isEmpty()) {
            Toast.makeText(getApplicationContext(), "You must select the acount type", Toast.LENGTH_SHORT).show();
            return;
        }


    }

    private void asd() {
        // Check which radio button was clicked
        switch (View.getId()) {
            case R.id.buttonadmin:
                acountType = "admin";
                // Pirates are the best
                break;
            case R.id.buttonteacher:
                acountType = "teacher";

                // Ninjas rule
                break;
            case R.id.buttonstudent:
                acountType = "student";

                // Ninjas rule
                break;
        }
        Toast.makeText(getApplicationContext(), " acount type", Toast.LENGTH_SHORT).show();
    }
}
