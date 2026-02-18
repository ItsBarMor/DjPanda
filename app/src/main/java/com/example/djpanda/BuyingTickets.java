package com.example.djpanda;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.djpanda.data.AppData;
import com.example.djpanda.models.Party;

public class BuyingTickets extends Fragment {

    public BuyingTickets() {
    }

    private int ticketCount = 1;
    private int pricePerTicket;
    private TextView ticketCountText;
    private TextView totalAmount;
    private View minusButton;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_buying_tickets, container, false);

        int partyId = getArguments().getInt("partyId");
        Party party = AppData.getPartyById(partyId);

        if (party == null) {
            NavHostFragment.findNavController(this).popBackStack(); // Return to the previous fragment
            return view;
        }

        TextView partyName = view.findViewById(R.id.party_name_card);
        TextView partyDate = view.findViewById(R.id.party_date_card);
        TextView partyTime = view.findViewById(R.id.party_time_card);
        TextView partyLocation = view.findViewById(R.id.party_location_card);
        ImageView partyImage = view.findViewById(R.id.categoryImage);

        ticketCountText = view.findViewById(R.id.ticketCountText);
        totalAmount = view.findViewById(R.id.totalAmount);

        minusButton = view.findViewById(R.id.minusContainer);
        View plusButton = view.findViewById(R.id.plusContainer);

        Button purchaseButton = view.findViewById(R.id.btnBuyNow);
        Button cancelButton = view.findViewById(R.id.btnGoBack);

        EditText noteEditText = view.findViewById(R.id.noteEditText);

        partyName.setText(party.name);
        partyDate.setText(party.date);
        partyTime.setText(party.time);
        partyLocation.setText(party.locationName + ", " + party.city);
        partyImage.setImageResource(party.imageResId);

        pricePerTicket = party.price;
        TextView pricePerTicketText = view.findViewById(R.id.totalAmount);
        pricePerTicketText.setText("$" + pricePerTicket);

        FrameLayout lottieOverlay = view.findViewById(R.id.lottieOverlay);
        LottieAnimationView lottie = view.findViewById(R.id.purchaseLottie);

        updateTotal(); // initial state

        plusButton.setOnClickListener(v -> {
            ticketCount++;
            updateTotal();
        });

        minusButton.setOnClickListener(v -> {
            if (ticketCount > 1) {
                ticketCount--;
                updateTotal();
            }
        });

        cancelButton.setOnClickListener(v ->
                NavHostFragment.findNavController(this).popBackStack() //return to the previous fragment
        );

        purchaseButton.setOnClickListener(v -> {

            purchaseButton.setEnabled(false);
            cancelButton.setEnabled(false);

            lottieOverlay.setVisibility(View.VISIBLE);
            lottie.playAnimation();

            lottie.addAnimatorListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    lottieOverlay.setVisibility(View.GONE);

                    Toast.makeText(requireContext(),
                            "Purchase completed successfully",
                            Toast.LENGTH_LONG).show();

                    NavHostFragment.findNavController(BuyingTickets.this)
                            .popBackStack(R.id.homeScreen, false);
                }
            });
        });

        return view;
    }

    private void updateTotal() {
        ticketCountText.setText(String.valueOf(ticketCount));
        totalAmount.setText("$" + (ticketCount * pricePerTicket));

        if (ticketCount == 1) {
            minusButton.setEnabled(false); //disabled
            minusButton.setAlpha(0.3f); // visual feedback
        } else {
            minusButton.setEnabled(true);
            minusButton.setAlpha(1f);
        }
    }
}
