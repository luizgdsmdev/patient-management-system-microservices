package com.pm.backendspringboot.mapper;

import com.pm.backendspringboot.dto.PatientDTO;
import com.pm.backendspringboot.dto.PatientDTOPartial;
import com.pm.backendspringboot.model.Patient;

public class PatientMapper {

    /**
     * @description Maps a partial Patient entity to a response PatientDTO, listing only the necessary fields.
     * Including only id, firstName, lastName, email, and active.
     * @param patient entity
     * @return PatientDTOPartial
     */
    public static PatientDTOPartial toPartialPatientDTO(Patient patient){
        PatientDTOPartial PatientDTOPartial = new PatientDTOPartial();
        PatientDTOPartial.setId(patient.getId().toString());
        PatientDTOPartial.setFirstName(patient.getFirstName());
        PatientDTOPartial.setLastName(patient.getLastName());
        PatientDTOPartial.setEmail(patient.getEmail());
        PatientDTOPartial.setActive(patient.getActive().toString());

        return PatientDTOPartial;
    }

    /**
     * @description Maps a complete Patient entity to PatientDTO, all fields included.
     * @param patient entity
     * @return PatientDTO
     */
    public static PatientDTO toPatientDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId(patient.getId().toString());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setActive(patient.getActive().toString());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setBirthDate(patient.getBirthDate().toString());
        patientDTO.setRegistrationDate(patient.getRegistrationDate().toString());
        patientDTO.setLastUpdate(patient.getLastUpdate().toString());


        return patientDTO;
    }
}
