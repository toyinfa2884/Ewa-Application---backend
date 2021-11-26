package semicolon.africa.ewaApplication.data.repositories;

import semicolon.africa.ewaApplication.data.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findCustomerByEmail(String email);
    void deleteByEmail(String email);
    List<Customer> findAll();
    void deleteAll();


}
