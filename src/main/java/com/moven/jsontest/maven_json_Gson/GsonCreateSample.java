package com.moven.jsontest.maven_json_Gson;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maven.bean.PeopleBean;

public class GsonCreateSample {

	public static void main(String[] args) {
		PeopleBean bean = new PeopleBean();
		bean.setName("王小二");
	    bean.setAge(25.2);
	    bean.setBirthday(new Date());
	    bean.setSchool("蓝翔");
	    bean.setMajor(Arrays.asList(new String[] {"理发", "挖掘机"}));
	    bean.setHas_girlfriend(false);
	    bean.setHouse(null);
	    bean.setCar(null);
	    bean.setComment("这是一个注释");
	    bean.setIgnore("生成json时忽略这个field");
	    
	    //1.直接new一个gson对象
	    //Gson gson = new Gson();
	    
	    //2.先创建一个builder，设置一些策略，create一个gson对象
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.setPrettyPrinting();//调整打印的格式
	    gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
			/**
			 * 在生成json时
			 * 将name改为NAME
			 * 该方法会和annotation冲突
			 */
			public String translateName(Field arg0) {
				if(arg0.getName().equals("name")){
					return "NAME";
				}
				return arg0.getName();
			}
		});
	    Gson gson = gsonBuilder.create();
	    System.out.println(gson.toJson(bean));
	}

}
