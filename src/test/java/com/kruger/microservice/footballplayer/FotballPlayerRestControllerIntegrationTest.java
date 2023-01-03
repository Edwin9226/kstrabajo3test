package com.kruger.microservice.footballplayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kruger.microservice.MicroserviceApplication;
import com.kruger.microservice.model.FootBallPlayer;
import com.kruger.microservice.model.repository.FootballPlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = MicroserviceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
public class FotballPlayerRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
//
//    @Sql({ "schema.sql", "data.sql" })
//    @Test
//    public void testAllEmployees()
//    {
//        assertTrue(
//                this.restTemplate
//                        .getForObject("http://localhost:" + port + "/footballplayer", FootBallPlayer.class)
//                        . == 3);
//    }

//    @Autowired
//    private FootballPlayerRepository footballPlayerRepository;
//
//    public void testFootballPlayerNameMustNotBeBlank() {
//        FootBallPlayer footBallPlayer =new FootBallPlayer();
//            String url="http://localhost:8080/footballplayer/save";
//            mockMvc.perform()
//    }


}
