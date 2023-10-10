package org.samodumkina.configuration;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("DEV")
public class DevConfiguration {

  @Bean
  public DataSource getDataSource() {
    var dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.h2.Driver");
    dataSourceBuilder.url("jdbc:h2:mem:dev");
    dataSourceBuilder.username("dev");
    dataSourceBuilder.password("");
    return dataSourceBuilder.build();
  }
}
