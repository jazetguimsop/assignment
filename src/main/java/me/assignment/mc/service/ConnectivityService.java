package me.assignment.mc.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConnectivityService {
	
	private final static Logger logger = LoggerFactory.getLogger(ConnectivityService.class);

	@Autowired
	@Qualifier("mapping")
	public Map<String, String> mapping;

	public String isConnected(String origin, String dest) {
		logger.info("inside isConnected method - Service");
		Map<String, String> connections = mapping;
		String startingPoint = origin;
		while (connections.containsKey(startingPoint)) {
			startingPoint = connections.get(startingPoint);
			if (startingPoint.equals(dest)) {
				return "yes";
			}
		}
		return "no";
	}
}
