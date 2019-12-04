package com.example.clinicapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText txEmail, txPassword;
    Button inBtn, upBtn;
    //new
    static User currUser = null;
    //new
    static Employee currEmp = null;

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
                final String email = txEmail.getText().toString().trim();
                final String password = txPassword.getText().toString().trim();
                //Test case #5 checks if email and password fields are empty
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this, "Field empty: Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Field empty: Please enter your password", Toast.LENGTH_SHORT).show();
                }
<<<<<<< HEAD
                else if(email.equals("admin@admin1.com") && password.equals("5T5ptQ"))
=======
<<<<<<< HEAD
                else if(email.equals("admin@admin1.com") && password.equals("5T5ptQ"))
=======
<<<<<<< HEAD
                else if(email.equals("admin@admin1.com") && password.equals("5T5ptQ"))
=======
                else if(email.equals("admin@strator.com") && password.equals("5T5ptQ"))
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
                {
                    Intent x = new Intent(getApplicationContext(), Admin.class);
                    startActivity(x);

                }
                else if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();

                }
                else if(!(TextUtils.isEmpty(email)&& TextUtils.isEmpty(password))) {
                    mFireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                final String uid;
                                FirebaseUser user;
                                user = FirebaseAuth.getInstance().getCurrentUser();
                                uid = user.getUid();
<<<<<<< HEAD
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
                                //DatabaseReference reference2= FirebaseDatabase.getInstance().g
=======
<<<<<<< HEAD
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
                                //DatabaseReference reference2= FirebaseDatabase.getInstance().g
=======
<<<<<<< HEAD
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uid);
                                //DatabaseReference reference2= FirebaseDatabase.getInstance().g
=======
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child(uid);

>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
                                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        final String role= dataSnapshot.child("role").getValue(String.class);
                                        System.out.println(role);
                                        if(role.equals("Employee")){
                                            Intent i = new Intent(MainActivity.this, EmployeeActivity.class);
                                            startActivity(i);
                                        }
                                        else{
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
                                            Intent in = new Intent(MainActivity.this, Welcome.class);
                                            startActivity(in);
                                        }


                                    }
                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });



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
