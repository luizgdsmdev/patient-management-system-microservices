package com.pm.backendspringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @description Patient entity, containing all fields with validation annotations.
 */
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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

    @NotNull(message = "Birth date cannot be null")
    private LocalDate birthDate;

    @NotNull(message = "Active cannot be null")
    private Boolean active;

    @NotNull(message = "Registration date cannot be null")
    @CreationTimestamp
    private LocalDate registrationDate;

    @NotNull(message = "Last update cannot be null")
    @UpdateTimestamp
    private LocalDate lastUpdate;

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
