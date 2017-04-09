package com.tv.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.tv.model.Role;
import com.tv.model.User;
import com.tv.service.RoleService;
import com.tv.service.UserService;

@Path("/role")
public class RoleInfo {
	@POST
	@Path("/addRole")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public JSONObject AddUser(JSONObject Jrole){
		JSONObject resp = new JSONObject();

	     ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");

	     RoleService roleService = (RoleService) appContext.getBean("roleServiceBean");

	     Role role = new Role();

	     if(Jrole.getString("role") == null){
	    	 resp.put("error", "do not contain role");
	    	 return resp;
	     }	     
	     /** insert **/
	     role.setRoleName(Jrole.getString("role"));;
	     roleService.save(role);        
	    
		try {
			resp.put("success", "add role successfully");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return resp;
	}
	
}
