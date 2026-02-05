package com.example.djpanda;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djpanda.adapters.MusicCategoryAdapter;
import com.example.djpanda.adapters.NearbyDjAdapter;
import com.example.djpanda.adapters.NowTrendingAdapter;
import com.example.djpanda.models.NearbyDj_model;
import com.example.djpanda.models.NowTrendingParty_model;
import com.example.djpanda.models.music_category_model;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        MaterialToolbar topAppBar = view.findViewById(R.id.topAppBar);
        topAppBar.inflateMenu(R.menu.top_app_bar_menu);

//        topAppBar.getMenu().add("Sign In")
//                .setOnMenuItemClickListener(item -> {
//                    androidx.navigation.fragment.NavHostFragment
//                            .findNavController(HomeScreen.this)
//                            .navigate(R.id.action_homeScreen_to_signIn);
//                    return true;
//                });

        View avatarView = topAppBar.getMenu()
                .findItem(R.id.action_account)
                .getActionView();

        PopupMenu popup = new PopupMenu(
                requireContext(),
                avatarView,
                Gravity.END,
                0,
                R.style.AvatarPopupMenu
        );

        popup.inflate(R.menu.avatar_menu);

        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_signin) {
                NavHostFragment.findNavController(HomeScreen.this)
                        .navigate(R.id.action_homeScreen_to_signIn);
                return true;
            }

            if (item.getItemId() == R.id.action_signup) {
                NavHostFragment.findNavController(HomeScreen.this)
                        .navigate(R.id.action_homeScreen_to_signUp);
                return true;
            }

            return false;
        });



        avatarView.setOnClickListener(v -> popup.show());

        RecyclerView trendingRecycler = view.findViewById(R.id.nowTrendingRecycler);
        trendingRecycler.setLayoutManager(
                new LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false)
        );

        List<NowTrendingParty_model> trendingParties = new ArrayList<>();
        trendingParties.add(new NowTrendingParty_model(
                1, R.drawable.dj_panda, "Neon Nights", "Fri · 10 PM · $20"));
        trendingParties.add(new NowTrendingParty_model(
                2, R.drawable.oren_lahav, "Summer Bass", "Sat · 2 PM · $45"));
        trendingParties.add(new NowTrendingParty_model(
                3, R.mipmap.app_logo, "Tech Pulse", "Tonight · $30"));

        trendingRecycler.setAdapter(new NowTrendingAdapter(trendingParties));

        RecyclerView nearbyRecycler = view.findViewById(R.id.nearbyDjRecycler);
        nearbyRecycler.setLayoutManager(
                new LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );

        List<NearbyDj_model> dummyDjs = new ArrayList<>();
        dummyDjs.add(new NearbyDj_model(1, R.drawable.dj_panda, "DJ PANDA", "0.4 km"));
        dummyDjs.add(new NearbyDj_model(2, R.drawable.dj_timmy, "DJ TIMMY", "1.2 km"));
        dummyDjs.add(new NearbyDj_model(3, R.drawable.dj_hippo, "DJ HIPPO", "2.1 km"));
        dummyDjs.add(new NearbyDj_model(4, R.drawable.dj_superstar, "DJ SUPERSTAR", "0.4 km"));
        dummyDjs.add(new NearbyDj_model(5, R.drawable.dj_shakira, "DJ SHAKIRA", "1.2 km"));
        dummyDjs.add(new NearbyDj_model(6, R.drawable.dj_neon, "DJ NEON", "2.1 km"));

        nearbyRecycler.setAdapter(new NearbyDjAdapter(dummyDjs));

        RecyclerView categoriesRecycler = view.findViewById(R.id.categoriesRecycler);
        categoriesRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        List<music_category_model> categories = new ArrayList<>();
        categories.add(new music_category_model("old_music", R.drawable.verynice_card));
        categories.add(new music_category_model("pop", R.drawable.pop_card));
        categories.add(new music_category_model("rock", R.drawable.rock_card));
        categories.add(new music_category_model("techno", R.drawable.techno_card2));

        categoriesRecycler.setAdapter(new MusicCategoryAdapter(categories));

        return view;
    }
}
