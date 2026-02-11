package com.example.djpanda.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djpanda.R;
import com.example.djpanda.models.music_category_model;

import java.util.List;

public class MusicCategoryAdapter extends RecyclerView.Adapter<MusicCategoryAdapter.ViewHolder> {

    private final List<music_category_model> categories;

    public MusicCategoryAdapter(List<music_category_model> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music_category_format, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        music_category_model category = categories.get(position);

        holder.image.setImageResource(category.imageRes);

        holder.itemView.setOnClickListener(v -> {

            String categoryToSend = "";

            if ("pop".equalsIgnoreCase(category.musicGenre)) categoryToSend = "Pop";
            else if ("techno".equalsIgnoreCase(category.musicGenre)) categoryToSend = "Techno";
            else if ("old_music".equalsIgnoreCase(category.musicGenre)) categoryToSend = "80s";
            else if ("rock".equalsIgnoreCase(category.musicGenre)) categoryToSend = "Rockstar";

            Bundle b = new Bundle();
            b.putString("category", categoryToSend);

            Navigation.findNavController(v)
                    .navigate(R.id.action_homeScreen_to_allPartiesUnderTheSameCategory, b);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.categoryImage);
        }
    }
}
