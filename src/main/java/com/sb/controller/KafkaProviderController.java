package com.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.entities.Customer;

@RestController
@RequestMapping("/kafka")
public class KafkaProviderController 
{
	/*@Autowired
	KafkaTemplate<String,Customer> kafkaTemplate;
	private static final String TOPIC="kafka";*/
	@Autowired
	KafkaTemplate<String,String> kafkaTemplateOne;
	private static final String TOPIC="kafka_string";
	@PostMapping("/publish")
	public String publishCustomerInfo(@RequestBody Customer customer)
	{
		//kafkaTemplate.send(TOPIC, customer);
		return "Customer published  successfully";
	}
   @GetMapping("/publish-string/{message}")
	public String sayHello(@PathVariable("message") String message)
	{
	   kafkaTemplateOne.send(TOPIC, message);
		return "published string successfully";
	}
}
