package com.example.insuranceapp.repository;

import com.example.insuranceapp.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
