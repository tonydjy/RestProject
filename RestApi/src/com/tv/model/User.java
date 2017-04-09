package com.tv.model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
	 	private Long userid;//id
	    private String name;//ÐÕÃû
	    private String password;
	    private Set<Role> roles;


		public void setUserid(Long userid) {
			this.userid = userid;	
		}

		public void setName(String name) {
			// TODO Auto-generated method stub
			this.name = name;
		}   
		
		public Long getUserid(){
			return this.userid;
		}
		
		public String getName(){
			return this.name;
		}
	
		public void setPassword(String password){
			this.password = password;
		}
		
		public String getPassword(){
			return this.password;
		}
		
		public void setRoles(Set<Role> roles){
			this.roles = roles;
		}
		
		public Set<Role> getRoles(){
			return this.roles;
		}
}
