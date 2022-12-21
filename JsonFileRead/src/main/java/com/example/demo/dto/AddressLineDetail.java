package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@JsonPropertyOrder({"line1", "line2" })
public class AddressLineDetail {

	private String line1;
	private String line2;
}
