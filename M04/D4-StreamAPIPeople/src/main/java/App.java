import data.Repository;
import models.Person;
import models.StateProvince;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Repository repository = new Repository();
        List<Person> people = repository.getPeople();

        List<StateProvince> stateProvinces = people.stream()
                .flatMap(person -> person.getStatesProvinces().stream())
                .toList();

        for(StateProvince stateProvince : stateProvinces){
            System.out.println(stateProvince);
        }

//        Map<Character,IntSummaryStatistics> lastNameGroup = people.stream()
//                .collect(Collectors.groupingBy(
//                        person -> person.getLastName().toUpperCase().charAt(0),
//                        Collectors.summarizingInt(person -> LocalDate.now().getYear() - person.getBirthDate().getYear())));
//
//
//        for(Character key : lastNameGroup.keySet()){
//            System.out.print(key + " last names | Average age: ");
//            IntSummaryStatistics agesSummary = lastNameGroup.get(key);
//            System.out.println(agesSummary.getAverage());
//            System.out.println("-------------");
//        }

//        Map<Character,List<Person>> lastNameGroup = people.stream()
//                .collect(Collectors.groupingBy(person -> person.getLastName().toUpperCase().charAt(0)));

//        for(Character key : lastNameGroup.keySet()){
//            System.out.println(key + " last names");
//            for(Person person : lastNameGroup.get(key)){
//                System.out.println(person);
//            }
//            System.out.println("-------------");
//        }

        // HashMap =  {"A": ListOf all the lastnames that start with A}

        // weird type cast issue must declare the type when reversing here
//        people.stream()
//                .sorted(Comparator.comparingInt((Person person) -> person.getBirthDate().getYear()).reversed())
//                .forEach(System.out::println);

//        people.stream()
//                .sorted(Comparator.comparing(Person::getBirthDate))
//                .forEach(System.out::println);

//        people.stream()
//                .sorted(Comparator.comparing(Person::getLastName).reversed())
//                .forEach(System.out::println);

//        people.stream()
//                .map(Person::getLastName)
//                .sorted(Comparator.reverseOrder())
//                .forEach(System.out::println);

//        List<String> sortedPeople = people.stream()
//                .map(person -> String.format("%s, %s", person.getLastName(),person.getFirstName()))
//                .sorted()
//                .toList();
//
//        for(String person: sortedPeople){
//            System.out.println(person);
//        }

//        people.stream()
//                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
//                .forEach(System.out::println);

//        people.stream()
//                .filter(p -> p.getStatesProvinces().stream()
//                        .anyMatch(stateProvince -> stateProvince.getAbbreviation().equalsIgnoreCase("ID")))
//                .forEach(System.out::println);


//        people.stream()
//                .filter(person -> person.getLastName().toLowerCase().charAt(0) == 'a')
//                .forEach(System.out::println);

                // method reference   class :: method in that class
                //person -> System.out.println(person)
                // imperative solution - how
                // declarative solution - what
        /*
        private boolean getLastNameStartsA(Person person){
            return person.getLastName()..toLowerCase().charAt(0) == 'a';
        }

         */

//        List<Person> lastNameStartsWithA = new ArrayList<>();
//        for(Person person : people){
//            if(person.getLastName().toLowerCase().charAt(0) == 'a'){
//                lastNameStartsWithA.add(person);
//            }
//        }
//
//        for(Person person:lastNameStartsWithA){
//            System.out.println(person);
//        }

//        for(Person person:people){
//            System.out.println(person);
//        }
    }
}
