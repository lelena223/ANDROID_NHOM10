package com.exemple.android_nhom10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.exemple.android_nhom10.Models.Lessons;
import java.util.ArrayList;
import java.util.List;

public class DetailSubjectActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LessonsAdapter lessonsAdapter;
    private List<Lessons> lessonList;
    private TextView txtLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_subject);

        // Khởi tạo RecyclerView và thiết lập LayoutManager
        recyclerView = findViewById(R.id.lesson_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Nhận tên môn học từ Intent
        Intent intent = getIntent();
        String subjectName = intent.getStringExtra("subject_name");

        // Tải danh sách các bài học tương ứng với môn học
        lessonList = loadLessonsForSubject(subjectName);

        // Khởi tạo và đặt adapter cho RecyclerView
        lessonsAdapter = new LessonsAdapter(this, lessonList);
        recyclerView.setAdapter(lessonsAdapter);

        // Thiết lập sự kiện click cho nút back
        ImageView arrowImageView = findViewById(R.id.img_detail_subject_arrow);
        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailSubjectActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private List<Lessons> loadLessonsForSubject(String subjectName) {
        List<Lessons> lessonsList = new ArrayList<>();

        txtLesson = findViewById(R.id.txt_lessons);
        if (subjectName.equals("C++")) {
            // Load lessons for C++
            txtLesson.setText(subjectName);
            lessonsList.add(new Lessons("Bài 1"));
            lessonsList.add(new Lessons("Bài 2"));
            lessonsList.add(new Lessons("Bài 3"));
            // Add more lessons for C++ if needed
        } else if (subjectName.equals("JAVA")) {
            // Load lessons for JAVA
            txtLesson.setText(subjectName);
            lessonsList.add(new Lessons("Bài 1"));
            lessonsList.add(new Lessons("Bài 2"));
            lessonsList.add(new Lessons("Bài 3"));
            // Add more lessons for JAVA if needed
        } else if (subjectName.equals("HTML/SCC")) {
            // Load lessons for HTML/SCC
            txtLesson.setText(subjectName);
            lessonsList.add(new Lessons("Bài 1"));
            lessonsList.add(new Lessons("Bài 2"));
            lessonsList.add(new Lessons("Bài 3"));
            // Add more lessons for HTML/SCC if needed
        } else if (subjectName.equals("JAVASCRIPT")) {
            // Load lessons for JAVASCRIPT
            txtLesson.setText(subjectName);
            lessonsList.add(new Lessons("Bài 1"));
            lessonsList.add(new Lessons("Bài 2"));
            lessonsList.add(new Lessons("Bài 3"));
            // Add more lessons for JAVASCRIPT if needed
        } else if (subjectName.equals("C#")) {
            // Load lessons for C#
            txtLesson.setText(subjectName);
            lessonsList.add(new Lessons("Bài 1"));
            lessonsList.add(new Lessons("Bài 2"));
            lessonsList.add(new Lessons("Bài 3"));
            // Add more lessons for C# if needed
        } else if (subjectName.equals("ANDROID")) {
            // Load lessons for ANDROID
            txtLesson.setText(subjectName);
            lessonsList.add(new Lessons("Bài 1"));
            lessonsList.add(new Lessons("Bài 2"));
            lessonsList.add(new Lessons("Bài 3"));
            // Add more lessons for ANDROID if needed
        } else if (subjectName.equals("ASP.NET")) {
            // Load lessons for ASP.NET
            txtLesson.setText(subjectName);
            lessonsList.add(new Lessons("Bài 1"));
            lessonsList.add(new Lessons("Bài 2"));
            lessonsList.add(new Lessons("Bài 3"));
            // Add more lessons for ASP.NET if needed
        } else if (subjectName.equals("TYPESCRIPT")) {
            // Load lessons for TYPESCRIPT
            txtLesson.setText(subjectName);
            lessonsList.add(new Lessons("Bài 1"));
            lessonsList.add(new Lessons("Bài 2"));
            lessonsList.add(new Lessons("Bài 3"));
            // Add more lessons for TYPESCRIPT if needed
        }

        return lessonsList;
    }

}
