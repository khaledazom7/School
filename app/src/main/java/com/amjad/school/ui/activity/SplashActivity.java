package com.amjad.school.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.amjad.school.R;
import com.amjad.school.databinding.FragmentEditTeacherBinding;
import com.amjad.school.utils.PreferenceUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String email = PreferenceUtils.getEmail(getApplicationContext());
                String typeUser = PreferenceUtils.getType(getApplicationContext());
                if (email ==null) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                } else {
                    if (typeUser.equals("teacher")) {

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else if (typeUser.equals("admin")) {
                        startActivity(new Intent(getApplicationContext(), AdminActivity.class));
                    }



            }
                finish();

            }
        },2000);
    }

    public static class EditTeacherFragment extends Fragment {

        FragmentEditTeacherBinding binding;
        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
        }
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binding = FragmentEditTeacherBinding.inflate(inflater, container, false);
            return binding.getRoot();
        }
        @Override

        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }
    }
}