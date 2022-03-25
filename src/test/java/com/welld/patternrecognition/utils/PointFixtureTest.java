package com.welld.patternrecognition.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointFixtureTest {

    @Test
    void should_create_correct_set() {
        var created = PointFixture.getDefaultPoints();
        assertEquals(10, created.size());
    }
}
