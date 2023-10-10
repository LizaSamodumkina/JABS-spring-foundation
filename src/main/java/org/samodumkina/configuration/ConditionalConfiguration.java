package org.samodumkina.configuration;

import javax.sql.DataSource;
import org.samodumkina.dao.CustomDataSource;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ConditionalConfiguration {

  @Bean
  @ConditionalOnMissingBean(value = CustomDataSource.class)
  public DataSource dataSource() {
    var dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.h2.Driver");
    dataSourceBuilder.url("jdbc:h2:mem:task2");
    dataSourceBuilder.username("task2");
    dataSourceBuilder.password("");
    return dataSourceBuilder.build();
  }
}
