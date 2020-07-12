package me.assignment.mc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.assignment.mc.ConnectivityApplication;
import me.assignment.mc.service.ConnectivityService;

@RestController
public class ConnectivityController {
	
	private final static Logger logger = LoggerFactory.getLogger(ConnectivityController.class);
	
	@Autowired
	private ConnectivityService connectivityService;

	@GetMapping(value = "/")
	@ApiOperation(value = "This API is to get Swagger UI")
	public void swaggerHome(HttpServletResponse response) throws IOException {
		logger.info("swagger url triggered");
		response.sendRedirect("swagger-ui.html");
	}

	@GetMapping(value = "/connected")
	@ApiOperation(value = "This API helps to check if there is a connectivity between given origin and destination, returns yes if there is connectivity, false otherwise")
	public String isConnected(@ApiParam(value = "Origin city", required = true) @RequestParam("origin") String origin,
			@ApiParam(value = "Destination city", required = true) @RequestParam("destination") String destination) {
		logger.info("inside isConnected method - Controller");
		return connectivityService.isConnected(origin, destination);
	}

}
