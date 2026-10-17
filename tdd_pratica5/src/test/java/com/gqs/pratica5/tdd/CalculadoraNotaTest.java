package com.gqs.pratica5.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {
    @Test
    void deveRejeitarA1MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
            () -> calc.calcularNotaFinal(35, 20, 30));
    }

    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
        CalculadoraNota calc = new CalculadoraNota();
        String situacao = calc.situacao(80, 90);
        assertEquals("APROVADO", situacao);
    }

    @Test
    void deveReprovarComNotaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        String situacao = calc.situacao(60, 90);
        assertEquals("REPROVADO", situacao);
    }

    @Test
    void deveReprovarPorFrequenciaMesmoComNotaAlta() {
        CalculadoraNota calc = new CalculadoraNota();
        String situacao = calc.situacao(95, 74);
        assertEquals("REPROVADO", situacao);
    }

    @Test
    void deveAprovarComFrequenciaExatamente75() {
        CalculadoraNota calc = new CalculadoraNota();
        String situacao = calc.situacao(70, 75);
        assertEquals("APROVADO", situacao);
    }
}
