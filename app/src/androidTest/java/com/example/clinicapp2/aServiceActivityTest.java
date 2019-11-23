package com.example.clinicapp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class aServiceActivityTest {
    @Test
    public void serviceNameTest(){
        aService p = new aService( "12345", "Flu Shot", "Nurse");
        assertEquals(p.getId(),"12345");
    }
}
