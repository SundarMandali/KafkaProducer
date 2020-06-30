package com.sundar.kafkaproducerexample.UserResourceController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sundar.kafkaproducerexample.UserData.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("kafka")
public class UserResourceController {
	@Autowired
	KafkaTemplate<String,UserData> kafkaTemplate;
	
	private static final String topic="kafkajsonn";
	//@GetMapping("/publish/{name}")
	//public String post(@PathVariable("name") final String name) {
		
//		kafkaTemplate.send(topic,new UserData(name,"CSE",10000L));
	//	return "Published successfully";
		
	//}
	@PostMapping("/publish/json")
	public String post(@RequestBody UserData userData)
	{
		kafkaTemplate.send(topic,userData);
		return "Published successfully";
		
		
	}
	
	

}
