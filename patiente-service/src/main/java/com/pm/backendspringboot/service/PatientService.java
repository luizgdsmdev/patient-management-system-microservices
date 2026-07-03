package com.pm.backendspringboot.service;


import com.pm.backendspringboot.dto.PatientDTO;
import com.pm.backendspringboot.dto.PatientDTOPartial;
import com.pm.backendspringboot.mapper.PatientMapper;
import com.pm.backendspringboot.model.Patient;
import com.pm.backendspringboot.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    /**
     * @description Returns a list of all patients, with only the necessary fields.
     * Including only id, firstName, lastName, email, and active for a more restricted/partial view of the patient.
     * @return List<PatientDTOPartial>
     */
    public List<PatientDTOPartial> getAllPatients(){
        List<Patient> patientList = patientRepository.findAll();

        return patientList.stream().map(PatientMapper::toPartialPatientDTO).toList();
    }


    /**
     * @description Returns a list of all patients, with all fields available.
     * @return List<PatientDTO>
     */
    public List<PatientDTO> getAllPatientsFullInfo(){
        List<Patient> patientList = patientRepository.findAll();

        return patientList.stream().map(PatientMapper::toPatientDTO).toList();
    }



}
