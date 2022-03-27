package com.welld.patternrecognition.service;

import com.welld.patternrecognition.entity.Point;
import com.welld.patternrecognition.repository.PointRepository;
import com.welld.patternrecognition.service.LineService;
import com.welld.patternrecognition.utils.PointFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@TestPropertySource({"classpath:application-test.properties"})
@ExtendWith(MockitoExtension.class)
class LineServiceTest {

    @Mock
    private PointRepository repository;

    @InjectMocks
    private LineService service;

    @Test
    void findLines_shouldWork() {
        var points = PointFixture.getDefaultPoints();
        points.add(Point.builder().x(2d).y(4d).build());
        when(repository.findAll()).thenReturn(points);
        var res = service.findLinesThroughPoints(2);
        var hasRequiredPoint = res.stream().anyMatch(l ->
                l.stream().anyMatch(p -> p.getX().equals(2d) &&
                        p.getY().equals(4d)));
        assertTrue(hasRequiredPoint);
    }

    @Test
    void findLines_shouldWork_withSameX() {
        var points = new ArrayList<Point>();
        points.add(Point.builder().x(0d).y(2d).build());
        points.add(Point.builder().x(0d).y(1d).build());
        points.add(Point.builder().x(0d).y(3d).build());
        when(repository.findAll()).thenReturn(points);
        var res = service.findLinesThroughPoints(3);
        res.forEach(System.out::println);
        assertEquals(1, res.size());
    }

    @Test
    void findLines_shouldWork_withSameY() {
        var points = new ArrayList<Point>();
        points.add(Point.builder().x(1d).y(0d).build());
        points.add(Point.builder().x(2d).y(0d).build());
        points.add(Point.builder().x(-3d).y(0d).build());
        when(repository.findAll()).thenReturn(points);
        var res = service.findLinesThroughPoints(3);
        res.forEach(System.out::println);
        assertEquals(1, res.size());
    }

    @Test
    void findLines_shouldWork_withDiagonal() {
        var points = new ArrayList<Point>();
        points.add(Point.builder().x(1d).y(1d).build());
        points.add(Point.builder().x(2d).y(2d).build());
        points.add(Point.builder().x(-3d).y(-3d).build());
        points.add(Point.builder().x(4d).y(4d).build());
        when(repository.findAll()).thenReturn(points);
        var res = service.findLinesThroughPoints(3);
        res.forEach(System.out::println);
        assertEquals(1, res.size());
    }
}
