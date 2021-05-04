package com.udacity.pricing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;

import com.udacity.pricing.domain.price.Price;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPricingService() {

		ResponseEntity<Price> response = restTemplate.getForEntity("http://localhost:" + port + "/services/price?vehicleId=1", Price.class);

		assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));
	}
}
