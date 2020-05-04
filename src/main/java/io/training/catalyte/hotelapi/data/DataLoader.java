package io.training.catalyte.hotelapi.data;

import io.training.catalyte.hotelapi.domains.reservations.Reservation;
import io.training.catalyte.hotelapi.domains.reservations.ReservationRepository;
import io.training.catalyte.hotelapi.domains.rooms.Room;
import io.training.catalyte.hotelapi.domains.rooms.RoomRepository;
import io.training.catalyte.hotelapi.domains.users.User;
import io.training.catalyte.hotelapi.domains.users.UserRepository;
import java.math.BigDecimal;
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

  @Autowired
  private RoomRepository roomRepository;

  @Autowired
  private ReservationRepository reservationRepository;

  @Override
  public void run(String... strings) {
    loadUsers();
    loadRooms();
    loadReservations();
  }

  private void loadUsers() {
    userRepository.save(new User("manager@hotelapi.com", "password", "manager"));
    userRepository.save(new User("employee@hotelapi.com", "password", "employee"));
  }

  private void loadRooms() {
    roomRepository.save(new Room("King", "Single king non-smoking", new BigDecimal(99.99), true));
    roomRepository.save(new Room("King", "Single king non-smoking", new BigDecimal(99.99), true));
    roomRepository.save(new Room("King", "Single king non-smoking", new BigDecimal(99.99), true));
    roomRepository.save(new Room("Queen", "Single queen non-smoking", new BigDecimal(79.99), true));
    roomRepository.save(new Room("Queen", "Single queen non-smoking", new BigDecimal(79.99), true));
    roomRepository.save(new Room("Queen", "Single queen non-smoking", new BigDecimal(79.99), true));
    roomRepository
        .save(new Room("Queen Double", "Two queens non-smoking", new BigDecimal(129.99), true));
    roomRepository
        .save(new Room("Queen Double", "Two queens non-smoking", new BigDecimal(129.99), true));
    roomRepository
        .save(new Room("Queen Double", "Two queens non-smoking", new BigDecimal(129.99), true));
  }

  private void loadReservations() {
    String MY_DATE = "01-01-2020";

    reservationRepository
        .save(new Reservation("employee@hotelapi.com", "bobRoss@gmail.com", 1L, MY_DATE, 2));
    reservationRepository
        .save(new Reservation("employee@hotelapi.com", "batman@gmail.com", 2L, MY_DATE, 1));
    reservationRepository
        .save(new Reservation("employee@hotelapi.com", "elrond@gmail.com", 3L, MY_DATE, 5));
    reservationRepository
        .save(new Reservation("employee@hotelapi.com", "elrond@gmail.com", 4L, MY_DATE, 5));
  }
}
