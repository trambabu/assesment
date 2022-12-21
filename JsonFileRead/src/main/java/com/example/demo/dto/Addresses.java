package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;


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
