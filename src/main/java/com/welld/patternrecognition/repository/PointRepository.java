package com.welld.patternrecognition.repository;

import com.welld.patternrecognition.entity.Point;
import com.welld.patternrecognition.utils.PointFixture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PointRepository {
    private final ArrayList<Point> points;

    public PointRepository(
            @Value("${com.welld.patternrecognition.default-set}") boolean hasDefaultValues
    ) {
        this.points = hasDefaultValues ? PointFixture.getDefaultPoints() : new ArrayList<>();
    }

    public void save(Point point) {
        points.add(point);
    }

    public List<Point> findAll() {
        return this.points;
    }

    public void deleteAll() {
        points.clear();
    }
}
