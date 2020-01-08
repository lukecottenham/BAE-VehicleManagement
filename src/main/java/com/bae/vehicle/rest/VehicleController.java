package com.bae.vehicle.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bae.vehicle.persistence.domain.Vehicle;
import com.bae.vehicle.service.VehicleService;

@RestController
public class VehicleController {

	private VehicleService service;
	
	public VehicleController(VehicleService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@GetMapping("/vehicle")
	public List<Vehicle> getAllVehicles(){
		return service.getAllVehicles();
	}
	
//	@CrossOrigin
//	@GetMapping("/user/{user_id}/vehicle")
//	public List<Vehicle> getVehicleByUser(@PathVariable Long user_id){
//		System.out.println("user" + user_id);
//		return service.findByUserId(user_id);
//	}
	
	@CrossOrigin
	@PostMapping("/vehicle")
	public Vehicle addVehicle(@RequestBody Vehicle vehicleToAdd) {
		return service.addNewVehicle(vehicleToAdd);
	}
	
	@CrossOrigin
	@DeleteMapping("/vehicle/{id}")
	public String deleteVehicle(@PathVariable Long id) {
		return service.deleteVehicle(id);
	}
}
