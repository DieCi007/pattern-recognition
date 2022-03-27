package com.welld.patternrecognition.utils;

import com.welld.patternrecognition.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class PointFixture {
    public static ArrayList<Point> getDefaultPoints() {
        return new ArrayList<>(List.of(getFor(1, 2),
                getFor(1, 3),
                getFor(2, 2),
                getFor(2, 3),
                getFor(3, 2),
                getFor(3, 3),
                getFor(4, 2),
                getFor(4, 3),
                getFor(5, 2),
                getFor(5, 3)));
    }

    private static Point getFor(double x, double y) {
        return Point.builder().x(x).y(y).build();
    }
}
