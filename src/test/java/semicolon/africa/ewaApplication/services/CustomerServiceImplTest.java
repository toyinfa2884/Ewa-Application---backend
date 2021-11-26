package semicolon.africa.ewaApplication.services;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.ewaApplication.dtos.requests.CustomerRequest;
import semicolon.africa.ewaApplication.dtos.responses.CustomerResponse;
import semicolon.africa.ewaApplication.exceptions.DuplicatedCustomerException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    private  static CustomerService customerService;

    @BeforeEach
    void setUp() {

        customerService = new CustomerServiceImpl();
    }

    @AfterEach
    void tearDown() {
        customerService.deleteAllCustomers();
    }

    @Test
    void registerCustomer(){
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setEmail("chibob@gmail.com");
        customerRequest.setFirstName("Chi");
        customerRequest.setLastName("Bob");
        customerRequest.setUserName("uncleChiX");
        customerRequest.setPassword("123");
        CustomerResponse saveCustomer = customerService.registerCustomer(customerRequest);

        assertEquals(1, customerService.findAllCustomer().size());
    }
    private  CustomerResponse customerInfo(){
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setEmail("chibob@gmail.com");
        customerRequest.setFirstName("Chi");
        customerRequest.setLastName("Bob");
        customerRequest.setUserName("uncleChiX");
        customerRequest.setPassword("123");

        return customerService.registerCustomer(customerRequest);
    }

    @Test
    void deleteCustomerByEmail() {
        CustomerResponse registerCustomer = customerInfo();
        assertEquals(registerCustomer, customerService.findCustomerByEmail(registerCustomer.getEmail()).get());
    }

    @Test
    void deleteAllCustomers() {
        registerCustomer();
        customerService.deleteAllCustomers();
        assertEquals(0, customerService.findAllCustomer().size());
    }

    @Test
    void findCustomerByEmail() {
        registerCustomer();
        customerService.findCustomerByEmail("chibob@gmail.com");
        assertEquals(1, customerService.findCustomerByEmail("chibob@gmail.com"));
    }
}