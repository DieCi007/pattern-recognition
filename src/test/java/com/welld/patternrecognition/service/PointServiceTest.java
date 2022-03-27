package com.welld.patternrecognition.service;

import com.welld.patternrecognition.exception.PointExistsException;
import com.welld.patternrecognition.feature.point.contract.AddPointRequest;
import com.welld.patternrecognition.repository.PointRepository;
import com.welld.patternrecognition.utils.PointFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PointServiceTest {
    @Mock
    private PointRepository repository;

    @InjectMocks
    private PointService pointService;

    @Test
    void addNewPoint_shouldAddPoint() {
        when(repository.findAll()).thenReturn(PointFixture.getDefaultPoints());
        assertDoesNotThrow(() -> pointService.addNewPoint(AddPointRequest.builder().x(1d).y(5d).build()));
    }

    @Test
    void addNewPoint_shouldThrow_pointExistsException() {
        when(repository.findAll()).thenReturn(PointFixture.getDefaultPoints());
        assertThrows(PointExistsException.class, () -> pointService.addNewPoint(AddPointRequest.builder().x(1d).y(2d).build()));
    }

}
