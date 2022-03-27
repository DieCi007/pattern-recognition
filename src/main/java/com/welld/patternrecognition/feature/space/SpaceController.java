package com.welld.patternrecognition.feature.space;

import com.welld.patternrecognition.entity.Point;
import com.welld.patternrecognition.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SpaceController {

    private final SpaceService spaceService;

    @Autowired
    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/space")
    public List<Point> getAllPoints() {
        return spaceService.getALlPoints();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/space")
    public void deleteAllPoints() {
        spaceService.deleteAllPoints();
    }
}
