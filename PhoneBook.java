import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    private Map<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
        System.out.println("Contact added successfully.");
    }

    public void removeContact(String name) {
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        System.out.println("Phone Book:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public String searchContact(String name) {
        return phoneBook.getOrDefault(name, "Contact not found.");
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Search Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter contact phone number: ");
                    String addPhoneNumber = scanner.nextLine();
                    phoneBook.addContact(addName, addPhoneNumber);
                    break;
                case 2:
                    System.out.print("Enter contact name to remove: ");
                    String removeName = scanner.nextLine();
                    phoneBook.removeContact(removeName);
                    break;
                case 3:
                    phoneBook.displayContacts();
                    break;
                case 4:
                    System.out.print("Enter contact name to search: ");
                    String searchName = scanner.nextLine();
                    System.out.println(phoneBook.searchContact(searchName));
                    break;
                case 5:
                    System.out.println("Exiting Phone Book. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
