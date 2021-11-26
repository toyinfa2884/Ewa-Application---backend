package semicolon.africa.ewaApplication.controllers;

import org.springframework.web.bind.annotation.*;
import semicolon.africa.ewaApplication.data.models.Customer;
import semicolon.africa.ewaApplication.dtos.requests.CustomerRequest;
import semicolon.africa.ewaApplication.dtos.responses.CustomerResponse;
import semicolon.africa.ewaApplication.services.CustomerService;
import semicolon.africa.ewaApplication.services.CustomerServiceImpl;

import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerService customerService = new CustomerServiceImpl();

    @PostMapping("/api/registerCustomer")
    public CustomerResponse registerCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.registerCustomer(customerRequest);
    }
    @GetMapping("/api/customer/{email}")
    public Optional<Customer> customer(@PathVariable String email){
        return customerService.findCustomerByEmail(email);
    }
}
