package semicolon.africa.ewaApplication.services;

import semicolon.africa.ewaApplication.data.models.BeansOrder;
import semicolon.africa.ewaApplication.data.models.Customer;
import semicolon.africa.ewaApplication.data.repositories.BeansOrderRepository;
import semicolon.africa.ewaApplication.data.repositories.BeansOrderRepositoryImpl;
import semicolon.africa.ewaApplication.dtos.requests.BeansOrderRequest;
import semicolon.africa.ewaApplication.dtos.responses.BeansOrderResponse;
import semicolon.africa.ewaApplication.exceptions.CustomerDoesNotExistException;
import semicolon.africa.ewaApplication.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class BeansOrderServiceImpl implements BeansOrderService{
    private final static BeansOrderRepository beansOrderRepository = new BeansOrderRepositoryImpl();
    private final CustomerService customerService = new CustomerServiceImpl();


    @Override
    public BeansOrderResponse addBeansOrder(BeansOrderRequest beansOrderRequest) {
        Optional<Customer> optionalCustomer = customerService.findCustomerByEmail(beansOrderRequest.getCustomerEmail());
        if(optionalCustomer.isPresent()) throw new CustomerDoesNotExistException("This customer does not exist");
        BeansOrder beansOrder = ModelMapper.map(beansOrderRequest);

        BeansOrder savedBeansOrder = beansOrderRepository.save(beansOrder);
        return ModelMapper.map(savedBeansOrder);
    }

    @Override
    public Optional<BeansOrder> findBeansOrderById(Integer beansOrderId) {
        return beansOrderRepository.findBeansOrderById(beansOrderId);
    }

    @Override
    public List<BeansOrder> getAllBeansOrders() {
        return beansOrderRepository.findAllBeansOrders();
    }
}
