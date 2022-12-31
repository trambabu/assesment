package com.json.file.process.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;



/**
 * This is main Model / POJO to json data
 * 
 * This is model file hold all Address.json field objects 
 * 
 * @author USER
 * lombok library has been used to generate dynamically for getters and setters and constructor of the POJO 
 * using with @Data annotation
 */
//@JsonInclude(Include.NON_NULL)
//@JsonInclude(Include.NON_EMPTY)
@Data
@JsonPropertyOrder({"id", "type","addressLineDetail", "provinceOrState", "cityOrTown", "country", "postalCode", "suburbOrDistrict", "lastUpdated"  })
public class Addresses {

		private String id;
		private Type type;
		private AddressLineDetail addressLineDetail;
		private ProvinceOrState provinceOrState;
		private String cityOrTown;
		private Country country;
		private String postalCode;
		private String suburbOrDistrict;
//		@JsonIgnore
		private String lastUpdated;
}
