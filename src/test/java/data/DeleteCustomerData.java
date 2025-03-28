package data;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class DeleteCustomerData {
    public static final List<String> CUSTOMER_NAMES = Arrays.asList(
            "Albus", "Neville", "Voldemort", "Hermione", "Ron"
    );

    public static double getAverageNameLength(List<String> customerNames) {
        OptionalDouble averageLengthOpt = customerNames.stream()
                .mapToInt(String::length)
                .average();
        return averageLengthOpt.orElse(0);
    }

    public static String getCustomerToDelete(List<String> customerNames, double averageLength) {
        return customerNames.stream()
                .min((name1, name2) -> Double.compare(
                        Math.abs(name1.length() - averageLength),
                        Math.abs(name2.length() - averageLength)
                ))
                .orElse(null);
    }
}