package org.samodumkina.service;

import org.samodumkina.dao.entity.UserEntity;
import org.samodumkina.dto.UserRequestDTO;
import org.samodumkina.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserResponseDTO mapEntityToDTO(UserEntity entity) {
    return new UserResponseDTO(entity.getId(), entity.getName(), entity.getEmail());
  }

  public UserEntity mapDTOToEntity(UserRequestDTO dto) {
    UserEntity entity = new UserEntity();
    entity.setName(dto.name());
    entity.setEmail(dto.email());
    return entity;
  }
}
