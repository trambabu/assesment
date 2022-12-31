package com.json.file.process.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This file is POJO / Model for province or state field information
 * 
 * @author USER
 *
 * * lombok library has been used to generate dynamically for getters and setters and constructor of the POJO 
 * using with @Data annotation
 */
@Data
@JsonPropertyOrder({"code", "name" })
public class ProvinceOrState {

	private String code;
	private String name;
}
