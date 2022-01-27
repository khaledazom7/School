package com.amjad.school.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.school.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {
   private EditText nameEditeText,emailEditeText,passwordEditeText;
   private String name,email,password;
   private Button registerButton;


   FirebaseAuth firebaseAuth;
   FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameEditeText = findViewById(R.id.editTextTextName);
        emailEditeText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditeText = findViewById(R.id.editTextTextPassword);
        registerButton = findViewById(R.id.buttonregister);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                name = nameEditeText.getText().toString().trim();
                email = emailEditeText.getText().toString().trim();
                password = passwordEditeText.getText().toString().trim();
                checkInputInfo();
                if(count==3) {
                    registerUserByEmailAndPassword(email,password);
                    firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                addNewUserOnDbFirebase();
                            } else {
                                Toast.makeText(getApplicationContext(), "Failed to register! Try again!", Toast.LENGTH_SHORT).show();
                            }
                            progressBar.setVisibility(View.GONE);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                private void addNewUserOnDbFirebase() {
                    firebaseUser = firebaseAuth.getCurrentUser();
                    User user = new User(userName, userEmail, "", "", "", "", userType, dateOfCreate, "https://i.ibb.co/W0hVGcJ/accont.png", true, "");
                    // save on cloudFireStore
                    DocumentReference documentReference = firebaseFirestore.collection("Users")
                            .document(firebaseUser.getUid());
                    documentReference.set(user);
                    verifyEmail();
                }

                private void verifyEmail() {
                    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                    assert firebaseUser != null;
                    firebaseUser.sendEmailVerification();
                    Toast.makeText(getApplicationContext(), "Registered Successfully!\nCheck your email to verify your account!", Toast.LENGTH_LONG).show();
                }




                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
finish();
                }
            }

            private void registerUserByEmailAndPassword(String email, String password) {
            }
        });


}
   int count =3;

private void checkInputInfo(){
    count =3;
    if (name.isEmpty()) {
        nameEditeText.setError("Yuor name is Required");
        nameEditeText.hasFocus();
        count--;
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