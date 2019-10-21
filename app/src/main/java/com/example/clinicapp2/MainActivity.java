package com.example.clinicapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText txEmail, txPassword;
    Button inBtn, upBtn;

    private FirebaseAuth mFireBaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txEmail = (EditText) findViewById(R.id.txEmail);
        txPassword = (EditText) findViewById(R.id.txPassword);
        inBtn = findViewById(R.id.inBtn);
        upBtn = findViewById(R.id.upBtn);

        mFireBaseAuth = FirebaseAuth.getInstance();


        inBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txEmail.getText().toString().trim();
                String password = txPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this, "Field empty: Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Field empty: Please enter your password", Toast.LENGTH_SHORT).show();
                }
                else if(!(TextUtils.isEmpty(email)&& TextUtils.isEmpty(password))) {
                    mFireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent i = new Intent(getApplicationContext(), Welcome.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToSignUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(inToSignUp);
            }
        });
    }
}
