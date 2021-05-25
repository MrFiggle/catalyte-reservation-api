package io.training.catalyte.hotelapi.domains.roomtypes;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/room-types")
public class RoomTypeController {

  private final Logger logger = LoggerFactory.getLogger(RoomTypeController.class);

  @Autowired private RoomTypeService roomTypeService;

  /**
   * This method retrieves all roomtypes from the database
   *
   * @return a collection of roomtypes and 200 status code
   * @throws Exception
   */
  @GetMapping
  @ApiOperation("Retrieve all roomtypes")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RoomType.class)})
  public ResponseEntity<List<RoomType>> getAllRoomTypes() {
    logger.info(" Get all request received");
    return new ResponseEntity<>(roomTypeService.getAll(), HttpStatus.OK);
  }

  /**
   * This method retrieves a single roomtype from the database
   *
   * @return a roomtype by the id provided and 200 status code
   * @throws Exception
   */
  @GetMapping("/{id}")
  @ApiOperation("Retrieve a roomtype by id")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RoomType.class)})
  public ResponseEntity<RoomType> getRoomTypeById(@PathVariable Long id) {
    logger.info(" Get all request received");
    return new ResponseEntity<>(roomTypeService.getById(id), HttpStatus.OK);
  }

  /**
   * This method creates a new roomtype record and saves it to the database
   *
   * @param roomType to be created
   * @return created roomtype and 201 status code
   * @throws Exception
   */
  @PostMapping
  @ApiOperation("Add a single roomtype by the roomtype info provided")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Created", response = RoomType.class),
        @ApiResponse(
            code = 400,
            message = "Invalid request",
            response = ResponseStatusException.class)
      })
  public ResponseEntity<RoomType> createRoomType(@Valid @RequestBody RoomType roomType) {
    logger.info(" Post request received");
    return new ResponseEntity<>(roomTypeService.createRoom(roomType), HttpStatus.CREATED);
  }

  /**
   * This method updates an existing roomtype record
   *
   * @param id of the roomtype to be updated
   * @param roomType updated roomtype information
   * @return updated roomtype and 200 status code
   * @throws Exception
   */
  @PutMapping("/{id}")
  @ApiOperation("Update a single roomtype by id and roomtype info provided")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK", response = RoomType.class),
        @ApiResponse(
            code = 400,
            message = "Invalid request",
            response = ResponseStatusException.class)
      })
  public ResponseEntity<RoomType> updateRoomType(
      @PathVariable Long id, @Valid @RequestBody RoomType roomType) {
    logger.info(" Put request received");
    return new ResponseEntity<>(roomTypeService.updateRoom(id, roomType), HttpStatus.OK);
  }
}
