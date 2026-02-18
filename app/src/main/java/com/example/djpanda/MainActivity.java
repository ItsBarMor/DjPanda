package com.example.djpanda;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.fragment.NavHostFragment;

import com.example.djpanda.adapters.NearbyDjAdapter;
import com.example.djpanda.models.NearbyDj_model;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private FirebaseAuth mAuth;

    TextView latitute, longlatitute, speed, place;
    LocationManager locationManager;
    String provider;

    public double currentUserLat = 0;
    public double currentUserLon = 0;
    public List<NearbyDj_model> djList = new ArrayList<>();
    public NearbyDjAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        latitute = findViewById(R.id.lat);
        longlatitute = findViewById(R.id.lon);
        speed = findViewById(R.id.speed);
        place = findViewById(R.id.place);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            setupLocation();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout_root), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setupLocation() {
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        if (provider != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(provider, 200, 1, this);
                Location location = locationManager.getLastKnownLocation(provider);
                if (location != null) onLocationChanged(location);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            setupLocation();
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        currentUserLat = location.getLatitude();
        currentUserLon = location.getLongitude();

        if (latitute != null) latitute.setText(String.valueOf(currentUserLat));
        if (longlatitute != null) longlatitute.setText(String.valueOf(currentUserLon));

        getFull(String.valueOf(currentUserLat), String.valueOf(currentUserLon));

        updateDjDistances();
    }

    public void updateDjDistances() {
        if (djList != null && !djList.isEmpty()) {
            for (NearbyDj_model dj : djList) {
                float[] results = new float[1];
                Location.distanceBetween(currentUserLat, currentUserLon, dj.latitude, dj.longitude, results);

                dj.distance = String.format(Locale.getDefault(), "%.1f km", results[0] / 1000);

                dj.distanceFromUser = results[0];
            }

            sortByDistance(djList);

            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void sortByDistance(List<NearbyDj_model> djs) {
        djs.sort((dj1, dj2) -> Float.compare(dj1.distanceFromUser, dj2.distanceFromUser));
    }

    private void getFull(String lat, String lon) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocation(Double.parseDouble(lat), Double.parseDouble(lon), 1);
            if (addressList != null && !addressList.isEmpty()) {
                place.setText(addressList.get(0).getAddressLine(0));
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && provider != null) {
            locationManager.requestLocationUpdates(provider, 200, 1, this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }


    public void signIn(View fragmentView) {
        EditText emailET = findViewById(R.id.email_edit_signin);
        EditText passwordET = findViewById(R.id.password_edit_signin);

        if (emailET == null || passwordET == null) return;

        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.nav_host))
                                .navigate(R.id.action_signIn_to_homeScreen);
                    } else {
                        Toast.makeText(MainActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void SignUp() {
        EditText emailET = findViewById(R.id.email_edit);
        EditText passwordET = findViewById(R.id.password_edit);

        if (emailET == null || passwordET == null) return;

        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.nav_host))
                                .navigate(R.id.action_signUp_to_homeScreen);
                    } else {
                        Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}