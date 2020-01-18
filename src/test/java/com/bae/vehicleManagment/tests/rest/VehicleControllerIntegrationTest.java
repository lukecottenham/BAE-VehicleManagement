package com.bae.vehicleManagment.tests.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.persistence.domain.Vehicle;
import com.bae.persistence.repo.VehicleRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerIntegrationTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private VehicleRepo repo;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private Vehicle newVehicle;

	private Vehicle testVehicleWithID;

	@Before
	public void init() {
		this.repo.deleteAll();

		this.newVehicle = new Vehicle(id, "BMW", "x5", "12-12-2019", "12-12-2019", "12-12-2019");
		this.testVehicleWithID = this.repo.save(this.newVehicle);
		this.id = this.testVehicleWithID.getId();
	}

	@Test
	public void testCreateVehicle() throws Exception {
		String result = this.mock
				.perform(request(HttpMethod.POST, "/vehicle").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newVehicle)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(testVehicleWithID), result);
	}

	@Test
	public void testDeleteVehicle() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/vehicle/" + this.id)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllVehicles() throws Exception {
		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(this.testVehicleWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/vehicle").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(vehicleList), content);
	}

	@Test
	public void testUpdateVehicle() throws Exception {
		Vehicle newVehicle = new Vehicle(id, "Kawazaki", "z10", "12-1-2019", "2-12-2019", "12-4-2019");
		Vehicle updatedVehicle = new Vehicle(id, newVehicle.getMake(), newVehicle.getModel(), newVehicle.getTaxDate(), newVehicle.getMotDate(), newVehicle.getInsuranceDate());
		updatedVehicle.setId(this.id);

		String result = this.mock
				.perform(request(HttpMethod.PATCH, "/updateVehicle/" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newVehicle)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(updatedVehicle), result);
	}

}