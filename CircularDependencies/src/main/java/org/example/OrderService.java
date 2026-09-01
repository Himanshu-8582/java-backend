package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    // Its solution is field injection, ie. Autowire
    @Autowired
    private PaymentService paymentService;
    // Problem
//    public  OrderService(PaymentService paymentService){
//        this.paymentService=paymentService;
//    }

    public void placeOrder(){
        paymentService.pay();
        getOrderDetails();
        System.out.println("Order placed");
    }

    public void getOrderDetails(){
        System.out.println("Order Details");
    }
}
