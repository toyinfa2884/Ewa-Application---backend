package semicolon.africa.ewaApplication.services;

import semicolon.africa.ewaApplication.data.models.BeansOrder;
import semicolon.africa.ewaApplication.dtos.requests.BeansOrderRequest;
import semicolon.africa.ewaApplication.dtos.responses.BeansOrderResponse;

import java.util.List;
import java.util.Optional;

public interface BeansOrderService {
    BeansOrderResponse addBeansOrder(BeansOrderRequest beansOrderRequest);
    Optional<BeansOrder>findBeansOrderById(Integer beansOrderId);
    List<BeansOrder> getAllBeansOrders();
}
