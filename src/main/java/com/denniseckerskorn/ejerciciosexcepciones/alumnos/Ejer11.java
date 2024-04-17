package com.denniseckerskorn.ejerciciosexcepciones.alumnos;

public class Ejer11 {
    public Ejer11() {
        Menu menuPrincipal = new Menu("1. Nuevo Alumno ...", "2. Baja de alumno ...", "3. Consultas", "0. Salir");
        SubMenu subMenu = new SubMenu("1. Por grupo ...", "2. Por edad ...", "3. Por nia ...", "4. Por appellidos ...", "0. Volver a Menú Principal");
        menuPrincipal.mostrarMenuPrincipal(subMenu);
    }
}
