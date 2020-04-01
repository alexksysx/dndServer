package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CounterFeatureValueDto {
    private Long counterFeature;
    private Integer value;
}
