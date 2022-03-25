package com.welld.patternrecognition.service;

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
        repository.save(request.toPoint());
        log.info("Saved new point: {}", request);
    }
}
