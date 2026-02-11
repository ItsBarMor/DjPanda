package com.example.djpanda;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        ViewCompat.setOnApplyWindowInsetsListener(  //edge to edge concept
                findViewById(R.id.nav_host),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );
                    return insets;
                }
        );
    }

    public void signIn(View fragmentView) {
        EditText emailET = findViewById(R.id.email_edit_signin);
        EditText passwordET = findViewById(R.id.password_edit_signin);

        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Sign In Successful!", Toast.LENGTH_SHORT).show();

                            NavHostFragment.findNavController(getSupportFragmentManager()
                                            .findFragmentById(R.id.nav_host))
                                    .navigate(R.id.action_signIn_to_homeScreen);
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication Failed: Check your details", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void SignUp() {
        EditText firstNameET = findViewById(R.id.first_name_edit);
        EditText lastNameET = findViewById(R.id.last_name_edit);
        EditText emailET = findViewById(R.id.email_edit);
        EditText passwordET = findViewById(R.id.password_edit);

        String fName = firstNameET.getText().toString().trim();
        String lName = lastNameET.getText().toString().trim();
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

        if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields (Name, Email and Password)", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();

                            NavHostFragment.findNavController(getSupportFragmentManager()
                                            .findFragmentById(R.id.nav_host))
                                    .navigate(R.id.action_signUp_to_homeScreen);
                        } else {
                            String error = task.getException() != null ? task.getException().getMessage() : "Registration Failed";
                            Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }




}


