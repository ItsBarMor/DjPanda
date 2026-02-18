package com.example.djpanda;
import com.example.djpanda.data.AppData;
import com.example.djpanda.models.Party;
import com.example.djpanda.models.Dj_model;
import android.widget.TextView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Paint;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class PartyProfile extends Fragment {

    public PartyProfile() {

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
        Party party = AppData.getPartyById(partyId);

        TextView partyNameText = view.findViewById(R.id.partyNameText);

        ImageView partyImage = view.findViewById(R.id.partyImage);


        TextView partyDateTimeText = view.findViewById(R.id.partyDateTimeText);
        TextView partyLocationText = view.findViewById(R.id.partyLocationText);
        TextView partyPricesText = view.findViewById(R.id.partyPricesText);
        TextView partyDescriptionText = view.findViewById(R.id.partyDescriptionText);

        Button buttonToBuyingTickets = view.findViewById(R.id.button_to_buying_tickets);
        Button buttonToDjProfile = view.findViewById(R.id.button_to_dj_profile);

        if (party == null) {
            partyNameText.setText("Party not found");
            partyDateTimeText.setText("");
            partyLocationText.setText("");
            partyPricesText.setText("");
            partyDescriptionText.setText("");
            partyImage.setImageResource(R.drawable.ic_launcher_background);

            //The button will turned grey and unclickable if the party is not found
            buttonToBuyingTickets.setEnabled(false);

            return view;
        }

        partyNameText.setText(party.name);
        partyImage.setImageResource(party.imageResId);

        partyDateTimeText.setText(party.date + " | " + party.time);
        Dj_model dj = AppData.getDjById(party.djId);

        partyLocationText.setText(party.locationName + ", " + party.city);
        partyDescriptionText.setText(party.description);


        buttonToBuyingTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("partyId", party.id);
                    Navigation.findNavController(view).navigate(R.id.action_partyProfile_to_buyingTicketsFragment,bundle);
            }
        });


        buttonToDjProfile.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("djId", party.djId);
            Navigation.findNavController(view).navigate(R.id.action_partyProfile_to_djsProfile, bundle);
        });


        return view;
    }
}
