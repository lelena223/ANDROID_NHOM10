package com.exemple.android_nhom10;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.exemple.android_nhom10.Models.Subject;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private Context context;
    private List<Subject> subjectList;

    public SubjectAdapter(Context context, List<Subject> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.txtSubject.setText(subject.getName());
        holder.imgSubject.setImageResource(subject.getImageResId());
        holder.linearItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailSubjectActivity.class);
                intent.putExtra("subject_name", subject.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView txtSubject;
        ImageView imgSubject;
        CardView cardView;

        LinearLayout linearItems;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSubject = itemView.findViewById(R.id.item_txt_subject);
            imgSubject = itemView.findViewById(R.id.item_img_subject);
            cardView = itemView.findViewById(R.id.item_card_view);
            linearItems = itemView.findViewById(R.id.subject);
        }
    }
}
