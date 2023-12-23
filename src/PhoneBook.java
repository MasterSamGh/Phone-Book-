import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;


public class PhoneBook {
    String filePath = "C:\\Users\\rojansystem\\IdeaProjects\\PhoneBook\\phonebook.txt";
    private Map<String,String>phoneBook;
    public PhoneBook(){
        phoneBook = new HashMap<>();
    }
    public void addContact(String name,String number){
        phoneBook.put(name,number);
        System.out.println("Contact added successfully.");
    }
    public void removeContact(String name){
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println("Contact delete successfully.");
        }
    }
    public void displayContact() {
        for (Map.Entry<String,String>entry: phoneBook.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
    public String searchContact(String name){
        return phoneBook.getOrDefault(name,"Contact not found.");
    }
    public void saveDataToFile(String fileName) {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    FileWriter fileWriter = new FileWriter(filePath, true);
                    String line = entry.getKey() + ":" + entry.getValue();
                    fileWriter.write(line);
                    fileWriter.close();
                    System.out.println("New data added");
                }
            }
            catch (IOException e){
                System.out.println("Error while saving data to file:" + e.getMessage());
            }
        }

        else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    String line = entry.getKey() + ":" + entry.getValue();
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("Data saved successfully.");
            } catch (IOException e) {
                System.out.println("Error while saving data to file:" + e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Search Contact");
            System.out.println("5. Save File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter Contact Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Contact Number:");
                    String number = scanner.nextLine();
                    phoneBook.addContact(name,number);
                    break;
                case 2:
                    System.out.println("Enter Contact Name to remove:");
                    String removeName = scanner.nextLine();
                    phoneBook.removeContact(removeName);
                    break;
                case 3:
                    phoneBook.displayContact();
                    break;
                case 4:
                    System.out.println("Enter Name to search:");
                    String searchName = scanner.nextLine();
                    System.out.println(phoneBook.searchContact(searchName));
                    break;
                case 5:
                    System.out.println("Enter File Name and extension to save");
                    String saveFile = scanner.nextLine();
                    phoneBook.saveDataToFile(saveFile);
                    break;
                case 6:
                    System.out.println("Exiting Phone Book. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}