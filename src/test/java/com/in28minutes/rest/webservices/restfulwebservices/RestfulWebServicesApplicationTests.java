package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.GregorianCalendar;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RestfulWebServicesApplicationTests {

	@Test
	void getUser() {
		get("/users/1").then().body("id", equalTo(1));
	}

	@Test
	void createUser() {
		RequestSpecification request = given();
		request.header("content-type", MediaType.APPLICATION_JSON_VALUE);
		request.body(new User(12, "Arielle", new GregorianCalendar(1998, 0,26).getTime()));
		Response response = request.post("/users").andReturn();
		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
		String location = response.getHeader("location");
		assertTrue(location.endsWith("/users/12"));
	}
}
