package com.welld.patternrecognition.feature.point.contract;

import com.welld.patternrecognition.entity.Point;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AddPointRequest {
    @NotNull(message = "Value required for field 'x'")
    private Double x;

    @NotNull(message = "Value required for field 'y'")
    private Double y;

    public Point toPoint() {
        return Point.builder().x(x).y(y).build();
    }
}
