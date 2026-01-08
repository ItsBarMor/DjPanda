package com.example.djpanda.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djpanda.R;
import com.example.djpanda.models.NearbyDj_model;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class NearbyDjAdapter extends RecyclerView.Adapter<NearbyDjAdapter.ViewHolder> {

    final private List<NearbyDj_model> djs;

    public NearbyDjAdapter(List<NearbyDj_model> djs) {
        this.djs = djs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nearby_dj, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NearbyDj_model dj = djs.get(position);
        holder.image.setImageResource(dj.imageRes);
        holder.name.setText(dj.name);
        holder.distance.setText(dj.distance);
    }

    @Override
    public int getItemCount() {
        return djs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView image;
        TextView name, distance;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.djImage);
            name = itemView.findViewById(R.id.djName);
            distance = itemView.findViewById(R.id.djDistance);
        }
    }
}

