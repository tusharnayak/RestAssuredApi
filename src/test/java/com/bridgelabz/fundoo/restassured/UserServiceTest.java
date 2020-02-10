package com.bridgelabz.fundoo.restassured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class UserServiceTest {
	String baseURI = "http://localhost:8080/api"; // specify base URI

//	@Test
	public void addUserTest() {
		RequestSpecification httpRequest = RestAssured.given().baseUri(baseURI);// request object

		JSONObject json = new JSONObject();
		json.put("firstName", "tushar");
		json.put("lastName", "nayak");
		json.put("userName", "tushar123");
		json.put("email", "nayak.tushar1996@gmail.com");
		json.put("password", "tushar123");
		json.put("confirmPassword", "tushar123");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(json.toJSONString());
		Response response = httpRequest.request(Method.POST, "/adduser");
		System.out.println("Response status" + response.getStatusCode());
		assertEquals(response.getStatusCode(), 200);

	}

//	@Test
	public void login() {
		RequestSpecification httpRequest = RestAssured.given().baseUri(baseURI);// request object
		JSONObject login = new JSONObject();
		login.put("email", "nayak.tushar1996@gmail.com");
		login.put("password", "tushar123");
		httpRequest.body(login.toJSONString());
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("token",
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InR1c2hhcm5heWFrMTk5NkBnbWFpbC5jb20ifQ.SlWAvo2lZ36Eeg5E5Y5eKaFUfooJlxqoQ4x6FNwAQrE");
		Response response=httpRequest.request(Method.POST,"/login");
		System.out.println("Response status:"+response.getStatusCode());
		assertEquals(response.getStatusCode(), 200);
	}
	@Test
	public void forgetPassword() {
		RequestSpecification httpRequest = RestAssured.given().baseUri(baseURI);// request object
		JSONObject resetPass=new JSONObject();
		resetPass.put("email", "nayak.tushar1996@gmail.com");
		httpRequest.body(resetPass.toJSONString());

		httpRequest.header("Content-Type", "application/json");
		Response response=httpRequest.request(Method.POST,"/forgetPassword");
		System.out.println("111111111111");
		System.out.println("Response status:"+response.getStatusCode());
		assertEquals(response.getStatusCode(), 200);
		
	}
}











