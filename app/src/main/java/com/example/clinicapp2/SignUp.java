package com.example.clinicapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class SignUp extends AppCompatActivity {
    EditText txEmail, txPassword,firstName, lastName;
    Button upBtn;
    RadioButton employeeBtn, patientBtn;
    private FirebaseAuth mFireBaseAuth;
    DatabaseReference databaseReference;
    String role= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        txEmail = (EditText) findViewById(R.id.txEmail);
        txPassword = (EditText) findViewById(R.id.txPassword);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);

        upBtn = (Button) findViewById(R.id.upBtn);
        employeeBtn = (RadioButton) findViewById(R.id.eBtn);
        patientBtn = (RadioButton) findViewById(R.id.pBtn);

        mFireBaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = txEmail.getText().toString().trim();
                final String password = txPassword.getText().toString().trim();
                final String fName = firstName.getText().toString().trim();
                final String lName = lastName.getText().toString().trim();

                if(employeeBtn.isChecked()){
                    role = "Employee";
                }
                if(patientBtn.isChecked()){
                    role = "Patient";
                }
                if(password.length()<6) {
                    Toast.makeText(SignUp.this, "Password needs to be 6 characters", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignUp.this, "Field empty: Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password)){
                    Toast.makeText(SignUp.this, "Field empty: Please enter your password", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(fName)){
                    Toast.makeText(SignUp.this, "Field empty: Please enter your first name", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(lName)){
                    Toast.makeText(SignUp.this, "Field empty: Please enter your last name", Toast.LENGTH_SHORT).show();
                }
                else if(!(patientBtn.isChecked() || employeeBtn.isChecked())){
                    Toast.makeText(SignUp.this, "Please select a role", Toast.LENGTH_SHORT).show();
                }else {
                    mFireBaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User information = new User(fName, lName, email, password, role);
                                FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(SignUp.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(getApplicationContext(), Welcome.class);
                                        startActivity(i);
                                    }
                                });

                            }
                        }
                    });
                }
            }
        });
    }


    public static String toSHA256(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return toHexString(encodedhash);
        } catch(NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String toHexString(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
