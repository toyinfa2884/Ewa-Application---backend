package semicolon.africa.ewaApplication.services;

import semicolon.africa.ewaApplication.data.models.Customer;
import semicolon.africa.ewaApplication.dtos.requests.CustomerRequest;
import semicolon.africa.ewaApplication.dtos.responses.CustomerResponse;
import semicolon.africa.ewaApplication.exceptions.DuplicatedCustomerException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerResponse registerCustomer(CustomerRequest customerResponse);
    List<Customer> findAllCustomer();
    void deleteCustomerByEmail(String email);
    void deleteAllCustomers();
    Optional<Customer> findCustomerByEmail(String email);
}
