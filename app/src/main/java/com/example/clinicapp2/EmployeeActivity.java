package com.example.clinicapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EmployeeActivity extends AppCompatActivity{
    Button profileView, serviceManage, calenderManage, logoutButton;
    TextView employeeWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        profileView = findViewById(R.id.profileView);
        serviceManage = findViewById(R.id.serviceManage);
        calenderManage = findViewById(R.id.calendarManage);
        logoutButton = findViewById(R.id.logoutButton);

        final String uid;
        FirebaseUser user;


        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
=======
<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
=======
<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
=======
<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
=======
<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
=======
<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
=======
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child(uid);
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final String fName = dataSnapshot.child("fName").getValue(String.class);
                final String role = dataSnapshot.child("role").getValue(String.class);
                employeeWelcome = (TextView) findViewById(R.id.employeeWelcome);
                employeeWelcome.setText("Welcome " + fName + "! You are logged-in as " + role);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        profileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToProfile = new Intent(EmployeeActivity.this, clinic_signup.class);
                startActivity(inToProfile);
            }
        });
        serviceManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToService = new Intent(EmployeeActivity.this, EmployeeServiceView.class);
                startActivity(inToService);
            }
        });
        calenderManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToCalender = new Intent(EmployeeActivity.this, Calender.class);
                startActivity(inToCalender);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intoMain = new Intent(EmployeeActivity.this, MainActivity.class);
                startActivity(intoMain);
            }
        });
    }
}
