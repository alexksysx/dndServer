package me.alexksysx.service;

import me.alexksysx.dto.OptionFeatureDto;
import me.alexksysx.model.features.*;
import me.alexksysx.repo.feature.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeatureService {
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

    public AdjustmentFeature createAdjustmentFeature(AdjustmentFeature adjustmentFeature) {
        return adjustmentFeatureRepository.save(adjustmentFeature);
    }

    public List<AdjustmentFeature> getAdjustmentFeatures() {
        return adjustmentFeatureRepository.findAll();
    }

    public CounterFeature createCounterFeature(CounterFeature counterFeature) {
        return counterFeatureRepository.save(counterFeature);
    }

    public List<CounterFeature> getCounterFeatures() {
        return counterFeatureRepository.findAll();
    }

    public Feature createCommonClassFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    public List<Feature> getCommonClassFeature() {
        return featureRepository.findAll();
    }

    public SpellCasterFeature createSpellCasterFeature(SpellCasterFeature spellCasterFeature) {
        return spellCasterFeatureRepository.save(spellCasterFeature);
    }

    public List<SpellCasterFeature> getSpellCasterFeature() {
        return spellCasterFeatureRepository.findAll();
    }

    public OptionsFeature createOptionFeature(OptionFeatureDto optionFeatureDto) {
        OptionsFeature optionsFeature = new OptionsFeature();
        BeanUtils.copyProperties(optionFeatureDto, optionsFeature, "options");
        List<Feature> opts = new ArrayList<>();
        for (Long cf : optionFeatureDto.getOptions()) {
            opts.add(featureRepository.getOne(cf));
        }
        optionsFeature.setOptions(opts);
        return optionsFeatureRepository.save(optionsFeature);
    }

    public List<OptionsFeature> getOptionFeatures() {
        return optionsFeatureRepository.findAll();
    }
}
