package com.denniseckerskorn.ejerciciosexcepciones;

import com.denniseckerskorn.ejerciciosexcepciones.ejer09.PersonalizedArithmeticException;
import com.denniseckerskorn.ejerciciosexcepciones.ejer09.PersonalizedIndexOutOfBoundsException;
import com.denniseckerskorn.ejerciciosexcepciones.ejer09.PersonalizedNullPointerException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ejer08 {
    public Ejer08() {
        try {
            int[] array = {0, 1, 4, 6, 7, 0};
            int[] result = dividir(2, array);
            System.out.println(Arrays.toString(result));
        } catch (PersonalizedArithmeticException ae) {
            System.out.println("No se puede dividir entre 0");
            System.out.println("Excepción ha sido tratada");
            System.out.println("Se ha producido la excepción " + ae.getMessage());
        }

        try {
            String[] arrayCadenas = {"Prueba", null, "Otra", "Prueba", null};
            String resultado = cadenas(arrayCadenas);
            System.out.println(resultado);
        } catch (PersonalizedNullPointerException npe) {
            System.out.println("No puede haber posiciones del array nulas");
            System.out.println("Excepción ha sido tratada");
            System.out.println("Se ha producido la excepcion " + npe.getMessage());
        }

        try {
            int[] arrayTooBig = {1, 2, 3, 4, 5, 6};
            int[] resultadoTooBig = arrays(arrayTooBig);
            System.out.println(Arrays.toString(resultadoTooBig));
        } catch (PersonalizedIndexOutOfBoundsException ioobe) {
            System.out.println("El array está fuera de limite");
            System.out.println("Excepción ha sido tratada");
            System.out.println("Se ha producido la excepción: " + ioobe.getMessage());
        }

    }

    public int[] dividir(int num, int[] array) throws PersonalizedArithmeticException {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            try {
                result[i] = num / array[i];
            } catch (ArithmeticException ae) {
                throw new PersonalizedArithmeticException("Se ha dividido por 0");
            }
        }
        return result;
    }

    public String cadenas(String[] array) throws PersonalizedNullPointerException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            try {
                sb.append(array[i].charAt(0));

            } catch (NullPointerException npe) {
                throw new PersonalizedNullPointerException("Hay una posicion nula en el el array");
            }
        }
        return sb.toString();
    }

    public int[] arrays(int[] array) throws PersonalizedIndexOutOfBoundsException {
        int[] resultado = new int[5];

        for (int i = 0; i < array.length; i++) {
            try {
                resultado[i] = array[i];

            } catch (IndexOutOfBoundsException ioobe) {
                throw new PersonalizedIndexOutOfBoundsException("El array está fuera de rango");
            }
        }
        return resultado;
    }
}
