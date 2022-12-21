package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@JsonPropertyOrder({"code", "name" })
public class Type {

	private String code;
	private String name;
}
