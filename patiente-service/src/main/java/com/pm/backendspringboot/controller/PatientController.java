package com.pm.backendspringboot.controller;


import com.pm.backendspringboot.dto.PatientDTO;
import com.pm.backendspringboot.dto.PatientDTOPartial;
import com.pm.backendspringboot.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * @description Returns a list of all patients, with only the necessary fields.
     * Including only id, firstName, lastName, email, and active for a more restricted/partial view of the patient.
     * @return ResponseEntity<List<PatientDTOPartial>>
     */
    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<List<PatientDTOPartial>> getAllPatients(){
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    /**
     * @description Returns a list of all patients, with all fields available.
     * @return ResponseEntity<List<PatientDTO>>
     */
    @GetMapping
    @RequestMapping("/all/full")
    public ResponseEntity<List<PatientDTO>> getAllPatientsFullInfo(){
        return ResponseEntity.ok().body(patientService.getAllPatientsFullInfo());
    }
}
