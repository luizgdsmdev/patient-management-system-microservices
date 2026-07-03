package com.pm.backendspringboot.dto;

/**
 * @description DTO for Patient entity, containing only the necessary fields.
 * Including only id, firstName, lastName, email, and active.
 * This is used for a more restricted view of the patient. For a complete view, use the PatientResponseDto class.
 */
public class PatientResponseDTOPartial {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

}
