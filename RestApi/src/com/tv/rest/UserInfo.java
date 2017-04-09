package com.tv.rest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.tv.model.Role;
import com.tv.model.User;
import com.tv.service.RoleService;
import com.tv.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;  

@Path("/user")
public class UserInfo {
	private ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
	private UserService userService = (UserService) appContext.getBean("userServiceBean");
	private RoleService roleService = (RoleService) appContext.getBean("roleServiceBean");
	//private UserRoleService userRoleService = (UserRoleService) appContext.getBean("userRoleServiceBean");
	@GET
	@Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON) 
	public Response test(@HeaderParam("x-auth-token") String token){
		ResponseBuilder builder = Response.status(401).entity(token);
		return builder.build();
	}
	
	@POST
	@Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public Response AddUser(JSONObject User){
		//check data format first
	    if(User.getString("name") == null || User.getString("password") == null || User.getString("role") == null){
	    	 
	    	 ResponseBuilder builder = Response.status(400).entity("data format error!");
	    	 return builder.build();
	    }
	    
	    //check user exist first
	    if(userService.checkUserExist(User.getString("name"))){
	    	 ResponseBuilder builder = Response.status(409).entity("user already exist!");
	    	 return builder.build();
	    }	
	     //set username and password
	    User user = new User();
	    user.setName(User.getString("name"));
	    user.setPassword(User.getString("password"));	  
	   
	    // set roles
	    Set<Role> roleSet = new HashSet<Role>();
	    Object[] role_array = (Object[]) User.getJSONArray("role").toArray();
	    for(Object role: role_array){
	    	if((Role)roleService.getRole(role.toString()) != null){
	    		roleSet.add((Role)roleService.getRole(role.toString()));
	    	}
	    	else{
	    		ResponseBuilder builder = Response.status(400).entity("data format error, do not have role: " + role.toString());
	    		 return builder.build();
	    	}
	    }
	    user.setRoles(roleSet); 
	    userService.save(user);
	    //return response
	    JSONObject resp = new JSONObject();
	    resp.put("message", "ok");
	    ResponseBuilder builder = Response.ok().entity(resp);
	    
	    return builder.build();
	}
	
	@POST
	@Path("/updateUser")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public Response UpdateUser(JSONObject User){
		//check data format first
	    if(User.getString("name") == null || User.getString("password") == null || User.getString("role") == null){
	    	 
	    	 ResponseBuilder builder = Response.status(400).entity("data format error!");
	    	 return builder.build();
	    }   
	    
	    
	    if(userService.getUser(User.getString("name"))==null){
	   	 	ResponseBuilder builder = Response.status(400).entity("user do not exist!");
	   	 	return builder.build();
	    }
	    User user = userService.getUser(User.getString("name"));
	    user.setPassword(User.getString("password"));	
	    
	    // set roles
	    Set<Role> roleSet = new HashSet<Role>();
	    Object[] role_array = (Object[]) User.getJSONArray("role").toArray();
	    for(Object role: role_array){
	    	if((Role)roleService.getRole(role.toString()) != null){
	    		roleSet.add((Role)roleService.getRole(role.toString()));
	    	}
	    	else{
	    		ResponseBuilder builder = Response.status(400).entity("data format error, do not have role: " + role.toString());
	    		 return builder.build();
	    	}
	    }
	    user.setRoles(roleSet);
	    userService.update(user);

	    
	    JSONObject resp = new JSONObject();
	    resp.put("message", "ok");
	    ResponseBuilder builder = Response.ok().entity(resp);
	    
	    return builder.build();
	}
	
	@POST
	@Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public JSONObject Auth(JSONObject User){
		JSONObject resp = new JSONObject();

	     UserService userService = (UserService) appContext.getBean("userServiceBean");     
	     boolean auth = false;
		try {
			auth = userService.authUser(User.getString("name"), User.getString("password"));
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
