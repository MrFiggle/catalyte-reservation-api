package io.training.catalyte.hotelapi.data;

import io.training.catalyte.hotelapi.domains.users.User;
import io.training.catalyte.hotelapi.domains.users.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

  @Autowired
  private UserRepository userRepository;


  @Override
  public void run(String... strings) throws Exception {
    logger.info("Loading data...");

    loadUsers();

  }

  private void loadUsers() {
    userRepository.save(new User("manager@hotelapi.com", "password", "manager"));
    userRepository.save(new User("employee@hotelapi.com", "password", "employee"));
  }

}
