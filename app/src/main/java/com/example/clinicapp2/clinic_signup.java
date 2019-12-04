package com.example.clinicapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class clinic_signup extends AppCompatActivity {

    EditText clinicName, etStreetNumber, etFlatNumber, etStreetName, etCity, etCountry, etPhoneNumber, etPaymentType;
    RadioButton btnPersonal, btnStudent, btnEmployee;
    Button clSaveBtn, clCancelBtn;
    DatabaseReference databaseReference;
    String insuranceType= "";
    Clinic clinic;

    String employeeID="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_signup);

        clinicName= findViewById(R.id.clinicName);
        etStreetNumber=findViewById(R.id.etStreetNumber);
        etStreetName=findViewById(R.id.etStreetName);
        etFlatNumber=findViewById(R.id.etFlatNumber);
        etCity=findViewById(R.id.etCity);
        etCountry=findViewById(R.id.etCountry);
        etPhoneNumber=findViewById(R.id.etPhoneNumber);
        etPaymentType=findViewById(R.id.paymentType);
        btnPersonal=findViewById(R.id.btnPersonal);
        btnEmployee=findViewById(R.id.btnEmployee);
        btnStudent=findViewById(R.id.btnStudent);
        //clCancelBtn=findViewById(R.id.clCancelBtn);
        clSaveBtn=findViewById(R.id.clSaveBtn);

        FirebaseUser user;
<<<<<<< HEAD
        clinic = new Clinic();
=======
<<<<<<< HEAD
        clinic = new Clinic();
=======
<<<<<<< HEAD
        clinic = new Clinic();
=======
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4



        databaseReference = FirebaseDatabase.getInstance().getReference("Clinic");
<<<<<<< HEAD


=======
<<<<<<< HEAD


=======
<<<<<<< HEAD


=======
        //we can get the employee ID and add it to the the clinic ID field
        user = FirebaseAuth.getInstance().getCurrentUser();
        employeeID = user.getUid();
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4

        clSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String clName = clinicName.getText().toString().trim();
                final String stNum= etStreetNumber.getText().toString().trim();
                final String stName= etStreetName.getText().toString().trim();
                final String flNum= etFlatNumber.getText().toString().trim();
                final String city= etCity.getText().toString().trim();
                final String country= etCountry.getText().toString().trim();
                final String phone= etPhoneNumber.getText().toString().trim();
                final String payment= etPaymentType.getText().toString().trim();

                if(btnPersonal.isChecked()){
                    insuranceType = "Personal Insurance";
                }if(btnStudent.isChecked()){
                    insuranceType = "Student Insurance";
                }if(btnEmployee.isChecked()){
                    insuranceType = "Employee Insurance";
                }
                if((TextUtils.isEmpty(clName) ||TextUtils.isEmpty(stNum) ||TextUtils.isEmpty(stName) ||TextUtils.isEmpty(flNum) ||
                        TextUtils.isEmpty(city) ||TextUtils.isEmpty(country) ||TextUtils.isEmpty(phone) || TextUtils.isEmpty(payment))){

                    Toast.makeText(clinic_signup.this, "One or more fields are empty", Toast.LENGTH_SHORT).show();

                    /*want to get user id of person that logged in so i can copy that and add that to the clinic id field
                    String id = databaseReference.push().getKey();
                    Clinic clinic = new Clinic(clName,stNum,stName,flNum,city,country,insuranceType,payment,phone,employeeID);
                    databaseReference.child(id).setValue(clinic);
                    Toast.makeText(clinic_signup.this, "Clinic added", Toast.LENGTH_SHORT).show();*/
                }else{
                    clinic.setClinicName(clName);
                    clinic.setCity(city);
                    clinic.setFlatNum(flNum);
                    clinic.setStreetNum(stNum);
                    clinic.setStreetName(stName);
                    clinic.setCountry(country);
                    clinic.setPhoneNumber(phone);
                    clinic.setPaymentMethod(payment);
                    clinic.setInsuranceType(insuranceType);
                    String mGroupId = databaseReference.push().getKey();

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4



                    databaseReference.child(mGroupId).child("Info").push().setValue(clinic);

                    Toast.makeText(clinic_signup.this, "Clinic Registry Complete", Toast.LENGTH_SHORT).show();

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
                    databaseReference.push().setValue(clinic);
                    Toast.makeText(clinic_signup.this, "Clinic Registry Complete", Toast.LENGTH_SHORT).show();
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
                    databaseReference = FirebaseDatabase.getInstance().getReference("User");
                    final String uid;
                    FirebaseUser user;
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    uid = user.getUid();
<<<<<<< HEAD
                    databaseReference.child("Employee").child(uid).child("clinicID").setValue(mGroupId);
=======
<<<<<<< HEAD
                    databaseReference.child("Employee").child(uid).child("clinicID").setValue(mGroupId);
=======
<<<<<<< HEAD
                    databaseReference.child("Employee").child(uid).child("clinicID").setValue(mGroupId);
=======
                    databaseReference.child(uid).child("clinicID").setValue(mGroupId);
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
                    Intent inToEmployeeActivity = new Intent(clinic_signup.this, EmployeeActivity.class);
                    startActivity(inToEmployeeActivity);



                }
            }
        });

        /*clCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToEmployeeActivity = new Intent(clinic_signup.this, EmployeeActivity.class);
                startActivity(inToEmployeeActivity);

            }
        });*/



    }
}
