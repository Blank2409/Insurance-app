package com.example.insuranceapp.service;

import com.example.insuranceapp.model.Insurance;
import com.example.insuranceapp.repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<Insurance> getAllInsurances() {
        return insuranceRepository.findAll();
    }

    public Insurance getInsuranceById(Long id) {
        return insuranceRepository.findById(id).orElse(null);
    }

    public void save(Insurance insurance) {
        insuranceRepository.save(insurance);
    }
    public void deleteById(Long id) {
        insuranceRepository.deleteById(id);
    }
    
}
