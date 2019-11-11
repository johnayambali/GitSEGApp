package com.example.clinicapp2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdapter extends ArrayAdapter<aService> {

    private Context context;
    private List<aService> serviceList= new ArrayList<>();

    public ServiceAdapter(Context context, @LayoutRes ArrayList<aService> serviceList){
        super(context,0,serviceList);
        this.context=context;
        this.serviceList=serviceList;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        aService aservice=getItem(position);
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);




        TextView service = (TextView) listItem.findViewById(R.id.tv_service);
        service.setText(aservice.getService());

        TextView role = (TextView) listItem.findViewById(R.id.tv_role);
        role.setText(aservice.getRole());

        return listItem;



    }

}
