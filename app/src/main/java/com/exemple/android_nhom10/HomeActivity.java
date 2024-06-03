package com.exemple.android_nhom10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exemple.android_nhom10.Models.Subject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SubjectAdapter subjectAdapter;
    private List<Subject> subjectList;
    private ImageView imgHomeAvatar;
    private TextView txtHomeAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWidget();
        recyclerView = findViewById(R.id.home_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        subjectList = new ArrayList<>();
        subjectList.add(new Subject("C++", R.drawable.img_subject));
        subjectList.add(new Subject("JAVA", R.drawable.img_subject));
        subjectList.add(new Subject("HTML/SCC", R.drawable.img_subject));
        subjectList.add(new Subject("JAVASCRIPT", R.drawable.img_subject));
        subjectList.add(new Subject("C#", R.drawable.img_subject));
        subjectList.add(new Subject("ANDROID", R.drawable.img_subject));
        subjectList.add(new Subject("ASP.NET", R.drawable.img_subject));
        subjectList.add(new Subject("TYPESCRIPT", R.drawable.img_subject));

        subjectAdapter = new SubjectAdapter(this, subjectList);
        recyclerView.setAdapter(subjectAdapter);

        imgHomeAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        txtHomeAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getWidget(){
        imgHomeAvatar = findViewById(R.id.img_home_avatar);
        txtHomeAvatar = findViewById(R.id.txt_home_username);
    }

}