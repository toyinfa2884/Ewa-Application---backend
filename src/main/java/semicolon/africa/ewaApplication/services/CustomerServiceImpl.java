package semicolon.africa.ewaApplication.services;

import semicolon.africa.ewaApplication.data.models.Customer;
import semicolon.africa.ewaApplication.data.repositories.CustomerRepository;
import semicolon.africa.ewaApplication.data.repositories.CustomerRepositoryImpl;
import semicolon.africa.ewaApplication.dtos.requests.CustomerRequest;
import semicolon.africa.ewaApplication.dtos.responses.CustomerResponse;
import semicolon.africa.ewaApplication.exceptions.DuplicatedCustomerException;
import semicolon.africa.ewaApplication.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private final static CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
        Optional<Customer> addCustomerToDatabase = customerRepository.findCustomerByEmail(customerRequest.getEmail());
        if(addCustomerToDatabase.isPresent()) throw new DuplicatedCustomerException(customerRequest.getEmail() + "already exists");
        Customer customer = ModelMapper.map(customerRequest);

        Customer savedCustomer = customerRepository.save(customer);
        return ModelMapper.map(savedCustomer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerByEmail(String email) {
        customerRepository.deleteByEmail(email);

    }

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAll();

    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
}
