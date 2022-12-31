package com.json.file.process.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This is pojo / model file for AddressLineDetail for Addresses
 * 
 * @author USER
 * lombok library has been used to generate dynamically for getters and setters and constructor of the POJO 
 * using with @Data annotation
 */
@Data
@JsonPropertyOrder({"line1", "line2" })
public class AddressLineDetail {

	private String line1;
	private String line2;
}
