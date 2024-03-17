package videogames.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import videogames.data.VideoGameRepository;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VideoGameControllerTest {

    @MockBean
    VideoGameRepository repository;
    @Autowired
    MockMvc mvc;

    @Test
    void findById() throws Exception {
        VideoGame expected = new VideoGame(2,"Test", VideoGameConsole.SWITCH, new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false);

        when(repository.findById(2)).thenReturn(expected);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String expectedJson = objectMapper.writeValueAsString(expected);

        //import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        //import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
        mvc.perform(get("/api/video-game/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));
    }

    @Test
    void shouldBe404IfNotFound() throws Exception{
        mvc.perform(get("/api/video-game/99"))
                .andExpect(status().isNotFound());
    }
}