package org.samodumkina;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.samodumkina.dao.UserRepository;
import org.samodumkina.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataSourceAutoConfigurationTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  void saveEntityTest() {
    UserEntity user = new UserEntity(1, "Test Name", "test@test.com");

    UserEntity saved = userRepository.save(user);
    List<UserEntity> users = userRepository.findAll();

    assertThat(users).hasSize(1);
    UserEntity actualUser = users.get(0);
    assertThat(actualUser).isNotNull();
    assertThat(actualUser.getId()).isEqualTo(saved.getId());
    assertThat(actualUser.getName()).isEqualTo(saved.getName());
    assertThat(actualUser.getEmail()).isEqualTo(saved.getEmail());
  }

}
