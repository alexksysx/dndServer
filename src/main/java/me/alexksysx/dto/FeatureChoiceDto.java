package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureChoiceDto {
    private Long optionFeature;
    private Long pickedFeature;
}
