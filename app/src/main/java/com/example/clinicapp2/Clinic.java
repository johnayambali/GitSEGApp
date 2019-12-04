package com.example.clinicapp2;

public class Clinic {

    public String clinicName, streetNum, streetName, flatNum, city, country, insuranceType, paymentMethod, phoneNumber;

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(String flatNum) {
        this.flatNum = flatNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Clinic(){

    }

    public Clinic( String clinicName, String streetNum, String streetName,
                   String flatNum, String city, String country, String insuranceType,
                   String paymentMethod, String phoneNumber){
        this.clinicName = clinicName;
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.flatNum = flatNum;
        this.city = city;
        this.country = country;
        this.insuranceType = insuranceType;
        this. paymentMethod = paymentMethod;
        this.phoneNumber=phoneNumber;

    }

}
