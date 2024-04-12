package com.denniseckerskorn.ejerciciosexcepciones;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer04 {
    public Ejer04() {
        int[] numbers = new int[5];
        readNumbersIntoArray("Please introduce a number", numbers);

        int[] numbersNull = null;

        readNumbersIntoArray("Please introduce numbers", numbersNull);
    }

    public void readNumbersIntoArray(String message, int[] array) {
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        int currentIndex = 0;

        do {
            try {
                System.out.println(message);
                array[currentIndex] = Integer.parseInt(lector.nextLine());
                currentIndex++;
            } catch (NumberFormatException nfe) {
                System.out.println("Only numbers are allowed");
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("Array has reached max capacity");
                exit = true;
                System.out.println(Arrays.toString(array));
            } catch (NullPointerException npe) {
                System.out.println("Array isn't initialized");
                exit = true;
            }
        } while (!exit);
        lector.close();
    }
}
