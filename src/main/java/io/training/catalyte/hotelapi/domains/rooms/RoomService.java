package io.training.catalyte.hotelapi.domains.rooms;

import java.util.List;

public interface RoomService {

  List<Room> getAll();

  Room getById(Long id);

  Room createRoom(Room room);

  Room updateRoom(Long id, Room room);

}
