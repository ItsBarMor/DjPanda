package com.example.djpanda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.fragment.NavHostFragment;

import com.example.djpanda.data.AppData;
import com.example.djpanda.models.Dj_model;

public class DjsProfile extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DjsProfile() {

    }

    public static DjsProfile newInstance(String param1, String param2) {
        DjsProfile fragment = new DjsProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_djs_profile, container, false);

        int djId = 0;
        Bundle args = getArguments();
        if (args != null) {
            djId = args.getInt("djId", 0);
        }
        Log.d("DjsProfile", "djId=" + djId);
        Dj_model dj = AppData.getDjById(djId);

        ImageView djImage = view.findViewById(R.id.djImage);
        TextView djNameText = view.findViewById(R.id.dj_profile_name);
        TextView djGenresText = view.findViewById(R.id.dj_genres_text);
        TextView djLocationsText = view.findViewById(R.id.dj_locations_text);
        TextView djRatingText = view.findViewById(R.id.dj_rating_text);
        TextView djInfoText = view.findViewById(R.id.djs_info);

        TextView reviewerName = view.findViewById(R.id.reviewer_name);
        RatingBar reviewRatingBar = view.findViewById(R.id.review_rating_bar);
        TextView reviewText = view.findViewById(R.id.review_text);

        EditText reviewEditText = view.findViewById(R.id.reviewEditText);
        View submitButton = view.findViewById(R.id.btnSubmitReview);

        if (dj == null) {
            djNameText.setText("DJ not found");
            djGenresText.setText("");
            djLocationsText.setText("");
            djRatingText.setText("");
            djInfoText.setText("");
            djImage.setImageResource(R.drawable.ic_launcher_background);
            return view;
        }

        djImage.setImageResource(dj.imageResId);
        djNameText.setText(dj.name);
        djGenresText.setText(dj.genres);
        djLocationsText.setText(dj.locations);
        djRatingText.setText(dj.rating + " ⭐ "  + " | " + dj.reviewsCount + " reviews");
        djInfoText.setText(dj.bio);

        View reviewContainer = view.findViewById(R.id.review_layout);

        if (dj.review != null)
        {
            reviewContainer.setVisibility(View.VISIBLE);
            reviewerName.setText(dj.review.userName);
            reviewRatingBar.setRating(dj.review.rating);
            reviewText.setText("\"" + dj.review.comment + "\"");
        }
        else
        {
            reviewContainer.setVisibility(View.GONE);
        }

        submitButton.setOnClickListener(v -> {

            String comment = reviewEditText.getText().toString().trim();

            if (!comment.isEmpty()) {
                Toast.makeText(requireContext(),
                        "Comment added: " + comment,
                        Toast.LENGTH_SHORT).show();
            }
            NavHostFragment.findNavController(DjsProfile.this)
                    .popBackStack(R.id.homeScreen, false);
        });

        return view;
    }
}
