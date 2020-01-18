package com.bae.vehicleManagment.tests.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bae.persistence.domain.Vehicle;
import com.bae.rest.VehicleController;
import com.bae.service.VehicleService;

@RunWith(MockitoJUnitRunner.class)
public class VehicleControllerUnitTest {

	@InjectMocks
	private VehicleController controller;

	@Mock
	private VehicleService service;

	private List<Vehicle> vehicleList;

	private Vehicle testVehicle;

	private Vehicle testVehicleWithID;

	final long id = 1L;
	
	@Before
	public void init() {
		this.vehicleList = new ArrayList<>();
		this.vehicleList.add(testVehicle);
		this.testVehicle = new Vehicle(id, "BMW", "x5", "12-12-2019", "12-12-2019", "12-12-2019");
		this.testVehicleWithID = new Vehicle(id, testVehicle.getMake(), testVehicle.getModel(), testVehicle.getTaxDate(), testVehicle.getMotDate(), testVehicle.getInsuranceDate());
		this.testVehicleWithID.setId(id);
	}

	@Test
	public void createVehicleTest() {
		when(this.service.addNewVehicle(testVehicle)).thenReturn(testVehicleWithID);

		assertEquals(this.testVehicleWithID, this.controller.addVehicle(testVehicle));

		verify(this.service, times(1)).addNewVehicle(this.testVehicle);
	}

	@Test
	public void deleteVehicleTest() {
		this.controller.deleteVehicle(id);

		verify(this.service, times(1)).deleteVehicle(id);
	}

	@Test
	public void findVehicleByIDTest() {
		when(this.service.findVehicleById(this.id)).thenReturn(this.testVehicleWithID);

		assertEquals(this.testVehicleWithID, this.controller.getVehicle(this.id));

		verify(this.service, times(1)).findVehicleById(this.id);
	}

	@Test
	public void getAllVehiclesTest() {

		when(service.getAllVehicles()).thenReturn(this.vehicleList);

		assertFalse("Controller has found no vehicles", this.controller.getAllVehicles().isEmpty());

		verify(service, times(1)).getAllVehicles();
	}

	@Test
	public void updateVehiclesTest() {
		// given
		Vehicle newVehicle = new Vehicle(id, "Kawasaki", "Z1000", "10-10-2019", "10-10-2019", "10-10-2019");
		Vehicle updatedVehicle = new Vehicle(id, newVehicle.getMake(), newVehicle.getModel(), newVehicle.getTaxDate(), newVehicle.getMotDate(), newVehicle.getInsuranceDate());
		updatedVehicle.setId(this.id);

		when(this.service.updateVehicle(newVehicle, this.id)).thenReturn(updatedVehicle);

		assertEquals(updatedVehicle, this.controller.updateVehicle(this.id, newVehicle));

		verify(this.service, times(1)).updateVehicle(newVehicle, this.id);
	}

}