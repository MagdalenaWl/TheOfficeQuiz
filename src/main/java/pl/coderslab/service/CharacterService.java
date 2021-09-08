package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.repository.CharacterRepository;
import pl.coderslab.dto.CharacterData;
import pl.coderslab.model.Character;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CharacterService {
    CharacterRepository characterRepository;

    public void save(CharacterData characterData){
        if(!characterRepository.existsCharacterByApiId(characterData.get_id())){
            Character character=new Character();
            character.setApiId(characterData.get_id());
            character.setFirstName(characterData.getFirstname());
            character.setLastName(characterData.getLastname());
            characterRepository.save(character);
        }

    }
    Character findByApiId(String apiId){
        return characterRepository.findFirstByApiId(apiId);
    }

    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }
}
