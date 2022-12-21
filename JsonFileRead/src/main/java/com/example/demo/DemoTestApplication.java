package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dto.Addresses;
import com.example.demo.processor.AddressDataProcessor;
import com.example.demo.processor.ValidateAddress;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootApplication
public class DemoTestApplication {

//	https://stackabuse.com/converting-json-array-to-a-java-array-or-list/
	public static void main(String[] args) {
		SpringApplication.run(DemoTestApplication.class, args);
		
		AddressDataProcessor obj = new AddressDataProcessor();
		obj.prettyPrint();
		obj.certainTypeAddress();
//		obj.jsonNodesPrint();
		
		obj.jsonNodesFieldesPrint();
		ValidateAddress validate = new ValidateAddress();
		validate.validateAddress();
	
	}
}
