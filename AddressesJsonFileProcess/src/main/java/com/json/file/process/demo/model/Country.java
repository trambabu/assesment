package com.json.file.process.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * This pojo / model for Country field for Addresses
 * 
 * @author USER
 * lombok library has been used to generate dynamically for getters and setters and constructor of the POJO 
 * using with @Data annotation
 */
@Data
@JsonPropertyOrder({"code", "name"  })
public class Country {

	private String code;
	private String name;
}
