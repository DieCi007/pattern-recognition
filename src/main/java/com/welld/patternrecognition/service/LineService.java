package com.welld.patternrecognition.service;

import com.welld.patternrecognition.entity.Point;
import com.welld.patternrecognition.exception.InvalidPointNumberException;
import com.welld.patternrecognition.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {
    private final PointRepository repository;

    @Autowired
    public LineService(PointRepository repository) {
        this.repository = repository;
    }

    /**
     * This is a brute force solution.
     * Another solution could be keeping track of all lines that a point could
     * pass through and grouping by similar lines at the end.
     *
     * @param numberOfPoints Minimum number of points that a line has to go through
     * @return List of lines meeting the criteria
     */
    public List<List<Point>> findLinesThroughPoints(int numberOfPoints) {
        if (numberOfPoints <= 1) {
            throw new InvalidPointNumberException("Number of points must be > 1 or use GET /space to receive all points.");
        }

        var allPoints = repository.findAll();
        var equations = new HashSet<String>();
        var lines = new ArrayList<List<Point>>();
        for (int i = 0; i < allPoints.size(); i++) {
            var point = allPoints.get(i);
            // check a point against every other point
            for (int y = 0; y < allPoints.size(); y++) {
                var nextPoint = allPoints.get(y);
                if (i == y) continue;
                // y = mx + b
                // calculate line slope (m)
                var tilt = calcTilt(point.getX(), point.getY(),
                        nextPoint.getX(), nextPoint.getY());
                if (tilt == null) {
                    if (!equations.contains("max" + point.getX())) {
                        var matchingPoints = allPoints.stream().filter(p -> p.getX().equals(point.getX()))
                                .collect(Collectors.toList());
                        equations.add("max" + point.getX());
                        if (matchingPoints.size() >= numberOfPoints) {
                            lines.add(matchingPoints);
                        }
                    }
                    continue;
                }
                // calculate yIntercept (b)
                var yIntercept = point.getY() - (tilt * point.getX());
                // create a unique string tilt-yIntercept to keep track of lines
                var tiltPositive = Math.abs(tilt);
                if (!equations.contains(tiltPositive + "" + yIntercept)) {
                    var matchingPoints = allPoints.stream()
                            .filter(p -> p.getY() == (tilt * p.getX()) + yIntercept)
                            .collect(Collectors.toList());
                    equations.add(tiltPositive + "" + yIntercept);
                    if (matchingPoints.size() >= numberOfPoints) {
                        lines.add(matchingPoints);
                    }
                }
            }
        }
        return lines;
    }

    private Double calcTilt(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            return null;
        }

        return (y2 - y1) / (x2 - x1);
    }
}
