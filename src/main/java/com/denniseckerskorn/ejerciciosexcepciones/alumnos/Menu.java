package com.denniseckerskorn.ejerciciosexcepciones.alumnos;

import com.denniseckerskorn.lib.LibIO;

public class Menu {
    private final String textoMenu1;
    private final String textoMenu2;
    private final String textoMenu3;
    private final String textoMenu4;
    private final String textoMenu5;

    public Menu(String textoMenu1, String textoMenu2, String textoMenu3, String textoMenu4) {
        this.textoMenu1 = textoMenu1;
        this.textoMenu2 = textoMenu2;
        this.textoMenu3 = textoMenu3;
        this.textoMenu4 = textoMenu4;
        this.textoMenu5 = null;
    }

    public void mostrarMenuPrincipal(SubMenu subMenu) {
        Grupo grupo1 = new Grupo("Todos los Alumnos", Config.MAX_ALUMNOS); //Se crean los 40 alumnos
        boolean salir = false;
        int opcion = -1;
        do{
            //test
            System.out.println(grupo1);
            System.out.println("GESTIÓN ALUMNOS");
            System.out.println(textoMenu1);
            System.out.println(textoMenu2);
            System.out.println(textoMenu3);
            System.out.println(textoMenu4);
            if(textoMenu5 != null) {
                System.out.println(textoMenu5);
            }
            opcion = LibIO.requestInt("Introduce una opción", 0, 3);
            switch(opcion) {
                case 1: // NUEVO ALUMNO
                    crearAlumno(grupo1);
                    break;
                case 2: // BAJA ALUMNO
                    break;
                case 3: // CONSULTAS
                    subMenu.mostrarSubMenu(this);
                    break;
                case 0: // SALIR
                    salir = true;
                    System.out.println("Hasta Pronto ...");
                    break;
                default:
                    break;
            }
        }while(!salir);
    }

    private void crearAlumno(Grupo grupo1) {
        int nia;
        String nombre;
        String apellido;
        String fechaNacimiento;
        String grupo;
        int numTelefono;
        //Validacion NIA: Falta implementar que no se pueda repetir
        nia = LibIO.requestInt("Ingresa el NIA del alumno:", 1000000, 9999999);
        //Validacion nombre
        nombre = LibIO.requestString("Ingresa el nombre del alumno", 0, 15);
        //Validacion apellido
        apellido = LibIO.requestString("Ingresa el apellido del alumno", 0, 15);
        //Validacion fecha nacimiento
        fechaNacimiento = LibIO.requestString("Ingresa la fecha de nacimiento del alumno en formato: XX-XX-XXXX", 8, 10);
        //Validacion grupo
        grupo = LibIO.requestString("Ingresa el nombre del grupo", 6, 7);
        //Validacion numero telefono
        numTelefono = LibIO.requestInt("Ingresa el número de telefono del alumno", 100000000,999999999);

        grupo1.crearAlumnoManual(nia, nombre, apellido, fechaNacimiento, grupo, numTelefono);
        System.out.println(grupo1);
    }
}