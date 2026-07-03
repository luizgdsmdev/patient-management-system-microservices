package com.pm.backendspringboot.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jfr.BooleanFlag;

import java.time.LocalDate;

public class PatientRequestDTO {

    @NotEmpty(message = "First name cannot be empty")
    @Size(max = 30, min = 1, message = "First name must be between 1 and 30 characters")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(max = 30, min = 1, message = "Last name must be between 1 and 30 characters")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email must be valid")
    @Size(max = 60, min = 1, message = "Email must be between 1 and 60 characters")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Address cannot be empty")
    @Size(max = 120, min = 1, message = "Address must be between 1 and 120 characters")
    private String address;

    @NotNull(message = "Birth date cannot be empty")
    @NotEmpty(message = "Birth date cannot be empty")
    private String birthDate;

    @NotNull(message = "Active cannot be empty")
    private boolean active;

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
