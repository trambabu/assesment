package com.example.demo.processor;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.example.demo.dto.Addresses;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateAddress {

	public void validateAddress() {
		final ObjectMapper objectMapper = new ObjectMapper();
		List<Addresses> langList = null;
		try {
			langList = objectMapper.readValue(
			        new File("addresses.json"), 
			        new TypeReference<List<Addresses>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		langList.forEach(x -> System.out.println(x.toString()));
				
		for (Iterator iterator = langList.iterator(); iterator.hasNext();) {
			Addresses addresses = (Addresses) iterator.next();
			if(addresses.getId()!=null) {
				int postalCode = Integer.parseInt(addresses.getPostalCode().toString());
				if(postalCode >0) {
					if((addresses.getAddressLineDetail()!=null)&&((addresses.getAddressLineDetail().getLine1()!=null)||(addresses.getAddressLineDetail().getLine2()!=null))) {
						System.out.println("ADDRESS IS PERFECT");
						System.out.println(addresses.toString());
					}else {
						System.out.println("ADDRESS IS NOT PERFECT DUE to ADDRESS LINES ARE MISSING");
						System.out.println(addresses.toString());
					}
				}
			}
			
		}
	}
}
