package com.bae.vehicle.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.vehicle.persistence.domain.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long>{

}
