package org.samodumkina;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.samodumkina.configuration.ConditionalConfiguration;
import org.samodumkina.dao.CustomDataSource;
import org.samodumkina.dao.CustomDataSourceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;

class ConditionalConfigurationTest {

  private final ApplicationContextRunner runner = new ApplicationContextRunner();

  @Test
  void createNoDataSourceAsCustomDataSourceIsPresent() {
    runner.withUserConfiguration(TestConfig.class, ConditionalConfiguration.class)
        .run(context -> {
          assertThat(context).hasSingleBean(CustomDataSource.class);
          assertThat(context).doesNotHaveBean(DataSource.class);
        });
  }

  @Test
  void createNoDataSourceAsCustomDataSourceIsPresent_WrongConfigOrder() {
    runner.withUserConfiguration(ConditionalConfiguration.class, TestConfig.class)
        .run(context -> {
          assertThat(context).hasSingleBean(CustomDataSource.class);
          assertThat(context).hasSingleBean(DataSource.class);
        });
  }

  @Test
  void createDataSourceOnMissingCustomDataSource() {
    runner.withUserConfiguration(ConditionalConfiguration.class)
        .run(context -> {
      assertThat(context).doesNotHaveBean(CustomDataSource.class);
      assertThat(context).hasSingleBean(DataSource.class);
    });
  }

  @TestConfiguration
  static class TestConfig {

    static final CustomDataSource cds = new CustomDataSourceImpl();

    @Bean
    public CustomDataSource customDataSource() {
      return cds;
    }
  }

}
