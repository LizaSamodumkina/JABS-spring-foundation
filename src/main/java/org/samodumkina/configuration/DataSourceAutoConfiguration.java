package org.samodumkina.configuration;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@AutoConfiguration
@Profile("default")
public class DataSourceAutoConfiguration {

  @Bean
  public DataSource getDataSource() {
    var dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.h2.Driver");
    dataSourceBuilder.url("jdbc:h2:mem:task1");
    dataSourceBuilder.username("task1");
    dataSourceBuilder.password("");
    return dataSourceBuilder.build();
  }

}
