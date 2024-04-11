package com.denniseckerskorn.ejerciciosexcepciones;

import com.denniseckerskorn.dynamicarray.GenericDynamicArray;

import java.util.Scanner;

public class Ejer03 {
    private GenericDynamicArray<Double> data;

    public Ejer03() {
        requestNumbersIntoArray("Please introduce numbers");
        double maxValue = data.getMaxValue();
        System.out.println("Max Value: " + maxValue);

    }

    public void requestNumbersIntoArray(String message) {
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        data = new GenericDynamicArray<>();
        double input = 0;

        do {
            try {
                System.out.println(message);
                input = Double.parseDouble(lector.nextLine());
                data.add(input);
            } catch (NullPointerException npe) {
                System.out.println("Input can't be empty, please introduce a number.");
            } catch (NumberFormatException nfe) {
                System.out.println("Sorry, only numbers... Exit");
                exit = true;
            }
        } while (!exit);
    }
}
