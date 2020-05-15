package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {
        // write your code here

//        scanner = new Scanner(System.in);
//        System.out.println("Enter the elements of array");
//        int noOfElements = scanner.nextInt();
//        int [] array = readIntegers(noOfElements);
//        System.out.println(findMin(array));

//        reverseArray(new int []{12,13,133,12,18});
//        ArrayList<Integer> intList = new ArrayList<>();
//        intList.add(3);
//        intList.add(4);
//        intList.add(5);
//        intList.add(6);


        printInstructions();
        boolean toOperate = true;
        while(toOperate) {
            System.out.println("\nPlease enter your choice");
             int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    mobilePhone.addContact();
                    break;

                case 2:
                    mobilePhone.deleteContact();
                    break;

                case 3:
                    mobilePhone.printContacts();
                    break;

                case 4:
                    mobilePhone.modifyContact();
                    break;

                case 5:
                    mobilePhone.searchContactByName();
                    break;

                case 6:
                    toOperate = false;
                    break;

            }
        }

    }

    private static void printInstructions(){
        System.out.println("Press 1 to add a contact.\n" +
                           "Press 2 to delete a contact.\n" +
                           "Press 3 to print all contacts.\n" +
                           "Press 4 to modify a contact.\n" +
                           "Press 5 to query a contact\n" +
                           "Press 6 to quit.");

    }

    private static void reverseArray(int[] array){
        int[] reversedArray = new int[array.length];

                for(int i =0;i<array.length;i++){
                    reversedArray[i] = array[array.length - i - 1];//12,13,17,2,9
                }
                System.out.println("The actual array is " + Arrays.toString(array));
                System.out.println("The reversed array is " + Arrays.toString(reversedArray));

    }

    private static int[] sortDescendingArray(int[] array){
        int[] sortArray = new int[5];
        int l =0;
        for(int i =0;i<array.length;i++){
            int max =0;
                for (int j=l; j < array.length; l++) {
                    if (array[j] > max) {
                        max = array[j];
                        sortArray[i] = max;   //12,3,5,7,18
                    }

            }
            l++;
        }


        return sortArray;
    }

    private static int findMin(int[] array){
    int min = array[0];
    boolean continueLoop = true;
    while(continueLoop){
        continueLoop = false;
        for(int i =0;i<array.length;i++){
            if(array[i] <= min){
                min = array[i];//12,34,9,13,6
            }
        }

    }
        return min;
    }


    private static int[] readIntegers(int elementsOfArray){
        int[] array = new int[elementsOfArray];
        System.out.println("Enter the "+ elementsOfArray +" numbers :"+"\n");
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static void printArray (int[] array){
        for(int i =0;i<array.length;i++){
            System.out.println("Element" + i +  " is " + array[i]);
        }
    }
}
