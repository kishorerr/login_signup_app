package com.example.login_signup_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class signupactivity extends AppCompatActivity {
    EditText username,email,password,loc;
    Button register;
    FirebaseAuth auth;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        loc = findViewById(R.id.loc);
        register = findViewById(R.id.register_btn);
        password = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register(username.getText().toString(),email.getText().toString(),password.getText().toString(),loc.getText().toString());
            }
        });
    }

    private void Register(String name,String email,String password,String loc)
    {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                databaseReference = FirebaseDatabase.getInstance().getReference("People").child(Objects.requireNonNull(auth.getCurrentUser()).getUid());
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("userid",auth.getCurrentUser().getUid());
                hashMap.put("username",name);
                hashMap.put("location",loc);


                databaseReference.setValue(hashMap).addOnCompleteListener(task1 -> {
                    if(task1.isSuccessful())
                    {
                        Intent intent=new Intent(signupactivity.this,homepage.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}