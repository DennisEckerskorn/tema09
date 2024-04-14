package com.denniseckerskorn.ejerciciosexcepciones;

public class Ejer07 {
    public Ejer07() {

        String[] arrayCadenas = {"Hola", "Esto", "Es", "Una", "prueba"};
        String resultado = mostrarCadenasArray(arrayCadenas);
        System.out.println(resultado);
    }

    /**
     * Método que devuelve un String con los primeros carácteres de la cadena de cada posicion del Array de Strings
     *
     * @param array de String[]
     * @return devuelve un StringBuilder con los carácteres de la primera posición de la cadena.
     */
    public String mostrarCadenasArray(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                sb.append(array[i].charAt(0));
            }
        }
        return sb.toString();
    }
}
