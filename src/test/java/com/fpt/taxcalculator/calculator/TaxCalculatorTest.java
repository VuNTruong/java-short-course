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

    private static final double STANDARD_RATE = 0.1;
    private static final double ABOVE_30_RATE = 0.2;
    private static final double ABOVE_50_RATE = 0.3;
    private static final double DELTA = 0.001;

    @BeforeEach
    void setUp() throws IOException {
        Tax level1Tax = new Tax();
        level1Tax.setRate(0.1);

        Tax level2Tax = new Tax();
        level2Tax.setRate(0.2);

        Tax level3Tax = new Tax();
        level3Tax.setRate(0.3);

        when(taxService.findByLevel("level 1")).thenReturn(level1Tax);
        when(taxService.findByLevel("level 2")).thenReturn(level2Tax);
        when(taxService.findByLevel("level 3")).thenReturn(level3Tax);
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

//    @Test
//    void calculate_WhenIncomeBetween30And50_ShouldApplyAbove30Rate() throws IOException {
//        // Arrange
//        User user = new User();
//        user.setIncome(40.0);
//        when(userFetching.findByUserId(1L)).thenReturn(user);
//
//        // Act
//        double result = taxCalculator.calculate(1L);
//
//        // Assert
//        assertEquals(8.0, result, DELTA);
//        verify(userFetching, times(1)).findByUserId(1L);
//    }
//
//    @Test
//    void calculate_WhenIncomeAbove50_ShouldApplyAbove50Rate() throws IOException {
//        // Arrange
//        User user = new User();
//        user.setIncome(60.0);
//        when(userFetching.findByUserId(1L)).thenReturn(user);
//
//        // Act
//        double result = taxCalculator.calculate(1L);
//
//        // Assert
//        assertEquals(18.0, result, DELTA);
//        verify(userFetching, times(1)).findByUserId(1L);
//    }
//
//    @Test
//    void calculate_WhenUserRepositoryThrowsIOException_ShouldPropagateException() throws IOException {
//        // Arrange
//        when(userFetching.findByUserId(1L)).thenThrow(new IOException("Database error"));
//
//        // Act & Assert
//        assertThrows(IOException.class, () -> taxCalculator.calculate(1L));
//        verify(userFetching, times(1)).findByUserId(1L);
//    }
//
//    @Test
//    void calculate_WhenUserNotFound_ShouldPropagateException() throws IOException {
//        // Arrange
//        when(userFetching.findByUserId(1L)).thenThrow(new IllegalArgumentException());
//
//        // Act & Assert
//        assertThrows(IllegalArgumentException.class, () -> taxCalculator.calculate(1L));
//        verify(userFetching, times(1)).findByUserId(1L);
//    }
}
