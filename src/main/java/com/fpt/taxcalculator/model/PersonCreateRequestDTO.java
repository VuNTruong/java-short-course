package com.fpt.taxcalculator.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class PersonCreateRequestDTO {
    private Long id;

    @NotNull(message = "First name field cannot be null")
    private String firstName;

    @NotNull(message = "Last name field cannot be null")
    private String lastName;

    @Size(min = 2, max = 10, message = "Tax code should have between 2 and 10 character")
    private String taxCode;

    @Positive
    private double income;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
