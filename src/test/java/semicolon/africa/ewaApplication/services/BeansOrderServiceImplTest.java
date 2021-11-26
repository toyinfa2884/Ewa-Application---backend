package semicolon.africa.ewaApplication.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.ewaApplication.data.models.BeansOrder;
import semicolon.africa.ewaApplication.dtos.requests.BeansOrderRequest;
import semicolon.africa.ewaApplication.dtos.responses.BeansOrderResponse;

import static org.junit.jupiter.api.Assertions.*;

class BeansOrderServiceImplTest {
    BeansOrderService beansOrderService;

    @BeforeEach
    void setUp() {
        beansOrderService = new BeansOrderServiceImpl();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void addBeansOrder() {
        BeansOrderRequest beansOrderRequest = new BeansOrderRequest();

        beansOrderRequest.setCustomerEmail("chibob@gamil.com");
        beansOrderRequest.setDeliveryAddress("Mushin");
        beansOrderRequest.setReceiverName("John");
        beansOrderRequest.setReceiversPhone("090567843");

        BeansOrderResponse response = beansOrderService.addBeansOrder(beansOrderRequest);
        assertEquals(1, beansOrderService.getAllBeansOrders().size());
    }



    @Test
    void findBeansOrderById() {
        BeansOrderRequest beansOrderRequest = new BeansOrderRequest();

        beansOrderRequest.setCustomerEmail("chibob@gamil.com");
        beansOrderRequest.setDeliveryAddress("Mushin");
        beansOrderRequest.setReceiverName("John");
        beansOrderRequest.setReceiversPhone("090567843");

        beansOrderService.addBeansOrder(beansOrderRequest);
        assertNotNull(beansOrderService.findBeansOrderById(1));
    }

    @Test
    void getAllBeansOrders() {

        BeansOrderRequest beansOrderRequest = new BeansOrderRequest();

        beansOrderRequest.setCustomerEmail("chibob@gamil.com");
        beansOrderRequest.setDeliveryAddress("Mushin");
        beansOrderRequest.setReceiverName("John");
        beansOrderRequest.setReceiversPhone("090567843");

        beansOrderService.addBeansOrder(beansOrderRequest);
        assertEquals(1, beansOrderService.getAllBeansOrders().size());
    }
}