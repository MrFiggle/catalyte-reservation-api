package io.training.catalyte.hotelapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.training.catalyte.hotelapi.domains.roomtypes.RoomType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

public class RoomHelper {

  public static final String ROOMTYPES_PATH = "/room-types";
  public static final String ROOMS_PATH_WITH_SLASH = ROOMTYPES_PATH + "/";
  public static final String ROOM_NAME_JSON = "$.name";
  public static final String ROOM_DESCRIPTION_JSON = "$.description";
  public static final String ROOM_RATE_JSON = "$.rate";
  public static final String ROOM_ACTIVE_JSON = "$.active";

  public static RoomType postRoom(MockMvc mockMvc, RoomType roomType) throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    String token = LoginHelper.authenticateAndReturnToken(mockMvc, true);

    MvcResult result = mockMvc.perform(post(ROOMTYPES_PATH)
        .header("authentication", "Bearer " + token)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(roomType)))
        .andReturn();

    return objectMapper.readValue(result.getResponse().getContentAsString(), RoomType.class);
  }


}
