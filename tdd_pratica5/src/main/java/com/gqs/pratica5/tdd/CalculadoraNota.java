package com.gqs.pratica5.tdd;

public class CalculadoraNota {
    private static final double VALOR_MAXIMO_A1 = 30.0;
    private static final double VALOR_MAXIMO_A2 = 30.0;    
    private static final double VALOR_MAXIMO_A3 = 40.0;
    private static final double FREQUENCIA_MINIMA = 75.0;

    public double calcularNotaFinal(double a1, double a2, double a3) {
        validarNota(a1, VALOR_MAXIMO_A1, "A1");
        validarNota(a2, VALOR_MAXIMO_A2, "A2");
        validarNota(a3, VALOR_MAXIMO_A3,"A3");

        return a1 + a2 + a3;
    }

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0 || nota > notaMaxima) {
            throw new IllegalArgumentException(nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
        }
    }

    public String situacao(double notaFinal, double frequencia) {
        if (notaFinal >= 70.0 && frequencia >= FREQUENCIA_MINIMA) {
            return "APROVADO";
        }
        return "REPROVADO";
    }
}