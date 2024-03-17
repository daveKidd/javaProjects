package videogames.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import videogames.data.VideoGameRepository;
import videogames.models.VideoGame;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    void shouldFindById() throws Exception {

        VideoGame expected = new VideoGame(2, "Test", new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false,1);

        when(repository.findById(2)).thenReturn(expected);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String expectedJson = objectMapper.writeValueAsString(expected);

        mvc.perform(get("/api/video-game/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));
    }

    @Test
    void shouldBe404forNotFound() throws Exception {
        mvc.perform(get("/api/video-game/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateVideoGameAndReturn201() throws Exception {
        VideoGame videoGame = new VideoGame(0, "Test", new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false,1);
        VideoGame expected = new VideoGame(7, "Test", new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false,1);

        ObjectMapper objectMapper = createObjectMapper();
        String videoGameJson = objectMapper.writeValueAsString(videoGame);
        String expectedJson = objectMapper.writeValueAsString(expected);

        // Must mock a "good" result from the repository
        when(repository.create(videoGame)).thenReturn(expected);

        var request = post("/api/video-game")
                .contentType(MediaType.APPLICATION_JSON)
                .content(videoGameJson);

        mvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));
    }

    @Test
    void shouldReturn400ForInvalidVideoGame() throws Exception {
        VideoGame videoGame = new VideoGame(0, null, new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false,1);

        ObjectMapper objectMapper = createObjectMapper();
        String videoGameJson = objectMapper.writeValueAsString(videoGame);

        // No need to mock repository methods, the
        // domain will cut off the invalid Video Game
        // before it gets there.

        var request = post("/api/video-game")
                .contentType(MediaType.APPLICATION_JSON)
                .content(videoGameJson);

        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldUpdateAndReturn204() throws Exception {
        VideoGame videoGame = new VideoGame(2, "Test", new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false,1);

        ObjectMapper objectMapper = createObjectMapper();
        String videoGameJson = objectMapper.writeValueAsString(videoGame);

        // Must mock a "good" result from the repository
        when(repository.update(videoGame)).thenReturn(true);

        var request = put("/api/video-game/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(videoGameJson);

        mvc.perform(request)
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldNotUpdateAndReturn409ForMismatchedIds() throws Exception {
        VideoGame videoGame = new VideoGame(2, "Test", new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false,1);

        ObjectMapper objectMapper = createObjectMapper();
        String videoGameJson = objectMapper.writeValueAsString(videoGame);

        var request = put("/api/video-game/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(videoGameJson);

        mvc.perform(request)
                .andExpect(status().isConflict());
    }

    @Test
    void shouldNotUpdateAndReturn404ForMissingVideoGame() throws Exception {
        VideoGame videoGame = new VideoGame(99, "Test", new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false,1);

        ObjectMapper objectMapper = createObjectMapper();
        String videoGameJson = objectMapper.writeValueAsString(videoGame);

        var request = put("/api/video-game/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(videoGameJson);

        mvc.perform(request)
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldNotUpdateAndReturn400ForInvalidVideoGame() throws Exception {
        VideoGame videoGame = new VideoGame(2, null, new BigDecimal("20.00"),
                LocalDate.parse("2022-01-01"), false,1);

        ObjectMapper objectMapper = createObjectMapper();
        String videoGameJson = objectMapper.writeValueAsString(videoGame);

        var request = put("/api/video-game/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(videoGameJson);

        mvc.perform(request)
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldDeleteAndReturn204() throws Exception {
        when(repository.deleteById(3)).thenReturn(true);

        mvc.perform(delete("/api/video-game/3"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldNotDeleteAndReturn404ForMissingVideoGame() throws Exception {
        mvc.perform(delete("/api/video-game/99"))
                .andExpect(status().isNotFound());
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }
}