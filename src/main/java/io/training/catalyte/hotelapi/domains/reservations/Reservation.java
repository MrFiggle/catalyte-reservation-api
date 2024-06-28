package io.training.catalyte.hotelapi.domains.reservations;

import static io.training.catalyte.hotelapi.constants.StringConstants.GUEST_EMAIL_VALIDATION_ERROR;
import static io.training.catalyte.hotelapi.constants.StringConstants.NUMBER_OF_NIGHTS_POSITIVE_VALIDATION_ERROR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Email(message = GUEST_EMAIL_VALIDATION_ERROR)
  private String guestEmail;

  @ValidDate()
  private String checkInDate;

  @Positive(message = NUMBER_OF_NIGHTS_POSITIVE_VALIDATION_ERROR)
  @NotNull
  private int numberOfNights;

  public Reservation() {
  }

  public Reservation(String guestEmail, Long roomTypeId, String checkInDate,
      int numberOfNights) {
    this.guestEmail = guestEmail;
    this.checkInDate = checkInDate;
    this.numberOfNights = numberOfNights;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGuestEmail() {
    return guestEmail;
  }

  public void setGuestEmail(String guestEmail) {
    this.guestEmail = guestEmail;
  }

  public String getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(String checkInDate) {
    this.checkInDate = checkInDate;
  }

  public int getNumberOfNights() {
    return numberOfNights;
  }

  public void setNumberOfNights(int numberOfNights) {
    this.numberOfNights = numberOfNights;
  }
}
