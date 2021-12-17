package com.datamigration.reader;

import java.util.Date;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import com.datamigration.domain.Person;

@Configuration
public class PersonFileReaderConfig {
	@Bean
	public FlatFileItemReader<Person> arquivoPessoaReader() {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personFileReader")
				.resource(new FileSystemResource("files/people.csv"))
				.delimited()
				.names("name", "email", "birthday", "age", "id")
				.addComment("--")
				.fieldSetMapper(fieldSetMapper())
				.build();
	}

	private FieldSetMapper<Person> fieldSetMapper() {
		return new FieldSetMapper<Person>() {

			@Override
			public Person mapFieldSet(FieldSet fieldSet) throws BindException {
				Person pessoa = new Person();
				pessoa.setName(fieldSet.readString("name"));
				pessoa.setEmail(fieldSet.readString("email"));
				pessoa.setBirthday(new Date(fieldSet.readDate("birthday", "yyyy-MM-dd HH:mm:ss").getTime()));
				pessoa.setAge(fieldSet.readInt("age"));
				pessoa.setId(fieldSet.readInt("id"));
				return pessoa;
			}
		};
	}

}
