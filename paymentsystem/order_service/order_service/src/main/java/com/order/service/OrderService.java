package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.common.Payment;
import com.order.common.TxnRequest;
import com.order.common.TxnResponse;
import com.order.entity.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String ENDPINT_URL;
	
	public TxnResponse saveOrder(TxnRequest txnRequest) {
		String message=""; 
		Order order=txnRequest.getOrder(); //TxnRequest declaration
		
		Payment payment=txnRequest.getPayment(); //TxnRequest declaration
		
		payment.setOrderId(order.getId()); // set payment orderId from order Id
		payment.setOrderPrice(order.getPrice()); // set payment orderAmount from order order price
		
		//rest call to payment
		Payment payResponse = restTemplate.postForObject(ENDPOINT_URL, payment, Payment.class);
		message = payResponse.getPaymentStatus().equals("success") ? "payment processing successfull" : "payment processing error";
		repository.save(order);	
		return new TxnResponse(order, payResponse.getOrderPrice(), payResponse.getTxnId(), message);
	}
	
}
