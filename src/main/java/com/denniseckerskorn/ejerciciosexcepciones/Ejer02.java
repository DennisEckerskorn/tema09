package com.denniseckerskorn.ejerciciosexcepciones;

import com.denniseckerskorn.dynamicarray.GenericDynamicArray;

import java.util.Scanner;

public class Ejer02 {
    private GenericDynamicArray<Double> decimalNumberArray;

    public Ejer02() {
        int errorCounter = requestDecimalNumbers("Introduce 10 decimal numbers", 10);
        System.out.println(decimalNumberArray.toString());
        double maxDecimalValue = decimalNumberArray.getMaxValue();
        System.out.println("Max Value is: " + maxDecimalValue);
        System.out.println("Error counts: " + errorCounter);

    }

    /**
     * Method to read decimal numbers, where the quantity needs to be indicated.
     * Keeps track of the number of inputs made.
     * Counts how many exceptions have occurred.
     *
     * @param message  the message to display when prompting for input
     * @param quantity the number of decimal numbers to read
     * @return the number of exceptions that occurred during input
     */
    public int requestDecimalNumbers(String message, int quantity) {
        Scanner lector = new Scanner(System.in);
        decimalNumberArray = new GenericDynamicArray<>(quantity);
        double input = 0;
        int errorCount = 0;
        int numberCount = 0;
        boolean exit = false;
        do {
            try {
                System.out.println(message);
                input = Double.parseDouble(lector.nextLine());
                decimalNumberArray.add(input);
                numberCount++;
                if (numberCount == quantity) {
                    exit = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Only decimal numbers are allowed");
                errorCount++;
            }
        } while (!exit);
        lector.close();
        return errorCount;
    }
}
