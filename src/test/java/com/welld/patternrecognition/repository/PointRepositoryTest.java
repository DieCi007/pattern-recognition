package com.welld.patternrecognition.repository;

import com.welld.patternrecognition.entity.Point;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource({"classpath:application-test.properties"})
class PointRepositoryTest {

    @Autowired
    private PointRepository repository;

    @Test
    void save_should_addPoint() {
        repository.save(Point.builder().x(1D).y(2D).build());
        assertEquals(1, repository.findAll().size());
    }

    @Test
    void delete_should_removePoints() {
        repository.save(Point.builder().x(1D).y(2D).build());
        repository.save(Point.builder().x(2D).y(3D).build());
        repository.save(Point.builder().x(1D).y(2D).build());
        repository.deleteAll();
        assertEquals(0, repository.findAll().size());
    }


}
