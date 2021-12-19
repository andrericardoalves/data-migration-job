package com.datamigration.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankData {

	private Integer id;
	private Integer personId;
	private Integer agency;
	private Integer account;
	private Integer bank;
	
}
