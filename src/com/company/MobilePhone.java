package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private ArrayList<Contact> contactList;

    public MobilePhone() {
        contactList = new ArrayList<Contact>();
    }

    public void addContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter contact name");
        String name = scanner.nextLine();
        System.out.println("Please enter contact number");
        int number = scanner.nextInt();
        Contact contact = new Contact(name,number);
        contactList.add(contact);
        System.out.println("Contact add " + contactList.toString());
        scanner.close();
    }

    public void printContacts(){
        int i = 1;
        for(Contact contact : contactList){
            System.out.println(i + ": Name = " + contact.getContactName() + " Phone Number = "+ contact.getPhoneNumber());
            i++;

        }
    }

    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter contact name to update.");
        String contactName = scanner.nextLine();
        int index = -1;
        if (findContact(contactName) == 1) {
            for (Contact contact : contactList) {
                if(contact.getContactName().equals(contactName)){
                    contactList.remove(contact);
                    System.out.println("This contact has been deleted.");
                    return;
                }
            }
            System.out.println("This contact was not found");
            scanner.close();


        }
    }

    public void modifyContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter contact name that you wish to modify.");
        String contactName = scanner.nextLine();

        if (findContact(contactName)==1) {
            System.out.println("Press 1 to change contact name\n" +
                    "Press 2 to change contact phone number\n" +
                    "Press 3 to change both\n" +
                    "Press 4 to quit.");


            if (scanner.hasNextInt()) {
                int selectedOption = scanner.nextInt();
                scanner.nextLine();
                switch (selectedOption) {
                    case 1:
                        System.out.println("Please specify a new Contact Name");
                        if(scanner.hasNextLine()) {
                            String newName = scanner.nextLine();
                            int index = loopContact(contactName);
                            Contact contact = contactList.get(index);
                            contact.setContactName(newName);

                        }
                        else{
                            System.out.println("Incorrect Name Specified.");
                        }
                        findContact(contactName);

                        break;

                    case 2:
                        System.out.println("Please specify a new Contact Phone Number");
                        if(scanner.hasNextInt()) {
                            int newNumber = scanner.nextInt();
                            scanner.nextLine();
                            int index = loopContact(contactName);
                            Contact contact = contactList.get(index);
                            contact.setPhoneNumber(newNumber);

                        }
                        else{
                            System.out.println("Incorrect Name Specified.");
                        }
                        findContact(contactName);

                        break;


                    case 3:

                        System.out.println("Please specify a new Contact Name");
                        if(scanner.hasNextLine()) {
                            String newName = scanner.nextLine();
                            int index = loopContact(contactName);
                            Contact contact = contactList.get(index);
                            contact.setContactName(newName);
                        }

                        else{
                            modifyContact();
                        }

                            System.out.println("Please specify a new phone number");
                            if(scanner.hasNextInt()) {
                                int newNumber1 = scanner.nextInt();
                                scanner.nextLine();
                                int index1 = loopContact(contactName);
                                Contact contact1 = contactList.get(index1);
                                contact1.setPhoneNumber(newNumber1);

                            }


                        else{
                            System.out.println("Incorrect number Specified.");
                        }
                        findContact(contactName);
                        break;

                    case 4:
                        return;
                }
            }
            else {
                System.out.println("Invalid option selected!\n" +
                        "Press 1 to retry \n" +
                        "Press 2 to quit.");

                if (scanner.hasNextInt()) {
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    switch (scanner.nextInt()) {
                        case 1:
                            modifyContact();
                            break;

                        case 2:
                            System.out.println("Quitting.");
                            break;


                    }
                }
                else{
                    scanner.close();
                    return;
                }
            }

            scanner.close();
        }

    }

    public void searchContactByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter contact name to search.");
        String contactName = scanner.nextLine();
        if(findContact(contactName)==1){
            System.out.println("Contact found. Contact details follow");
            int index = loopContact(contactName);
            Contact contact = contactList.get(index);
            System.out.println("Name : " + contact.getContactName() + " Phone Number " + contact.getContactName() );
        }

        else{
            System.out.println("No such contact has been found.");
        }
        scanner.close();
    }

    public int loopContact(String contactName){
        for(Contact contact : contactList){
            if(contact.searchContact(contactName)){
                int index = contactList.indexOf(contact);
                return index;

            }
        }

        return -1;
    }
    private void replaceName(String oldName,String newName){
        int index = contactList.indexOf(oldName);

    }

    private int findContact(String contactName){

        for(Contact contact : contactList){
            if(contact.searchContact(contactName)){
                return 1;
            }
        }
        return -1;
    }



}
