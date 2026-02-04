package com.example.djpanda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djpanda.data.AppData;
import com.example.djpanda.models.Party;
import com.example.djpanda.adapters.PartiesAdapter;

import java.util.ArrayList;

public class AllPartiesUnderTheSameCategory extends Fragment {

    public AllPartiesUnderTheSameCategory() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_parties_under_the_same_category, container, false);

        String category = "";
        Bundle args = getArguments();
        if (args != null) {
            category = args.getString("category", "");
        }

        ArrayList<Party> filtered = new ArrayList<>();
        for (Party p : AppData.parties) {
            if (p != null && p.category != null) {
                if (category != null && !category.isEmpty() && p.category.equalsIgnoreCase(category)) {
                    filtered.add(p);
                }
            }
        }

        RecyclerView recyclerView = view.findViewById(R.id.partiesRecyclerView);

        PartiesAdapter adapter = new PartiesAdapter(filtered, new PartiesAdapter.OnPartyClickListener() {
            @Override
            public void onPartyClick(Party party) {
                Bundle b = new Bundle();
                b.putInt("partyId", party.id);

                Navigation.findNavController(view)
                        .navigate(R.id.action_allPartiesUnderTheSameCategory_to_partyProfile, b);
            }
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}
