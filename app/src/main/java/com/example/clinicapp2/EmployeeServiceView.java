package com.example.clinicapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceView extends AppCompatActivity {
    TextView addServiceBtn, deleteServiceBtn;
    DatabaseReference databaseReference, clinicDBR, db;
    List<aService> services;
    ListView adminListView, employeeListView;
    List<aService> employeeServices;
    String clinicID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_service_view);
        addServiceBtn = (TextView) findViewById(R.id.addServiceBtn);
        adminListView = (ListView) findViewById(R.id.adminListView);
        employeeListView = (ListView) findViewById(R.id.employeeListView);

        services = new ArrayList<>();
        employeeServices = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Service");
        clinicDBR= FirebaseDatabase.getInstance().getReference("Clinic");

        registerForContextMenu(adminListView);
        registerForContextMenu(employeeListView);




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



            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


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

}