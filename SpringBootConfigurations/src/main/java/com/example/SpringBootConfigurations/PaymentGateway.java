package com.example.SpringBootConfigurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    // We can also use this and also pass default value directly
//    @Value("${paymentGateway.type}")
//    private String type;
//
//    @Value("${paymentGateway.retryCount:7}")
//    private int retryCount;
//
////    public PaymentGateway(@Value("${paymentGateway.type}") String type, @Value("${paymentGateway.retryCount}") int retryCount) {
////        this.type = type;
////        this.retryCount = retryCount;
////    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetry_count() {
//        return retryCount;
//    }
//
//    public void setRetry_count(int retry_count) {
//        this.retryCount = retry_count;
//    }


    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }

    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }

    public boolean isEnabled() {
        return paymentProperties.isEnabled();
    }
    public int getTimeOut() {
        return paymentProperties.getTimeOut();
    }

    public void print(){
        System.out.println(paymentProperties.getType());
        System.out.println(paymentProperties.getRetryCount());
        System.out.println(paymentProperties.isEnabled());
        System.out.println(paymentProperties.getTimeOut());
    }

}
