package com.welld.patternrecognition.utils;

import com.welld.patternrecognition.entity.Point;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointFixture {
    public static HashSet<Point> getDefaultPoints() {
        return Stream.of(getFor(1, 2),
                        getFor(1, 3),
                        getFor(2, 2),
                        getFor(2, 3),
                        getFor(3, 2),
                        getFor(3, 3),
                        getFor(4, 2),
                        getFor(4, 3),
                        getFor(5, 2),
                        getFor(5, 3))
                .collect(Collectors.toCollection(HashSet::new));
    }

    private static Point getFor(double x, double y) {
        return Point.builder().x(x).y(y).build();
    }
}
