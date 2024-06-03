package com.exemple.android_nhom10;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.exemple.android_nhom10.Models.Lessons;

import java.util.List;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.LessonViewHolder> {

    private Context context;
    private List<Lessons> lessonList;

    public LessonsAdapter(Context context, List<Lessons> lessonList) {
        this.context = context;
        this.lessonList = lessonList;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lesson, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        Lessons lesson = lessonList.get(position);
        holder.txtLessonName.setText(lesson.getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailSubjectActivity.class);
            intent.putExtra("lesson_name", lesson.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public static class LessonViewHolder extends RecyclerView.ViewHolder {
        TextView txtLessonName;
        CardView cardView;
        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLessonName = itemView.findViewById(R.id.lesson_txt_lesson);
            cardView = itemView.findViewById(R.id.lesson_card_view);
        }
    }
}
