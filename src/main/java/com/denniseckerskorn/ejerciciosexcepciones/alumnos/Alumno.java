package com.denniseckerskorn.ejerciciosexcepciones.alumnos;

import java.util.Objects;

public class Alumno {
    //private static long autoincrement = 0;
    private final int nia; //Convertir a String, posibilidad de desbordamiento
    private final String nombre;
    private final String apellido;
    private final String fechaNacimiento;
    private final String grupo;
    private final int numTelefono; //Convertir a String, posibilidad de desbordamiento

    public Alumno(int nia, String nombre, String apellido, String fechaNacimiento, String grupo, int numTelefono) {
        this.nia = nia; //String.format("%07d", ++autoincrement); otro constructor
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.grupo = grupo;
        this.numTelefono = numTelefono;
    }

    //get de todo, menos autoincrement

    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getNumTelefono() {
        return numTelefono;
    }


    //equals y hash solo del nia ya que es como una clave primaria
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (nia != alumno.nia) return false;
        if (numTelefono != alumno.numTelefono) return false;
        if (!Objects.equals(nombre, alumno.nombre)) return false;
        if (!Objects.equals(apellido, alumno.apellido)) return false;
        if (!Objects.equals(fechaNacimiento, alumno.fechaNacimiento))
            return false;
        return Objects.equals(grupo, alumno.grupo);
    }

    @Override
    public int hashCode() {
        int result = nia;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + numTelefono;
        return result;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
                "nia=" + nia +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", grupo='" + grupo + '\'' +
                ", numTelefono=" + numTelefono +
                '}' + "\n";
    }
}
