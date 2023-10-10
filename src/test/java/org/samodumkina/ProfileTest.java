package org.samodumkina;

import static org.assertj.core.api.Assertions.assertThat;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("DEV")
class ProfileTest {

  @Autowired
  private DataSource dataSource;

  @Test
  void testActualDatabaseInContext() {
    String jdbcUrl = ((HikariDataSource) dataSource).getJdbcUrl();
    assertThat(jdbcUrl).isEqualTo("jdbc:h2:mem:dev");
  }

}
