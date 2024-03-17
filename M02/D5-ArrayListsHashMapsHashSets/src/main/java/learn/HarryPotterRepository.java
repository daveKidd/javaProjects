package learn;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class HarryPotterRepository {

    public List<HarryPotterCharacter> findHarryPotterCharacters(int count){
        ArrayList<HarryPotterCharacter> characters = new ArrayList<>();
        Faker faker = new Faker();

        for(int i=0; i < count; i++){
            HarryPotterCharacter character = new HarryPotterCharacter();
            character.setName(faker.harryPotter().character());
            character.setQuote(faker.harryPotter().quote());
            character.setSpell(faker.harryPotter().spell());
            characters.add(character);
        }
        return characters;
    }
}