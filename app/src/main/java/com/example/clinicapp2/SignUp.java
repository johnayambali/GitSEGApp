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
    static User currUser ;
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3

                                if(role.equals("Employee")){
                                    FirebaseDatabase.getInstance().getReference("User").child("Employee").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(SignUp.this, "Employee Sign Up Complete", Toast.LENGTH_SHORT).show();
                                            final String uid;
                                            FirebaseUser user;
                                            user = FirebaseAuth.getInstance().getCurrentUser();
                                            uid = user.getUid();
                                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
                                            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    final String role= dataSnapshot.child("role").getValue(String.class);
                                                    System.out.println(role);
                                                    if(role.equals("Employee")){
                                                        Intent i = new Intent(SignUp.this, EmployeeActivity.class);
                                                        startActivity(i);
                                                    }
                                                }
                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                        }
                                    });
                                }else{
                                    FirebaseDatabase.getInstance().getReference("User").child("Patient").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(SignUp.this, "Patient SignUp Complete", Toast.LENGTH_SHORT).show();
                                            final String id;
                                            FirebaseUser user2;
                                            user2 = FirebaseAuth.getInstance().getCurrentUser();
                                            id = user2.getUid();
                                            DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("User").child("Patient").child(id);
                                            reference2.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final String role = dataSnapshot.child("role").getValue(String.class);
                                                    if (role.equals("Patient")){
                                                        Intent in = new Intent(SignUp.this, Welcome.class);
                                                        startActivity(in);
                                                    }
                                                }
                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                        }
                                    });
                                }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
                                FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(SignUp.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                        final String uid;
                                        FirebaseUser user;
                                        user = FirebaseAuth.getInstance().getCurrentUser();
                                        uid = user.getUid();
                                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child(uid);

                                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                final String role= dataSnapshot.child("role").getValue(String.class);
                                                System.out.println(role);
                                                if(role.equals("Employee")){
                                                    Intent i = new Intent(SignUp.this, EmployeeActivity.class);
                                                    startActivity(i);
                                                }
                                                else{
                                                    Intent in = new Intent(SignUp.this, Welcome.class);
                                                    startActivity(in);
                                                }


                                            }
                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }
                                        });
                                    }
                                });
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3

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
