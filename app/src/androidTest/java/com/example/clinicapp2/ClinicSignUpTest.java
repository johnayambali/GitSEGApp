package com.example.clinicapp2;

import android.widget.TextView;

import androidx.test.annotation.UiThreadTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class ClinicSignUpTest {

    @Rule
    public ActivityTestRule<clinic_signup> cActivityTestRule= new ActivityTestRule<>(clinic_signup.class);
    private clinic_signup cActivity=null;
    private TextView text;


    @Before
    public void setUp() throws Exception {
        cActivity=cActivityTestRule.getActivity();
    }
    @Test
    @UiThreadTest
    public void checkClinicName() throws Exception {

        //User user= new User("LeBron","James","lbj@gmail.com","lebronjames23","goat");
        //assertEquals("Check the name of the user account", "LeBron", user.fName);

        text = cActivity.findViewById(R.id.clinicName);
        text.setText("clinicName1");
        String clinicName = text.getText().toString();
        assertNotEquals("ClinicName", clinicName);
    }

    @Test
    @UiThreadTest
    public void checkStreetNumber() throws Exception {

        text = cActivity.findViewById(R.id.etStreetNumber);
        text.setText("1");
        String number = text.getText().toString();
        assertNotEquals("2", number);
    }

    @Test
    @UiThreadTest
    public void checkStreetName() throws Exception {

        text = cActivity.findViewById(R.id.etStreetName);
        text.setText("Sunshine");
        String name = text.getText().toString();
        assertNotEquals("SinShine", name);
    }

    @Test
    @UiThreadTest
    public void checkFlatNumber() throws Exception {

        text = cActivity.findViewById(R.id.etFlatNumber);
        text.setText("50");
        String x = text.getText().toString();
        assertNotEquals("44", x);
    }

    @Test
    @UiThreadTest
    public void checkCity() throws Exception {

        text = cActivity.findViewById(R.id.etCity);
        text.setText("New York");
        String x = text.getText().toString();
        assertNotEquals("Ottawa", x);
    }

    @Test
    @UiThreadTest
    public void checkCountry() throws Exception {

        text = cActivity.findViewById(R.id.etCountry);
        text.setText("USA");
        String x = text.getText().toString();
        assertNotEquals("Mexico", x);
    }

    @Test
    @UiThreadTest
    public void checkPhoneNumber() throws Exception {

        text = cActivity.findViewById(R.id.etPhoneNumber);
        text.setText("5550125");
        String x = text.getText().toString();
        assertNotEquals("999999", x);
    }

    @Test
    @UiThreadTest
    public void checkPayment() throws Exception {

        text = cActivity.findViewById(R.id.paymentType);
        text.setText("Credit");
        String x = text.getText().toString();
        assertNotEquals("Cash", x);
    }







}
