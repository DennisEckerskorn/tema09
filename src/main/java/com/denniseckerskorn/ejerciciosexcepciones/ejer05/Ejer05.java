package com.denniseckerskorn.ejerciciosexcepciones.ejer05;

import com.denniseckerskorn.ejerciciosexcepciones.Ejer04;

import java.util.Arrays;
import java.util.Scanner;

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
        Scanner lector = new Scanner(System.in);
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Introduce el nombre:");
            String nombre = lector.nextLine();
            try {
                System.out.println("Introduce tu edad:");
                int edad = Integer.parseInt(lector.nextLine());
                System.out.println("Introduce tu altura:");
                float altura = Float.parseFloat(lector.nextLine());
                Alumno alumno = new Alumno(nombre, edad, altura);
                alumnos[i] = alumno;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se pueden ingresar números: ");
            }

        }
        lector.close();
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
