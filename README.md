# JABS-spring-foundation

1. Create AutoConfiguration for data source -
   [DataSourceAutoConfiguration](src/main/java/org/samodumkina/configuration/DataSourceAutoConfiguration.java)
2. Create custom configuration with conditional -
   [ConditionalConfiguration](src/main/java/org/samodumkina/configuration/ConditionalConfiguration.java)
3. Enable default Actuator and create custom endpoint -
   [SecurityConfig](src/main/java/org/samodumkina/configuration/SecurityConfig.java) and
   [CustomActuatorEndpoint](src/main/java/org/samodumkina/actuator/CustomActuatorEndpoint.java)
4. Use Spring Profiles