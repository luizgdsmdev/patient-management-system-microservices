package com.pm.backendspringboot.mapper;

import com.pm.backendspringboot.dto.PatientRequestDTO;
import com.pm.backendspringboot.dto.PatientResponseDTOPartial;
import com.pm.backendspringboot.dto.PatientResponseDto;
import com.pm.backendspringboot.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    /**
     * @description Maps a partial Patient entity to a response PatientResponseDto, listing only the necessary fields.
     * Including only id, firstName, lastName, email, and active.
     * @param patient entity
     * @return PatientResponseDTOPartial
     */
    public static PatientResponseDTOPartial toPartialPatientDTO(Patient patient){
        PatientResponseDTOPartial PatientResponseDTOPartial = new PatientResponseDTOPartial();

        PatientResponseDTOPartial.setId(patient.getId().toString());
        PatientResponseDTOPartial.setFirstName(patient.getFirstName());
        PatientResponseDTOPartial.setLastName(patient.getLastName());
        PatientResponseDTOPartial.setEmail(patient.getEmail());
        PatientResponseDTOPartial.setActive(patient.getActive().toString());

        return PatientResponseDTOPartial;
    }

    /**
     * @description Maps a complete Patient entity to PatientResponseDto, all fields included.
     * @param patient entity
     * @return PatientResponseDto
     */
    public static PatientResponseDto toPatientDTO(Patient patient){
        PatientResponseDto patientResponseDto = new PatientResponseDto();

        patientResponseDto.setId(patient.getId().toString());
        patientResponseDto.setFirstName(patient.getFirstName());
        patientResponseDto.setLastName(patient.getLastName());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setActive(patient.getActive().toString());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setBirthDate(patient.getBirthDate().toString());
        patientResponseDto.setRegistrationDate(patient.getRegistrationDate().toString());
        patientResponseDto.setLastUpdate(patient.getLastUpdate().toString());


        return patientResponseDto;
    }

    public static Patient toPatientEntity(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();

        patient.setFirstName(patientRequestDTO.getFirstName());
        patient.setLastName(patientRequestDTO.getLastName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setBirthDate(LocalDate.parse(patientRequestDTO.getBirthDate()));
        patient.setActive(patientRequestDTO.getActive());
        patient.setRegistrationDate(LocalDate.now());
        patient.setLastUpdate(LocalDate.now());

        return patient;
    }
}
