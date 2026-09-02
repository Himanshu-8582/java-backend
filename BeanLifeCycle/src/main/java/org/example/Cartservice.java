package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// InitializingComponent
@Component
public class Cartservice {
    Map<Integer,String> mp;

    public Cartservice(){
        mp=new HashMap<>();
        System.out.println("CartService constructor called");
    }

    @PostConstruct
    public void start(){
        System.out.println("Bean is ready");
        mp.put(1,"Aditya");
        mp.put(2,"Rohit");
    }

    public void addToCart(){
        System.out.println("Added to cart");
    }

    public String getValue(int key){
        return mp.get(key);
    }

}
