package com.denniseckerskorn.ejerciciosexcepciones.ejer05;

import java.util.Objects;

public class Alumno {
    private String nombre;
    private int edad;
    private float altura;

    public Alumno(String nombre, int edad, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (edad != alumno.edad) return false;
        if (Float.compare(altura, alumno.altura) != 0) return false;
        return Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + edad;
        result = 31 * result + (altura != 0.0f ? Float.floatToIntBits(altura) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }
}
