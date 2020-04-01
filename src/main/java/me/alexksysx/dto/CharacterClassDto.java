package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterClassDto {
    private Integer level;
    private boolean isFirst;
    private Long gameClass;
    private List<FeatureChoiceDto> featureChoices;
    private List<CounterFeatureValueDto> counterFeatureValues;
}
