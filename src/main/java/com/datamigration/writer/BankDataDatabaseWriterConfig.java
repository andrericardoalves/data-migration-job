package com.datamigration.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datamigration.domain.BankData;

@Configuration
public class BankDataDatabaseWriterConfig {

	@Bean
	public JdbcBatchItemWriter<BankData> bankDataDatabaseWriter(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<BankData>()
				.dataSource(dataSource)
				.sql("INSERT INTO bank_data (id, person_id, agency, account, bank) VALUES (:id, :personId, :agency, :account, :bank)")
				.beanMapped()
				.build();
	}
}
