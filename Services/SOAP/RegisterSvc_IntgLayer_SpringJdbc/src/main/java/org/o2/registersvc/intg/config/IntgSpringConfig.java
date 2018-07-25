package org.o2.registersvc.intg.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "org.o2.registersvc.intg.impl")
@ImportResource
public class IntgSpringConfig {
	static Logger logger = Logger.getLogger(IntgSpringConfig.class);

	@Bean
	public DriverManagerDataSource dataSource() {
		logger.debug("Enter into data source");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/autop");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	public JdbcTemplate getTemplate() {
		logger.debug("Enter into the JdbcTemplate");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		logger.debug("In bean getTemplate:: " + jdbcTemplate);
		return jdbcTemplate;
	}
}
