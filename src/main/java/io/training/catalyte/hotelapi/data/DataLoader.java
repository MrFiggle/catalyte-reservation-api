package io.training.catalyte.hotelapi.data;

import io.training.catalyte.hotelapi.domains.reservations.Reservation;
import io.training.catalyte.hotelapi.domains.reservations.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  @Autowired
  private ReservationRepository reservationRepository;

  @Override
  public void run(String... strings) {
    loadReservations();
  }

  private void loadReservations() {
    String MY_DATE = "03-18-2024";

    reservationRepository
        .save(new Reservation("bross@gmail.com", 1L, MY_DATE, 2));
    reservationRepository
        .save(new Reservation("eapoe@gmail.com", 2L, MY_DATE, 1));
    reservationRepository
        .save(new Reservation("blee@gmail.com", 3L, MY_DATE, 5));
    reservationRepository
        .save(new Reservation("asmith@gmail.com", 4L, MY_DATE, 5));
  }
}
