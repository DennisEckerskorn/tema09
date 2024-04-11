package com.denniseckerskorn.ejerciciosexcepciones;

import com.denniseckerskorn.dynamicarray.GenericDynamicArray;

import java.util.Scanner;

public class Ejer02 {
    private Scanner lector;
    private GenericDynamicArray<Double> decimalNumberArray;
    public Ejer02() {
        requestDecimalNumbers("Introduce 10 decimal numbers", 10);
        decimalNumberArray.toString();

    }
    public void requestDecimalNumbers(String message, int quantity) {
        lector = new Scanner(System.in);
        decimalNumberArray = new GenericDynamicArray<>(quantity);
        double input = 0;
        int errorCount = 0;
        //Falta sacar el maximo de los numeros. Metodo
        for(int i = 0; i <= quantity; i++) {
            try{
                input = Double.parseDouble(lector.nextLine());
                decimalNumberArray.add(input);
            } catch (NumberFormatException nfe) {
                System.out.println("You can only introduce numbers");
                errorCount++;
            }
        }
    }
}
