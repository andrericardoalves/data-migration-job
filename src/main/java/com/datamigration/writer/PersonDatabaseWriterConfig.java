package com.datamigration.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datamigration.domain.Person;

@Configuration
public class PersonDatabaseWriterConfig {

	@Bean
	public JdbcBatchItemWriter<Person> bancoPessoaWriter(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Person>()
				.dataSource(dataSource)
				.sql("INSERT INTO person (id, name, email, birthday, age) VALUES (?, ?, ?, ?, ?)")
				.itemPreparedStatementSetter(itemPreparedStatementSetter())
				.build();
	}

	private ItemPreparedStatementSetter<Person> itemPreparedStatementSetter() {
		return new ItemPreparedStatementSetter<Person>() {

			@Override
			public void setValues(Person person, PreparedStatement ps) throws SQLException {
				ps.setInt(1, person.getId());
				ps.setString(2, person.getName());
				ps.setString(3, person.getEmail());
				ps.setDate(4, new Date(person.getBirthday().getTime()));
				ps.setInt(5, person.getAge());
			}
			
		};
	}
}
