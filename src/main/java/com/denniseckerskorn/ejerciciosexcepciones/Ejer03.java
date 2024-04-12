package com.denniseckerskorn.ejerciciosexcepciones;

import com.denniseckerskorn.dynamicarray.GenericDynamicArray;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Ejer03 {
    private GenericDynamicArray<Double> data;

    public Ejer03() {
        try {
            requestNumbersIntoArray("Please introduce numbers");
            if (data != null && data.size() != 0) {
                double maxValue = 0;
                maxValue = data.getMaxValue();
                System.out.println("Max Value: " + maxValue);
            } else {
                System.out.println("No numbers were provided");
            }
        } catch (NullPointerException npe) {
            System.out.println("Input can't be empty, please introduce a number.");

        }
    }

    public void requestNumbersIntoArray(String message) {
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        data = new GenericDynamicArray<>(); //Inicializar array fuera del metodo.
        double input = 0;

        do {
            try {
                System.out.println(message);
                input = Double.parseDouble(lector.nextLine());
                data.add(input);
            } catch (NumberFormatException nfe) {
                System.out.println("Only numbers can be introduced...Exit");
                exit = true;
            }
        } while (!exit);
    }
}
