package com.tv.model;

import java.io.Serializable;

public class User implements Serializable {
	 	private Long id;//id
	    private String name;//ÐÕÃû
	    private String password;



		public void setId(Long id) {
			this.id = id;	
		}

		public void setName(String name) {
			// TODO Auto-generated method stub
			this.name = name;
		}   
		
		public Long getId(){
			return this.id;
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
}
