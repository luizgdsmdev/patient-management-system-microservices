package com.pm.backendspringboot.controller;


import com.pm.backendspringboot.dto.PatientRequestDTO;
import com.pm.backendspringboot.dto.PatientResponseDto;
import com.pm.backendspringboot.dto.PatientResponseDTOPartial;
import com.pm.backendspringboot.service.PatientService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
     * @return ResponseEntity<List<PatientResponseDTOPartial>>
     */
    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<List<PatientResponseDTOPartial>> getAllPatients(){
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    /**
     * @description Returns a list of all patients, with all fields available.
     * @return ResponseEntity<List<PatientResponseDto>>
     */
    @GetMapping
    @RequestMapping("/all/full")
    public ResponseEntity<List<PatientResponseDto>> getAllPatientsFullInfo(){
        return ResponseEntity.ok().body(patientService.getAllPatientsFullInfo());
    }

    /**
     * @description Returns a single patient, with all fields available.
     * @PathVariable id
     * @return ResponseEntity<PatientResponseDto>
     */
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getSinglePatient(@PathVariable UUID id) throws BadRequestException {
        return ResponseEntity.ok().body(patientService.getSinglePatient(id));
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> insertPatient(
            @Valid
            @RequestBody PatientRequestDTO patientRequestDTO
    ){
        return ResponseEntity.ok().body(patientService.insertPatient(patientRequestDTO));
    }
}
