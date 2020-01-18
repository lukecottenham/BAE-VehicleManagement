package com.bae.vehicleManagment.tests.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Vehicle;
import com.bae.persistence.repo.VehicleRepo;
import com.bae.service.VehicleService;

@RunWith(SpringRunner.class)
public class VehicleServiceUnitTest {

	@InjectMocks
	private VehicleService service;

	@Mock
	private VehicleRepo repo;

	private List<Vehicle> vehicleList;

	private Vehicle testVehicle;

	private Vehicle testVehicleWithID;

	final long id = 1L;
	


	@Test
	public void createVehicleTest() {
		when(this.repo.save(testVehicle)).thenReturn(testVehicleWithID);

		assertEquals(this.testVehicleWithID, this.service.addNewVehicle(testVehicle));

		verify(this.repo, times(1)).save(this.testVehicle);
	}

	@Test
	public void deleteVehicleTest() {
		when(this.repo.existsById(id)).thenReturn(true, false);

		this.service.deleteVehicle(id);

		verify(this.repo, times(1)).deleteById(id);
//		verify(this.repo, times(2)).existsById(id);
	}

	@Test
	public void findVehicleByIDTest() {
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testVehicleWithID));

		assertEquals(this.testVehicleWithID, this.service.findVehicleById(this.id));

		verify(this.repo, times(1)).findById(this.id);
	}

	@Test
	public void readVehiclesTest() {

		when(repo.findAll()).thenReturn(this.vehicleList);

		assertFalse("Controller has found no vehicles", this.service.getAllVehicles().isEmpty());

//		verify(repo, times(1)).findAll();
	}

	@Test
	public void updateVehicleTest() {
		Vehicle newVehicle = new Vehicle(id, "Kawazaki", "z10", "12-1-2019", "2-12-2019", "12-2-2019");
		
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testVehicleWithID));

		Vehicle updatedVehicle = new Vehicle(id, newVehicle.getMake(), newVehicle.getModel(), newVehicle.getTaxDate(), newVehicle.getMotDate(), newVehicle.getInsuranceDate());
		updatedVehicle.setId(this.id);

		when(this.repo.save(updatedVehicle)).thenReturn(updatedVehicle);

		assertEquals(updatedVehicle, this.service.updateVehicle(newVehicle, this.id));

		verify(this.repo, times(1)).findById(1L);
		verify(this.repo, times(1)).save(updatedVehicle);
	}
	
	@Before
	public void init() {
		this.vehicleList = new ArrayList<>();
		this.vehicleList.add(testVehicle);
		this.testVehicle = new Vehicle(id, "BMW", "x5", "12-12-2019", "12-12-2019", "12-12-2019");
		this.testVehicleWithID = new Vehicle(id, testVehicle.getMake(), testVehicle.getModel(), testVehicle.getTaxDate(), testVehicle.getMotDate(), testVehicle.getInsuranceDate());
		this.testVehicleWithID.setId(id);
	}

}