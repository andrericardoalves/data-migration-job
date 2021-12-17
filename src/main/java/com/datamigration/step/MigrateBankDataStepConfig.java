package com.datamigration.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datamigration.domain.BankData;

@Configuration
public class MigrateBankDataStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step migrateBankDataStep(
			ItemReader<BankData> bankDataReaderFile,
			ItemWriter<BankData> databaseBankDateWriter) {
		return stepBuilderFactory
				.get("migrateBankDataStep")
				.<BankData, BankData>chunk(10000)
				.reader(bankDataReaderFile)
				.writer(databaseBankDateWriter)
				.build();
	}
}
