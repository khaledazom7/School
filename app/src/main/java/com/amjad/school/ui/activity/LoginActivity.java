package com.amjad.school.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.amjad.school.databinding.ActivityLoginBinding;
import com.amjad.school.model.User;
import com.amjad.school.utils.PreferenceUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseUser firebaseUser;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();//data link ربط البييانات
        firebaseFirestore = FirebaseFirestore.getInstance();        //Data storage

        firebaseUser = firebaseAuth.getCurrentUser();
        longUser();
        registerUser();
    }

    private void registerUser() {
        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });
    }


    private void longUser() {
        binding.buttonLogen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = binding.editTextTextEmailAddress.getText().toString().trim();
                password = binding.editTextTextPassword2.getText().toString().trim();
                //checkInputInfo();
                if (email.isEmpty()) {
                    binding.editTextTextEmailAddress.setError("Your email is Required*");
                    binding.editTextTextEmailAddress.hasFocus();
                    return;
                }

                if (password.isEmpty()) {
                    binding.editTextTextPassword2.setError("The Password is Required*");
                    binding.editTextTextPassword2.hasFocus();
                    return;
                }
                signInToAccountByEmailAndPassword();
            }


        });
    }

    private void signInToAccountByEmailAndPassword() {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                checkUserType();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void checkUserType() {
        firebaseAuth = FirebaseAuth.getInstance();//data link ربط البييانات
        firebaseUser = firebaseAuth.getCurrentUser();
        assert firebaseUser != null;
        String userID = firebaseUser.getUid();
        firebaseFirestore.collection("Users").document(userID).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        User user = documentSnapshot.toObject(User.class);
                        if (user == null) {
                            Toast.makeText(getApplicationContext(), "You not confirm your account", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Successfully Sign in", Toast.LENGTH_SHORT).show();
                            String typeUser = user.getUserType();
                            String email = user.getEmail();
                            PreferenceUtils.saveEmail(email, getApplicationContext());
                            PreferenceUtils.saveType(typeUser, getApplicationContext());
                            if (typeUser.equals("teacher")) {
                                startActivity(new Intent(getApplicationContext(), TeacherActivity.class));
                            } else if (typeUser.equals("admin")) {
                                startActivity(new Intent(getApplicationContext(), AdminActivity.class));
                            } else if (typeUser.equals("student")) {
                                //startActivity(new Intent(getApplicationContext(), StudentActivity.class));
                            }
                            finish();
                        }
                    }
                });

    }


    private void checkInputInfo() {
        if (email.isEmpty()) {
            binding.editTextTextEmailAddress.setError("Yuor email is Required");
            binding.editTextTextEmailAddress.hasFocus();
            return;
        }
        if (password.isEmpty()) {
            binding.editTextTextPassword2.setError("Yuor password is Required");
            binding.editTextTextPassword2.hasFocus();
            return;
        }
    }
}
