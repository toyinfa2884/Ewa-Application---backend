package semicolon.africa.ewaApplication.data.models;

import lombok.Data;

@Data
public class Customer {
    private  String email;
    private String firstName;
    private String lastName;
    private  String password;
    private String userName;
}
