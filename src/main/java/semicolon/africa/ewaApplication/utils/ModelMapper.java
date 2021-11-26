package semicolon.africa.ewaApplication.utils;

import semicolon.africa.ewaApplication.data.models.BeansOrder;
import semicolon.africa.ewaApplication.data.models.Customer;
import semicolon.africa.ewaApplication.dtos.requests.BeansOrderRequest;
import semicolon.africa.ewaApplication.dtos.requests.CustomerRequest;
import semicolon.africa.ewaApplication.dtos.responses.BeansOrderResponse;
import semicolon.africa.ewaApplication.dtos.responses.CustomerResponse;

public class ModelMapper {
    public static Customer map(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setEmail(customerRequest.getEmail());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setPassword(customerRequest.getPassword());
        customer.setUserName(customerRequest.getUserName());
        return customer;
    }

    public static CustomerResponse map(Customer customer){
        CustomerResponse response = new CustomerResponse();
        response.setEmail(customer.getEmail());
        response.setUserName(customer.getUserName());
        return response;
    }

    public static BeansOrder map(BeansOrderRequest beansOrderRequest){
        BeansOrder beansOrder = new BeansOrder();
        beansOrder.setReceiversPhone(beansOrderRequest.getReceiversPhone());
        beansOrder.setReceiverName(beansOrderRequest.getReceiverName());
        beansOrder.setDeliveryAddress(beansOrderRequest.getDeliveryAddress());
        beansOrder.setCustomerEmail(beansOrderRequest.getCustomerEmail());
        return beansOrder;
    }

    public static BeansOrderResponse map(BeansOrder beansOrder){
        BeansOrderResponse response = new BeansOrderResponse();
        response.setDeliveryAddress(beansOrder.getDeliveryAddress());
        response.setReceiversPhone(beansOrder.getReceiversPhone());
        response.setTrackingId(beansOrder.getId());
        return response;
    }
}
