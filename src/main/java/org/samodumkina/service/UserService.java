package org.samodumkina.service;

import java.util.List;
import org.samodumkina.dao.UserRepository;
import org.samodumkina.dao.entity.UserEntity;
import org.samodumkina.dto.UserRequestDTO;
import org.samodumkina.dto.UserResponseDTO;
import org.samodumkina.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {

  private final UserRepository repository;
  private final UserMapper userMapper;

  public UserService(UserRepository repository, UserMapper userMapper) {
    this.repository = repository;
    this.userMapper = userMapper;
  }

  public List<UserResponseDTO> getUsers() {
    List<UserEntity> users = repository.findAll();
    return users.stream().map(userMapper::mapEntityToDTO).toList();
  }

  public UserResponseDTO getUser(Integer id) {
    UserEntity userEntity = repository.findById(id)
        .orElseThrow(() -> new NotFoundException("There is no user with id='%d".formatted(id)));
    return userMapper.mapEntityToDTO(userEntity);
  }

  @Transactional
  public UserResponseDTO createUser(UserRequestDTO dto) {
    UserEntity entity = userMapper.mapDTOToEntity(dto);
    UserEntity saved = repository.save(entity);
    return userMapper.mapEntityToDTO(saved);
  }

  @Transactional
  public UserResponseDTO updateUser(Integer id, UserRequestDTO dto) {
    UserEntity userEntity = repository.findById(id)
        .orElseThrow(() -> new NotFoundException("There is no user with id='%d".formatted(id)));
    userEntity.setEmail(dto.email());
    userEntity.setName(dto.name());
    return userMapper.mapEntityToDTO(userEntity);
  }

  @Transactional
  public void deleteUser(Integer id) {
    repository.deleteById(id);
  }
}
