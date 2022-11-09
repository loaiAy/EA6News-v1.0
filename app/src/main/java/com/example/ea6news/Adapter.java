package com.example.ea6news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Model> modelArrayList;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url", modelArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        String tmpAuthor = modelArrayList.get(position).getAuthor() == null ? "no author" : modelArrayList.get(position).getAuthor();
        String date = modelArrayList.get(position).getPublishedAt();
        String converted = ZonedDateTime.parse(date)
                .format(DateTimeFormatter.ofPattern(
                                "EEE MMM d, uuuu HH:mm:ss",
                                Locale.ENGLISH
                        )
                );

        holder.heading.setText(modelArrayList.get(position).getTitle());
        holder.content.setText(modelArrayList.get(position).getDescription());
        Glide.with(context).load(modelArrayList.get(position).getUrlToImage()).into(holder.imageView);
        holder.author.setText("by: " + tmpAuthor);
        holder.time.setText("published: " + converted);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading, content, author, category, time;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.head);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            imageView= itemView.findViewById(R.id.imageview);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
