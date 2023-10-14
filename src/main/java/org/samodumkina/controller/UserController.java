package org.samodumkina.controller;

import java.util.List;
import org.samodumkina.dto.UserRequestDTO;
import org.samodumkina.dto.UserResponseDTO;
import org.samodumkina.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserResponseDTO> getUsers() {
    return service.getUsers();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserResponseDTO getUser(@PathVariable Integer id) {
    return service.getUser(id);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
    return service.createUser(userRequestDTO);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public UserResponseDTO updateUser(@PathVariable Integer id, @RequestBody UserRequestDTO userRequestDTO) {
    return service.updateUser(id, userRequestDTO);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteUser(@PathVariable Integer id) {
    service.deleteUser(id);
  }
}
