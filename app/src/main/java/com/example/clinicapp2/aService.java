package com.example.clinicapp2;



public class aService {
    private String service;
    private String role;

    public aService(String service, String role){
        this.service=service;
        this.role="Performed by " + role;
    }

    public String getService(){
        return service;
    }

    public String getRole(){
        return role;
    }

    public void setService(String service){
        this.service= service;

    }

    public void setRole(String role){
        this.role =role;
    }
}
