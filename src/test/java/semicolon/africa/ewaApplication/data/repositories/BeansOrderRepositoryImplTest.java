package semicolon.africa.ewaApplication.data.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.ewaApplication.data.models.BeansOrder;

import static org.junit.jupiter.api.Assertions.*;

class BeansOrderRepositoryImplTest {
    BeansOrderRepository beansOrderRepository;

    @BeforeEach
    void setUp() {
        beansOrderRepository = new BeansOrderRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        beansOrderRepository.deleteAll();
    }

    @Test
    void save() {
        BeansOrder  beansOrder = new BeansOrder();
        beansOrder.setId(beansOrder.getId());
        beansOrder.setCustomerEmail("chibob@gmail.com");
        beansOrder.setDeliveryAddress("Mushin");
        beansOrder.setReceiverName("Jerry");
        beansOrder.setReceiversPhone("090357658");
        BeansOrder savedBeansOrder = beansOrderRepository.save(beansOrder);

        assertEquals(savedBeansOrder, beansOrderRepository.save(savedBeansOrder));
    }

    private BeansOrder orderInformation(){
        BeansOrder  beansOrder = new BeansOrder();
        beansOrder.setId(beansOrder.getId());
        beansOrder.setCustomerEmail("chibob@gmail.com");
        beansOrder.setDeliveryAddress("Mushin");
        beansOrder.setReceiverName("Jerry");
        beansOrder.setReceiversPhone("090357658");

        return beansOrderRepository.save(beansOrder);

    }

    @Test
    void findBeansOrderById() {
        BeansOrder savedBeansOrder = orderInformation();
        assertEquals(savedBeansOrder, beansOrderRepository.findBeansOrderById(savedBeansOrder.getId()).get());
    }

    @Test
    void findAllBeansOrders() {
        orderInformation();
        orderInformation();
        assertEquals(2, beansOrderRepository.findAllBeansOrders().size());
    }

    @Test
    void deleteBeansOrderById() {
        BeansOrder savedBeansOrder = orderInformation();
        beansOrderRepository.deleteBeansOrderById(savedBeansOrder.getId());
        assertEquals(0, beansOrderRepository.findAllBeansOrders().size());
    }

    @Test
    void delete() {
        BeansOrder savedBeansOrder = orderInformation();
        beansOrderRepository.delete(savedBeansOrder);
        assertEquals(0, beansOrderRepository.findAllBeansOrders().size());
    }

    @Test
    void deleteAll() {
        orderInformation();
        orderInformation();
        orderInformation();

        beansOrderRepository.deleteAll();
        assertEquals(0,beansOrderRepository.findAllBeansOrders().size());


    }
}