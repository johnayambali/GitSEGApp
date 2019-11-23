package com.example.clinicapp2;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class ClinicActivityTest {
    @Test
    public void clinicActivityTest(){
        Clinic p = new Clinic( "Sunshine Clinic", "23", "Garden Crescent", "22", "Ottawa", "Canada", "Student", "Credit", "777666555");
        assertEquals(p.getClinicName(),"Sunshine Clinic");
    }

}
