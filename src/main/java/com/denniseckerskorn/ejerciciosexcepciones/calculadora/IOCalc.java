package com.denniseckerskorn.ejerciciosexcepciones.calculadora;

import com.denniseckerskorn.lib.LibRandom;

import java.util.Random;

public class IOCalc {
    private Calculadora calculadora;
    private Random rnd;
    private int iteraciones;

    public IOCalc() {
        calculadora = new Calculadora();
        rnd = new Random();
        iteraciones = 10;

        for (int i = 0; i < iteraciones; i++) {
            double numeroUno = LibRandom.randomDouble(0, 500);
            double numeroDos = LibRandom.randomDouble(0, 500);

            int opcion = rnd.nextInt(12); //Faltan opciones totales

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Suma:");
                        double resultSuma = calculadora.suma(numeroUno, numeroDos);
                        System.out.println(numeroUno + " + " + numeroDos + " = " + resultSuma);
                        break;
                    case 2:
                        System.out.println("Resta:");
                        double resultResta = calculadora.resta(numeroUno, numeroDos);
                        System.out.println(numeroUno + " - " + numeroDos + " = " + resultResta);
                        break;
                    case 3:
                        System.out.println("División:");
                        double resultDivision = calculadora.division(numeroUno, numeroDos);
                        System.out.println(numeroUno + " / " + numeroDos + " = " + resultDivision);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error aritmético" + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error de argumento" + e.getMessage());
            }
        }

    }

}
