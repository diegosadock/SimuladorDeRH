package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto() {
        BonusService bonus = new BonusService();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonus.calcularBonus(new Funcionario("Rodrigo Sousa", LocalDate.now(), new BigDecimal("25000"))));

    }

    @Test
    void bonusDeveriaSer10PorcentoDoSalario() {
        BonusService bonus = new BonusService();
        BigDecimal calcularBonus = bonus.calcularBonus(new Funcionario("Mauricio Pinheiro", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), calcularBonus);
    }

    @Test
    void bonusDeveriaSer10PorcentoParaSalarioDeExatamente10MilReais() {
        BonusService bonus = new BonusService();
        BigDecimal calcularBonus = bonus.calcularBonus(new Funcionario("Mauricio Pinheiro", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), calcularBonus);
    }
}