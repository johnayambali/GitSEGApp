package com.example.clinicapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Welcome extends AppCompatActivity {
    Button logoutBtn;
    TextView welcomeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        final String uid;


        FirebaseUser user;



        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Patient").child(uid);
=======
<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Patient").child(uid);
=======
<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Patient").child(uid);
=======
<<<<<<< HEAD
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Patient").child(uid);
=======
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child(uid);
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final String fName = dataSnapshot.child("fName").getValue(String.class);
                final String role= dataSnapshot.child("role").getValue(String.class) ;

                welcomeText = (TextView) findViewById(R.id.welcomeText);
                welcomeText.setText("Welcome " + fName + "! You are logged-in as " + role);



            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






        logoutBtn = (Button)findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intoMain = new Intent(Welcome.this, MainActivity.class);
                startActivity(intoMain);
            }
        });
    }
}
