package com.example.contaazul.rover.controller;

import com.example.contaazul.rover.service.RoverControlService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class RoverControlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RoverControlService roverControlService;


    @ParameterizedTest
    @ValueSource(strings = {"M", "L", "R"})
    @DisplayName("Should move rover when give valid command.")
    void should_execute_rover_command(String command) throws Exception {

        // Arrange
        String anyPosition = "(0, 2, N)";
        doReturn(anyPosition).when(roverControlService).execute(command);

        // Act
        MockHttpServletResponse response = mockMvc.perform(post("/mars/{command}", command))
                .andReturn()
                .getResponse();

        // Assert
        verify(roverControlService).execute(command);
        assertEquals(response.getStatus(), HttpStatus.ACCEPTED.value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "1", "T","~"})
    @DisplayName("Should not move rover when give invalid command.")
    void should_not_execute_rover_command(String command) throws Exception {

        // Act
        MockHttpServletResponse response = mockMvc.perform(post("/mars/{command}", command))
                .andReturn()
                .getResponse();

        // Assert
        verify(roverControlService, never()).execute(command);
        assertEquals(response.getStatus(), HttpStatus.BAD_REQUEST.value());
    }
}