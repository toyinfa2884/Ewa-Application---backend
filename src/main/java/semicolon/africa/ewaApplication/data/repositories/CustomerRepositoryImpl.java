package semicolon.africa.ewaApplication.data.repositories;

import semicolon.africa.ewaApplication.data.models.Customer;

import java.util.*;

public class CustomerRepositoryImpl implements CustomerRepository{
    Map<String, Customer> database = new HashMap<>();
    @Override
    public Customer save(Customer customer) {
        database.put(customer.getEmail(), customer);
        return database.get(customer);
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {
        if(database.containsKey(email)) return Optional.of(database.get(email));
        return Optional.empty();
    }

    @Override
    public void deleteByEmail(String email) {
        database.remove(email);

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> all = new ArrayList<>();
        Set<String> keys = database.keySet();
        for(String key : keys){
            all.add(database.get(key));
        }
        return all;
    }

    @Override
    public void deleteAll() {
        database.clear();

    }
}
