package aula06;

import aula05.DateYMD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactManager {

    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;

        do {
            listOptions();
            choice = Integer.parseInt(input("^[0-5]$", "Invalid option! Try again: ", true));
            if (choice > 1 && !contactsExists()) {
                System.out.println("No contacts to manage!");
                continue;
            }
            selector(choice);

        } while (choice != 0);
    }

    private static void listOptions() {
        System.out.println("Select an option:");
        System.out.println("1 - Add contact");
        System.out.println("2 - Update contact");
        System.out.println("3 - Remove contact");
        System.out.println("4 - Search contacts");
        System.out.println("5 - List all contacts");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private static String input(String regex, String wrongInputMsg, boolean recursive) {
        if (wrongInputMsg == null) {
            wrongInputMsg = "Invalid input!";
        }

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!input.matches(regex)) {
            System.out.println(wrongInputMsg);
            return recursive ? input(regex, wrongInputMsg, recursive) : null;
        }

        return input;
    }

    private static String input(String regex, String wrongInputMsg) {
        if (wrongInputMsg == null) {
            wrongInputMsg = "Invalid input!";
        }

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!input.matches(regex)) {
            System.out.println(wrongInputMsg);
            return null;
        }

        return input;
    }

    private static void selector(int choice) {
        switch (choice) {
            case 1:
                addContact();
                break;
            case 2:
                updateContact();
                break;
            case 3:
                removeContact();
                break;
            case 4:
                searchContacts();
                break;
            case 5:
                listContacts();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }

    private static void searchContacts() {
        message("Choose how you want to search\n");
        message("1 - Get contact by index\n");
        message("2 - Get contact by name\n");
        message("3 - Get contact by phone number\n");
        message("Your choice: ");
        String input = input("^[1-3]$", "Invalid Choice!");
        if (input == null) {
            return;
        }
        List<Contact> filteredContacts = null;
        switch (input) {
            case "1":
                message("Index: ");
                int index = Integer.parseInt(
                    input("^[0-" + (contacts.size() - 1) + "]+$", "Invalid index!"));
                filteredContacts = Collections.singletonList(getContactByIndex(index));
                if (filteredContacts.isEmpty()) {
                    System.out.println("No contacts found!");
                    return;
                }
                break;
            case "2":
                message("Name: ");
                String name = input("^[a-zA-Z ]+$", "Invalid Name!");
                filteredContacts = contacts.stream()
                    .filter(contact -> contact.getPerson().getName().equals(name))
                    .collect(Collectors.toList());
                if (filteredContacts.isEmpty()) {
                    System.out.println("No contacts found!");
                    return;
                }
                break;
            case "3":
                message("Phone Number: ");
                int number = Integer.parseInt(input("^9[0-9]{8}$", "Invalid phone number!"));
                filteredContacts = contacts.stream().filter(contact -> contact.getPhone() == number)
                    .collect(Collectors.toList());
                if (filteredContacts.isEmpty()) {
                    System.out.println("No contacts found!");
                    return;
                }
                break;
            default:
                System.out.println("no such option");
                break;
        }

        for (Contact contact : filteredContacts) {
            System.out.println(contact);
        }
    }

    private static void removeContact() {
        message("Choose how you want to find the contact to remove\n");
        message("1 - Get contact by index\n");
        message("2 - Get contact by name\n");
        message("3 - Get contact by phone number\n");
        message("Your choice: ");
        String input = input("^[1-3]$", "Invalid Choice!");
        if (input == null) {
            return;
        }
        Contact contact = null;
        switch (input) {
            case "1":
                message("Index: ");
                int index = Integer.parseInt(
                    input("^[0-" + (contacts.size() - 1) + "]+$", "Invalid index!"));
                contact = getContactByIndex(index);
                if (contact == null) {
                    return;
                }
                break;
            case "2":
                message("Name: ");
                String name = input("^[a-zA-Z ]+$", "Invalid Name!");
                contact = getContactByName(name);
                if (contact == null) {
                    return;
                }
                break;
            case "3":
                message("Phone Number: ");
                int number = Integer.parseInt(input("^9[0-9]{8}$", "Invalid phone number!"));
                contact = getContactByNumber(number);
                if (contact == null) {
                    return;
                }
                break;
            default:
                System.out.println("no such option");
                break;

        }

        contacts.remove(contact);
    }

    private static void listContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(i + " - " + contacts.get(i));
        }
    }

    private static void message(String msg) {
        System.out.print(msg);

    }

    private static void addContact() {
        String input;

        message("Enter the person following this pattern (name-surname cc birthday(yyyy-mm-dd)): ");
        input = input(
            "^([a-zA-Z]+-)?[a-zA-Z]+ [1-9][0-9]{7} [0-9]{1,4}-(0?[1-9]|1[0-2])-[0-9]{1,9}$",
            "Invalid person!");
        if (input == null) {
            return;
        }
        Person person = personHandler(input);

        if (personInContactsHandler(person)) {
            return;
        }

        message("Enter phone number (must start with 9 and have 9 total digits): ");
        input = input("^9[0-9]{8}$", "Invalid phone number!");
        if (input == null) {
            return;
        }
        int phone = phoneHandler(input);

        message("Enter email (user@email.com): ");
        input = input(Contact.EMAIL_REGEX, "Invalid email address!");
        if (input == null) {
            return;
        }
        String email = input;

        Contact contact = new Contact(person, email, phone);
        contacts.add(contact);
    }

    private static boolean personInContactsHandler(Person person) {
        List<Contact> contactsByPerson = contacts.stream()
            .filter(contact -> contact.getPerson() == person)
            .collect(Collectors.toList());
        if (contactsByPerson.isEmpty()) {
            return false;
        }
        message("This contact already exists do you still want to add it? (y/N)");
        return input("^([yY]|yes|YES)$", null) == null;
    }

    private static Person personHandler(String input) {
        String[] inputArray = input.split(" ");

        String name = String.join(" ", inputArray[0].split("-"));
        int cc = Integer.parseInt(inputArray[1]);
        String[] dateArray = inputArray[2].split("-");

        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        DateYMD date = new DateYMD(year, month, day);

        return new Person(name, cc, date);
    }

    private static int phoneHandler(String input) {
        return Integer.parseInt(input);
    }

    private static void updateContact() {
        message("Choose how you want to find\n");
        message("1 - Get contact by index\n");
        message("2 - Get contact by name\n");
        message("3 - Get contact by phone number\n");
        message("Your choice: ");
        String input = input("^[1-3]$", "Invalid Choice!");
        if (input == null) {
            return;
        }
        Contact contact = null;
        switch (input) {
            case "1":
                message("Index: ");
                int index = Integer.parseInt(
                    input("^[0-" + (contacts.size() - 1) + "]+$", "Invalid index!"));
                contact = getContactByIndex(index);
                if (contact == null) {
                    return;
                }
                break;
            case "2":
                message("Name: ");
                String name = input("^[a-zA-Z ]+$", "Invalid Name!");
                contact = getContactByName(name);
                if (contact == null) {
                    return;
                }
                break;
            case "3":
                message("Phone Number: ");
                int number = Integer.parseInt(input("^9[0-9]{8}$", "Invalid phone number!"));
                contact = getContactByNumber(number);
                if (contact == null) {
                    return;
                }
                break;
            default:
                System.out.println("no such option");
                return;

        }

        message("Choose what you want to update\n");
        message("1 - Phone number\n");
        message("2 - Email\n");
        message("Your choice: ");
        input = input("^[12]$", null);
        if (input == null) {
            return;
        }
        switch (input) {
            case "1":
                message("Enter new phone: ");
                String phoneInput = input("^9[0-9]{8}$", "Invalid Phone!");
                if (phoneInput == null) {
                    return;
                }
                int phone = Integer.parseInt(phoneInput);
                contact.setPhone(phone);
                break;

            case "2":
                message("Enter new email: ");
                String email = input(Contact.EMAIL_REGEX, "Invalid Email!");
                if (email == null) {
                    return;
                }
                contact.setEmail(email);
                break;

            default:
                message("invalid choice");
                break;
        }

    }

    private static Contact getContactByIndex(int index) {
        return contacts.get(index);
    }

    private static Contact getContactByName(String name) {
        List<Contact> contactsByName = contacts.stream()
            .filter(contact -> contact.getPerson().getName().equals(name))
            .collect(Collectors.toList());
        if (contactsByName.isEmpty()) {
            return null;
        }
        if (contactsByName.size() == 1) {
            return contactsByName.get(0);
        }

        message("Which of the following would you like to choose?\n");

        for (int i = 0; i < contactsByName.size(); i++) {
            message(i + " - " + contactsByName.get(i));
        }

        String input = input("^[0-" + (contactsByName.size() - 1) + "]$", "Not a contact!");
        if (input == null) {
            return null;
        }

        return contactsByName.get(Integer.parseInt(input));
    }

    private static Contact getContactByNumber(int number) {
        List<Contact> contactsByName = contacts.stream()
            .filter(contact -> contact.getPhone() == number)
            .collect(Collectors.toList());
        if (contactsByName.isEmpty()) {
            return null;
        }
        if (contactsByName.size() == 1) {
            return contactsByName.get(0);
        }

        message("Which of the following would you like to choose?\n");

        for (int i = 0; i < contactsByName.size(); i++) {
            message(i + " - " + contactsByName.get(i));
        }

        String input = input("^[0-" + (contactsByName.size() - 1) + "]", "Not a contact!");
        if (input == null) {
            return null;
        }

        return contactsByName.get(Integer.parseInt(input));
    }

    private static boolean contactsExists() {
        return !contacts.isEmpty();
    }
}
