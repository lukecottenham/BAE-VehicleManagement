package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.User;
import com.bae.persistence.domain.Vehicle;
import com.bae.service.VehicleService;

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
	
	@CrossOrigin
	@GetMapping("/getVehicle/{id}")
	public Vehicle getVehicle(@PathVariable Long id) {
		return this.service.findVehicleById(id);
	}
	
	@CrossOrigin
	@PostMapping("/vehicle")
	public Vehicle addVehicle(@RequestBody Vehicle vehicleToAdd) {
		return service.addNewVehicle(vehicleToAdd);
	}
	
	@CrossOrigin
	@PatchMapping("/updateVehicle/{id}")
	public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
		return this.service.updateVehicle(vehicle, id);
	}
	
	@CrossOrigin
	@DeleteMapping("/vehicle/{id}")
	public String deleteVehicle(@PathVariable Long id) {
		return service.deleteVehicle(id);
	}
}
