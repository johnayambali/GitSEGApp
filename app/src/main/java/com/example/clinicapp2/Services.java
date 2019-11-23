package com.example.clinicapp2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import android.text.TextUtils;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class Services extends AppCompatActivity {
    EditText editTextServiceName;
    EditText editTextServiceRole;
    Button addButton;
    ListView listViewServices;
    DatabaseReference databaseServices;

    List<aService> services;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        editTextServiceName = (EditText) findViewById(R.id.editTextServiceName);
        editTextServiceRole = (EditText) findViewById(R.id.editTextServiceRole);
        listViewServices = (ListView) findViewById(R.id.listViewServices);
        addButton = (Button) findViewById(R.id.addButton);
        databaseServices = FirebaseDatabase.getInstance().getReference("Service");


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addService(); //Add method of addService
            }
        });

        services = new ArrayList<>();

        listViewServices.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                aService service = services.get(i);
                showUpdateDeleteDialog(service.getId(), service.getServiceName());
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseServices.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                services.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    aService service = postSnapshot.getValue(aService.class);
                    services.add(service);
                }
                ServiceList servicesAdapter = new ServiceList(Services.this, services);
                listViewServices.setAdapter(servicesAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showUpdateDeleteDialog(final String serviceId, String serviceName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.activity_update, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextServiceName = (EditText) dialogView.findViewById(R.id.editTextServiceName);
        final EditText editTextServiceRole = (EditText) dialogView.findViewById(R.id.editTextServiceRole);
        final Button buttonUpdateService = (Button) dialogView.findViewById(R.id.buttonUpdateService);
        final Button buttonDeleteService = (Button) dialogView.findViewById(R.id.buttonDeleteService);

        dialogBuilder.setTitle(serviceName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdateService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextServiceName.getText().toString().trim();
                String role = editTextServiceRole.getText().toString().trim();
                if (!TextUtils.isEmpty(name)) {
                    updateService(serviceId, name, role);
                    b.dismiss();
                }
            }
        });

        buttonDeleteService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteService(serviceId);
                b.dismiss();
            }
        });
    }

    private void updateService(String id, String name, String role) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("Service").child(id);
        aService service = new aService(id, name, role);
        dR.setValue(service);
        Toast.makeText(getApplicationContext(), "Service Updated", Toast.LENGTH_SHORT).show();
    }

    private boolean deleteService(String id) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("Service").child(id);
        dR.removeValue();
        Toast.makeText(getApplicationContext(), "Service Deleted", Toast.LENGTH_SHORT).show();
        return true;
    }

    private void addService() {
        String name = editTextServiceName.getText().toString().trim();
        String role = editTextServiceRole.getText().toString().trim();
        if (!TextUtils.isEmpty(name)) {
            String id = databaseServices.push().getKey();
            aService product = new aService(id, name, role);
            databaseServices.child(id).setValue(product);
            editTextServiceName.setText("");
            editTextServiceRole.setText("");
            Toast.makeText(this, "Service added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter a service", Toast.LENGTH_SHORT).show();
        }

    }
}
