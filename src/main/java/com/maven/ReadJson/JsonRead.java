package com.maven.ReadJson;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maven.DAO.CustomerDAO;
import com.maven.DAO.CustomerDAOImpl;
import com.maven.bean.Customer;

public class JsonRead {

	public static void main(String[] args) throws IOException {
		File file = new File(JsonRead.class.getResource("./customers.json").getFile());
		String content = FileUtils.readFileToString(file,"UTF-8");
		
		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<Customer>>(){}.getType();
		List<Customer> customer = gson.fromJson(content, collectionType);
		
		CustomerDAO cust = new CustomerDAOImpl();
		
		customer.forEach($->{

				//cust.updateCustomer($);
			
		});
		
		cust.findCustomer(null);
		
	}

}
