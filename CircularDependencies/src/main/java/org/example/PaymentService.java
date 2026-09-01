package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    // But we can also solve this by not using circular dependencies, by SRP , By running getOrderDetails() in order class
    // Its solution is field injection, ie. Autowire
//    @Autowired
//    OrderService orderService;

//    Problem
//    public PaymentService(OrderService orderService){
//        this.orderService=orderService;
//    }

    public void pay() {
        System.out.println("Payment Done");
//        orderService.getOrderDetails();
    }
}
