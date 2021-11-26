package semicolon.africa.ewaApplication.data.repositories;

import semicolon.africa.ewaApplication.data.models.BeansOrder;

import java.util.List;
import java.util.Optional;

public interface BeansOrderRepository {
    BeansOrder save(BeansOrder beansOrder);
    Optional<BeansOrder> findBeansOrderById(Integer beansOrderId);
    List<BeansOrder> findAllBeansOrders();
    void deleteBeansOrderById(Integer beansOrderId);
    void delete( BeansOrder beansOrder);
    void deleteAll();
}
