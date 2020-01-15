package com.bae.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long>{

}
