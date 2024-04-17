package com.denniseckerskorn;

import com.denniseckerskorn.ejerciciosexcepciones.*;
import com.denniseckerskorn.ejerciciosexcepciones.alumnos.Ejer11;
import com.denniseckerskorn.ejerciciosexcepciones.alumnos.Menu;
import com.denniseckerskorn.ejerciciosexcepciones.alumnos.SubMenu;
import com.denniseckerskorn.ejerciciosexcepciones.calculadora.IOCalc;
import com.denniseckerskorn.ejerciciosexcepciones.ejer05.Ejer05;
import com.denniseckerskorn.lib.LibIO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Ejer01 ejer01 = new Ejer01();
        //Ejer02 ejer02 = new Ejer02();
        //Ejer03 ejer03 = new Ejer03();
        //Ejer04 ejer04 = new Ejer04();
        //Ejer05 ejer05 = new Ejer05();
        //Ejer06 ejer06 = new Ejer06();
        //Ejer07 ejer07 = new Ejer07();
        //Ejer08 ejer08 = new Ejer08();
        //IOCalc ioCalc = new IOCalc();
        //Ejer11 ejer11 = new Ejer11();


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date minDate = null;
        Date maxDate = null;

        try {
            minDate = sdf.parse("18/05/1991");
            maxDate = sdf.parse("18/05/2024"); // Especifica la fecha máxima aquí
        } catch (ParseException e) {
            e.printStackTrace();
        }

// Llama al método solicitarFechaDate con los parámetros de fecha mínima y máxima
        Date selectedDate = LibIO.solicitarFechaDate("Fecha:", sdf, minDate, maxDate);

    }
}