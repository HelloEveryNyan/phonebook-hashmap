import java.util.*;

public class phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> phoneBook = new HashMap<>();

        while (true) {
            System.out.println("Enter name (enter 'exit' out of programme): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
        }

        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort(Comparator.comparingInt(entry -> -entry.getValue().size()));

        System.out.println("Phonebook:");

        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
