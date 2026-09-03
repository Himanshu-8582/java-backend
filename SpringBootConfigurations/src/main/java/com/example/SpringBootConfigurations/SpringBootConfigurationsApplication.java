package com.example.SpringBootConfigurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootConfigurationsApplication {

	public static void main(String[] args) {
//		ApplicationContext context=SpringApplication.run(SpringBootConfigurationsApplication.class, args);
//		PaymentGateway paymentGateway=context.getBean(PaymentGateway.class);
//		paymentGateway.setRetry_count(5);
//		paymentGateway.setType("Razorpay");

//		System.out.println(paymentGateway.getType());
//		System.out.println(paymentGateway.getRetry_count());
//		System.out.println(paymentGateway.getRetryCount());
//		System.out.println(paymentGateway.isEnabled());
//		System.out.println(paymentGateway.getTimeOut());


		// We can also directly use
//		paymentGateway.print();

		// Without creating IOC Object ie context
		SpringApplication.run(SpringBootConfigurationsApplication.class, args);
	}

}
