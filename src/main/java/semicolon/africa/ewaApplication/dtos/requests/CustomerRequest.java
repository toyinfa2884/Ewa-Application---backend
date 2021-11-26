package semicolon.africa.ewaApplication.dtos.requests;

import lombok.Data;

@Data
public class CustomerRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
}
