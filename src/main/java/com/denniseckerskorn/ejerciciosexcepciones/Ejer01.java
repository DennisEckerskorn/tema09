package com.denniseckerskorn.ejerciciosexcepciones;

import com.denniseckerskorn.dynamicarray.GenericDynamicArray;

import java.util.Scanner;

public class Ejer01 {
    private Scanner lector;
    private GenericDynamicArray<Integer> arrayNumbers;
    private GenericDynamicArray<Integer> testArray;

    public Ejer01() {
        testArray = new GenericDynamicArray<>();
        testArray = requestNumbers("Introduce numeros:");
        System.out.println(testArray.toString());
    }

    public GenericDynamicArray<Integer> requestNumbers(String message) {
        lector = new Scanner(System.in);
        arrayNumbers = new GenericDynamicArray<>();
        boolean exit = false;
        int input = 0;
        do {
            System.out.println(message);
            try {
                input = Integer.parseInt(lector.nextLine());
                if (input >= 0) {
                    arrayNumbers.add(input);
                } else {
                    exit = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo números positivos");
            }
        } while (!exit);

        return arrayNumbers;
    }
}
