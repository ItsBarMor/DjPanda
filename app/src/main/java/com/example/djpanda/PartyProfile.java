package com.example.djpanda;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class PartyProfile extends Fragment {

    public PartyProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_party_profile, container, false);

        int partyId = 0;
        Bundle args = getArguments();
        if (args != null) {
            partyId = args.getInt("partyId", 0);
        }

        Button buttonToDjsProfile = view.findViewById(R.id.button_to_djs_profile);
        buttonToDjsProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_partyProfile_to_djsProfile);
            }
        });

        Button buttonToBuyingTickets = view.findViewById(R.id.button_to_buying_tickets);
        buttonToBuyingTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_partyProfile_to_buyingTicketsFragment);
            }
        });

        return view;
    }
}
