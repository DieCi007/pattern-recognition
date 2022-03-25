package com.welld.patternrecognition.feature.line;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LineController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/lines/{n}")
    public void findValidLines(@PathVariable(value = "n") Integer numberOfPoints) {

    }

}