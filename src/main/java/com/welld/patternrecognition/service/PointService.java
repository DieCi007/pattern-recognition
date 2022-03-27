package com.welld.patternrecognition.service;

import com.welld.patternrecognition.exception.PointExistsException;
import com.welld.patternrecognition.feature.point.contract.AddPointRequest;
import com.welld.patternrecognition.repository.PointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PointService {
    private final PointRepository repository;

    @Autowired
    public PointService(PointRepository repository) {
        this.repository = repository;
    }

    public void addNewPoint(AddPointRequest request) {
        var exists = repository.findAll().stream().anyMatch(p ->
                p.getX().equals(request.getX()) && p.getY().equals(request.getY()));
        if (exists) {
            throw new PointExistsException("Point already exists");
        }
        repository.save(request.toPoint());
        log.info("Saved new point: {}", request);
    }
}
