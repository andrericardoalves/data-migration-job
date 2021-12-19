package com.datamigration.domain;

import java.util.Date;

import org.apache.logging.log4j.util.Strings;

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
	
	
	public boolean isValid() {
		return !Strings.isBlank(name) && !Strings.isBlank(email) && birthday != null;
	}
}
