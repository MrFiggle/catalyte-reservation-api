package io.training.catalyte.hotelapi.domains.rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

  private final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

  @Autowired
  private RoomRepository roomRepository;

  /**
   * Retrieves all rooms from the database.
   *
   * @return a list of all rooms.
   */
  @Override
  public List<Room> getAll() {
    List<Room> roomList = new ArrayList<>();

    try {
      roomList = roomRepository.findAll();
    } catch (DataAccessException e) {
      logger.error(e.getMessage());
    }

    return roomList;
  }

  /**
   * Retrieves a room from the database by its id.
   *
   * @param id the id of the room to retrieve
   * @return the specified room
   */
  @Override
  public Room getById(Long id) {
    Optional<Room> room = Optional.ofNullable(null);

    try {
      room = roomRepository.findById(id);
    } catch (DataAccessException e) {
      logger.error(e.getMessage());
    }

    if (room.isEmpty()) {
      throw new ResourceNotFoundException();
    } else {
      return room.get();
    }
  }

  /**
   * Persists a new room to the database.
   *
   * @param room the room object to persist
   * @return the persisted room
   */
  @Override
  public Room createRoom(Room room) {
    Room postedRoom = null;

    try {
      postedRoom = roomRepository.save(room);
    } catch (DataAccessException e) {
      logger.error(e.getMessage());
    }

    return postedRoom;
  }

  /**
   * Updates a specified record in the database.
   *
   * @param id the id of the record to update
   * @param room the provided room information to persist
   * @return the updated room
   */
  @Override
  public Room updateRoom(Long id, Room room) {
    Room updatedRoom = null;

    try {
      Optional<Room> roomToUpdate = roomRepository.findById(id);
      if(roomToUpdate.isEmpty()){
        throw new ResourceNotFoundException();
      } else {
        updatedRoom = roomRepository.save(room);
      }
    } catch (DataAccessException e) {
      logger.error(e.getMessage());
    }

    return updatedRoom;
  }
}
