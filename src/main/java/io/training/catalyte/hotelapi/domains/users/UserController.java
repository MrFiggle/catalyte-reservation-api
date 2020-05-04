package io.training.catalyte.hotelapi.domains.users;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {

  private final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  /**
   * This method creates a new user record and saves it to the database
   *
   * @param user to be created
   * @return created user and 201 status code
   * @throws Exception
   */
  @PostMapping
  @ApiOperation("Add a single user by the user info provided")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "OK", response = User.class),
      @ApiResponse(code = 400, message = "Invalid request", response = ResponseStatusException.class),
      @ApiResponse(code = 409, message = "This email is conflict with an email address in the database", response = DataIntegrityViolationException.class)
  })
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    logger.info(" Post request received");
    return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
  }
}
