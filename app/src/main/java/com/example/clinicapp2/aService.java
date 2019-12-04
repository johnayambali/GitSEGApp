package com.example.clinicapp2;

public class aService {
    public String serviceName, serviceRole, id;

    public aService(){
    }

    public aService(String id, String serviceName, String serviceRole)
    {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceRole = serviceRole;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    }
    public String getServiceName(){
        return this.serviceName;
    }
    public void setServiceRole(String serviceRole){
        this.serviceRole = serviceRole;
    }
    public String getServiceRole(){
        return this.serviceRole;
    }

}
