package me.alexksysx.service;

import me.alexksysx.dto.CharacterClassDto;
import me.alexksysx.dto.CharacterDto;
import me.alexksysx.dto.FeatureChoiceDto;
import me.alexksysx.model.Character;
import me.alexksysx.model.bindModel.CharacterClass;
import me.alexksysx.model.bindModel.FeatureChoice;
import me.alexksysx.repo.*;
import me.alexksysx.repo.feature.FeatureRepository;
import me.alexksysx.repo.feature.OptionsFeatureRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    RaceRepository raceRepository;
    @Autowired
    SubRaceRepository subRaceRepository;
    @Autowired
    GameClassRepository gameClassRepository;
    @Autowired
    CharacterClassRepository characterClassRepository;
    @Autowired
    OptionsFeatureRepository optionsFeatureRepository;
    @Autowired
    FeatureRepository featureRepository;
    @Autowired
    FeatureChoiceRepository featureChoiceRepository;

    private Character getCharacterFromDto(CharacterDto characterDto) {
        Character character = new Character();
        BeanUtils.copyProperties(characterDto, character, "race", "subrace", "classes");
        character.setRace(raceRepository.getOne(characterDto.getRace()));
        character.setSubRace(subRaceRepository.getOne(characterDto.getSubRace()));
        List<CharacterClass> classes = new ArrayList<>();

        if (characterDto.getClasses() != null && !characterDto.getClasses().isEmpty()) {
            for (CharacterClassDto charClassDto : characterDto.getClasses()) {
//                CharacterClass characterClass = new CharacterClass();
//                BeanUtils.copyProperties(charClassDto, characterClass, "classes");
//                if (charClassDto.getGameClass() != null) {
//                    characterClass.setGameClass(gameClassRepository.getOne(charClassDto.getGameClass()));
//                }
//                characterClass = characterClassRepository.save(characterClass);
//                classes.add(characterClass);
                classes.add(getCharacterClassFromDto(charClassDto));
            }
        }
        character.setClasses(classes);
        return character;
    }

    private CharacterClass getCharacterClassFromDto(CharacterClassDto charClassDto) {
        CharacterClass characterClass = new CharacterClass();
        BeanUtils.copyProperties(charClassDto, characterClass, "classes");
        List<FeatureChoice> featureChoiceList = new ArrayList<>();
        if (charClassDto.getGameClass() != null) {
            characterClass.setGameClass(gameClassRepository.getOne(charClassDto.getGameClass()));
            for(FeatureChoiceDto featureChoiceDto: charClassDto.getFeatureChoices()) {
                FeatureChoice featureChoice = new FeatureChoice();
                featureChoice.setOptionFeature(optionsFeatureRepository.getOne(featureChoiceDto.getOptionFeature()));
                featureChoice.setPickedFeature(featureRepository.getOne(featureChoiceDto.getPickedFeature()));
                featureChoiceList.add(featureChoiceRepository.save(featureChoice));
            }
        }
        characterClass.setFeatureChoices(featureChoiceList);
        characterClass = characterClassRepository.save(characterClass);
        return characterClass;
    }


    public Character getOne(Long id) {
        return characterRepository.getOne(id);
    }

    public boolean existsById(Long id) {
        return characterRepository.existsById(id);
    }

    public void deleteById(Long id) {
        characterRepository.deleteById(id);
    }

    public Character create(CharacterDto characterDto) {
        Character character = getCharacterFromDto(characterDto);
        return characterRepository.save(character);
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }
}
