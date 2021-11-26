package semicolon.africa.ewaApplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.ewaApplication.data.models.BeansOrder;
import semicolon.africa.ewaApplication.dtos.requests.BeansOrderRequest;
import semicolon.africa.ewaApplication.dtos.responses.BeansOrderResponse;
import semicolon.africa.ewaApplication.exceptions.CustomerDoesNotExistException;
import semicolon.africa.ewaApplication.services.BeansOrderService;
import semicolon.africa.ewaApplication.services.BeansOrderServiceImpl;

import java.util.Optional;

    @RestController
    public class BeansOrderController {

        private final BeansOrderService beansOrderService = new BeansOrderServiceImpl();
        @PostMapping("/api/addOrder")
        public ResponseEntity<?> addBeansOrder(@RequestBody BeansOrderRequest beansOrderRequest){

            try {
                BeansOrderResponse response = beansOrderService.addBeansOrder(beansOrderRequest);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (CustomerDoesNotExistException ex){
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/api/order/{id}")
        public Optional<BeansOrder> findByOrderId(@PathVariable("id")Integer id){
            return beansOrderService.findBeansOrderById(id);
        }
    }

