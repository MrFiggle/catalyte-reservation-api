package io.training.catalyte.hotelapi.domains.rooms;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/rooms")
public class RoomController {

  private final Logger logger = LoggerFactory.getLogger(RoomController.class);

  @Autowired
  private RoomService roomService;


  /**
   * This method retrieves all rooms from the database
   *
   * @return a collection of rooms and 200 status code
   * @throws Exception
   */
  @GetMapping
  @ApiOperation("Retrieve all rooms")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK", response = Room.class)
  })
  public ResponseEntity<List<Room>> getAllRooms() {
    logger.info(" Get all request received");
    return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
  }

  /**
   * This method retrieves a single room from the database
   *
   * @return a room by the id provided and 200 status code
   * @throws Exception
   */
  @GetMapping("/id")
  @ApiOperation("Retrieve a room by id")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK", response = Room.class)
  })
  public ResponseEntity<Room> getRoomById(Long id) {
    logger.info(" Get all request received");
    return new ResponseEntity<>(roomService.getById(id), HttpStatus.OK);
  }

  /**
   * This method creates a new room record and saves it to the database
   *
   * @param room to be created
   * @return created room and 201 status code
   * @throws Exception
   */
  @PostMapping
  @ApiOperation("Add a single room by the room info provided")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created", response = Room.class),
      @ApiResponse(code = 400, message = "Invalid request", response = ResponseStatusException.class)
  })
  public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room) {
    logger.info(" Post request received");
    return new ResponseEntity<>(roomService.createRoom(room), HttpStatus.CREATED);
  }

  /**
   * This method updates an existing room record
   *
   * @param id of the room to be updated
   * @param room updated room information
   * @return updated room and 200 status code
   * @throws Exception
   */
  @PutMapping("/{id}")
  @ApiOperation("Update a single room by id and room info provided")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK", response = Room.class),
      @ApiResponse(code = 400, message = "Invalid request", response = ResponseStatusException.class)
  })
  public ResponseEntity<Room> updateRoom(@Valid @RequestBody Room room, @PathVariable Long id) {
    logger.info(" Put request received");
    return new ResponseEntity<>(roomService.updateRoom(id, room), HttpStatus.OK);
  }
}
