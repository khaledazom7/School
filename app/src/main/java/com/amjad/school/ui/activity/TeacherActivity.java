package com.amjad.school.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.school.databinding.ActivityLoginBinding;
import com.amjad.school.utils.PreferenceUtils;

public class TeacherActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
binding=ActivityLoginBinding.inflate(getLayoutInflater());
setContentView(binding.getRoot());
binding.buttonLogen.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        PreferenceUtils.saveEmail(null,getApplicationContext());
        PreferenceUtils.saveType("",getApplicationContext());
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }
});
    }
}