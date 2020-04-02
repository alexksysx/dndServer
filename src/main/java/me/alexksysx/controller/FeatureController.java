package me.alexksysx.controller;

import me.alexksysx.dto.OptionFeatureDto;
import me.alexksysx.model.features.*;
import me.alexksysx.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/feature")
public class FeatureController {
    @Autowired
    FeatureService featureService;

    @PostMapping(value = "/adjustment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AdjustmentFeature createAdjustmentFeature(@RequestBody AdjustmentFeature adjustmentFeature) {
        return featureService.createAdjustmentFeature(adjustmentFeature);
    }

    @GetMapping(value = "/adjustment", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdjustmentFeature> getAdjustmentFeatures() {
        return featureService.getAdjustmentFeatures();
    }

    @PostMapping(value = "/counter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CounterFeature createCounterFeature(@RequestBody CounterFeature counterFeature) {
        return featureService.createCounterFeature(counterFeature);
    }

    @GetMapping(value = "/counter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CounterFeature> getCounterFeatures() {
        return featureService.getCounterFeatures();
    }

    @PostMapping(value = "/common", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Feature createCommonClassFeature(@RequestBody Feature feature) {
        return featureService.createCommonClassFeature(feature);
    }

    @GetMapping(value = "/common", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Feature> getCommonClassFeature() {
        return featureService.getCommonClassFeature();
    }

    @PostMapping(value = "/caster", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SpellCasterFeature createSpellCasterFeature(@RequestBody SpellCasterFeature spellCasterFeature) {
        return featureService.createSpellCasterFeature(spellCasterFeature);
    }

    @GetMapping(value = "/caster", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SpellCasterFeature> getSpellCasterFeatures() {
        return featureService.getSpellCasterFeature();
    }

    @PostMapping(value = "/option", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OptionsFeature createOptionFeature(@RequestBody OptionFeatureDto optionFeatureDto) {
        return featureService.createOptionFeature(optionFeatureDto);
    }

    @GetMapping(value = "/option", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OptionsFeature> getOptionFeatures() {
        return featureService.getOptionFeatures();
    }

}
