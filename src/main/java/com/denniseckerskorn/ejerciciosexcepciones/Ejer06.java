package com.denniseckerskorn.ejerciciosexcepciones;

import java.util.Arrays;

public class Ejer06 {
    public Ejer06() {
        int[] array = {-2, -1, 0, 1, 2};

        int[] arrayResult = dividirEntreArrayV3(2, array);

        System.out.println(Arrays.toString(arrayResult));

    }

    public int[] dividirEntreArray(int num, int[] array) {
        int[] resultadoDivision = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            resultadoDivision[i] = num / array[i];
        }

        return resultadoDivision;
    }

    public int[] dividirEntreArrayV2(int num, int[] array) {
        int[] resultadoDivision = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            try {
                resultadoDivision[i] = num / array[i];

            } catch (ArithmeticException ae) {
                System.out.println("0 no puede ser dividido por 0");
            }
        }
        return resultadoDivision;
    }

    public int[] dividirEntreArrayV3(int num, int[] array) {
        int[] resultadoDivision = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                resultadoDivision[i] = num / array[i];
            } else {
                resultadoDivision[i] = 0;
            }
        }
        return resultadoDivision;
    }
}
