package partI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Intermediate {

    public static void main(String[] args) {
//         lengthSort();
//         longestString();
//         stringsWithVowels();
//         listToSingleString();
//         reverseStrings();
         removeEmptyOrNull();
    }

    public static void lengthSort() {
        // Sort the list of strings based on their lengths in ascending/descending order.
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        List<String> stringList = fruits.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println("Sorted list based on length (ascending): " + stringList);
    }

    public static void longestString() {
        // Find the longest string in the list.
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        String longest = fruits.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Longest string: " + longest);
    }

    public static void stringsWithVowels() {
        // Get the list of strings having vowels
        List<String> fruits = Arrays.asList("apple", "dfg", "ghj", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        List<String> stringsWithVowels = fruits.stream().filter(s -> s.matches(".*[aeiouAEIOU].*")).collect(Collectors.toList());
        System.out.println("Strings with vowels: " + stringsWithVowels);
    }

    public static void listToSingleString() {
        // Convert a list of strings into a single string, separated by commas, using streams
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        String singleString = fruits.stream().collect(Collectors.joining(", "));
        System.out.println("Single string: " + singleString);
    }

    public static void reverseStrings() {
        // Create a new list of strings, where string is reversed from the original list, using Java streams
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "grape", "pineapple", "strawberry", "peach", "watermelon", "lemon");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        fruits.stream().map(s -> new StringBuilder(s).reverse().toString()).forEach(System.out::println);
    }

    public static void removeEmptyOrNull() {
        // Remove all strings from the list that are empty or null using streams.
        List<String> strings = Arrays.asList("apple", "", "banana", null, "mango", " ", "orange", "grape", "null", "pineapple");
        System.out.println("Original string list: " + strings);
        System.out.println("-----------------------------------------------------------------");

        List<String> stringList = strings.stream().filter(s -> (s != null && !s.isEmpty() && !s.equals(" "))).toList();
        System.out.println("Removed the null or empty strings: " + stringList);
    }
}
