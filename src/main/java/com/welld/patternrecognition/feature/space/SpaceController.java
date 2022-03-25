package com.welld.patternrecognition.feature.space;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SpaceController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/space")
    public void getAllPoints() {

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/space")
    public void deleteAllPoints() {

    }
}
