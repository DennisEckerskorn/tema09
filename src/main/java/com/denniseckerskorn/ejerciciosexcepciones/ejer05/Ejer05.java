package com.denniseckerskorn.ejerciciosexcepciones.ejer05;

import com.denniseckerskorn.lib.LibIO;
import java.util.Arrays;

public class Ejer05 {
    private Alumno[] alumnos;

    public Ejer05() {
        alumnos = new Alumno[2];
        solicitarDatosAlumno(alumnos);
        System.out.println(Arrays.toString(alumnos));
        int edadMax = getEdadMax();
        System.out.println("Edad Máxima" + edadMax);
    }

    public void solicitarDatosAlumno(Alumno[] alumnos) {
        for (int i = 0; i < alumnos.length; i++) {
            String nombre = LibIO.requestString("Introduce el nombre", 3, 20);
            int edad = LibIO.requestInt("Introduce tu edad", 1, 50);
            float altura = LibIO.requestFloat("Introduce tu altura:");
            Alumno alumno = new Alumno(nombre, edad, altura);
            alumnos[i] = alumno;
        }
    }

    public int getEdadMax() {
        int edad = 0;
        for (int i = 0; i < alumnos.length; i++) {
            edad = alumnos[0].getEdad();
            if (alumnos[i].getEdad() > edad) {
                edad = alumnos[i].getEdad();
            }
        }
        return edad;
    }
}
