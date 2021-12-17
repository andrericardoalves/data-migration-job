package com.datamigration.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private Integer id;
	private String name;
	private String email;
	private Date birthday;
	private Integer age;
	
}
