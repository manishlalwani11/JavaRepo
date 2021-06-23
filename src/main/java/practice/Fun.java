package practice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Fun {


    public static void main(String[] args) {

        System.out.println("Hello I am back !! ");

        Predicate<Integer> predicate = (input) -> (input > 5);

        List<String> fruits = Arrays.asList("mango", "banana", "cheery");

        List<Integer> a = fruits.stream()
                .map(String::length)
                .filter(predicate)
                .collect(Collectors.toList());

        // Comparator<String> comparator = (x,y) ->
        //Comparator.

        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println("result1 : " + fruits);


        Collections.sort(fruits, new StringComparator());
        fruits.stream()
                .forEach(p -> System.out.println("values " + p));

        System.out.println("result: " + a);

        Predicate<Person> pre = (p) -> p.getAge() > 30;

        Map<Integer, String> personAttributes =  PersonRepository.getRepo()
                .stream()
                .filter(pre)
                .collect(Collectors.toMap(Person::getAge, Person::getName));

        System.out.println("Map: " + personAttributes);

        List<String> personHobbies = PersonRepository.getRepo().stream(). // Stream of Persons
                                        map(Person::getHobbies). // Stream <List<String>>
                                        flatMap(List::stream).distinct().collect(Collectors.toList());

        System.out.println("List : " + personHobbies);

        long count = PersonRepository.getRepo().stream()
                .map(Person::getHobbies)
                .flatMap(Collection::stream).count();

        System.out.println("hobbies count : " + count);

        // Converting person names to Upper Case
        PersonRepository.getRepo().stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);

        Optional<Person> p = PersonRepository.getRepo().stream().collect(Collectors.minBy(Comparator.comparing(Person::getAge)));
        System.out.println("Person p : " + p);

        p.get();

        getAllTheMinAgedPersons();

        System.out.println("join All Person Names : " + joinAllPersonNames());
    }

    private static String joinAllPersonNames() {
       return PersonRepository.getRepo().stream()
                .map(Person::getName).collect(Collectors.joining());
    }

    private static List<Person>  getAllTheMinAgedPersons() {
        List<Person> filteredPersonList = new ArrayList<>();
        List<Person> filteredPersonRepo = new ArrayList<>();
        Optional<Person> personWithMinAge = PersonRepository.getRepo().stream().collect(Collectors.minBy(Comparator.comparing(Person::getAge)));
        Person per = personWithMinAge.orElse(null);

        filteredPersonList.add(per);

        filteredPersonRepo = PersonRepository.getRepo().stream()
                .filter((person -> person.getAge() == per.getAge())).collect(Collectors.toList());

        System.out.println("min age persons" + filteredPersonRepo);

        return filteredPersonRepo;

    }


}

class StringComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        return (o1.toString().compareTo(o2.toString()));
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

class PersonRepository {

    public static List<Person> getRepo() {
        List<Person> personRepoList = new ArrayList<>();
        personRepoList.add(new Person(11, "Manish", Arrays.asList("Cricket", "Football", "Books")));
        personRepoList.add(new Person(31, "John", Arrays.asList("Fishing", "Cricket")));
        personRepoList.add(new Person(21, "Mike", Arrays.asList("Dancing")));
        personRepoList.add(new Person(11, "Angel", Arrays.asList("Dancing, Music")));
        return personRepoList;
    }
}
