package com.moven.jsontest.maven_json_Gson;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maven.bean.PeopleBean;

public class GsonReadSample {

	public static void main(String[] args) throws IOException {
		File file = new File(GsonReadSample.class.getResource("./jsonWang.json").getFile());
		String content = FileUtils.readFileToString(file,"UTF-8");
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("YYYY-mm-DD").create();
		PeopleBean xiaoer = gson.fromJson(content, PeopleBean.class);
		System.out.println(DateFormat.getDateInstance().format(xiaoer.getBirthday()));
		System.out.println(xiaoer.toString());
		System.out.println(xiaoer.getMajor().getClass());
	}

}
