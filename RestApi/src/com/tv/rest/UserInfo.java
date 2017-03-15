package com.tv.rest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.tv.model.User;
import com.tv.service.UserService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;  

@Path("/user")
public class UserInfo {
	
	@POST
	@Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public JSONObject AddUser(JSONObject User){
		JSONObject resp = new JSONObject();

	     ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");

	     UserService userService = (UserService) appContext.getBean("userServiceBean");
	     /** insert **/
	     Long Id = 20l;
	     User user = new User();
	     user.setName(User.getString("name"));
	     user.setPassword(User.getString("password"));
	     userService.save(user);        
	    
		try {
			resp.put("success", "add user successfully");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return resp;
	}
	
	@POST
	@Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public JSONObject Auth(JSONObject User){
		JSONObject resp = new JSONObject();

	     ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");

	     UserService userService = (UserService) appContext.getBean("userServiceBean");     
	     boolean auth = false;
		try {
			auth = userService.checkUser(User.getString("name"), User.getString("password"));
			if(auth){
				resp.put("success", "auth user successfully");
			}else
			{
				resp.put("error", "failed to auth user");
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return resp;
	}
}
