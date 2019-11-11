package com.example.clinicapp2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Services extends AppCompatActivity {


    //ListView sv;
    EditText servText, rolText;
    Button addBtn, editBtn, delBtn;
    //ArrayList<String> services=new ArrayList<String>();
    ArrayList<aService> servix=new ArrayList<aService>();
    //ArrayAdapter<String> adapter;
    private ListView lv;
    private ServiceAdapter sa;
    private aService serv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        //sv = findViewById(R.id.servView);
        lv = findViewById(R.id.service_list);
        servText = findViewById(R.id.servTxt);
        rolText =findViewById(R.id.roleTxt);
        addBtn = findViewById(R.id.addBtn);
        editBtn =findViewById(R.id.editBtn);
        delBtn=findViewById(R.id.delBtn);


        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, services);
        //sv.setAdapter(adapter);

        sa = new ServiceAdapter(this, servix);
        lv.setAdapter(sa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
            }
        });


        //Set selected item


        //Handle events

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

        //return bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }




    private void add(){
        String service=servText.getText().toString();
        String role=rolText.getText().toString();
        aService newServ = new aService(service,role);
        Boolean chek=checkRole(role);

        if(!service.isEmpty()&& !role.isEmpty()&&service.length()>0&&role.length()>0){
            if(chek) {
                //Add
                servix.add(new aService(service, role));

                //Refresh
                sa.notifyDataSetChanged();

                servText.setText("");
                rolText.setText("");

                Toast.makeText(getApplicationContext(), "Added " + service, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Role has to be either Doctor, Nurse, or Staff " + service, Toast.LENGTH_SHORT).show();
            }
        }else{
            //Test case #3 checks if the fields service and role aren't fulfilled properly then sends a message
            Toast.makeText(getApplicationContext(), "Nothing to add " + service, Toast.LENGTH_SHORT).show();
        }
    }

    private void update(){


        String service=servText.getText().toString();
        String role=rolText.getText().toString();
        aService newServ = new aService(service,role);
        Boolean chek=checkRole(role);

        //getting position
        int pos = lv.getCheckedItemPosition();

        if(!service.isEmpty()&& !role.isEmpty()&&service.length()>0&&role.length()>0){
            if(chek) {
                //removing
                sa.remove(servix.get(pos));
                //insert
                sa.insert(newServ, pos);
                //refresh
                sa.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Updated " + service, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Role has to be either Doctor, Nurse, or Staff " + service, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Nothing to edit...Enter new Service and Role then press edit. " + service, Toast.LENGTH_SHORT).show();
        }



    }


    private void delete(){

        int pos =lv.getCheckedItemPosition();

        if(pos> -1){
            //delete
            servix.remove(servix.get(pos));
            //refresh
            sa.notifyDataSetChanged();

            servText.setText("");
            rolText.setText("");
            Toast.makeText(getApplicationContext(), "Deleted ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Nothing to delete ", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean checkRole(String role){

        if(role.equals("Doctor") || role.equals("doctor") || role.equals("Nurse") || role.equals("nurse") || role.equals("Staff") || role.equals("staff")){

            return true;

        }
        return false;

    }
}
