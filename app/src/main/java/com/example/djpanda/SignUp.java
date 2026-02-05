package com.example.djpanda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SignUp extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 1. קודם כל "מנפחים" את ה-Layout ושומרים אותו בתוך משתנה שנקרא view
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // 2. עכשיו מוצאים את ה-TextView מתוך ה-view שנוצר
        TextView linkToSignIn = view.findViewById(R.id.link_to_signin);

        // 3. מגדירים את הלחיצה
        linkToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // מעבר לפרגמנט התחברות
                NavHostFragment.findNavController(SignUp.this)
                        .navigate(R.id.action_signUp_to_signIn);
            }
        });

        // 4. ורק בסוף בסוף מחזירים את ה-view המוכן
        return view;
    }
}