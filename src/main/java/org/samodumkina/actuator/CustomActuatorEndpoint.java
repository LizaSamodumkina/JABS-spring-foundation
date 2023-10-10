package org.samodumkina.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customActuator")
public class CustomActuatorEndpoint {

  @ReadOperation
  public String healthMessage() {
    return "Alright, alright, alright....";
  }
}
