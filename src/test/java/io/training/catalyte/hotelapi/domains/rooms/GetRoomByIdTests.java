package io.training.catalyte.hotelapi.domains.rooms;

import static io.training.catalyte.hotelapi.RoomHelper.ROOMS_PATH_WITH_SLASH;
import static io.training.catalyte.hotelapi.RoomHelper.ROOM_ACTIVE_JSON;
import static io.training.catalyte.hotelapi.RoomHelper.ROOM_DESCRIPTION_JSON;
import static io.training.catalyte.hotelapi.RoomHelper.ROOM_RATE_JSON;
import static io.training.catalyte.hotelapi.RoomHelper.ROOM_TYPE_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.training.catalyte.hotelapi.LoginHelper;
import io.training.catalyte.hotelapi.RoomHelper;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GetRoomByIdTests {

  @Autowired
  private static MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext wac;

  LoginHelper loginHelper = new LoginHelper();
  Room testRoom = null;
  private final String TEST_DESCRIPTION = "test description";
  private final String TEST_ROOMTYPE = "test room type";
  private final Double TEST_RATE = 100.00;
  private final boolean TEST_ACTIVE = true;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    testRoom = new Room(TEST_ROOMTYPE, TEST_DESCRIPTION, new BigDecimal(TEST_RATE), TEST_ACTIVE);
  }

  @Test
  public void getByIdAuthenticatedAsManagerHappyPath() throws Exception {
    String token = loginHelper.authenticateAndReturnToken(mockMvc, true);
    Room postedRoom = RoomHelper.postRoom(mockMvc, testRoom);

    mockMvc.perform(get(ROOMS_PATH_WITH_SLASH + postedRoom.getId())
        .header("authentication", "Bearer " + token))
        .andExpect(status().isOk())
        .andExpect(jsonPath(ROOM_TYPE_JSON).value(TEST_ROOMTYPE))
        .andExpect(jsonPath(ROOM_DESCRIPTION_JSON).value(TEST_DESCRIPTION))
        .andExpect(jsonPath(ROOM_RATE_JSON).value(TEST_RATE))
        .andExpect(jsonPath(ROOM_ACTIVE_JSON).value(TEST_ACTIVE))
        .andReturn();
  }

}
