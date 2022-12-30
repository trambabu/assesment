package com.json.file.process.demo;

import java.io.File;
import java.io.IOException;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.json.file.process.demo.processor.ValidationUtils;

/**
 * This file is ment to execute the json file against json schema
 * 
 * addresses.json  --> Address information
 * addresses_schema_1.json   --> Schema file which contains the Schema rules
 * 
 *  This is failing for some reason and reaching desire requirement
 *  
 * @author USER
 *
 */
public class ValidateJsonFileAgainstSchemaFile {

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
