package com.datamigration.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

	private Integer id;
	private String name;
	private String email;
	private Date birthday;
	private Integer age;
	
}
