package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")     // Creates 4 objs individual for everyone
@Scope("singleton")     // Creates only 1 obj and everyone shares it
public class OrderService {

    OrderService(){
        System.out.println("Order service created");
    }
    public void placeOrder(){
        System.out.println("Order Placed");
    }
}
