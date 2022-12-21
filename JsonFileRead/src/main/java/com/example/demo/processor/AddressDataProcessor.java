package com.example.demo.processor;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.example.demo.dto.Addresses;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

public class AddressDataProcessor {

	public List<Addresses>  processAddresInfo() {
		
		List<Addresses> addresses = null;
		try {
			// create object mapper instance
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			// convert JSON array to list of addresses
			 addresses = Arrays.asList(mapper.readValue(Paths.get("addresses.json").toFile(), Addresses[].class));
//			addresses.forEach(System.out::println);
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}return addresses;
	}
	
	/**
	 * Print pretty Json Address String
	 * @param prettyJson
	 */
	public void prettyPrint() {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		List<Addresses> addresses =  processAddresInfo();
		String prettyJson = null;
		try {
			prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addresses);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(prettyJson.toString());
		
	}
	
	public void certainTypeAddress() {
		List<Addresses> addresses =  processAddresInfo();
		
		for (Iterator iterator = addresses.iterator(); iterator.hasNext();) {
			Addresses address = (Addresses) iterator.next();
			if(address.getType().getName().contains("Physical")) {
				System.out.println("Contain physical address");
				certainType( address,  "Physical");
			}else if(address.getType().getName().contains("Postal")) {
				System.out.println("Contain Postal address");
				certainType( address,  "Postal");
			}else if(address.getType().getName().contains("Business")) {
				System.out.println("Contain Business address");
				certainType( address,  "Business");
			}else
				{
					System.out.println("Contain Unknown address");
					certainType( address,  "Physical");
				}
			
		}
	}
	/**
	 * Print specific address of Type Like Physical, Postal, Business address
	 * @param address
	 * @param addressType
	 */
	private void certainType(Addresses address, String addressType) {
		
		System.out.println("AddressDataProcessor.certainType()-->"+addressType);
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		switch (addressType) {
		case "Physical":
			try {
				String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
				System.out.println(prettyJson);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(addressType.toString());
			break;
		case "Postal":
			try {
				String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
				System.out.println(prettyJson);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Business":
			try {
				String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
				System.out.println(prettyJson);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
            // Print statement corresponding case
            System.out.println("no match found");
            try {
				String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
				System.out.println(prettyJson);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
// *************************
public void jsonNodesPrint() {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		List<Addresses> addresses =  processAddresInfo();
		String prettyJson = null;
		try {
			prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addresses);
			 getKeysInJsonUsingJsonNodeFieldNames(prettyJson,  mapper);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(prettyJson.toString());
		
	}
	public List<String> getKeysInJsonUsingJsonNodeFieldNames(String json, ObjectMapper mapper) throws JsonMappingException, JsonProcessingException {

	    List<String> keys = new ArrayList<>();
	    JsonNode jsonNode = mapper.readTree(json);
	    Iterator<String> iterator = jsonNode.fieldNames();
	    iterator.forEachRemaining(e -> keys.add(e));
	    keys.forEach(System.out::println);
	    return keys;
	}
	
	public void jsonNodesFieldesPrint() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		List<Addresses> addresses =  processAddresInfo();
		String prettyJson = null;
		try {
			prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addresses);
//			getAllKeysInJsonUsingJsonNodeFieldsNames(prettyJson,  mapper);
			printnln(prettyJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<String> getAllKeysInJsonUsingJsonNodeFields(String json, ObjectMapper mapper) throws JsonMappingException, JsonProcessingException {

	    List<String> keys = new ArrayList<>();
	    JsonNode jsonNode = mapper.readTree(json);
	    getAllKeysUsingJsonNodeFields(jsonNode, keys);
	    return keys;
	}
	
	public List<String> getAllKeysInJsonUsingJsonNodeFieldsNames(String json, ObjectMapper mapper) throws JsonMappingException, JsonProcessingException {

	    List<String> keys = new ArrayList<>();
	    JsonNode jsonNode = mapper.readTree(json);
	    getAllKeysUsingJsonNodeFieldNames(jsonNode, keys);
	    return keys;
	}

	private void getAllKeysUsingJsonNodeFields(JsonNode jsonNode, List<String> keys) {
System.out.println("AddressDataProcessor.getAllKeysUsingJsonNodeFields()");
	    if (jsonNode.isObject()) {
	        Iterator<Entry<String, JsonNode>> fields = jsonNode.fields();
	        fields.forEachRemaining(field -> {
	            keys.add(field.getKey());
//	            System.out.println(field.getKey()+""+field.getValue());
	            getAllKeysUsingJsonNodeFieldNames((JsonNode) field.getValue(), keys);
	        });
	    } else if (jsonNode.isArray()) {
	        ArrayNode arrayField = (ArrayNode) jsonNode;
	        arrayField.forEach(node -> {
	        	 System.out.println("Array found"+node.asText());
	            getAllKeysUsingJsonNodeFieldNames(node, keys);
	        });
	    }
	}
	
	 private void getAllKeysUsingJsonNodeFieldNames(JsonNode jsonNode, List<String> keys) {
//System.out.println("AddressDataProcessor.getAllKeysUsingJsonNodeFieldNames() ******");
	        if (jsonNode.isObject()) {
	            Iterator<String> fieldNames = jsonNode.fieldNames();
	            fieldNames.forEachRemaining(fieldName -> {
	                keys.add(fieldName);
	                System.out.println("__"+jsonNode.get(fieldName).toPrettyString()+"<<keys.size()>>"+keys.size());
	                getAllKeysUsingJsonNodeFieldNames(jsonNode.get(fieldName), keys);
	            });
	        } else if (jsonNode.isArray()) {
	            ArrayNode arrayField = (ArrayNode) jsonNode;
	            arrayField.forEach(node -> {
//	            	System.out.println("--"+node.asText());
	                getAllKeysUsingJsonNodeFieldNames(node, keys);
	            });
	        }

	    }

	 public List<String> getKeysInJsonUsingJsonParser(String json) throws JsonParseException, IOException {

		    List<String> keys = new ArrayList<>();
		    JsonFactory factory = new JsonFactory();
		    JsonParser jsonParser = factory.createParser(json);
		    while (!jsonParser.isClosed()) {
		        if (jsonParser.nextToken() == JsonToken.FIELD_NAME) {
		            keys.add((jsonParser.getCurrentName()));
		        }
		    }
		    return keys;
		}
	public void printnln(String json) {
		try {
			List<String>keys = getKeysInJsonUsingJsonParser(json);
			keys.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public void validateJsonDocument(String definition, String payload){
//	 	JSONObject jsonSchema = new JSONObject(definition);
//	    JSONObject jsonData = new JSONObject(payload);
//	    
//	    Schema schema = SchemaLoader.load(jsonSchema);
//	    schema.validate(jsonData);
//	}
	
	
}
