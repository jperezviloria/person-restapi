package com.home.core.controller;

import com.home.core.model.Doctor;
import com.home.core.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }

    @PostMapping
    public String saveDoctor(@RequestBody Doctor doctor){
        doctorRepository.save(doctor);
        return "completed saved";
    }

}
