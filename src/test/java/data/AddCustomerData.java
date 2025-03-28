package data;

public final class AddCustomerData {
    public static final String LAST_NAME = "Lovegood";
    public static final String POST_CODE = generatePostCode();
    public static final String FIRST_NAME = generateFirstName(POST_CODE);
    public static final String ALERT_MESSAGE = "Customer added successfully with customer id";

    private AddCustomerData() {
    }

    private static String generatePostCode() {
        return String.valueOf((long) (Math.random() * 1_000_000_0000L)); // 10-значный номер
    }

    private static String generateFirstName(String postCode) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < postCode.length(); i += 2) {
            int num = Integer.parseInt(postCode.substring(i, Math.min(i + 2, postCode.length())));
            char letter = (char) ('a' + (num % 26));
            name.append(letter);
        }
        return name.toString();
    }
}