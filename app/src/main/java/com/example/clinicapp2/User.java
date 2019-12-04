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
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
        clinicID ="null";
>>>>>>> a55d5abab4d0efb4710ddf6c60f878dc1c4eef12
>>>>>>> d3627a3eb309eb827b8fbb36451e84130498bb4f
>>>>>>> 13acf58ecba74e7061cbdd1d1ba590115429ecd4
>>>>>>> 10e7b2b35b74e8c4652750815f5c902b37b5e8c7
>>>>>>> 82865bfd9362cb3a3a01942b7d11c378f31a2989
>>>>>>> 124e82fa65d90f2eabcf411e300c55f76ff06e29
>>>>>>> 2f0339586ef13ff1c999277e71a324dd4ee338d3
    }
}
