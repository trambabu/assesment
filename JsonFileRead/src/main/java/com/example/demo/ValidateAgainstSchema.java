package com.example.demo;

import java.io.File;
import java.io.IOException;

import com.example.demo.processor.ValidationUtils;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;

public class ValidateAgainstSchema {

	public static void main( String[] args ) throws IOException, ProcessingException
	{
	    File schemaFile = new File("addresses_schema_1.json");
	    File jsonFile = new File("addresses.json");
	    	
	    if (ValidationUtils.isJsonValid(schemaFile, jsonFile)){
	    	System.out.println("Valid!");
	    }else{
	    	System.out.println("NOT valid!");
	    }
	}

}
