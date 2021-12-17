package com.datamigration.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datamigration.domain.Person;

@Configuration
public class MigratePersonStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step migratePersonStep(
			ItemReader<Person> readerPersonFile,
			ClassifierCompositeItemWriter<Person> classifierPersonWriter,
			FlatFileItemWriter<Person> personFileWriteInvalid) {
		return stepBuilderFactory
				.get("migratePersonStep")
				.<Person, Person>chunk(10000)
				.reader(readerPersonFile)
				.writer(classifierPersonWriter)
				.stream(personFileWriteInvalid)
				.build();
	}
	
}
