package com.microservic.springbootconfig.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value("${my.greeting: default value}")
	private String greetingMessage;

	@Value("This is a static value")
	private String someStaticValue;

	@Value("${my.list.greeting}")
	private List<String> myList;

	@Value("#{${my.details}}")
	private Map<String, String> myDetails;

	@GetMapping("/greeting")
	public String greeting() {
		return new StringBuilder(greetingMessage)
				.append(" ").append(someStaticValue)
				.append("").append(myList)
				.append(" ").append(myDetails.get("lastname"))
				.append(",").append(myDetails.get("firstname"))
				.toString();
	}
}
