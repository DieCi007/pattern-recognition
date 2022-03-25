package com.welld.patternrecognition.repository;

import com.welld.patternrecognition.entity.Point;
import com.welld.patternrecognition.utils.PointFixture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PointRepository {
    private HashSet<Point> points;

    public PointRepository(
            @Value("${com.welld.patternrecognition.default-set}") boolean hasDefaultValues
    ) {
        this.points = hasDefaultValues ? PointFixture.getDefaultPoints() : new HashSet<>();
    }

    public void save(Point point) {
        points.add(point);
    }

    public Set<Point> findAll() {
        return this.points;
    }
}
