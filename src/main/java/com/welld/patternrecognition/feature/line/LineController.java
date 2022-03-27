package com.welld.patternrecognition.feature.line;

import com.welld.patternrecognition.entity.Point;
import com.welld.patternrecognition.repository.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LineController {

    private final LineService lineService;

    @Autowired
    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/lines/{n}")
    public List<List<Point>> findValidLines(@PathVariable(value = "n") Integer numberOfPoints) {
        return lineService.findLinesThroughPoints(numberOfPoints);
    }

}
