package com.microservic.springbootconfig.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservic.springbootconfig.configuration.UserConfiguration;

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

	@Autowired
	private UserConfiguration userConfig;

	@GetMapping("/greeting")
	public String greeting() {
		return new StringBuilder(userConfig.getFirstName()).append(" ")
				.append(userConfig.getLastName()).append(" ")
				.append(userConfig.getAge()).toString();
	}
}
