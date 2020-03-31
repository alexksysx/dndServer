package me.alexksysx.controller;

import me.alexksysx.dto.OptionFeatureDto;
import me.alexksysx.model.features.Feature;
import me.alexksysx.model.features.AdjustmentFeature;
import me.alexksysx.model.features.OptionsFeature;
import me.alexksysx.model.features.CounterFeature;
import me.alexksysx.model.features.SpellCasterFeature;
import me.alexksysx.repo.feature.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/feature")
public class FeatureController {
    @Autowired
    AdjustmentFeatureRepository adjustmentFeatureRepository;
    @Autowired
    FeatureRepository featureRepository;
    @Autowired
    CounterFeatureRepository counterFeatureRepository;
    @Autowired
    SpellCasterFeatureRepository spellCasterFeatureRepository;
    @Autowired
    OptionsFeatureRepository optionsFeatureRepository;

    @PostMapping(value = "/adjustment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AdjustmentFeature createAdjustmentFeature(@RequestBody AdjustmentFeature adjustmentFeature) {
        return adjustmentFeatureRepository.save(adjustmentFeature);
    }

    @GetMapping(value = "/adjustment", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdjustmentFeature> getAdjustmentFeatures() {
        return adjustmentFeatureRepository.findAll();
    }

    @PostMapping(value = "/counter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CounterFeature createCounterFeature(@RequestBody CounterFeature counterFeature) {
        return counterFeatureRepository.save(counterFeature);
    }

    @GetMapping(value = "/counter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CounterFeature> getCounterFeatures() {
        return counterFeatureRepository.findAll();
    }

    @PostMapping(value = "/common", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Feature createCommonClassFeature(@RequestBody Feature feature) {
        return featureRepository.save(feature);
    }

    @GetMapping(value = "/common", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Feature> getCommonClassFeature() {
        return featureRepository.findAll();
    }

    @PostMapping(value = "/caster", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SpellCasterFeature createSpellCasterFeature(@RequestBody SpellCasterFeature spellCasterFeature) {
        return spellCasterFeatureRepository.save(spellCasterFeature);
    }

    @GetMapping(value = "/caster", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SpellCasterFeature> getSpellCasterFeatures() {
        return spellCasterFeatureRepository.findAll();
    }

    @PostMapping(value = "/choice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OptionsFeature createChoiceFeature(@RequestBody OptionFeatureDto optionFeatureDto) {
        OptionsFeature optionsFeature = new OptionsFeature();
        BeanUtils.copyProperties(optionFeatureDto, optionsFeature, "options");
        List<Feature> opts = new ArrayList<>();
        for (Long cf: optionFeatureDto.getOptions()) {
            opts.add(featureRepository.getOne(cf));
        }
        optionsFeature.setOptions(opts);
        return optionsFeatureRepository.save(optionsFeature);
    }

    @GetMapping(value = "/choice", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OptionsFeature> getChoiceFeatures() {
        return optionsFeatureRepository.findAll();
    }

}
