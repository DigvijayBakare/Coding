package partI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basic {
    public static void main(String[] args) {
//       stringToUpperCase();
//        stringLengthGreater();
//        removeDuplicate();
//        particularWord();
//        removeWord();
//        firstElement();
        lengthOfEachWord();
    }
    public static void lengthOfEachWord() {
        // Get the length of each name in a list
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");
//        fruits.stream().map(String::length).sorted().forEach(System.out::println);

//        fruits.forEach(fruit -> System.out.println(fruit + " → " + fruit.length()));

        Map<String, Integer> fruitLengthMap = fruits.stream().collect(Collectors.toMap(fruit -> fruit, String::length));
        fruitLengthMap.forEach((fruit, length) -> System.out.println(fruit + ": " + length));

    }

    public static void firstElement() {
        // Find the first element in a list that starts with a particular letter
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "aorange", "grape", "apineapple", "strawberry", "peach", "awatermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");
        Optional<String> first = fruits.stream().filter(s -> s.startsWith("a")).findFirst();
        System.out.println("First: " + first.orElse(""));
    }

    public static void removeWord() {
        // Write a Java program to remove strings that start with a specific word from a list using streams.
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "agrape", "pineapple", "strawberry", "apeach", "watermelon", "alemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");
        fruits.stream().filter(s -> !s.startsWith("a")).forEach(System.out::println);
    }

    public static void particularWord() {
        // Get the list of strings having a particular word and char
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");
        fruits.stream().filter(fruit -> fruit.contains("apple")).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");
        fruits.stream().filter(fruit -> fruit.contains("a")).forEach(System.out::println);
    }

    public static void removeDuplicate() {
        // Remove duplicates from a list
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "apple", "banana", "mango", "orange", "grape");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");
        fruits.stream().distinct().forEach(System.out::println);
    }

    public static void stringLengthGreater() {
        // Get the list of strings where the length of each element is >5 and get the count
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");
        List<String> stringList = fruits.stream().filter(fruit -> fruit.length() > 6).collect(Collectors.toList());
        System.out.println("List of string whose length is greater than 6: " + stringList);
        System.out.println("Number of Strings whose length is greater than 6: " + stringList.size());
    }

    public static void stringToUpperCase() {
        // Convert the string to the UpperCase, sort them and print
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");
        List<String> fruitList = fruits.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println("New string list: " + fruitList);
    }
}
