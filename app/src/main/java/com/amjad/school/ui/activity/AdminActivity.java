package com.amjad.school.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.school.adapter.UsersAdapter;
import com.amjad.school.databinding.ActivityAdminBinding;
import com.amjad.school.model.User;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AdminActivity extends AppCompatActivity {
private ActivityAdminBinding binding;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();//data link ربط البييانات
        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView=binding.recyclerViewTeacher;
        binding.buttonAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });

        getAllteachers();



    }

    private void getAllteachers() {
        Query query = FirebaseFirestore.getInstance().collection("User")
                .whereEqualTo("userType","teacher");
        FirestoreRecyclerOptions<User>options=new FirestoreRecyclerOptions.Builder<User>()
                .setQuery(query,User.class).
                        build();
        fillTeacherRecycleAdapter(options);
    }

    private void fillTeacherRecycleAdapter(FirestoreRecyclerOptions<User> options) {
        UsersAdapter usersAdapter=new UsersAdapter(options);
        usersAdapter.onItemSetOnClickListener(new UsersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                String userId=documentSnapshot.getId();
                Intent intent=new Intent(getApplicationContext(),OpenTeacherProfile.class);
               // intent.putExtra(UsersAdapter);
                startActivity(intent);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(usersAdapter);
        usersAdapter.startListening();
    }
}