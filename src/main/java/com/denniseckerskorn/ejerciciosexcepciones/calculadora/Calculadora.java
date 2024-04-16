package com.denniseckerskorn.ejerciciosexcepciones.calculadora;

public class Calculadora {

    public Calculadora() {

    }

    /**
     * SUMA:
     * Recibe dos parámetros y los suma.
     *
     * @param numeroUno double
     * @param numeroDos double
     * @return suma de los dos parámetros.
     */
    public double suma(double numeroUno, double numeroDos) {
        return numeroUno + numeroDos;
    }

    /**
     * RESTA:
     * Recibe dos parámetros y los resta.
     *
     * @param numeroUno double
     * @param numeroDos double
     * @return resta de los dos parámetros.
     */
    public double resta(double numeroUno, double numeroDos) {
        return numeroUno - numeroDos;
    }

    /**
     * DIVISIÓN:
     * Recibe dos parámetros y los divide.
     * Si el segundo número es 0, se devuelve NEGATIVE_INFINITY.
     * No se puede dividir entre 0
     *
     * @param numeroUno double
     * @param numeroDos double
     * @return división de los dos parámetros, si num2 = 0 return NEGATIVE_INFINITY
     */
    public double division(double numeroUno, double numeroDos) throws ArithmeticException{
        if (numeroDos == 0) {
            throw new ArithmeticException(("No se puede dividir por cero"));
        }
        return numeroUno / numeroDos;

    }

    /**
     * MULTIPLICACIÓN:
     * Recibe dos parámetros y los multiplica.
     *
     * @param num1 double
     * @param num2 double
     * @return multiplicación de los dos parámetros.
     */
    public double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * RESTO DE DIVISIÓN:
     * Recibe dos parámetros y saca el residuo de los dos.
     * No se puede dividir entre 0, si num2 = 0 return NEGATVIVE_INFINITY
     *
     * @param num1 double
     * @param num2 double
     * @return residuo de la división de los dos parámetros.
     */
    public double restoDivision(double num1, double num2) throws ArithmeticException{
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return num1 % num2;
    }

    /**
     * CONVERTIR NÚMERO DECIMAL ENTERO A BINARIO
     * Convierte un número entero decimal a binario.
     * Si el decimal es 0, devuelve un 0.
     * Después de la conversión da la vuelta al número binario para ordenarlo correctamente.
     *
     * @param decimal int
     * @return String número binario
     */
    public String decimalToBinary(int decimal) throws IllegalArgumentException{
        if (decimal < 0) {
            throw new IllegalArgumentException("El número decimal debe ser mayor o igual a cero");
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        if (decimal == 0) {
            return "0";
        }

        for (int i = decimal; i > 0; i /= 2) {
            int resto = i % 2;
            sb.append(resto);
        }

        for (int i = sb.length() - 1; i >= 0; i--) {
            sb1.append(sb.charAt(i));
        }

        return sb1.toString();
    }

    /**
     * CONVERTIR NÚMERO BINARIO A NUMERO DECIMAL ENTERO
     * Convierte un numero binario a decimal
     *
     * @param binario String
     * @return número convertido a decimal.
     */
    public int binaryToDecimal(String binario) throws IllegalArgumentException{
        if (!binario.matches("[01]+")) {
            throw new IllegalArgumentException("Entrada binaria inválida");
        }

        int decimal = 0;
        int power = 0;
        for (int i = binario.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(binario.charAt(i));
            decimal += digit * Math.pow(2, power);
            power++;
        }
        return decimal;
    }

    /**
     * CONVERTIR DECIMAL A HEXADECIMAL
     * Recibe el número decimal entero como aprámetro y convierte el número a Hexadecimal.
     *
     * @param decimal int
     * @return número hexadecimal convertido
     */
    public String decimalToHexadecimal(int decimal) throws IllegalArgumentException {
        if (decimal < 0) {
            throw new IllegalArgumentException("El número decimal debe ser mayor o igual a cero");
        }
        StringBuilder sb = new StringBuilder();
        String caracterHexa = "0123456789ABCDEF";

        if (decimal == 0) {
            return "0";
        }

        for (int i = decimal; i > 0; i /= 16) {
            int resto = i % 16;
            sb.append(caracterHexa.charAt(resto));
        }
        return sb.toString();

    }

    /**
     * HEXADECIMAL A DECIMAL
     * Convierte un numero hexadecimal a un número decimal
     *
     * @param num String
     * @return número decimal convertido como String
     */
    public int hexadecimalToDecimal(String num) throws IllegalArgumentException{
        if (!num.matches("[0-0A-Fa-f]+")) {
            throw new IllegalArgumentException("Entrada hexadecimal inválida");
        }
        int resultado = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            char digito = Character.toUpperCase(num.charAt(i));
            int valor = Character.isDigit(digito) ? (digito - '0') : (digito - 'A' + 10);
            resultado += valor * Math.pow(16, num.length() - 1 - i);
        }
        return resultado;
    }

    /**
     * BINARIO A HEXADECIMAL
     * Convierte el numero Binario a hexadecimal usando método anteriores.
     *
     * @param numBinario String
     * @return String con el resultado en hexadecimal
     */
    public String binarioHexadecimal(String numBinario) {
        StringBuilder result = new StringBuilder();
        int binarioDecimal = binaryToDecimal(numBinario);
        String decimalToHexa = decimalToHexadecimal(binarioDecimal);
        result.append(decimalToHexa);
        return result.toString();
    }

    /**
     * HEXADECIMAL A BINARIO
     * Convierte el numero hexadecimal a binario haciendo uso de metodos anteriores
     *
     * @param numHexa String
     * @return String con el resultado en binario.
     */
    public String hexadecimalBinario(String numHexa) {
        StringBuilder result = new StringBuilder();
        int hexaToDecimal = hexadecimalToDecimal(numHexa);
        String decimalToBinario = decimalToBinary(hexaToDecimal);
        result.append(decimalToBinario);
        return result.toString();
    }

}
