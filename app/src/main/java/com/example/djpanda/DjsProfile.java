package com.example.djpanda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.djpanda.data.AppData;
import com.example.djpanda.models.Dj;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DjsProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DjsProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DjsProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DjsProfile.
     */
    // TODO: Rename and change types and number of parameters
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
        Dj dj = AppData.getDjById(djId);

        ImageView djImage = view.findViewById(R.id.djImage);
        TextView djNameText = view.findViewById(R.id.dj_profile_name);
        TextView djGenresText = view.findViewById(R.id.dj_genres_text);
        TextView djLocationsText = view.findViewById(R.id.dj_locations_text);
        TextView djRatingText = view.findViewById(R.id.dj_rating_text);
        TextView djInfoText = view.findViewById(R.id.djs_info);
        //reviewstuff
        TextView reviewerName = view.findViewById(R.id.reviewer_name);
        TextView reviewRating = view.findViewById(R.id.review_rating);
        TextView reviewText = view.findViewById(R.id.review_text);

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
            reviewRating.setText("⭐ " + dj.review.rating);
            reviewText.setText("\"" + dj.review.comment + "\"");
        }
        else
        {
            reviewContainer.setVisibility(View.GONE); //hide from screen
        }

        return view;
        //return inflater.inflate(R.layout.fragment_djs_profile, container, false);
    }
}