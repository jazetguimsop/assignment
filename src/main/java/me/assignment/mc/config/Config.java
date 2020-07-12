package me.assignment.mc.config;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class Config {
	private final static Logger logger = LoggerFactory.getLogger(Config.class);

	@Value("classpath:city.txt")
	private Resource file;

	@Bean(name = "mapping")
	public Map<String, String> getMapping() {
		Map<String, String> mapping = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		try (Scanner sc = new Scanner(file.getInputStream())) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				String arr[] = line.split(",");
				mapping.put(arr[1].trim(), arr[0].trim());
			}
		} catch (IOException e) {
			logger.error("could not load city file", e);
		}
		return mapping;
	}

}