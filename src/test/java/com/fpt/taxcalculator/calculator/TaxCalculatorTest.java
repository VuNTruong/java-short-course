package com.fpt.taxcalculator.calculator;

import com.fpt.taxcalculator.model.Tax;
import com.fpt.taxcalculator.model.User;
import com.fpt.taxcalculator.service.TaxCalculator;
import com.fpt.taxcalculator.service.TaxService;
import com.fpt.taxcalculator.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaxCalculatorTest {
    @Mock
    private UserService userService;

    @Mock
    private TaxService taxService;

    @InjectMocks
    private TaxCalculator taxCalculator;

    @BeforeEach
    void setUp() throws IOException {
        Tax level1Tax = new Tax();
        level1Tax.setRate(0.1);

        Tax level2Tax = new Tax();
        level2Tax.setRate(0.2);

        Tax level3Tax = new Tax();
        level3Tax.setRate(0.3);

        when(taxService.findByLevel(anyString())).thenAnswer(invocation -> {
            String level = invocation.getArgument(0);
            return switch (level) {
                case "level 1" -> level1Tax;
                case "level 2" -> level2Tax;
                case "level 3" -> level3Tax;
                default -> null;
            };
        });
    }

    @Test
    void calculate_WhenIncomeBelowOrEqual30_ShouldApplyStandardRate() throws IOException {
        // Arrange
        User user = new User();
        user.setIncome(30.0);
        when(userService.findById(1L)).thenReturn(user);

        // Act
        double result = taxCalculator.calculate(1L);

        // Assert
        assertEquals(3.0, result);
    }


    @Test
    void calculate_WhenIncomeBetween30And50_ShouldApplyAbove30Rate() throws IOException {
        // Arrange
        User user = new User();
        user.setIncome(40.0);
        when(userService.findById(1L)).thenReturn(user);

        // Act
        double result = taxCalculator.calculate(1L);

        // Assert
        assertEquals(8.0, result);
    }

    @Test
    void calculate_WhenIncomeAbove50_ShouldApplyAbove50Rate() throws IOException {
        // Arrange
        User user = new User();
        user.setIncome(60.0);
        when(userService.findById(1L)).thenReturn(user);

        // Act
        double result = taxCalculator.calculate(1L);

        // Assert
        assertEquals(18.0, result);
    }
}
