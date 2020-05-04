package io.training.catalyte.hotelapi.domains.rooms;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 3, message = "must have length greater than 3")
  private String roomType;

  private String description;

  @NotNull
  @Positive(message = "rate should be a positive value greater than zero")
  private BigDecimal rate;

  private boolean active;

  public Room(String roomType, String description, BigDecimal rate, boolean active) {
    this.roomType = roomType;
    this.description = description;
    this.rate = rate;
    this.active = active;
  }

  public Room() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Room room = (Room) o;

    if (isActive() != room.isActive()) {
      return false;
    }
    if (!getRoomType().equals(room.getRoomType())) {
      return false;
    }
    if (!getDescription().equals(room.getDescription())) {
      return false;
    }
    return getRate().equals(room.getRate());
  }

  @Override
  public int hashCode() {
    int result = getDescription().hashCode();
    result = 31 * result + getRate().hashCode();
    result = 31 * result + (isActive() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Room{" +
        "id=" + id +
        ", roomType='" + roomType + '\'' +
        ", description='" + description + '\'' +
        ", rate=" + rate +
        ", active=" + active +
        '}';
  }
}
