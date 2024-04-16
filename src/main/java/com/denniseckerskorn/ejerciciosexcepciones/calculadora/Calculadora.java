package com.denniseckerskorn.ejerciciosexcepciones.calculadora;

public class Calculadora {
    private final double numeroUno;
    private final double numeroDos;

    public Calculadora(double numeroUno, double numeroDos) {
        this.numeroUno = numeroUno;
        this.numeroDos = numeroDos;
    }

    //Suma, resta, multiplicar, dividir, restoDivision

    public double suma(double numeroUno, double numeroDos) {
        return numeroUno + numeroDos;
    }

    public double resta(double numeroUno, double numeroDos) {
        return numeroUno - numeroDos;
    }

    //DecimalBinario
    //BinarioDecimal
    //DecimalHexadecimal
    //HexadecimalDecimal
    //BinarioHexadecimal
    //HexadecimalBinario
}
