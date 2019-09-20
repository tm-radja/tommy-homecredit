package com.tommy.manik;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tommy.manik.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TommyMHomeCreditApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TommyMHomeCreditApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {

	return "http://localhost:" + port;

	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetUserById() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/user/findBy?userId=1",HttpMethod.GET, entity, String.class);
		Assert.assertNotNull(response.getBody());
	}

}
