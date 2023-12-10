package com.example.weatherapplication;

import com.example.weatherapplication.util.DtoBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ActiveProfiles("tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WeatherApplicationTests {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @Test
    @WithMockUser(roles = "EDITOR", username = "user")
    void shouldSaveWeatherRecord() throws Exception {

        var weatherDto = DtoBuilder.createWeatherDto();
        var json = objectMapper.writeValueAsString(weatherDto);
        mockMvc.perform(post("/api/weather")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));
    }
    @Test
    @WithMockUser(roles = "ADMIN", username = "user")
    void shouldNotSaveWeatherRecord() throws Exception {

        var weatherDto = DtoBuilder.createWeatherDto();
        var json = objectMapper.writeValueAsString(weatherDto);
        mockMvc.perform(post("/api/weather")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isForbidden());
    }
    @Test
    void shouldGetRecordWhenRecordIsFound() throws Exception {

        mockMvc.perform(get("/api/weather/1")
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.date").value("1985-01-01"))
                .andExpect(jsonPath("$.lat").value(36.1189))
                .andExpect(jsonPath("$.city").value("Nashville"))
                .andExpect(jsonPath("$.state").value("Tennessee"))
                .andExpect(jsonPath("$.temperatures").isArray());
    }

    @Test
    void shouldThrowExceptionWhenRecordIsNotFound() throws Exception {
        mockMvc.perform(get("/api/weather/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_PROBLEM_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("Not Found"));
    }

    @Test
    void shouldGetWhenDateIsNotNull() throws Exception {
        mockMvc.perform(get("/api/weather?date=1115-01-01"))
                .andExpect(status().isOk());
    }
    @Test
    void shouldGetWhenDateAndCitiesAreNotNull() throws Exception {
        mockMvc.perform(get("/api/weather?date=1985-01-01&cities=Lviv"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetWhenDateAndCitiesAndSortAreNotNull() throws Exception {
        mockMvc.perform(get("/api/weather?date=1985-01-01&cities=Lviv&sort=date"))
                .andExpect(status().isOk());
    }

}
