package com.example.djpanda.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djpanda.R;
import com.example.djpanda.models.NowTrendingParty_model;

import java.util.List;

public class NowTrendingAdapter
        extends RecyclerView.Adapter<NowTrendingAdapter.ViewHolder> {

    final private List<NowTrendingParty_model> parties;

    public NowTrendingAdapter(List<NowTrendingParty_model> parties) {
        this.parties = parties;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.now_trending_format, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NowTrendingParty_model party = parties.get(position);
        holder.image.setImageResource(party.imageRes);
        holder.title.setText(party.title);
        holder.subtitle.setText(party.subtitle);
    }

    @Override
    public int getItemCount() {
        return parties.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, subtitle;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.partyImage);
            title = itemView.findViewById(R.id.partyTitle);
            subtitle = itemView.findViewById(R.id.partySubtitle);
        }
    }
}
