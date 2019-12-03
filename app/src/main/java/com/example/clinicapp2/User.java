package com.example.clinicapp2;

public class User {
    public String fName, lName, email, password , role, clinicID;

    public User(){

    }

    public User(String fName, String lName, String email, String password, String role) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = SignUp.toSHA256(password);
        this.role = role;
<<<<<<< HEAD

=======
        clinicID ="null";
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
    }
}
