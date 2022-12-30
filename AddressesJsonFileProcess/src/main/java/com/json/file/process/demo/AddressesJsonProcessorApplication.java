package com.json.file.process.demo;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.file.process.demo.model.Addresses;
import com.json.file.process.demo.processor.AddressDataProcessor;
import com.json.file.process.demo.processor.ValidateAddress;

/**
 * This is main file to execute which can process the Addresses.json file data
 *  from the requirement questionnaire the following 3 questions were answered
 * 
 *  1. PrettyPrint
 *  2. CertainTypeaddress
 *  3. ValidateAddresses
 *  
 * @author USER
 *
 */
@SpringBootApplication
public class AddressesJsonProcessorApplication {


	public static void main(String[] args) {
		SpringApplication.run(AddressesJsonProcessorApplication.class, args);
		
		AddressDataProcessor obj = new AddressDataProcessor();
		obj.prettyPrint();
		obj.certainTypeAddress();
//		obj.jsonNodesPrint();
		
		obj.jsonNodesFieldesPrint();
		ValidateAddress validate = new ValidateAddress();
		validate.validateAddress();
	
	}
}
