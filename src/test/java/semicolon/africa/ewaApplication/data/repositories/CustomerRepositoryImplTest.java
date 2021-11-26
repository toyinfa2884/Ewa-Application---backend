package semicolon.africa.ewaApplication.data.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.ewaApplication.data.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = new Customer();
        customer.setEmail("toyinfatai@gmail.com");
        customer.setFirstName("Chi");
        customer.setFirstName("Bob");
        customer.setPassword("12345");
        customerRepository.save(customer);
        assertEquals(1, customerRepository.findAll().size());

    }
    private  Customer helperMethod(){
        Customer customer = new Customer();
        customer.setEmail("chibob@gmail.com");
        customer.setFirstName("Chi");
        customer.setFirstName("Bob");
        customer.setPassword("12345");
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Test
    void findCustomerByEmail() {
        Customer customer = new Customer();
        customer.setEmail("chibob@gmail.com");
        customer.setFirstName("Chi");
        customer.setLastName("Bob");
        customer.setPassword("12345");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findCustomerByEmail("chibob@gmail.com"));
        assertEquals(1, customerRepository.findAll().size());
    }

    @Test
    void deleteByEmail() {
        helperMethod();
        assertEquals(1, customerRepository.findAll().size());
        customerRepository.deleteByEmail("chibob@gmail.com");
        assertEquals(0, customerRepository.findAll().size());
    }

    @Test
    void findAll() {
        helperMethod();
        assertEquals(1, customerRepository.findAll().size());

    }

    @Test
    void deleteAll() {
        helperMethod();
        assertEquals(1, customerRepository.findAll().size());
        customerRepository.deleteAll();
        assertEquals(0, customerRepository.findAll().size());
    }

}