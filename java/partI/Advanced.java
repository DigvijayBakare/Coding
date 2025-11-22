package partI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Advanced {
    public static void main(String[] args) {
//        groupByFirstLetter();
//        groupByLengthOfString();
//        groupByLastLetter();
//        withAndWithoutVowel();
//        excludeDigits();
//        lengthAs10();
        palindromeString();
//        reverseList();
    }

    public static void groupByFirstLetter() {
        // Given the list of strings, group a list of strings by the first letter of each string using streams
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "caret", "cinemon", "strawberry", "blueberry", "watermelon", "avocado");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        Map<Character, List<String>> groupBased = fruits.stream().collect(Collectors.groupingBy((s -> s.charAt(0))));
        System.out.println("This is based on the group: ");
        System.out.println(groupBased);
    }

    public static void groupByLengthOfString() {
        // Given the list of strings, group a list of strings by the length of the string
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "caret", "cinemon", "strawberry", "blueberry", "watermelon", "avocado");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        Map<Integer, List<String>> groupBased = fruits.stream().collect(Collectors.groupingBy(String :: length));
        System.out.println("This is based on the group: ");
        System.out.println(groupBased);
    }

    public static void groupByLastLetter() {
        // Given the list of strings, create a map where the key is the last letter of the string, and the value is a list of strings that start with that letter using streams
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "caret", "cinemon", "strawberry", "blueberry", "watermelon", "avocado");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        Map<Character, List<String>> groupBased = fruits.stream().collect(Collectors.groupingBy((s -> s.charAt(s.length()-1))));
        System.out.println("This is based on the group: ");
        System.out.println(groupBased);
    }

    public static void withAndWithoutVowel() {
        // Given a list of strings, group the list of the strings with vowels and no vowels into the lists
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "orange", "caret", "kjh", "strawberry", "blueberry", "sdf", "fgh");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        Map<Boolean, List<String>> partitioned = fruits.stream().collect(Collectors.partitioningBy(s -> s.matches(".*[aeiouAEIOU].*")));
        System.out.println("Partitioned data: " + partitioned);
    }

    public static void excludeDigits() {
        // Given a list of strings print only the string elements excluding the digits using streams.
        List<String> fruits = Arrays.asList("apple", "253863", "mango", "ora2325nge", "24513", "kjh", "515", "bluebe35rry", "sdf", "fgh");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        Predicate<String> p = s -> !s.matches(".*[0-9].*");
        List<String> stringList = fruits.stream().filter(p).toList();
        System.out.println("List of string with only characters: " + stringList);
    }

    public static void lengthAs10() {
        // Given a list of strings find the first element having length as 10 if not handle the exception
        List<String> fruits = Arrays.asList("apple", "253863", "mango", "ora2325nge4", "24513", "kjh", "515", "bluebe35rr", "sdf", "fgh");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        String noValueFound = fruits.stream().filter(s -> s.length() > 10).findFirst().orElseThrow(() -> new NoSuchElementException("No value found"));
        System.out.println("The first string with length greater than 10: " + noValueFound);
    }

    public static void palindromeString() {
        // Given a list of strings create a new list with the strings that are palindrome
        List<String> fruits = Arrays.asList("madam", "apple", "racecar", "banana", "level", "stream", "noon", "java", "refer", "hello");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        List<String> stringList = fruits.stream().filter(s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())).toList();
        System.out.println("List of palindrome strings: " + stringList);
    }

    public static void reverseList() {
        // Reverse the list of strings using streams API
        List<String> fruits = Arrays.asList("madam", "apple", "racecar", "banana", "level", "stream", "noon", "java", "refer", "hello");
        System.out.println("Original string list: " + fruits);
        System.out.println("-----------------------------------------------------------------");

        IntStream.range(0, fruits.size()).mapToObj(i -> fruits.get(fruits.size() -1 -i)).forEach(System.out::println);
    }
}
