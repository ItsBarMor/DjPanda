package com.example.djpanda.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.djpanda.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djpanda.models.Party;

import java.util.ArrayList;

public class PartiesAdapter extends RecyclerView.Adapter<PartiesAdapter.PartyVH> {

    public interface OnPartyClickListener {
        void onPartyClick(Party party);
    }

    private final ArrayList<Party> parties;
    private final OnPartyClickListener listener;

    public PartiesAdapter(ArrayList<Party> parties, OnPartyClickListener listener) {
        this.parties = parties;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PartyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_party, parent, false);
        return new PartyVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PartyVH holder, int position) {
        Party p = parties.get(position);

        holder.partyTitle.setText(p.name);
        holder.partyImage.setImageResource(p.imageResId);

        // שורה שנייה קצרה ופשוטה (תאריך + עיר + מועדון)
        String subtitle = p.date + " | " + p.city + " | " + p.locationName;
        holder.partySubtitle.setText(subtitle);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onPartyClick(p);
        });
    }

    @Override
    public int getItemCount() {
        return parties == null ? 0 : parties.size();
    }

    static class PartyVH extends RecyclerView.ViewHolder {
        ImageView partyImage;
        TextView partyTitle;
        TextView partySubtitle;

        public PartyVH(@NonNull View itemView) {
            super(itemView);
            partyImage = itemView.findViewById(R.id.partyImage);
            partyTitle = itemView.findViewById(R.id.partyTitle);
            partySubtitle = itemView.findViewById(R.id.partySubtitle);
        }
    }
}
