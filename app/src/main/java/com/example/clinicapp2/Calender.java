package com.example.clinicapp2;

import android.os.Bundle;
import android.view.View;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class Calender extends AppCompatActivity{
    TextView manageCalender, mondayTitle, mondayHour, mondayEditTime, tuesdayTitle, tuesdayHour, tuesdayEditTime, wednesdayTitle, wednesdayHour, wednesdayEditTime, thursdayTitle, thursdayHour, thursdayEditTime, fridayTitle, fridayHour, fridayEditTime, textFormat;
    Button mondayEditBtn, tuesdayEditBtn, wednesdayEditBtn, thursdayEditBtn, fridayEditBtn;
    DatabaseReference databaseReference;
    String currentClinicID;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Calender extends AppCompatActivity{
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
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
        manageCalender = (TextView) findViewById(R.id.manageCalendar);
        mondayTitle = (TextView) findViewById(R.id.mondayTitle);
        tuesdayTitle = (TextView) findViewById(R.id.tuesdayTitle);
        wednesdayTitle = (TextView) findViewById(R.id.wednesdayTitle);
        thursdayTitle = (TextView) findViewById(R.id.thursdayTitle);
        fridayTitle = (TextView) findViewById(R.id.fridayTitle);
        textFormat = (TextView) findViewById(R.id.textFormat);
        mondayEditBtn = (Button) findViewById(R.id.mondayEditBtn);
        tuesdayEditBtn = (Button) findViewById(R.id.tuesdayEditBtn);
        wednesdayEditBtn = (Button) findViewById(R.id.wednesdayEditBtn);
        thursdayEditBtn = (Button) findViewById(R.id.thursdayEditBtn);
        fridayEditBtn = (Button) findViewById(R.id.fridayEditBtn);
        mondayHour = (TextView) findViewById(R.id.mondayHour);
        mondayEditTime = (TextView) findViewById(R.id.mondayEdit);
        tuesdayHour = (TextView) findViewById(R.id.tuesdayHour);
        tuesdayEditTime = (TextView) findViewById(R.id.tuesdayEdit);
        wednesdayHour = (TextView) findViewById(R.id.wednesdayHour);
        wednesdayEditTime = (TextView) findViewById(R.id.wednesdayEdit);
        thursdayHour = (TextView) findViewById(R.id.thursdayHour);
        thursdayEditTime = (TextView) findViewById(R.id.thursdayEdit);
        fridayHour = (TextView) findViewById(R.id.fridayHour);
        fridayEditTime = (TextView) findViewById(R.id.fridayEdit);
        final String uid;
        FirebaseUser user;
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String clinicID = dataSnapshot.child("clinicID").getValue(String.class);
                currentClinicID = clinicID;
                databaseReference = FirebaseDatabase.getInstance().getReference("Clinic").child(currentClinicID).child("Hours");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final String mondayHourTime = dataSnapshot.child("Monday").child("hour").getValue(String.class);
                        final String tuesdayHourTime = dataSnapshot.child("Tuesday").child("hour").getValue(String.class);
                        final String wednesdayHourTime = dataSnapshot.child("Wednesday").child("hour").getValue(String.class);
                        final String thursdayHourTime = dataSnapshot.child("Thursday").child("hour").getValue(String.class);
                        final String fridayHourTime = dataSnapshot.child("Friday").child("hour").getValue(String.class);

                        //if(!(mondayHourTime.equals("") && tuesdayHourTime.equals("") && wednesdayHourTime.equals("") && thursdayHourTime.equals("") && fridayHourTime.equals(""))){
                        if(!(mondayHourTime=="" && tuesdayHourTime=="" && wednesdayHourTime=="" && thursdayHourTime=="" && fridayHourTime=="")){
                            mondayHour.setText(mondayHourTime);
                            tuesdayHour.setText(tuesdayHourTime);
                            wednesdayHour.setText(wednesdayHourTime);
                            thursdayHour.setText(thursdayHourTime);
                            fridayHour.setText(fridayHourTime);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void mondayEdit(View v){
        if (!mondayEditTime.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9]:[0-9][0-9]-[0-2][0-9]:[0-9][0-9]$", mondayEditTime.getText().toString().trim())){
            mondayHour.setText(mondayEditTime.getText());
            mondayEditTime.setText("");
            String time = mondayHour.getText().toString();
            Hour hour = new Hour();
            hour.setHour(time);
            System.out.println(hour);
            databaseReference.child("Monday").child("hour").setValue(time);

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
    }

    public void mondayEdit(View v){
        TextView mondayHour = (TextView) findViewById(R.id.mondayHour);
        TextView mondayEdit = (TextView) findViewById(R.id.mondayEdit);
        if (!mondayEdit.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9][0-9][0-9]-[0-2][0-9][0-9][0-9]$", mondayEdit.getText().toString().trim())){
            mondayHour.setText(mondayEdit.getText());
            mondayEdit.setText("");
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3
        }
        else{
            Toast.makeText(Calender.this, "Invalid Time", Toast.LENGTH_SHORT).show();
        }

    }

    public void tuesdayEdit(View v){
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
        if (!tuesdayEditTime.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9]:[0-9][0-9]-[0-2][0-9]:[0-9][0-9]$", tuesdayEditTime.getText().toString().trim())){
            tuesdayHour.setText(tuesdayEditTime.getText());
            tuesdayEditTime.setText("");
            String time = tuesdayHour.getText().toString();
            Hour hour = new Hour();
            hour.setHour(time);
            databaseReference.child("Tuesday").child("hour").setValue(time);
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
        TextView tuesdayHour = (TextView) findViewById(R.id.tuesdayHour);
        TextView tuesdayEdit = (TextView) findViewById(R.id.tuesdayEdit);
        if (!tuesdayEdit.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9][0-9][0-9]-[0-2][0-9][0-9][0-9]$", tuesdayEdit.getText().toString().trim())){
            tuesdayHour.setText(tuesdayEdit.getText());
            tuesdayEdit.setText("");
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3
        }
        else{
            Toast.makeText(Calender.this, "Invalid Time", Toast.LENGTH_SHORT).show();
        }
    }

    public void wednesdayEdit(View v){
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
        if (!wednesdayEditTime.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9]:[0-9][0-9]-[0-2][0-9]:[0-9][0-9]$", wednesdayEditTime.getText().toString().trim())){
            wednesdayHour.setText(wednesdayEditTime.getText());
            wednesdayEditTime.setText("");
            String time = wednesdayHour.getText().toString();
            Hour hour = new Hour();
            hour.setHour(time);
            databaseReference.child("Wednesday").child("hour").setValue(hour);
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
        TextView wednesdayHour = (TextView) findViewById(R.id.wednesdayHour);
        TextView wednesdayEdit = (TextView) findViewById(R.id.wednesdayEdit);
        if (!wednesdayEdit.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9][0-9][0-9]-[0-2][0-9][0-9][0-9]$", wednesdayEdit.getText().toString().trim())){
            wednesdayHour.setText(wednesdayEdit.getText());
            wednesdayEdit.setText("");
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3
        }
        else{
            Toast.makeText(Calender.this, "Invalid Time", Toast.LENGTH_SHORT).show();
        }
    }

    public void thursdayEdit(View v){
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
        if (!thursdayEditTime.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9]:[0-9][0-9]-[0-2][0-9]:[0-9][0-9]$", thursdayEditTime.getText().toString().trim())){
            thursdayHour.setText(thursdayEditTime.getText());
            thursdayEditTime.setText("");
            String time = thursdayHour.getText().toString();
            Hour hour = new Hour();
            hour.setHour(time);
            databaseReference.child("Thursday").child("hour").setValue(time);
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
        TextView thursdayHour = (TextView) findViewById(R.id.thursdayHour);
        TextView thursdayEdit = (TextView) findViewById(R.id.thursdayEdit);
        if (!thursdayEdit.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9][0-9][0-9]-[0-2][0-9][0-9][0-9]$", thursdayEdit.getText().toString().trim())){
            thursdayHour.setText(thursdayEdit.getText());
            thursdayEdit.setText("");
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3
        }
        else{
            Toast.makeText(Calender.this, "Invalid Time", Toast.LENGTH_SHORT).show();
        }
    }

    public void fridayEdit(View v){
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
        if (!fridayEditTime.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9]:[0-9][0-9]-[0-2][0-9]:[0-9][0-9]$", fridayEditTime.getText().toString().trim())){
            fridayHour.setText(fridayEditTime.getText());
            fridayEditTime.setText("");
            String time = fridayHour.getText().toString();
            Hour hour = new Hour();
            hour.setHour(time);
            databaseReference.child("Friday").child("hour").setValue(time);
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
        TextView fridayHour = (TextView) findViewById(R.id.fridayHour);
        TextView fridayEdit = (TextView) findViewById(R.id.fridayEdit);
        if (!fridayEdit.getText().toString().trim().equals("") && Pattern.matches("^[0-2][0-9][0-9][0-9]-[0-2][0-9][0-9][0-9]$", fridayEdit.getText().toString().trim())){
            fridayHour.setText(fridayEdit.getText());
            fridayEdit.setText("");
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3
        }
        else{
            Toast.makeText(Calender.this, "Invalid Time", Toast.LENGTH_SHORT).show();
        }
    }
}
