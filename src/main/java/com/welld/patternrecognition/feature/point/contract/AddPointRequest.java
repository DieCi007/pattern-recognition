package com.welld.patternrecognition.feature.point.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPointRequest {
    @NotNull(message = "Value required for field 'x'")
    private Double x;

    @NotNull(message = "Value required for field 'y'")
    private Double y;
}
