package com.example.opet.autenticacaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailActivity extends AppCompatActivity {

    private TextView textEmail;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        textEmail = findViewById(R.id.textEmail);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        textEmail.setText(user.getEmail());
    }

    public void signOut(View view) {

        firebaseAuth.signOut();
        Intent intent = new Intent(EmailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

