package org.example;

import org.springframework.stereotype.Component;

@Component
public class B {
    A a;
//    B(A a){
//        this.a=a;
//    }

    public void setA(A a){
        this.a=a;
    }
}
