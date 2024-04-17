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
        iteraciones = 50;

        for (int i = 0; i < iteraciones; i++) {
            double numeroUno = LibRandom.randomDouble(0, 500);
            double numeroDos = LibRandom.randomDouble(0, 500);
            int numDecimal = LibRandom.randomInt(0, 500);
            String binaryNum = generarNumBinario(6);
            String numHexa = generarNumHexadecimal(3);

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
                        System.out.println("Multiplicacion");
                        double resultadoMultiplicación = calculadora.multiplicacion(numeroUno, numeroDos);
                        System.out.println(numeroUno + " * " + numeroDos + " = " + resultadoMultiplicación);
                        break;
                    case 5:
                        System.out.println("Resto de División");
                        double resultRestDiv = calculadora.restoDivision(numeroUno, numeroDos);
                        System.out.println(numeroUno + " % " + numeroDos + " = " + resultRestDiv);
                        break;
                    case 6:
                        System.out.println("Decimal a Binario");
                        String numBinario = calculadora.decimalToBinary(numDecimal);
                        System.out.println("El numero " + numDecimal + " en binario es: " + numBinario);
                        break;
                    case 7:
                        System.out.println("Binario a Decimal");
                        int numDecimalConverted = calculadora.binaryToDecimal(binaryNum);
                        System.out.println("El número binario : " + binaryNum + " es: " + numDecimalConverted + " en decimal");
                        break;
                    case 8:
                        System.out.println("Decimal a Hexadecimal");
                        String resultHexa = calculadora.decimalToHexadecimal(numDecimal);
                        System.out.println("El número " + numDecimal + " en hexadecimal es: " + resultHexa);
                        break;
                    case 9:
                        System.out.println("Hexadecimal a Decimal");
                        int numHexaConvertido = calculadora.hexadecimalToDecimal(numHexa);
                        System.out.println("El número hexadecimal: " + numHexa + " en decimal es: " + numHexaConvertido);
                        break;
                    case 10:
                        System.out.println("Binario a Hexadecimal");
                        String resHexa = calculadora.binarioHexadecimal(binaryNum);
                        System.out.println("El número binario " + binaryNum + " es hexadecimal es: " + resHexa);
                        break;
                    case 11:
                        System.out.println("Hexadecimal a Binario");
                        String binaryConverted = calculadora.hexadecimalBinario(numHexa);
                        System.out.println("El número hexadecimal " + numHexa + " en binario es " + binaryConverted);
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

    /**
     * Crea un numero binario de 0 y 1 de las posiciones indicadas.
     *
     * @param numPosiciones int
     * @return String con el número binario
     */
    private String generarNumBinario(int numPosiciones) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numPosiciones; i++) {
            sb.append(LibRandom.randomInt(0, 1));
        }
        return sb.toString();
    }

    //TODO 17/04: Hexadecimal genera una excepción, arreglar fallo...

    /**
     * Crea un número HexaDecimal aleatorio de las posiciones indicadas.
     *
     * @param numPosiciones int
     * @returnString con el número hexadecimal
     */
    private String generarNumHexadecimal(int numPosiciones) {
        StringBuilder sb = new StringBuilder();
        String hexaCaracters = "0123456789ABCDEF";
        for (int i = 0; i < numPosiciones; i++) {
            int index = rnd.nextInt(hexaCaracters.length());
            char digit = hexaCaracters.charAt(index);
            sb.append(digit);
        }
        return sb.toString();
    }

}
