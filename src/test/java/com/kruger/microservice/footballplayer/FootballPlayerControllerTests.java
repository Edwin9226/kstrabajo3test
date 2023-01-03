package com.kruger.microservice.footballplayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kruger.microservice.controller.FootballPlayerController;
import com.kruger.microservice.model.FootBallPlayer;
import com.kruger.microservice.model.repository.FootballPlayerRepository;
import com.kruger.microservice.model.service.FootballPlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FootballPlayerController.class)
public class FootballPlayerControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FootballPlayerService footballPlayerRepository;


    @Test
   public void testListFootballPlayer() throws Exception {


        String url="http://localhost:8080/footballplayer";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
    }
/*
    @Test
    public void createFootballPlayerAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/save")
                        .content(asJsonStrin(new EmployeeVO(null, "firstName4", "lastName4", "email4@mail.com")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
    }*/

    @Test
    public void getFootballPlayerByIdAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .get("http://localhost:8080/footballplayer/show/{id}", 3)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteEmployeeAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders.delete("http://localhost:8080/footballplayer/delete/{id}", 3) )
                .andExpect(status().isOk());
    }

}
