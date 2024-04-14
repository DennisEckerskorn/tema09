package com.denniseckerskorn.ejerciciosexcepciones;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ejer08 {
    public Ejer08() {
        try {
            int[] array = {0, 1, 4, 6, 7, 0};
            int[] result = dividir(2, array);
            System.out.println(Arrays.toString(result));

        } catch (ArithmeticException ae) {
            System.out.println("No se puede dividir entre 0");
            System.out.println("Excepción ha sido tratada");
        }

        try {
            String[] arrayCadenas = {"Prueba", null, "Otra", "Prueba", null};
            String resultado = cadenas(arrayCadenas);
            System.out.println(resultado);

        } catch (NullPointerException npe) {
            System.out.println("No puede haber posiciones del array nulas");
            System.out.println("Excepción ha sido tratada");
        }

        try {
            int[] arrayTooBig = {1, 2, 3, 4, 5, 6};
            int[] resultadoTooBig = arrays(arrayTooBig);
            System.out.println(Arrays.toString(resultadoTooBig));

        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("El array está fuera de limite");
            System.out.println("Excepción ha sido tratada");
        }

    }

    public int[] dividir(int num, int[] array) throws ArithmeticException {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = num / array[i];
        }
        return result;
    }

    public String cadenas(String[] array) throws NullPointerException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i].charAt(0));
        }
        return sb.toString();
    }

    public int[] arrays(int[] array) throws IndexOutOfBoundsException {
        int[] resultado = new int[5];

        for (int i = 0; i < array.length; i++) {
            resultado[i] = array[i];
        }
        return resultado;
    }
}
