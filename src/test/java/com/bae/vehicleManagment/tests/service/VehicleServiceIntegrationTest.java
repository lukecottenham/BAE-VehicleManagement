package com.bae.vehicleManagment.tests.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Vehicle;
import com.bae.persistence.repo.VehicleRepo;
import com.bae.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleServiceIntegrationTest {

	

		@Autowired
		private VehicleService service;

		@Autowired
		private VehicleRepo repo;

		private Vehicle newVehicle;

		private Vehicle testVehicleWithID;

		@Before
		public void init() {
			this.newVehicle = new Vehicle(null, "BMW", "x5", "12-12-2019", "12-12-2019", "12-12-2019");
			
			this.repo.deleteAll();

			this.testVehicleWithID = this.repo.save(this.newVehicle);
		}
		
		@Test
		public void testCreateVehicle() {
			assertEquals(this.testVehicleWithID, this.service.addNewVehicle(newVehicle));
		}

		@Test
		public void testDeleteVehicle() {
			assertThat(this.service.deleteVehicle(this.testVehicleWithID.getId()));
		}

		@Test
		public void testFindVehicleByID() {
			assertThat(this.service.findVehicleById(this.testVehicleWithID.getId())).isEqualTo(this.testVehicleWithID);
		}

		@Test
		public void testReadVehicles() {
			assertThat(this.service.getAllVehicles()).isEqualTo(Arrays.asList(new Vehicle[] { this.testVehicleWithID }));
		}

		@Test
		public void testUpdateVehicle() {
			Vehicle newVehicle = new Vehicle(null, "Kawazaki", "z10", "12-1-2019", "2-12-2019", "12-2-2019");
			Vehicle updatedUser = new Vehicle(newVehicle.getId(), newVehicle.getMake(), newVehicle.getModel(), newVehicle.getTaxDate(), newVehicle.getMotDate(), newVehicle.getInsuranceDate());
			updatedUser.setId(this.testVehicleWithID.getId());

			assertThat(this.service.updateVehicle(newVehicle, this.testVehicleWithID.getId())).isEqualTo(updatedUser);
		}

	
}
