package com.datamigration.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.datamigration.domain.BankData;

@Configuration
public class BankDataFileReaderConfig {

	@Bean
	public FlatFileItemReader<BankData> dadosBancariosReader() {
		return new FlatFileItemReaderBuilder<BankData>()
				.name("bankDataReader")
				.resource(new FileSystemResource("files/bank_data.csv"))
				.delimited()
				.names("personId", "agency", "account", "bank", "id")
				.addComment("--")
				.targetType(BankData.class)
				.build();
	}
}
