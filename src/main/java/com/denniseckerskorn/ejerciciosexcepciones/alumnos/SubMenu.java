package com.denniseckerskorn.ejerciciosexcepciones.alumnos;

import com.denniseckerskorn.lib.LibIO;

import java.util.Scanner;

public class SubMenu {
    private final String textoMenu1;
    private final String textoMenu2;
    private final String textoMenu3;
    private final String textoMenu4;
    private final String textoMenu5;

    public SubMenu(String textoMenu1, String textoMenu2, String textoMenu3, String textoMenu4, String textoMenu5) {
        this.textoMenu1 = textoMenu1;
        this.textoMenu2 = textoMenu2;
        this.textoMenu3 = textoMenu3;
        this.textoMenu4 = textoMenu4;
        this.textoMenu5 = textoMenu5;
    }

    public void mostrarSubMenu(Menu subMenu) {
        boolean volverMenuPrincipal = false;
        int opcion = 0;
        do{
            System.out.println("CONSULTAS");
            System.out.println(textoMenu1);
            System.out.println(textoMenu2);
            System.out.println(textoMenu3);
            System.out.println(textoMenu4);
            System.out.println(textoMenu5);
            opcion = LibIO.requestInt("Introduce una opción", 0, 4);
            switch(opcion) {
                case 1: // Por Grupo
                    break;
                case 2: //Por Edad
                    break;
                case 3: // Por Nia
                    break;
                case 4: // Por appellidos
                    break;
                case 0: //VOLVER A MENU PRINCIPAL
                    volverMenuPrincipal = true;
                    break;
                default:
                    break;
            }
        }while(!volverMenuPrincipal);
    }
}
