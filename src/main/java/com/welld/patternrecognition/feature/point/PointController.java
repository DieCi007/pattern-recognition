package com.welld.patternrecognition.feature.point;

import com.welld.patternrecognition.feature.point.contract.AddPointRequest;
import com.welld.patternrecognition.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PointController {
    private final PointService service;

    @Autowired
    public PointController(PointService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/point")
    public void addPoint(@RequestBody @Valid AddPointRequest request) {
        service.addNewPoint(request);
    }
}
