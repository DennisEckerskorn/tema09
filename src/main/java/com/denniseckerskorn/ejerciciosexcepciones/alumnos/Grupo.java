package com.denniseckerskorn.ejerciciosexcepciones.alumnos;

import net.datafaker.Faker;

import java.util.*;

public class Grupo {
    //Solo haria falta un array de Alumnos (cambiar nombre de clase), nombre y numAlumnos
    private Alumno[] alumnos;
    private final String nombreGrupo;
    private int numAlumnos;

    //Constructor con el que se crean los grupos para los alumnos
    public Grupo(String nombreGrupo, int cantidadAlumnos) {
        this.alumnos = new Alumno[Config.MAX_ALUMNOS];
        this.nombreGrupo = nombreGrupo;
        numAlumnos = 0;
        crearAlumnoAutomatico(cantidadAlumnos);
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public Alumno crearAlumnoManual(int nia, String nombre, String apellido, String fechaNacimiento, String grupo, int numTelefono) {
        try {
            if (numAlumnos == alumnos.length) {
                // Incrementar el tamaño del array
                duplicarArray();
            }
            Alumno alumno = new Alumno(nia, nombre, apellido, fechaNacimiento, grupo, numTelefono);
            alumnos[numAlumnos] = alumno;
            numAlumnos++;
            return alumno;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el alumno" + e.getMessage());
            return null;
        }
    }

    private void duplicarArray() {
        Alumno[] arrayAmpliado = new Alumno[alumnos.length * 2];
        for (int i = 0; i < alumnos.length; i++) {
            arrayAmpliado[i] = alumnos[i];
        }
        alumnos = arrayAmpliado; //Array apunta al puntero de arrayAmpliado, array original dejara de existir ya que nada apunta al puntero.
    }

    //Eliminar alumno
    public boolean bajaAlumno(int nia) {
        try {
            for (int i = 0; i < alumnos.length; i++) {
                int posicion = buscarPosicionAlumnoPorNia(nia);
                if (posicion >= 0) {
                    alumnos[posicion] = alumnos[numAlumnos - 1];
                    alumnos[numAlumnos - 1] = null;
                    numAlumnos--;
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Error al dar de baja al alumno" + aioobe.getMessage());
            return false;
        }

    }

    public Alumno buscarAlumnoPorNia(int nia) {
        try {
            int posicion = buscarPosicionAlumnoPorNia(nia);
            if (posicion >= 0) {
                return alumnos[posicion];
            }
            return null;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Error al buscar al Alumno" + aioobe.getMessage());
            return null;
        }

    }

    public int buscarPosicionAlumnoPorNia(int nia) {
        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].getNia() == (nia)) {
                return i;
            }
        }
        return -1;
    }

    public Alumno[] buscarAlumnosPorGrupo(String grupo) {
        int contador = 0;
        Alumno[] result = null;
        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].getGrupo().equals(grupo)) {
                contador++;
            }
        }
        if (contador > 0) {
            result = new Alumno[contador];
            contador = 0;
            for (int i = 0; i < numAlumnos; i++) {
                if (alumnos[i].getGrupo().equals(grupo)) {
                    result[contador++] = alumnos[i];
                }
            }
        }
        return result;
    }

    public Alumno[] buscarAlumnosPorApellidos(String apellido) {
        int contador = 0;
        Alumno[] result = null;
        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].getApellido().startsWith(apellido)) {
                contador++;
            }
        }
        if (contador > 0) {
            result = new Alumno[contador];
            contador = 0;
            for (int i = 0; i < numAlumnos; i++) {
                if (alumnos[i].getApellido().startsWith(apellido)) {
                    result[contador++] = alumnos[i];
                }
            }
        }
        return result;
    }

    public void crearAlumnoAutomatico(int cantidadAlumnos) {
        Faker faker = new Faker(new Locale("es", "ES"));
        Random rnd = new Random();
        for (int i = 0; i < cantidadAlumnos; i++) {
            int nia;
            String nombre;
            String apellido;
            String fechaNacimiento;
            String grupo;
            int numTelefono;
            do {
                nia = 1000000 + rnd.nextInt(9000000);
            } while (existeNIA(nia));
            nombre = faker.name().firstName();
            apellido = faker.name().lastName();
            fechaNacimiento = faker.date().birthday(8, 40).toString();
            grupo = "Grupo" + (i % Config.MAX_GRUPOS + 1);
            numTelefono = faker.number().numberBetween(600000000, 699999999);
            alumnos[numAlumnos++] = new Alumno(nia, nombre, apellido, fechaNacimiento, grupo, numTelefono);
        }
    }

    private boolean existeNIA(int nia) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getNia() == nia) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grupo grupo = (Grupo) o;

        if (numAlumnos != grupo.numAlumnos) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(alumnos, grupo.alumnos)) return false;
        return Objects.equals(nombreGrupo, grupo.nombreGrupo);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(alumnos);
        result = 31 * result + (nombreGrupo != null ? nombreGrupo.hashCode() : 0);
        result = 31 * result + numAlumnos;
        return result;
    }

    @Override
    public String toString() {
        return "Grupos{" +
                "alumnos=\n" + Arrays.toString(alumnos) +
                ", nombreGrupo='" + nombreGrupo + '\'' +
                ", numAlumnos=" + numAlumnos +
                '}';
    }
}

