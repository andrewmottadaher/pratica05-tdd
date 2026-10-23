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

    @Test
    void devePermitirAIPorSomaA2EA3SuficienteENotaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        // A1=10, A2=20, A3=30, Frequência=80 -> Nota final = 60 (< 70), A2 + A3 = 50 (>= 40)
        assertTrue(calc.podeFazerAI(10, 20, 30, 80));
    }

    @Test
    void devePermitirAIPorSomaA1EA3ExatamenteNoLimite() {
        CalculadoraNota calc = new CalculadoraNota();
        // A1=10, A2=5, A3=30, Frequência=80 -> Nota final = 45 (< 70), A1 + A3 = 40 (exatamente no limite)
        assertTrue(calc.podeFazerAI(10, 5, 30, 80));
    }

    @Test
    void naoDevePermitirAISeJaFoiAprovado() {
        CalculadoraNota calc = new CalculadoraNota();
        // A1=25, A2=25, A3=30, Frequência=80 -> Nota final = 80 (>= 70): já foi aprovado
        assertFalse(calc.podeFazerAI(25, 25, 30, 80));
    }

    @Test
    void naoDevePermitirAIPorFrequenciaAbaixoDoMinimo() {
        CalculadoraNota calc = new CalculadoraNota();
        // A1=10, A2=20, A3=30, Frequência=70 -> Frequência abaixo de 75
        assertFalse(calc.podeFazerAI(10, 20, 30, 70));
    }

    @Test
    void naoDevePermitirAIPorSomasInsuficientes() {
        CalculadoraNota calc = new CalculadoraNota();
        // A1=5, A2=5, A3=30, Frequência=80 -> A1 + A3 = 35 e A2 + A3 = 35 (ambas < 40)
        assertFalse(calc.podeFazerAI(5, 5, 30, 80));
    }

    @Test
    void deveSubstituirA1QuandoForMenorQueA2() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(75.0, calc.aplicarAI(10, 20, 30, 25));
    }
    
    @Test
    void deveSubstituirA2QuandoForMenorQueA1() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(75.0, calc.aplicarAI(20, 10, 30, 25));
    }
    
    @Test
    void naoDeveAlterarNotasQuandoAIForMenorQueAmbas() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(60.0, calc.aplicarAI(10, 20, 30, 5));
    }
    
    @Test
    void naoDeveAlterarNotasQuandoAIForIgualAMenorNota() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(60.0, calc.aplicarAI(10, 20, 30, 10));
    }
    
    @Test
    void deveAceitarNotaAIZero() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(60.0, calc.aplicarAI(10, 20, 30, 0));
    }
    
    @Test
    void deveAceitarNotaAIMaxima() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(80.0, calc.aplicarAI(10, 20, 30, 30));
    }
    
    @Test
    void deveRejeitarNotaAIMaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
            () -> calc.aplicarAI(10, 20, 30, 31));
    }

    @Test
    void deveRejeitarNotaAINegativa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
            () -> calc.aplicarAI(10, 20, 30, -1));
    }
}