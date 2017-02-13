package com.tv.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.Consumes;  

@Path("/product")
public class ProductInfo {
	
	@GET
	@Path("/test")
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
	
	@GET
	@Path("/createListFile")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public JSONObject createProductList(){
		JSONObject resp = new JSONObject();
		User user = new User();
		user.setAge(10);
		String separator = File.separator;
		String fileName = "ProductList.txt";
		String directory = ".." + separator + ".." + separator;
        File file = new File(directory,fileName);
		try {
			if(!file.exists()){
				file.createNewFile();
				resp.put("result", "success");
			}else
			{
				resp.put("result", "already exists");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resp;
	}
	
	@GET
	@Path("/getProductList")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public JSONObject getProductList(){
		JSONObject resp = new JSONObject();
		User user = new User();
		user.setAge(10);
		String separator = File.separator;
		String fileName = "ProductList.txt";
		String directory = ".." + separator + ".." + separator;
        File file = new File(directory,fileName);
        BufferedReader br;
        BufferedWriter bw; 
        String str =file.getAbsolutePath();
		try {
			br = new BufferedReader(new FileReader(  
			        file.getAbsolutePath()));   
			String full_content = "", temp_str = "";  
			while ((temp_str = br.readLine()) != null){
				full_content = full_content + temp_str;
			}
			JSONObject dataJson = new JSONObject(full_content);
			JSONArray productList = dataJson.getJSONArray("ProductList");
			resp.put("ProductList", productList);
			br.close();

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 读取原始json文件  
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     

		return resp;
	}
	
	@POST
	@Path("/addProduct")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
	public JSONObject addProduct(String product){
		JSONObject resp = new JSONObject();
		User user = new User();
		user.setAge(10);
		String separator = File.separator;
		String fileName = "ProductList.txt";
		String directory = ".." + separator + ".." + separator;
        File file = new File(directory,fileName);
        BufferedReader br;
        BufferedWriter bw; 
        String str =file.getAbsolutePath();
		try {
			br = new BufferedReader(new FileReader(  
			        file.getAbsolutePath()));   
			String full_content = "", temp_str = "";  
			while ((temp_str = br.readLine()) != null){
				full_content = full_content + temp_str;
			}
			br.close();
			JSONObject dataJson = new JSONObject(full_content);
			JSONArray productList = dataJson.getJSONArray("ProductList");
			productList.put(product);
			bw = new BufferedWriter(new FileWriter(  
			        file.getAbsolutePath())); 
			bw.write(dataJson.toString());
			
			resp.put("ProductList", productList);
			bw.close();
			

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 读取原始json文件  
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     

		return resp;
	}
}
