package com.tv.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class ProductInfo {
	@GET
	public String hello(){
		return "Hello TV!!";
	}
}
