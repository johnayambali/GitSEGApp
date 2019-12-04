package com.example.clinicapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceView extends AppCompatActivity {
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
    TextView addServiceBtn, deleteServiceBtn;
    DatabaseReference databaseReference, clinicDBR, db;
    List<aService> services;
    ListView adminListView, employeeListView;
    List<aService> employeeServices;
    String clinicID;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
    Button addServiceBtn, deleteServiceBtn;
    DatabaseReference databaseReference;
    List<aService> services;
    ListView adminListView, employeeListView;
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_service_view);
<<<<<<< HEAD
        addServiceBtn = (TextView) findViewById(R.id.addServiceBtn);
=======
<<<<<<< HEAD
        addServiceBtn = (TextView) findViewById(R.id.addServiceBtn);
=======
<<<<<<< HEAD
        addServiceBtn = (TextView) findViewById(R.id.addServiceBtn);
=======
<<<<<<< HEAD
        addServiceBtn = (TextView) findViewById(R.id.addServiceBtn);
=======
<<<<<<< HEAD
        addServiceBtn = (TextView) findViewById(R.id.addServiceBtn);
=======
        addServiceBtn = (Button) findViewById(R.id.addServiceBtn);
        deleteServiceBtn = (Button) findViewById(R.id.deleteServiceBtn);
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
        adminListView = (ListView) findViewById(R.id.adminListView);
        employeeListView = (ListView) findViewById(R.id.employeeListView);

        services = new ArrayList<>();
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
        employeeServices = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Service");
        clinicDBR= FirebaseDatabase.getInstance().getReference("Clinic");

        registerForContextMenu(adminListView);
        registerForContextMenu(employeeListView);



<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        databaseReference = FirebaseDatabase.getInstance().getReference("Service");

        addServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmployeeService(); //Add method of addService
            }
        });
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989

    }
    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    aService service = postSnapshot.getValue(aService.class);
                    services.add(service);
                }
                ServiceList servicesAdapter = new ServiceList(EmployeeServiceView.this, services);
                adminListView.setAdapter(servicesAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

        final String uID;
        FirebaseUser user;
        user = FirebaseAuth.getInstance().getCurrentUser();
        uID = user.getUid();
        db = FirebaseDatabase.getInstance().getReference("User").child("Employee").child(uID);


        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final String clinID = dataSnapshot.child("clinicID").getValue(String.class);
                clinicID=clinID;
                //Needs string to print

                db=FirebaseDatabase.getInstance().getReference("Clinic").child(clinicID).child("Service");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        employeeServices.clear();
                        for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                            aService service = postSnapshot.getValue(aService.class);
                            employeeServices.add(service);
                        }
                        ServiceList servicesAdapter = new ServiceList(EmployeeServiceView.this, employeeServices);
                        employeeListView.setAdapter(servicesAdapter);
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                services.clear();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    aService service = postSnapshot.getValue(aService.class);
                    services.add(service);
                }
                ServiceList servicesAdapter = new ServiceList(EmployeeServiceView.this, services);
                employeeListView.setAdapter(servicesAdapter);
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        if(v.getId()==R.id.adminListView){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.administrator_menu,menu);
        }

        if(v.getId()==R.id.employeeListView){
            MenuInflater inflater2= getMenuInflater();
            inflater2.inflate(R.menu.employee_menu,menu);

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position; //Use this for getting the list item value
        View view = info.targetView;

        switch(item.getItemId()) {
            case R.id.addService:
                addEmployeeService(index);
                return true;

            case R.id.deleteService:
                deleteEmployeeService(index);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
    //Might be this!
    private void addEmployeeService(int pos) {
        aService service= services.get(pos);
        String id = service.getId();
        db.child(id).setValue(service);
    }
    private void deleteEmployeeService(int pos) {
        aService service= employeeServices.get(pos);
        String id = service.getId();
        db.child(id).removeValue();
    }

<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======
}
=======
    //private boolean deleteEmployeeService(String id) {

    //}

    private void addEmployeeService() {

    }
}
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
