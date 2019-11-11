package com.example.clinicapp2;

import android.widget.TextView;

import androidx.test.annotation.UiThreadTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class SignUpAcitivityTest {

    @Rule
    public ActivityTestRule<SignUp> sActivityTestRule= new ActivityTestRule<SignUp>(SignUp.class);
    private SignUp sActivity=null;
    private TextView text;



    @Before
    public void setUp() throws Exception {
        sActivity=sActivityTestRule.getActivity();
    }
    @Test
    @UiThreadTest
    public void checkFirstName() throws Exception {

        //User user= new User("LeBron","James","lbj@gmail.com","lebronjames23","goat");
        //assertEquals("Check the name of the user account", "LeBron", user.fName);

        text = sActivity.findViewById(R.id.firstName);
        text.setText("firstName1");
        String name = text.getText().toString();
        assertNotEquals("firstName", name);
    }

    @Test
    @UiThreadTest
    public void checkLastName() throws Exception {

        text = sActivity.findViewById(R.id.lastName);
        text.setText("lastName1");
        String name = text.getText().toString();
        assertNotEquals("lastName", name);
    }

    @Test
    @UiThreadTest
    public void checkEmail() throws Exception {

        text = sActivity.findViewById(R.id.txEmail);
        text.setText("email1");
        String name = text.getText().toString();
        assertNotEquals("email", name);
    }

    @Test
    @UiThreadTest
    public void checkPassword() throws Exception {

        text = sActivity.findViewById(R.id.txPassword);
        text.setText("password1");
        String name = text.getText().toString();
        assertNotEquals("password", name);
    }

    @Test
    @UiThreadTest
    public void checkRole() throws Exception {

        text = sActivity.findViewById(R.id.roleText);
        text.setText("Role1");
        String name = text.getText().toString();
        assertNotEquals("Role", name);
    }




}
