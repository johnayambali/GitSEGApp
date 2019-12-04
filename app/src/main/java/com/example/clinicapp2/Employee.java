package com.example.clinicapp2;

public class Employee {

    public String clinic,userID;

    public Employee(){
        this.clinic = null;
        this.userID = null;


    }

    public Employee(String userID, String clinic){
        this.userID=userID;
        this.clinic=clinic;

    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
