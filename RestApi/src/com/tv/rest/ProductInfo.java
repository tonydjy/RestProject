package com.tv.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.Consumes;  

@Path("/hello")
public class ProductInfo {
	
	@GET
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public JSONObject hello(){
		JSONObject resp = new JSONObject();
		User user = new User();
		user.setAge(10);
		try {
			resp.put("name", "tv from server");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return resp;
	}
}
