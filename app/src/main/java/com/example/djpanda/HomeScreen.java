package com.example.djpanda;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
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
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends Fragment {

    private FusedLocationProviderClient fusedLocationClient;
    private NearbyDjAdapter nearbyAdapter;
    private List<NearbyDj_model> nearbyDjs;

    private final ActivityResultLauncher<String[]> locationPermissionLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.RequestMultiplePermissions(),
                    result -> {
                        Boolean fineGranted = result.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false);
                        if (Boolean.TRUE.equals(fineGranted)) {
                            getUserLocationAndSortDjs();
                        } else {
                            Toast.makeText(requireContext(), "Location is required to show nearby DJs", Toast.LENGTH_LONG).show();
                        }
                    }
            );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialToolbar topAppBar = view.findViewById(R.id.topAppBar);
        topAppBar.inflateMenu(R.menu.top_app_bar_menu);
        View avatarView = topAppBar.getMenu().findItem(R.id.action_account).getActionView();
        setupPopupMenu(avatarView);

        RecyclerView trendingRecycler = view.findViewById(R.id.nowTrendingRecycler);
        trendingRecycler.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        List<NowTrendingParty_model> trendingParties = new ArrayList<>();
        trendingParties.add(new NowTrendingParty_model(1, R.drawable.techno_party1, "Warehouse Techno", "Fri · 2 PM · $20"));
        trendingParties.add(new NowTrendingParty_model(5, R.drawable.pop_party2, "Pop Glow Party", "Sat · 10 PM · $45"));
        trendingParties.add(new NowTrendingParty_model(11, R.drawable.rock_party2, "Legends Of Rock", "Next Week · 8 PM · $30"));
        trendingRecycler.setAdapter(new NowTrendingAdapter(trendingParties));

        RecyclerView nearbyRecycler = view.findViewById(R.id.nearbyDjRecycler);
        nearbyRecycler.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        nearbyDjs = new ArrayList<>();
        nearbyDjs.add(new NearbyDj_model(1, R.drawable.dj_panda, "DJ PANDA", "-", 32.0853, 34.7818));
        nearbyDjs.add(new NearbyDj_model(2, R.drawable.dj_timmy, "DJ TIMMY", "-", 32.1663, 34.8433));
        nearbyDjs.add(new NearbyDj_model(3, R.drawable.dj_hippo, "DJ HIPPO", "-", 31.9642, 34.8047));
        nearbyDjs.add(new NearbyDj_model(4, R.drawable.dj_superstar, "DJ SUPERSTAR", "-", 32.7940, 34.9896));
        nearbyDjs.add(new NearbyDj_model(5, R.drawable.dj_shakira, "DJ SHAKIRA", "-", 31.7683, 35.2137));
        nearbyDjs.add(new NearbyDj_model(6, R.drawable.dj_neon, "DJ NEON", "-", 31.2520, 34.7913));

        nearbyAdapter = new NearbyDjAdapter(nearbyDjs);
        nearbyRecycler.setAdapter(nearbyAdapter);

        MainActivity main = (MainActivity) getActivity();
        if (main != null) {
            main.djList = nearbyDjs;
            main.adapter = nearbyAdapter;

          if (main.currentUserLat != 0) {
                main.updateDjDistances();
            }
        }

        RecyclerView categoriesRecycler = view.findViewById(R.id.categoriesRecycler);
        categoriesRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        List<music_category_model> categoryList = new ArrayList<>();
        categoryList.add(new music_category_model("old_music", R.drawable.verynice_card));
        categoryList.add(new music_category_model("pop", R.drawable.pop_card));
        categoryList.add(new music_category_model("rock", R.drawable.rock_card));
        categoryList.add(new music_category_model("techno", R.drawable.techno_card2));

        categoriesRecycler.setAdapter(new MusicCategoryAdapter(categoryList));

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        if (hasLocationPermission()) {
            getUserLocationAndSortDjs();
        } else {
            requestLocationPermission();
        }
    }


    private void setupPopupMenu(View avatarView) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), avatarView, Gravity.END, 0, R.style.AvatarPopupMenu);
        popupMenu.inflate(R.menu.avatar_menu);
        MenuItem signOutItem = popupMenu.getMenu().findItem(R.id.action_signout);
        if (signOutItem != null) {
            SpannableString s = new SpannableString(signOutItem.getTitle().toString());
            s.setSpan(new ForegroundColorSpan(Color.RED), 0, s.length(), 0);
            signOutItem.setTitle(s);
        }
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_signin) {
                NavHostFragment.findNavController(this).navigate(R.id.action_homeScreen_to_signIn);
                return true;
            }
            if (item.getItemId() == R.id.action_signup) {
                NavHostFragment.findNavController(this).navigate(R.id.action_homeScreen_to_signUp);
                return true;
            }
            if (item.getItemId() == R.id.action_signout) {
                Toast.makeText(requireContext(), "Signed out successfully", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
        avatarView.setOnClickListener(v -> popupMenu.show());
    }

    private boolean hasLocationPermission() {
        return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestLocationPermission() {
        locationPermissionLauncher.launch(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION});
    }

    private void getUserLocationAndSortDjs() {
        if (!hasLocationPermission()) return;
        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            if (location == null) return;


            MainActivity main = (MainActivity) getActivity();
            if (main != null) {
                main.currentUserLat = location.getLatitude();
                main.currentUserLon = location.getLongitude();
                main.updateDjDistances();
            }
        });
    }
}