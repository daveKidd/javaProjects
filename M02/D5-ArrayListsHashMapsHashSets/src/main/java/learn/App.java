package learn;

import com.github.javafaker.Faker;

import java.util.*;

public class App {
    public static void main(String[] args) {

        HarryPotterRepository repostiory = new HarryPotterRepository();
        List<HarryPotterCharacter> characters = repostiory.findHarryPotterCharacters(3);

        HashSet<HarryPotterCharacter> characterSet = new HashSet<>();

        for(HarryPotterCharacter character : characters){
            characterSet.add(character);
        }

        characterSet.add(makeDeathEater());
        characterSet.add(makeDeathEater());

        for(HarryPotterCharacter character : characterSet){
            System.out.println(character);
        }

//        HashMap<String, HarryPotterCharacter> characterMap = new HashMap<>();
//
//        for(HarryPotterCharacter character : characters){
//            characterMap.put(character.getSpell(), character);
//        }
//
//        System.out.println(characters.size());
//        System.out.println(characterMap.size());
//        System.out.println(characterMap.get("help"));
//
//        for(HarryPotterCharacter character : characterMap.values()){
//            System.out.println(character);
//            System.out.println(character.getName());
//        }
//
//        for(String key : characterMap.keySet()){
//            System.out.println(key);
//        }
//
//        for(Map.Entry<String, HarryPotterCharacter> entry : characterMap.entrySet()){
//            System.out.printf("Key: %s | Value: %s%n",entry.getKey(), entry.getValue());
//        }




        //        List<HarryPotterCharacter> characters2 = repostiory.findHarryPotterCharacters(10);
//        characters.addAll(characters2);
//
//        HarryPotterCharacter bella = makeDeathEater();
//        characters.add(bella);
//        HarryPotterCharacter bellaTest = makeDeathEater();
//
//        for(HarryPotterCharacter character : characters){
//            if(character.equals(bellaTest)){
//                System.out.println("Bella is here run away!");
//            }
//        }
    }

    private static HarryPotterCharacter makeDeathEater(){
        HarryPotterCharacter deathEater = new HarryPotterCharacter();
        deathEater.setName("Bellatrix Lestrange");
        deathEater.setQuote("He know how to play.  Itty, bitty, baby Potter");
        deathEater.setSpell("Avada Kedavra");

        return deathEater;
    }
}





 /*
        for(int i = 0; i < characters.size(); i++){
            System.out.println(characters.get(i));
        }
         */










//        ArrayList<String> characters = new ArrayList<>();
//        List<String> characters2 = new ArrayList<>();
//
//
//
//        characters.add("Harry Potter");
//        characters.add("Hermione Granger");
//        characters.add("Hagrid");
//
//        System.out.println(characters.get(1));
//        System.out.println(characters.size());
//
//        characters.add(1, "Ron Weasley");
//
//        System.out.println(characters.size());
//        System.out.println(characters.get(1));
//        System.out.println(characters.get(2));
//
//        System.out.println(characters.isEmpty());
//        System.out.println(characters.contains("hagrid"));
//        System.out.println(characters.indexOf("Harry Potter"));
//
//        characters.remove(0);
//        System.out.println(characters.size());
//        System.out.println(characters.indexOf("Harry Potter"));
//        System.out.println(characters.get(0));
