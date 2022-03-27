package com.welld.patternrecognition.service;

import com.welld.patternrecognition.repository.PointRepository;
import com.welld.patternrecognition.utils.PointFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpaceServiceTest {
    @Mock
    private PointRepository repository;

    @InjectMocks
    private SpaceService service;

    @Test
    void getAll_shouldWork() {
        when(repository.findAll()).thenReturn(PointFixture.getDefaultPoints());
        assertEquals(10, service.getALlPoints().size());
    }
}
