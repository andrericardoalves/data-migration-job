package com.datamigration.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@EnableBatchProcessing
@Configuration
public class DataMigrationJobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job dataMigrationJob(
			@Qualifier("migratePersonStep")  Step migratePersonStep,
			@Qualifier("migrateBankDataStep") Step migrateBankDataStep) {
		return jobBuilderFactory
				.get("dataMigrationJob")
				.start(parallelSteps(migratePersonStep, migrateBankDataStep))
				.end()
				.incrementer(new RunIdIncrementer())
				.build();
	}

	private Flow parallelSteps(Step migratePersonStep, Step migrateBankDataStep) {
		Flow migrateBankDataFlow = new FlowBuilder<Flow>("migrateBankDataFlow")
				.start(migrateBankDataStep)
				.build();
		
		Flow parallelSteps = new FlowBuilder<Flow>("parallelStepsFlow")
				.start(migratePersonStep)
				.split(new SimpleAsyncTaskExecutor())
				.add(migrateBankDataFlow)
				.build();
		
		return parallelSteps;
	}
}
