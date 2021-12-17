package com.datamigration.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankData {

	private Integer id;
	private Integer personId;
	private Integer agency;
	private Integer account;
	private Integer bank;
	
}
