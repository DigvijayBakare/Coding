package part2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basic {
    public static void main(String[] args) {
//        evenOdd();
//        evenOddInRange();
//        ascDscNum();
//        sumAndAverage();
        minMaxNum();
    }

    public static void evenOdd() {
        // Get the even and odd numbers from the list of integers and the array of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original list of numbers: " + numbers);
        System.out.println("Original array of numbers: " + numbers);
        System.out.println("--------------------------------------------------");

        List<Integer> even = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("List of even numbers: " + even);

        int[] odd = Arrays.stream(num).filter(n -> n % 2 != 0).toArray();
        System.out.println("Array of odd numbers: " + Arrays.toString(odd));
    }

    public static void evenOddInRange() {
        // Get the even and odd numbers between a range
        IntStream numbers = IntStream.range(10, 50);
        System.out.println("--------------------------------------------------");

        int[] evenNum = numbers.filter(n -> n % 2 == 0).toArray();
        System.out.println("Even num in the range of 10 to 50: " + Arrays.toString(evenNum));

        // similarly we can done this for the odd numbers
    }

    public static void ascDscNum() {
        // Sort a list of integers in the descending/ ascending order
        List<Integer> numbers = Arrays.asList(15, 27, 25, 45, 5, 65, 7,48, 92, 10);
        System.out.println("Original list of numbers: " + numbers);
        System.out.println("--------------------------------------------------");

        List<Integer> desc = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("List in descending order: " + desc);
    }

    public static void sumAndAverage() {
        // Calculate the sum and average of numbers in an array and list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original list of numbers: " + numbers);
        System.out.println("Original array of numbers: " + numbers);
        System.out.println("--------------------------------------------------");

//        Integer sum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
        Integer sum = numbers.stream().reduce((x, y) -> x+y).get();
        System.out.println("Sum of first 10 num: " + sum);

        Arrays.stream(num).average().ifPresent((l) -> System.out.println("The average of first 10 numbers: " + l));
    }

    public static void minMaxNum() {
        // Find the maximum/minimum number in an array/list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original list of numbers: " + numbers);
        System.out.println("Original array of numbers: " + numbers);
        System.out.println("--------------------------------------------------");

        Integer max = numbers.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println("maximum number: " + max);

        int min = Arrays.stream(num).sorted().findFirst().getAsInt();
        System.out.println("Minimum number: " + min);
    }
}