package com.welld.patternrecognition.feature.point;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.welld.patternrecognition.feature.point.contract.AddPointRequest;
import com.welld.patternrecognition.service.PointService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PointController.class)
@TestPropertySource({"classpath:application-test.properties"})
class PointControllerTest {
    @MockBean
    private PointService pointService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addPoint_shouldWork() throws Exception {
        var request = AddPointRequest.builder().x(1.2).y(2.2).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/point")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is(201));
    }

    @ParameterizedTest
    @MethodSource("getInvalidAddPointRequest")
    void addPoint_shouldReturnBadRequest_whenInvalidRequest(AddPointRequest invalidRequest) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/point")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
    }

    public static Stream<AddPointRequest> getInvalidAddPointRequest() {
        var withNullX = AddPointRequest.builder().x(null).y(3.2).build();
        var withNullY = AddPointRequest.builder().y(null).x(3.2).build();
        return Stream.of(withNullX, withNullY);
    }
}
