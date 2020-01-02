package io.mk.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mk.model.Physician;
import io.mk.service.PhysicianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("physician")
@Api(value = "Physician controller")
public class PhysicianController {

	@Autowired
	private PhysicianService physicianService;

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Physician", response = Physician.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Physician") })
	public Physician getPhysician(@PathVariable(required = true) int id) {
		return physicianService.getPhysician(id);
	}

	@RequestMapping(value = "add", method = RequestMethod.PUT)
	@ApiOperation(value = "Add Physician", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added Physician") })
	public boolean addPhysician(@RequestBody Physician physician) {
		return physicianService.addPhysician(physician);
	}

	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Remove Physician", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully removed Physician") })
	public boolean removePhysician(@PathVariable(required = true) int id) {
		return physicianService.removePhysician(id);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ApiOperation(value = "update Physician", response = Physician.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated Physician") })
	public Physician updatePhysician(@RequestBody Physician physician) {
		return physicianService.updatePhysician(physician);
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ApiOperation(value = "List Physician", response = Collection.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Physicians") })
	public Collection<Physician> listPhysicians() {
		return physicianService.listPhysicians();
	}
}
