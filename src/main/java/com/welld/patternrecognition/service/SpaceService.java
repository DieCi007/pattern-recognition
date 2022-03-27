package com.welld.patternrecognition.service;

import com.welld.patternrecognition.entity.Point;
import com.welld.patternrecognition.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceService {
    private final PointRepository pointRepository;

    @Autowired
    public SpaceService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> getALlPoints() {
        return pointRepository.findAll();
    }

    public void deleteAllPoints() {
        pointRepository.deleteAll();
    }
}
